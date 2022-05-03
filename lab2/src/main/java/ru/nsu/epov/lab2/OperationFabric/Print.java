package ru.nsu.epov.lab2.OperationFabric;

import ru.nsu.epov.lab2.core.CommandContext;
import ru.nsu.epov.lab2.core.Operations;

import java.util.EmptyStackException;

public class Print implements Operations
{
    @Override
    public void workingCommand(CommandContext context)
    {
        try {
            System.out.println( context.getStack().peek());
        }
        catch(EmptyStackException e)
        {
            e.printStackTrace();
        }
    }
}

