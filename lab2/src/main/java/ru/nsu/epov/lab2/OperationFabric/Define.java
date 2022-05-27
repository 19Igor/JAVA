package ru.nsu.epov.lab2.OperationFabric;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.nsu.epov.lab2.core.CommandContext;
import ru.nsu.epov.lab2.core.Operations;
import ru.nsu.epov.lab2.perpetrator.toCheckParam;

import java.util.EmptyStackException;

public class Define implements Operations
{
    static final Logger logger = LogManager.getLogger(Define.class);
    @Override
    public void workingCommand(CommandContext context)
    {
        double number = 0;
        logger.debug("Command DEFINE runs.");
        /**
         * if the first parameter of Define command is digit
         * */
        try {
            if (context.getValues().size() < 2) {
                throw new EmptyStackException();
            }
            String val = context.getValues().pop();
            String key = context.getValues().pop();
            if (toCheckParam.isDigit(key)) {
                throw new Exception("Incorrect first define parameter. Printed by Define.java");
            }
            /**
             * If the second parameter is a variable, but not a number
             * */
            else if (context.getDefine().containsKey(val)) {
                number = context.getDefine().get(val);
                context.getDefine().put(key, number);
            } else
            {
                number = Double.parseDouble(val);
                context.getDefine().put(key, number);
            }
        }
        catch (NumberFormatException e)
        {
            logger.error("Incorrect second Define command parameter.");
            return ;
        }
        catch (EmptyStackException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        logger.debug("Command DEFINE terminated.");

    }
    @Override
    public final Integer returnArgNumb()
    {
        return 2;
    }
}
