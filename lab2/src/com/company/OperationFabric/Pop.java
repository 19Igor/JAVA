package com.company.OperationFabric;

import java.util.Stack;

public class Pop implements Operations
{
    @Override
    public void Command(Stack<Double> stack)
    {
        if (stack.size() <= 0)
        {
            System.out.println("На стеке нет места!");
            System.out.println("Printed by Pop\n");
            return;
        }
        stack.pop();
    }
}
