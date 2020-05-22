package com.company;

import java.util.Scanner;
import java.lang.Math;

interface Commands { //interface
void ToDo();
}

abstract class DEFINE implements Commands{
    @Override
    public void ToDo(){}
}

abstract class PUSH implements Commands{
    @Override
    public void ToDo(){}
}

abstract class POP implements Commands{
    @Override
    public void ToDo(){}
}

abstract class PRINT implements Commands{
    @Override
    public void ToDo(){}
}

abstract class SUM implements Commands{
    @Override
    public void ToDo(){}
}

abstract class MULTIPLY implements Commands{
    @Override
    public void ToDo(){}
}

abstract class SUBTRACT implements Commands{
    @Override
    public void ToDo(){}
}

abstract class DEVIDE implements Commands{
    @Override
    public void ToDo(){}
}

abstract class SQRT implements Commands{
    @Override
    public void ToDo(){}
}
