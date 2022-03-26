package ru.nsu.epov.lab1.print;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import ru.nsu.epov.lab1.print.counter.Counter;


public class PrintToCSV
{
    static private final String OutputFile = "test.csv";
    public static void Printer(Map<String, Integer> map)
    {
        final String WordTitle = "Word";
        final String FreqTitle = "Frequency";
        final String PercentTitle = "%";
        final char Separator = ',';
        try (PrintWriter writer = new PrintWriter(new File(OutputFile)))
        {
            int WordsAmount = Counter.FreqCounter(map);
            StringBuilder sb = new StringBuilder();
            sb.append(WordTitle);
            sb.append(Separator);
            sb.append(FreqTitle);
            sb.append(Separator);
            sb.append(PercentTitle);
            sb.append('\n');

            for (Map.Entry<String, Integer> entry : map.entrySet())
            {
                sb.append(entry.getKey());
                sb.append(Separator);
                sb.append(entry.getValue());
                sb.append(Separator);
                int a = entry.getValue() * 100 / WordsAmount;
                sb.append(a + PercentTitle);
                sb.append('\n');
            }

            writer.write(sb.toString());
            writer.close();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        PrintToCSV testCSV =  new PrintToCSV();
    }

    public void readCSVFile(){
        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(OutputFile)))
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
            final String sep = ",";
            rowScanner.useDelimiter(sep);
            while (rowScanner.hasNext())
            {
                values.add(rowScanner.next());
            }
        }
        return values;
    }
}
