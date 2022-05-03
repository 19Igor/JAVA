package ru.nsu.epov.lab2.OperationFabric;

import ru.nsu.epov.lab2.core.CommandContext;
import ru.nsu.epov.lab2.core.Operations;

import java.util.Stack;
import java.util.concurrent.ExecutionException;

import static java.lang.Math.sqrt;

public class SQRT implements Operations {
    @Override
    public void workingCommand(CommandContext context) {
        try {
            if (context.getStack().peek() < 0) {
                throw new Exception("Корень от отрицательного числа.");
            }
            context.getStack().push(sqrt(context.getStack().pop()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
