package com.company.perpetrator;

import java.util.Map;
import java.util.Stack;

import com.company.perpetrator.toCheckSecParam;
import com.company.OperationFabric.*;

public class Perpetrator
{
    public static void Perp(String Commands[], Stack<Double> stack, Map<String, Double> defined)
    {
        for (int i = 1; i < Commands.length; i++)
        {
            if (Commands[i].equalsIgnoreCase("DEFINE"))
            {



                if (toCheckSecParam.isDigit(Commands[i + 2]))
                {
                    Define obj = new Define();
                    obj.CommandDefined(stack, defined, Commands[i + 1], Commands[i + 2]);
                }
            }

            // в таком же духе доделать остальные операции (с помощью фабрики)

            else if (Commands[i].equalsIgnoreCase("PUSH"))
            {
                if (toCheckSecParam.isDigit(Commands[i + 1]))
                {
                    stack.push(Double.parseDouble(Commands[i + 1]));
                }
            }
            else if (Commands[i].equalsIgnoreCase("POP"))
            {
                stack.pop();
            }
            else if (Commands[i].equalsIgnoreCase("DIVISION"))
            {

            }

        }
    }
}

