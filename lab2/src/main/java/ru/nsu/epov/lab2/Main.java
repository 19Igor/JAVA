package ru.nsu.epov.lab2;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import ru.nsu.epov.lab2.input.Input;
import ru.nsu.epov.lab2.perpetrator.Perpetrator;
import ru.nsu.epov.lab2.reading.toReadStrings;

import java.util.Scanner;
import java.util.Stack;
import java.util.logging.Logger;


public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException, InvocationTargetException, NoSuchMethodException {

//        final int FileMode = 0;
        final int WorkFlowMode = 1;
        Map<String, Double> DefineMap = new HashMap<String, Double>();
        Stack<Double> stack = new Stack<Double>();

//        System.out.println("Choose mode of entry:\n");
//        System.out.println("File - 0,\tor\tWorkflow - 1");

//        int InputMode = -1;
        Scanner console = new Scanner(System.in);
//        InputMode = console.nextInt();

        Object a;

        if (true)
        {
            String FilePath = Input.toEnterInputFilePath(args[0]); // getting path to a file
            File InFile = new File(FilePath);
            String FileToString_1[] = toReadStrings.ReadStringFromFile(InFile);
            Perpetrator.Perp(FileToString_1, stack, DefineMap);
        }
        else if (true)
        {
            String WorkFlowToString[] = toReadStrings.ReadStringFromConsole();
            Perpetrator.Perp(WorkFlowToString, stack, DefineMap);
        }
        else
        {
            System.out.println("Input mode wasn't defined.");
            return;
        }
    }
}
