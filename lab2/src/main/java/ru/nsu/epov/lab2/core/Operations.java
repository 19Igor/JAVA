package ru.nsu.epov.lab2.core;


public interface Operations
{
    default void workingCommand (CommandContext context){}
    default Integer returnArgNumb(){return 0;}
}