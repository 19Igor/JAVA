package ru.nsu.epov.lab2.core;


public interface Operations
{
    /**
     * workingCommand is used for calculator's commands implementations.
     * The interface is used to specify the number of arguments of particular calculator's commands.
     * */
    default void workingCommand (CommandContext context){}
    default Integer returnArgNumb(){return 0;}
}