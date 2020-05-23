package com.company;

import java.util.ArrayList;

public class Stack {
    private ArrayList<Integer> stack = null; //основной стек, в котром будут храниться числа для взаимодействия
    private ArrayList<figure> figures = null; //числа через DEFINE
    private ArrayList<String> LineParam = null;
    {
        stack = new ArrayList<Integer>();
        figures = new ArrayList<figure>();
    }
    public void AddNum(figure n) {
        boolean Added = false;
        int ind = 0;
        for (figure number : figures) {
            if (number.equals(n)) {
                Added = true;
                break;
            }
            ind++;
            if (!Added)
                figures.add(n);
            else figures.get(ind).b = n.b;
        }
    }
        public void AddToStack(int n){
            stack.add(n);
        }
        public void DeleteFromStack(){
            stack.remove(stack.size()-1);
        }
        public int GetLastInStack(){
        return stack.get(stack.size()-1);
        }
        public int GetFigureSize(){
        return figures.size();
        }
        public int GetStackSize(){
        return stack.size();
        }

        public void setNumStr(ArrayList<String> Arr){
        LineParam = Arr;
        }

        public ArrayList<String> GetNumString(){
        return LineParam;
        }

        public int getInt(figure f){
        return (int) figures.get(figures.indexOf(f)).b;
        }

        public int getInt(int i){
        return (int) figures.get(i).b;
        }

        public figure GetFigure(figure f){
        return figures.get(figures.indexOf(f));
        }

        public void PrintFigures(){
        int i =0;
        while (i<figures.size()){
            System.out.println(figures.get(i).print());
            i++;
            }
        }

        public void PrintStack(){
        int s=0;
        while (s<stack.size()){
            System.out.println(stack.get(s));
            s++;
            }
        }
    }
