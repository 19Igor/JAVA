package com.company.OperationFabric;

import java.util.Stack;

import static java.lang.Math.sqrt;

public class SQRT implements Operations
{
    @Override
    public void Command(Stack<Double> stack)
    {
        double a = stack.peek();
        if (a < 0 )
        {
            System.out.println("Корень от отрицательного числа.\n");
            System.out.println("Printed by SQRT\n");
            return;
        }
        stack.push(sqrt(stack.pop()));
    }
}
