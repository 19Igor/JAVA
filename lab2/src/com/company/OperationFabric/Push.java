package com.company.OperationFabric;

import java.util.Map;
import java.util.Stack;

public class Push implements Operations
{
    @Override
    public void CommandPush(Stack<Double> stack, Map<String, Double> define, String val)
    {
        try
        {
            Double.parseDouble(val);
        }
        catch (NumberFormatException e)
        {
            System.out.println("Неправильный параметр Pushn\n");
            return;
        }

        if (!define.containsKey(val))
        {
            System.out.println("В мапе нету такой переменнйо\n");
            return;
        }

        if (define.containsKey(val))
            stack.push(define.get(val));
        else
            stack.push(Double.parseDouble(val));
    }
}
