package com.company;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
//должен быть фабричным

public class Parser {
    HashMap<String, Commands> CommandsMap = new HashMap<String, Commands>(); //здесь храним название команды и ее алгоритм

    public void process(Stack stack, String ComName) {
        try {//фабричный метод
            Commands command = CommandsMap.get(ComName);
            if (command == null) {
                Class<?> cl = Class.forName(ComName);
                Constructor<?> constructor = cl.getDeclaredConstructor();
                command = (Commands) constructor.newInstance();
                CommandsMap.put(ComName, command);
            }
            command.ToDo(stack);
        } catch (InvocationTargetException | IllegalAccessException
                | ClassNotFoundException | NoSuchMethodException
                | InstantiationException e) {
            e.printStackTrace();
        }

    }
}
