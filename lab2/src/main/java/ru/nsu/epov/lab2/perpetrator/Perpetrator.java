package ru.nsu.epov.lab2.perpetrator;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import ru.nsu.epov.lab2.core.CommandList;
import ru.nsu.epov.lab2.core.Operations;
import ru.nsu.epov.lab2.core.CommandContext;

public class Perpetrator
{
    public static void Perp(String[] commands, Stack<Double> stack, HashMap<String, Double> defined) throws IOException, InvocationTargetException, NoSuchMethodException {
        Map<String, Operations> commandList;

        CommandList perpet = new CommandList();
        commandList = perpet.returnCommandList(); // couple: key, command     PLUS object_plus

        CommandContext context = new CommandContext();
        context.setStack(stack);
        context.setDefine(defined);
        Stack<String> values = new Stack<>();
        context.setValues(values);
        /**
         * Возвращает мапу с элементами такого вида
         * PlUS new Plus()-объект плюс
         * */
        try
        {
            int flag;
            for (int i = 0; !commands[i].equalsIgnoreCase("/0"); i++) {
                if (commandList.containsKey(commands[i]))      // если в commandList содержится пользовательская команда
                {
                    flag = i;
                    for (int j = 0; j < commandList.get(commands[flag]).returnArgNumb(); j++) {
                        context.getValues().push(commands[++i]);
                    }
                    commandList.get(commands[flag]).workingCommand(context);
                } else {
                    System.out.println("Ошибка !");
                }
            }
        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}

