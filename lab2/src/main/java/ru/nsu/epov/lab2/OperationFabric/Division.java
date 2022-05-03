package ru.nsu.epov.lab2.OperationFabric;

import ru.nsu.epov.lab2.core.CommandContext;
import ru.nsu.epov.lab2.core.Operations;

import java.util.EmptyStackException;

public class Division implements Operations
{
    private final Double ZERO_FOR_DIVISION_P = 0.0;
    private final Double ZERO_FOR_DIVISION_M = -0.0;
    @Override
    public void workingCommand(CommandContext context)
    {

        try {
            if (context.getStack().size() < 2) {
                throw new EmptyStackException();
            }
            Double value1 = context.getStack().pop();

            if (context.getStack().peek().equals(ZERO_FOR_DIVISION_M) || context.getStack().peek().equals(ZERO_FOR_DIVISION_P)){
                context.getStack().push(value1);
                throw new ArithmeticException();
            }
            double a = value1 / context.getStack().pop();
            context.getStack().push(a);
        }
        catch (EmptyStackException | ArithmeticException e)
        {
            e.printStackTrace();
        }
    }
}
