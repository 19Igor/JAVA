package com.company.OperationFabric;

import java.util.Map;
import java.util.Stack;

public class Define implements Operations
{
    private double number = 0;
    @Override
    public void CommandDefined(Stack<Double> stack, Map<String, Double> define, String key, String val)
    {
        // Если второй аргумент это переменная, а не число
        if (define.containsKey(val)) {
            number = define.get(val);
            define.put(key, number);
            stack.push(number);
        }
        else {
            try {
                Double.parseDouble(val);
            } catch (NumberFormatException e) {
                System.out.println("Неправильный второй параметр Define\n");
                return;
            }
            number = Double.parseDouble(val);
            define.put(key, number);
            stack.push(number);
        }
    }
}
