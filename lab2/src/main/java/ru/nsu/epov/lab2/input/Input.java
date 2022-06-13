package ru.nsu.epov.lab2.input;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class Input
{
    static final Logger logger = LogManager.getLogger(Input.class);

    public String[] In(String[] args) throws IOException {
        if (args.length == 1)
        {
            logger.debug("Calculator's commands begins to be read from file.");
            String FilePath = args[0];
            File InFile = new File(FilePath);
            return toReadStrings.ReadStringFromFile(InFile);
        }
        else if (args.length < 1)
        {
            logger.debug("Calculator's commands begins to be read from console.");
            return toReadStrings.ReadStringFromConsole();
        }
        else
        {
            System.out.println("Printed by reading/toReadStrings");
            throw new IOException("Incorrect numb of parameters.");
        }
    }
}
