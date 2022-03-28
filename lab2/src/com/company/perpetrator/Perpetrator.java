package com.company.perpetrator;

import java.util.Map;
import java.util.Stack;

import com.company.OperationFabric.*;

public class Perpetrator
{
    public static void Perp(String Commands[], Stack<Double> stack, Map<String, Double> defined)
    {
        for (int i = 1; i < Commands.length; i++)
        {
            if (Commands[i].equalsIgnoreCase("DEFINE"))
            {
                Define obj = new Define();
                obj.CommandDefined(defined, Commands[i + 1], Commands[i + 2]);
                int a = 10;
            }
            else if (Commands[i].equalsIgnoreCase("PUSH"))
            {
                Push obj = new Push();
                obj.CommandPush(stack, defined, Commands[i + 1]);
            }
            else if (Commands[i].equalsIgnoreCase("POP"))
            {
                Pop obj = new Pop();
                obj.Command(stack);
            }
            else if (Commands[i].equalsIgnoreCase("DIVISION"))
            {
                Division obj = new Division();
                obj.Command(stack);
            }
            else if (Commands[i].equalsIgnoreCase("MULTIPLICATION"))
            {
                Multiplication obj = new Multiplication();
                obj.Command(stack);
            }
            else if (Commands[i].equalsIgnoreCase("PLUS"))
            {
                Plus obj = new Plus();
                obj.Command(stack);
            }
            else if (Commands[i].equalsIgnoreCase("MINUS"))
            {
                Minus obj = new Minus();
                obj.Command(stack);
            }
            else if (Commands[i].equalsIgnoreCase("PRINT"))
            {
                Print obj = new Print();
                obj.Command(stack);
            }
            else if (Commands[i].equalsIgnoreCase("SQRT"))
            {
                SQRT obj = new SQRT();
                obj.Command(stack);
            }
        }
    }
}
