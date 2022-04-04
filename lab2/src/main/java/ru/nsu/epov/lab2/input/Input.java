package ru.nsu.epov.lab2.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Input
{
    public static String toEnterInputFilePath(String ar) throws IOException {
        String FilePath;
        if (ar.length() == 0)
        {
            System.out.println("Введите путь к файлу: ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FilePath = reader.readLine();
        }
        else
        {
            FilePath = ar;
        }
        return FilePath;
    }
}
