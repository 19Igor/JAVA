package com.company.OperationFabric;

import java.util.Stack;

public class Multiplication implements Operations
{
    @Override
    public void Command(Stack<Double> stack)
    {
        stack.push(stack.pop() * stack.pop());
    }
}
