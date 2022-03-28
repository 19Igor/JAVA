package com.company.OperationFabric;

import java.util.Stack;

public class Multiplication implements Operations
{
    @Override
    public void Command(Stack<Double> stack)
    {
        if (stack.size() < 2)
        {
            System.out.println("Not enough elements in the stack.\n");
            System.out.println("Printed by Multiplication\n");
            return;
        }
        stack.push(stack.pop() * stack.pop());
    }
}
