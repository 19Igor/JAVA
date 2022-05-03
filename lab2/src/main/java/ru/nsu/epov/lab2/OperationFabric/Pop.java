package ru.nsu.epov.lab2.OperationFabric;

import ru.nsu.epov.lab2.core.CommandContext;
import ru.nsu.epov.lab2.core.Operations;

import java.util.EmptyStackException;
import java.util.Stack;

public class Pop implements Operations
{
    @Override
    public void workingCommand(CommandContext context)
    {
        try {
            context.getStack().pop();
        }
        catch(EmptyStackException e)
        {
            e.printStackTrace();
        }
    }
}
