package ru.nsu.epov.lab2.OperationFabric;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.nsu.epov.lab2.core.CommandContext;
import ru.nsu.epov.lab2.core.Operations;

import java.util.EmptyStackException;

public class Pop implements Operations
{
    static final Logger logger = LogManager.getLogger(Pop.class);
    @Override
    public void workingCommand(CommandContext context)
    {
        logger.debug("Command POP runs.");
        try {
            context.getStack().pop();
        }
        catch(EmptyStackException e)
        {
            e.printStackTrace();
        }
        logger.debug("Command POP ended.");
    }
}
