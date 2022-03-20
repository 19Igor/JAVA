package com.company.OperationFabric;

import java.util.Stack;

public class Print implements Operations
{
    @Override
    public void Command(Stack<Double> stack)
    {
        System.out.println("Верхний элемент со стека: " + stack.peek());
    }
}

// дописать классы