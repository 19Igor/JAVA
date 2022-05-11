package ru.nsu.epov.lab2.core;

import java.util.Stack;
import java.util.HashMap;

/**
 * CommandContext is a shell which consists of source stack, source map and additional stack.
 * The class is needed we can pass arguments of calculator's commands in one object.
 * */
public class CommandContext {

    private Stack<Double> stack;
    private HashMap<String,Double> define;
    private Stack<String> values;

    public Stack<Double> getStack() {return stack;}
    /**
     * Installs source stack.
     * The stack consists values of variables that are numbers.
     * */
    public void setStack(Stack<Double> stack)
    {
        this.stack = stack;
    }


    public HashMap<String, Double> getDefine()
    {
        return define;
    }
    /**
     * Installs source Map.
     * The map consists variables and appropriate values.
     * */
    public void setDefine(HashMap<String, Double> define)
    {
        this.define = define;
    }


    public Stack<String> getValues()
    {
        return values;
    }
    /**
     * This stack is needed for calculator's commands push and define.
     * */
    public void setValues(Stack<String> values)
    {
        this.values = values;
    }
}
