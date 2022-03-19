package com.company.checker;


public class CheckingFromFool
{
    public static void ArgChecker(int StringLength)
    {
        int AmountOfArg = 2;
        if (StringLength != AmountOfArg)
        {
            System.out.println("Incorrect amount of elements !");
            System.out.println("Printed by <CheckingFromFool.java>.");
            System.exit(1);
        }
    }
}
