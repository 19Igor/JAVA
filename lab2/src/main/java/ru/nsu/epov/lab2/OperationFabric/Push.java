package ru.nsu.epov.lab2.OperationFabric;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.nsu.epov.lab2.core.CommandContext;
import ru.nsu.epov.lab2.core.Operations;

public class Push implements Operations
{
    final Logger logger = LogManager.getLogger(Push.class);
    @Override
    public void workingCommand(CommandContext context)
    {
        logger.debug("Command PUSH runs.");
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
        logger.debug("Command PUSH ended.");
    }
    @Override
    public final Integer returnArgNumb()
    {
        return 1;
    }
}
