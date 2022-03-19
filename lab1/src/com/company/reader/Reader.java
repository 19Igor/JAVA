package com.company.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import com.company.reader.put.Putting;

public class Reader
{
    public static boolean ReadText(File file, Map<String, Integer> map) throws FileNotFoundException {

        Scanner scanner = new Scanner(file);
        String TemporaryString = "";
        while(scanner.hasNextLine())
        {
            String ScanToHereWord = scanner.nextLine();   // считывает строку из файла
            String emptiness = "";
            for (int i = 0; i < ScanToHereWord.length(); i++)
            {
                String letter = String.valueOf(ScanToHereWord.charAt(i));
                char let = ScanToHereWord.charAt(i);
                if (let >= 'A' && let <= 'Z' || let >= 'a' && let <= 'z')  // если символ - это англ. буква то записываем
                {
                    TemporaryString += letter;
                }
                else if (let >= 'А' && let <= 'Я' ||
                        let >= 'а' && let <= 'я' ||
                        'Ё' == let || 'ё' == let)
                {
                    TemporaryString += letter;
                }
                else if (let >= '1' && let <= '9')             
                {
                    TemporaryString += letter;
                }
                else if (TemporaryString != emptiness)
                {
                    if (!Putting.PutInMap(map, TemporaryString))
                        return false;
                    TemporaryString = emptiness;
                }
            }
            if (TemporaryString != emptiness)
            {
                if (!Putting.PutInMap(map, TemporaryString))
                    return false;
                TemporaryString = emptiness;
            }
        }
        scanner.close();
        return true;
    }
}
