package com.company;

import javax.imageio.IIOException;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;
//import java.util.Stack;

//public class Calculator {
//    void GetIntoWork() {
//        FileInputStream std = null;
//        Properties prop = null;
//        Scanner scan = null;
//        try {
//            std = new FileInputStream("C:\\Users\\Tom\\Desktop\\Programming\\java\\Text.txt");
//            scan = new Scanner("C:\\Users\\Tom\\Desktop\\Programming\\java\\Text.txt");
//        }catch(IOException e){
//            System.err.println("Error while reading file: " + e.getLocalizedMessage());
//        }
//        if(scan == null){
//            System.out.println("Enter the line to calculate");
//            scan = new Scanner(System.in);
//        }
//    }
//    void to_Do(){}
//}
class figure{
    String a;
    float b;
    figure (String a, float b){
        this.a = a;
        this.b = b;
    }
    String print(){
        return "<" +  a + ">  ==  " + b;
    }
    public boolean equals(Object obj){//сравниваем два объекта.
        figure toCheck = (figure)obj;
        return this.a.equals(toCheck.a);
    }
}

public class Calculator{
    //C:\Users\Tom\Desktop\Programming\java
    private Properties ComName = null;
    private Scanner scan = null;
    private Stack stack = null;
    private Parser parser = null;
    {
        FileInputStream input = null;
        ComName = new Properties(); //создаем лист команд (пустой)
        try {
            input = new FileInputStream("adress");
            ComName.load(input);
        }catch (IOException e){
            e.printStackTrace();
        }
        stack = new Stack();
        parser = new Parser();
    }
    String GetProperty (String string){
        return ComName.getProperty(string);
    }

    Calculator(){
        this.scan = new Scanner(System.in);
    }
    Calculator(String string){
        this.scan = new Scanner(string);
    }

    void calculation(){
        while(scan.hasNext()){ //пока не конец
            String string = scan.nextLine();
            if(string.equals("EXIT")){
                System.out.println("Good bye!");
                break;
            }
            Scanner strings = new Scanner(string); //start parsing
            ArrayList<String> ArrStr = new ArrayList<>();
            while(strings.hasNext()){
                String str = strings.next();
                if (str.contains("#"))
                    ArrStr.add(str);
                else{
                    str = (str.indexOf('#')==0)? "#" : str.substring(0,str.indexOf('#'));
                    ArrStr.add(str);
                    break;
                }
            }

            int i = 0;
            String ComName = null;
            while (i<ArrStr.size()){
                if(this.GetProperty(ArrStr.get(i))!= null){
                    ComName = this.GetProperty(ArrStr.get(i));
                    break;
                }else if (ArrStr.get(i).substring(0,1).equals("#")){
                    ComName = "#";
                    break;
                }
                i++;
            }
            ArrStr.remove((String)"#");
            if(ComName==null){
                System.out.println("Wrong Command.");
                continue;
            }
            stack.setNumStr(ArrStr);
            parser.parsing(stack, ComName);
        }
    }
}
