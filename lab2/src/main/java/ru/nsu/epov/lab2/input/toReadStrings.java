package ru.nsu.epov.lab2.input;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class toReadStrings
{
    final private static String SPEC_SYMBOL = "/0";
    static String STOP_SIGNAL = "After all type <<STOP>>";
    final static String regex = "[!@#$%^&*?()_+]";
    static final Logger logger = LogManager.getLogger(toReadStrings.class);

    /**
     * DeleteShiftInString deletes empty strings from array witch it gets and
     * returns same array without empty strings.
     * */
    private static String[] DeleteShiftInString(String[] str)
    {
        int counterOfShifts = str.length;
        for(int i = 0; i < str.length - 1; i++)
        {
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
        String[] tmp = new String[counterOfShifts];
        for (int i = 0; i < counterOfShifts; i++)
        {
            tmp[i] = str[i];
        }
        logger.debug("Calculator's commands reading ends.");
        return tmp;
    }
    /**
     * ReadStringFromFile reads strings (calculator's commands) from file witch it gets.
     * The method returns array of string (calculator's commands).
     * */
    public static String[] ReadStringFromFile(File InFile) throws FileNotFoundException {
        StringBuilder tempString = new StringBuilder();
        Scanner scan = new Scanner(InFile);

        while (scan.hasNextLine())
        {
            tempString.append(" " + scan.nextLine() + " ");
        }
        String[] TempAr_1 = tempString.toString().split(" ");
        TempAr_1 = DeleteShiftInString(TempAr_1);
        scan.close();
        logger.debug("Calculator's commands reading ends.");
        return TempAr_1;
    }

    /**
     * ReadStringFromFile reads strings (calculator's commands) from console witch it gets.
     * The method returns array of string (calculator's commands).
     * */
    public static String[] ReadStringFromConsole()
    {
        StringBuilder tempString = new StringBuilder();
        Scanner console = new Scanner(System.in);

        System.out.println(STOP_SIGNAL);
        String tempStr = console.nextLine();
        while (!tempStr.equals("STOP") && !tempStr.equals("stop") && !tempStr.equals("Stop"))
        {
            tempString.append(" " + tempStr + " ");
            tempStr = console.nextLine();
        }
        tempString.append(tempStr);

        String[] TempAr_1 = tempString.toString().split(" ");
        TempAr_1 = DeleteShiftInString(TempAr_1);
        console.close();
        logger.debug("Calculator's commands reading ends.");
        return TempAr_1;
    }
}
