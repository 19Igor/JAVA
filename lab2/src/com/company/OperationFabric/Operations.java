package com.company.OperationFabric;

import java.util.Map;
import java.util.Stack;

public interface Operations
{
    default void Command (Stack <Double> stack){}
    default void CommandPush (Stack <Double> stack, Map <String, Double> define, String val){}
    default void CommandDefined (Stack<Double> stack, Map <String, Double> define, String key, String val){}
}


// defiend a 5
/*
* defined b a
*
*
* */