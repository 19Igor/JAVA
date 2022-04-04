package ru.nsu.epov.lab1.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ru.nsu.epov.lab1.reader.put.Putting;

public class Reader
{
    public static boolean ReadText(File file, Map<String, Integer> map) throws FileNotFoundException {

        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine())
        {
            String ScanToHereWord = scanner.nextLine();   // считывает строку из файла

            final String regex = "[^\\s\\Q?,.;:()<>!&#*{}[]\\E\\\"]+";
            Pattern pattern = Pattern.compile(regex);
            Matcher mather = pattern.matcher(ScanToHereWord);

            while (mather.find())
            {
                String TemporaryString = mather.group();
                if (!Putting.PutInMap(map, TemporaryString))
                    return false;
            }
        }
        scanner.close();
        return true;
    }
}
