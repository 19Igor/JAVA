package ru.nsu.epov.lab1;

import ru.nsu.epov.lab1.checker.CheckingFromFool;
import ru.nsu.epov.lab1.print.PrintToCSV;
import ru.nsu.epov.lab1.reader.Reader;
import ru.nsu.epov.lab1.sort.Sort;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class Main
{
    public static void main(String [] args) throws IOException {
        final int InPathIndex = 0;

        CheckingFromFool.ArgChecker(2);
        Map<String, Integer> map = new HashMap<String, Integer>();

        String separator = File.separator;
        File InFile = new File("src"+ separator + args[InPathIndex]);

        if (!Reader.ReadText(InFile, map))
        {
            System.out.println("Problems with reading.");
            System.out.print("Printed by Main.java");
        }

        Sort.SortMap(map);

        PrintToCSV.Printer(map);
    }
}
