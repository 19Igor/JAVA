package com.company.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import com.company.reader.put.Putting;

public class Reader
{
    public static boolean ReadText(File file, Map<String, Integer> map) throws FileNotFoundException {
        final int SPACE = 32;
        final int engl_A = 65;
        final int engl_Z = 90;
        final int engl_a = 97;
        final int engl_z = 122;
        final int rus_A = 1040;
        final int rus_a = 1072;
        final int rus_YA = 1071;
        final int rus_ya = 1103;
        final int rus_YO = 1025;
        final int rus_yo = 1105;
        final int ONE = 48;
        final int NINE = 57;

        Scanner scanner = new Scanner(file);
        String TemporaryString = "";
        while(scanner.hasNextLine())
        {
            String ScanToHereWord = scanner.nextLine();   // считывает строку из файла

            for (int i = 0; i < ScanToHereWord.length(); i++)
            {
                String letter = String.valueOf(ScanToHereWord.charAt(i));
                int let = (int)ScanToHereWord.charAt(i);
                if (let >= engl_A && let <= engl_Z || let >= engl_a && let <= engl_z)  // если символ - это англ. буква то записываем
                {
                    TemporaryString += letter;
                }
                else if (let >= rus_A && let <= rus_YA ||
                        let >= rus_a && let <= rus_ya ||
                        rus_YO == let || rus_yo == let)
                {
                    TemporaryString += letter;
                }
                else if (let >= ONE && let <= NINE)               // если цифра, то считываем
                {
                    TemporaryString += letter;
                }
                else if (TemporaryString != "")
                {
                    if (!Putting.PutInMap(map, TemporaryString))
                        return false;
                    TemporaryString = "";
                }
            }
            if (TemporaryString != "")
            {
                if (!Putting.PutInMap(map, TemporaryString))
                    return false;
                TemporaryString = "";
            }
        }
        scanner.close();
        return true;
    }
}
