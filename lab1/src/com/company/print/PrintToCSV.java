package com.company.print;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import com.company.print.counter.Counter;


public class PrintToCSV
{
    public static void Printer(Map<String, Integer> map)
    {
        try (PrintWriter writer = new PrintWriter(new File("test.csv")))
        {
            int WordsAmount = Counter.FreqCounter(map);
            StringBuilder sb = new StringBuilder();
            sb.append("Word");
            sb.append(',');
            sb.append("Frequency");
            sb.append(',');
            sb.append("%");
            sb.append('\n');

            for (Map.Entry<String, Integer> entry : map.entrySet())
            {
                sb.append(entry.getKey());
                sb.append(',');
                sb.append(entry.getValue());
                sb.append(',');
//                int b = entry.getValue();
                int a = entry.getValue() * 100 / WordsAmount;
                sb.append(a + "%");
                sb.append('\n');
//                System.out.println("Word =  " + entry.getKey() + " Frequency = " + entry.getValue());
            }

            writer.write(sb.toString());
            writer.close();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        PrintToCSV testCSV =  new PrintToCSV();
//        testCSV.readCSVFile();
    }

    public void readCSVFile(){
        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("test.csv")))
        {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(records.toString());
    }
    private List<String> getRecordFromLine(String line)
    {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line))
        {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext())
            {
                values.add(rowScanner.next());
            }
        }
        return values;
    }
}
