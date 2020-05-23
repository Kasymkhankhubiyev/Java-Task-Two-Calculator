package com.company;

import java.util.Scanner;
import static java.lang.Math.sqrt;

interface Commands { //interface
void ToDo(Stack stack);
}

abstract class DEFINE implements Commands{
    @Override
    public void ToDo(Stack stack){
        Scanner check = null;
        figure toArray = null;
        try{
            check = new Scanner(stack.GetNumString().get(2));
            if(check.hasNextInt()){
                toArray = new figure(stack.GetNumString().get(1),check.nextInt());
            }else {
                System.out.println("Wrong value of arguments");
            }
        }catch (NullPointerException | IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        stack.AddNum(toArray);
    }
}

abstract class PUSH implements Commands{
    @Override
    public void ToDo(Stack stack) {
        if (stack.GetNumString().size() == 2) {
            figure f = new figure(stack.GetNumString().get(1), 0);
            try {
                stack.AddToStack(stack.getInt(f));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("This number is not found");
            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
            }
        }
        else{
                System.out.println("Wrong number of arguments");
            }
    }
}

abstract class POP implements Commands{
    @Override
    public void ToDo(Stack stack){
        if(stack.GetStackSize()!= 0)
            stack.DeleteFromStack();
        else
            System.out.println("Stack is empty");
    }
}

abstract class PRINT implements Commands{
    @Override
    public void ToDo(Stack stack){
        if(stack.GetStackSize() != 0)
            System.out.println(stack.GetLastInStack());
        else
            System.out.println("Stack is empty");
    }
}

abstract class SUM implements Commands{
    @Override
    public void ToDo(Stack stack){
        if(stack.GetStackSize() > 1){
            int a = stack.GetLastInStack();
            stack.DeleteFromStack();
            int b = a + stack.GetLastInStack();
            stack.DeleteFromStack();
            stack.AddToStack(b);
        }
        else{
            System.out.println("Wrong number of arguments");
        }
    }
}

abstract class MULTIPLY implements Commands{
    @Override
    public void ToDo(Stack stack){
        if(stack.GetStackSize() > 1){
            int a = stack.GetLastInStack();
            stack.DeleteFromStack();
            int b =a * stack.GetLastInStack();
            stack.DeleteFromStack();
            stack.AddToStack(b);
        }
        else{
            System.out.println("Wrong number of arguments");
        }
    }
}

abstract class SUBTRACT implements Commands{
    @Override
    public void ToDo(Stack stack){
        if(stack.GetStackSize() > 1){
            int a = stack.GetLastInStack();
            stack.DeleteFromStack();
            int b =a - stack.GetLastInStack();
            stack.DeleteFromStack();
            stack.AddToStack(b);
        }
        else{
            System.out.println("Wrong number of arguments");
        }
    }
}

abstract class DEVIDE implements Commands{
    @Override
    public void ToDo(Stack stack){
        if(stack.GetStackSize() > 1){
            int a = stack.GetLastInStack();
            stack.DeleteFromStack();
            int b = stack.GetLastInStack();
            stack.DeleteFromStack();
            int f = 0;
            if(b != 0){
                f = a / b;
            }else{
                System.out.println("Second argument is null");
            }
            stack.AddToStack(f);
        }
        else{
            System.out.println("Wrong number of arguments");
        }
    }
}

abstract class SQRT implements Commands{
    @Override
    public void ToDo(Stack stack){
        if(stack.GetStackSize() > 0){
            int a = stack.GetLastInStack();
            stack.DeleteFromStack();
            stack.AddToStack((int)sqrt(a));
        }
        else{
            System.out.println("Wrong number of arguments");
        }
    }
}
