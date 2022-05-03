package ru.nsu.epov.lab2.core;

import java.util.Map;
import java.util.Stack;
import java.util.HashMap;

public class CommandContext {

    private Stack<Double> stack;
    private HashMap<String,Double> define;
    private Stack<String> values;

    public Stack<Double> getStack()
    {
        return stack;
    }

    public void setStack(Stack<Double> stack)
    {
        this.stack = stack;
    }

    public HashMap<String, Double> getDefine()
    {
        return define;
    }

    public void setDefine(HashMap<String, Double> define)
    {
        this.define = define;
    }

    public Stack<String> getValues()
    {
        return values;
    }

    public void setValues(Stack<String> values)
    {
        this.values = values;
    }
}
