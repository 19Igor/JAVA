package ru.nsu.epov.lab2.core;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import ru.nsu.epov.lab2.input.Input;
import ru.nsu.epov.lab2.perpetrator.Perpetrator;

import java.util.Stack;
import java.util.logging.Logger;


public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException, InvocationTargetException, NoSuchMethodException {

        HashMap<String, Double> DefineMap = new HashMap<String, Double>();
        Stack<Double> stack = new Stack<Double>();
        Input in = new Input();


        String[] InputData = in.In(DefineMap, stack, args);
        Perpetrator.Perp(InputData, stack, DefineMap);

        return;
    }
}
