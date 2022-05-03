package ru.nsu.epov.lab2.OperationFabric;

import ru.nsu.epov.lab2.core.CommandContext;
import ru.nsu.epov.lab2.core.Operations;
import ru.nsu.epov.lab2.perpetrator.toCheckParam;

import java.util.EmptyStackException;
import java.util.Map;
import java.util.Stack;

public class Push implements Operations
{
    @Override
    public void workingCommand(CommandContext context) {
        try
        {
            String val = context.getValues().pop();
            // here we clearly know val is a variable
            if (context.getDefine().containsKey(val)) // if it's a variable and it doesn't contained in the map
            {
                context.getStack().push(context.getDefine().get(val));
            }
            else
            {
                context.getStack().push(Double.parseDouble(val));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @Override
    public final Integer returnArgNumb()
    {
        return 1;
    }
}
