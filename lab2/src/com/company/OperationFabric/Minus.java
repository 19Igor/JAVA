package com.company.OperationFabric;

import java.util.Stack;

public class Minus implements Operations
{
    @Override
    public void Command(Stack<Double> stack)
    {
        double a = stack.pop();
        double b = stack.pop();
        stack.push(b - a);
    }
}
