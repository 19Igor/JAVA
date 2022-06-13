package ru.nsu.epov.lab2.OperationFabric;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.nsu.epov.lab2.core.CommandContext;
import ru.nsu.epov.lab2.core.Operations;

import java.util.EmptyStackException;

public class Print implements Operations
{
    final Logger logger = LogManager.getLogger(Print.class);
    @Override
    public void workingCommand(CommandContext context)
    {
        logger.debug("Command PRINT runs.");
        try {
            System.out.println( context.getStack().peek());
        }
        catch(EmptyStackException e)
        {
            e.printStackTrace();
        }
        logger.debug("Command PRINT ended.");
    }
}

