package com.company.checker;


public class CheckingFromFool
{
    public static void ArgChecker(int StringLength)
    {
        if (StringLength != 2)
        {
            System.out.println("Incorrect amount of elements !");
            System.out.println("Printed by <CheckingFromFool.java>.");
            System.exit(1);
        }
    }
}
