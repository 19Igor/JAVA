package com.company.OperationFabric;

import java.util.Stack;

public class Division implements Operations
{
    @Override
    public void Command(Stack<Double> stack)
    {
        if (stack.peek() == 0)
        {
            System.out.println("Деление на ноль.\n");
            System.out.println("Printed by Division\n");
        }
        double a = stack.pop() / stack.pop();
        stack.push(a);
    }
}
