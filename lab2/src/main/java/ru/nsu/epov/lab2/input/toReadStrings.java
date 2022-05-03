package ru.nsu.epov.lab2.input;


import java.io.*;
import java.util.Scanner;

public class toReadStrings
{
    final private static String SPEC_SYMBOL = "/0";
    final static String regex = "[!@#$%^&*?()_+]";

    private static String[] DeleteShiftInString(String[] str)
    {
        int counterOfShifts = str.length;
        for(int i = 0; i < str.length - 1; i++)
        {
//            if(str[i].equals(""))
            if (str[i].matches(regex) || str[i].equals(""))
            {
                for(int j = i; j < str.length - 1; j++)
                {
                    str[j] = str[j + 1];
                }
                counterOfShifts--;
            }
        }
        str[counterOfShifts] = SPEC_SYMBOL;
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

    static String STOP_SIGNAL = "Before the end type << Stop >>";

    public static String[] ReadStringFromConsole()
    {
        StringBuilder tempString = new StringBuilder();
        Scanner console = new Scanner(System.in);
        String tempStr = console.nextLine();

        System.out.println(STOP_SIGNAL);
        while (!tempStr.equals("Stop"))
        {
            tempString.append(" " + tempStr + " ");
            tempStr = console.nextLine();
        }

        String TempAr_1[] = tempString.toString().split(" ");
        TempAr_1 = DeleteShiftInString(TempAr_1);
        console.close();
        return TempAr_1;
    }
}
