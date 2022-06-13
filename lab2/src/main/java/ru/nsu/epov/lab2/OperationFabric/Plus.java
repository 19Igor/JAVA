package ru.nsu.epov.lab2.OperationFabric;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.nsu.epov.lab2.core.CommandContext;
import ru.nsu.epov.lab2.core.Operations;

import java.util.EmptyStackException;

public class Plus implements Operations
{
    static final Logger logger = LogManager.getLogger(Plus.class);
    @Override
    public void workingCommand(CommandContext context)
    {
        logger.debug("Command PLUS runs.");
        try {
            if(context.getStack().size() < 2)
            {
                throw new EmptyStackException();
            }
            context.getStack().push(context.getStack().pop() + context.getStack().pop());
        }
        catch (EmptyStackException e){
            e.printStackTrace();
        }
        logger.debug("Command PLUS ended.");
    }
}
