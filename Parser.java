package com.company;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class Parser { //фабричный метод
    HashMap<String,Commands> ComandsMap = new HashMap<String, Commands>(); //здесь храним название команды и ее алгоритм
}
