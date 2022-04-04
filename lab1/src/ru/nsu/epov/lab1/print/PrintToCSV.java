package ru.nsu.epov.lab1.print;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import ru.nsu.epov.lab1.print.counter.Counter;


public class PrintToCSV
{
    static public  final double toRound(double number)   // number = 3.1415
    {
        number *= 1000;                           // number = 3141.5
        number /= 10;                             // number = 314
        number %= 100;                            // number = 3.14
        return number;
    }

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
                double a = entry.getValue() * 100 / WordsAmount;
                a = toRound(a);
                sb.append(a + PercentTitle);
                sb.append('\n');
            }

            writer.write(sb.toString());

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
