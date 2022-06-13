package ru.nsu.epov.lab2.perpetrator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.nsu.epov.lab2.core.CommandContext;
import ru.nsu.epov.lab2.core.CommandList;
import ru.nsu.epov.lab2.core.Operations;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Perpetrator
{
    static String SPEC_SYMBOL = "STOP";
    static final Logger logger = LogManager.getLogger(Perpetrator.class);
    public static void Perpetrate(String[] InputData, Stack<Double> stack, HashMap<String, Double> DefineMap)
    {
        logger.debug("Perpetrator runs.");
        Map<String, Operations> commandList;
        CommandList perpet = new CommandList();
        /**
         * commandList consists Map with <ClassName, Class>  //
         * */
        commandList = perpet.returnCommandList(); // couple: key, command     PLUS object_plus

        CommandContext context = new CommandContext();
        context.setStack(stack);
        context.setDefine(DefineMap);
        Stack<String> values = new Stack<>();
        context.setValues(values);
         /** Возвращает мапу с элементами такого вида
         * PlUS new Plus()-объект плюсInputData = {String[27]@730} ["DEFINE", "A", "9", "", "DEFINE", +22 more]
         * */
        try
        {
            int flag;
            for (int i = 0; !InputData[i].equalsIgnoreCase(SPEC_SYMBOL); i++)
            {
                if (commandList.containsKey(InputData[i]))   // если в commandList содержится пользовательская команда
                {
                    flag = i;
                    int variable = i;
                    for (int j = 0; j < commandList.get(InputData[flag]).returnArgNumb(); j++)
                    {
                        context.getValues().push(InputData[++variable]);
                    }
                    commandList.get(InputData[flag]).workingCommand(context);
                }
            }
        } catch(Exception e)
        {
            e.printStackTrace();
        }
        logger.debug("Perpetrator ended.");
    }
}
