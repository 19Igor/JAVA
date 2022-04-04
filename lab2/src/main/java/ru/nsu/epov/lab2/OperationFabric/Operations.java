package ru.nsu.epov.lab2.OperationFabric;

import java.util.Map;
import java.util.Stack;

public interface Operations
{
    default void Command (Stack <Double> stack){}
    default void CommandPush (Stack <Double> stack,
                              Map <String, Double> define,
                              String val){}

    default void CommandDefined (Map <String, Double> define,
                                 String key,
                                 String val){}
}
