package com.company.OperationFabric;

import java.util.Map;
import java.util.Stack;

public class Push implements Operations
{
    @Override
    public void CommandPush(Stack<Double> stack, Map<String, Double> define, String val) {
        try
        {
            Double.parseDouble(val);               // проверка на то, что val  - это число
        }
        catch (NumberFormatException e)
        {
            // here we clearly know val is a variable
            if (!define.containsKey(val)) // if it's a variable and it doesn't contain in the map
            {
                System.out.println("В мапе нету такой переменной \n");
                return;
            }
            else
            {
                stack.push(define.get(val));
                return;
            }
        }
        stack.push(Double.parseDouble(val));
    }
}
