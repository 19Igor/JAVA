package ru.nsu.epov.lab2.OperationFabric;
import ru.nsu.epov.lab2.perpetrator.toCheckParam;

import java.util.Map;

public class Define implements Operations
{
    private double number = 0;
    @Override
    public void CommandDefined(Map<String, Double> define, String key, String val)
    {
        if (toCheckParam.isDigit(key))  // if first parameter of define is a digit
        {
            System.out.println("Incorrect first define parameter.");
            System.out.println("Printed by Define.java \n");
            return;
        }
        // Если второй аргумент это переменная, а не число
        if (define.containsKey(val))
        {
            number = define.get(val);
            define.put(key, number);
        }
        else
        {
            try
            {
                Double.parseDouble(val);
            }
            catch (NumberFormatException e)
            {
                System.out.println("Неправильный второй параметр Define.");
                System.out.println("Printed by Define.java  \n");
                return;
            }
            number = Double.parseDouble(val);
            define.put(key, number);
        }
    }
}

/*
define a 1
define b 2
define a b
define c 3
PLUS a c
*/