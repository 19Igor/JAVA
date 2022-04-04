package ru.nsu.epov.lab2.reading;


import java.io.*;
import java.util.Scanner;

public class toReadStrings
{
    private static String[] DeleteShiftInString(String str[])
    {
        int counterOfShifts = str.length;
        for(int i = 0; i < str.length - 1; i++)
        {
            if(str[i].equals(""))
            {
                for(int j = i; j < str.length - 1; j++)
                {
                    str[j] = str[j + 1];
                }
                counterOfShifts--;
            }
        }
        for (int i = counterOfShifts; i < str.length; i++)
        {
            str[i] = "";
        }
        return str;
    }
    public static String[] ReadStringFromFile(File InFile) throws FileNotFoundException {
        StringBuilder tempString = new StringBuilder();
        Scanner scan = new Scanner(InFile);

        while (scan.hasNextLine())
        {
            tempString.append(" " + scan.nextLine() + " ");
        }

        String TempAr_1[] = tempString.toString().split(" ");
        TempAr_1 = DeleteShiftInString(TempAr_1);
        scan.close();
        return TempAr_1;
    }

    public static String[] ReadStringFromConsole()
    {
        StringBuilder tempString = new StringBuilder();
        Scanner console = new Scanner(System.in);
        String TempStr = console.nextLine();

        System.out.println("Before the end type << Stop >>");
        while (!TempStr.equals("STOP"))
        {
            tempString.append(" " + TempStr + " ");
            TempStr = console.nextLine();
        }

        String TempAr_1[] = tempString.toString().split(" ");
        TempAr_1 = DeleteShiftInString(TempAr_1);
        console.close();
        return TempAr_1;
    }
}
