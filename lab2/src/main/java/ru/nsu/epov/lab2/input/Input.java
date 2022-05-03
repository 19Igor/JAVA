package ru.nsu.epov.lab2.input;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Stack;


public class Input
{
    public String[] In(Map<String, Double> DefineMap, Stack<Double> stack, String[] args) throws IOException {
        if (args.length == 1)
        {
            String FilePath = args[0];   // getting path to a file
            File InFile = new File(FilePath);
            return toReadStrings.ReadStringFromFile(InFile);
        }
        else if (args.length < 1)
        {
            return toReadStrings.ReadStringFromConsole();
        }
        else
        {
            System.out.println("Printed by reading/toReadStrings");
            throw new IOException("Incorrect numb of parameters.");
        }
    }
}
