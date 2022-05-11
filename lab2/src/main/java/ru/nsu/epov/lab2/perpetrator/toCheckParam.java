package ru.nsu.epov.lab2.perpetrator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class toCheckParam {
    private static final double flag = - 0.0;
    static final Logger logger = LogManager.getLogger(toCheckParam.class);

    public static boolean isDigit(String param2)
    {
        logger.debug("Checking of command's parameters.");
        try{
            double val = Double.parseDouble(param2);
            logger.debug("Checking of command's parameters.");
            return true;
        }catch (Exception e)
        {
            logger.error("Incorrect second parameter.");
            return false;
        }
    }
}
