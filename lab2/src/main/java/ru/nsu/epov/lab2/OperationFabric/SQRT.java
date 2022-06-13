package ru.nsu.epov.lab2.OperationFabric;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.nsu.epov.lab2.core.CommandContext;
import ru.nsu.epov.lab2.core.Operations;

import static java.lang.Math.sqrt;

public class SQRT implements Operations
{
    final Logger logger = LogManager.getLogger(SQRT.class);
    @Override
    public void workingCommand(CommandContext context)
    {
        logger.debug("Command SQRT runs.");
        try {
            if (context.getStack().peek() < 0) {
                throw new Exception("Корень от отрицательного числа.");
            }
            context.getStack().push(sqrt(context.getStack().pop()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.debug("Command SQRT ended.");
    }
}
