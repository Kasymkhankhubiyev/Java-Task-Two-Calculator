package com.company;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;


public abstract class Calculator {
    abstract void to_Do();
}
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
        figure Check = (figure)obj;
        return this.a.equals(Check.a);
    }
}
