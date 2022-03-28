package com.company.OperationFabric;

import java.util.Stack;

public class Minus implements Operations
{
    @Override
    public void Command(Stack<Double> stack)
    {
        if (stack.size() < 2)
        {
            System.out.println("Not enough elements in the stack.");
            System.out.println("Printed by Minus\n");
            return;
        }
        double a = stack.pop();
        double b = stack.pop();
        stack.push(b - a);
    }
}
