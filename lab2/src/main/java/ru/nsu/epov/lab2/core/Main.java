package ru.nsu.epov.lab2.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.nsu.epov.lab2.input.Input;
import ru.nsu.epov.lab2.perpetrator.Perpetrator;

import java.io.IOException;
import java.util.HashMap;
import java.util.Stack;


public class Main {

//    static final Logger rootLogger = (Logger) LogManager.getRootLogger();
    static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws IOException{
        //  /Users/igorepov/IdeaProjects/JAVA/lab2/InputFile.txt
        /**
         * DefineMap consists variable with its values
         * */
        HashMap<String, Double> DefineMap = new HashMap<>();
        /**
         * stack consist values of variables that are numbers
         * */
        Stack<Double> stack = new Stack<>();
        Input in = new Input();

        /**
         * Here we can show reading input string of commands of calculator
         * */
        String[] InputData = in.In(args);
        logger.debug("Calculator's commands reading ends.");
        logger.debug("Perpetrating begins.");
        Perpetrator.Perpetrate(InputData, stack, DefineMap);
        logger.debug("Perpetrating ends.");

        return;
    }
}
