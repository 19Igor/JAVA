package com.company.OperationFabric;


import java.util.Stack;

public class Plus implements Operations
{
    @Override
    public void Command(Stack<Double> stack)
    {
        if (stack.size() >= 2)
        {
            stack.push(stack.pop() + stack.pop());
        }
        else
        {
            System.out.println("На стеке меньше одного числа !\n");
            System.out.println("Printed by Plus");
        }
    }
}


/*
* SQRT
* push
* define
* Division
*
* */