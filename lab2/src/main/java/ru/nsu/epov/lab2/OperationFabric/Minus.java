package ru.nsu.epov.lab2.OperationFabric;

import ru.nsu.epov.lab2.core.CommandContext;
import ru.nsu.epov.lab2.core.Operations;

import java.util.EmptyStackException;
import java.util.Stack;

public class Minus implements Operations
{
    @Override
    public void workingCommand(CommandContext context)
    {
        try {
        if(context.getStack().size()<2)
        {
            throw new EmptyStackException();
        }
            context.getStack().push(context.getStack().pop() - context.getStack().pop());
        }
        catch (EmptyStackException e){
            e.printStackTrace();
        }
    }
}
