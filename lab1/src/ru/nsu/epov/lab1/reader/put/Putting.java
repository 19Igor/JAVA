package ru.nsu.epov.lab1.reader.put;

import java.util.Map;

public class Putting
{
    public static boolean PutInMap(Map<String, Integer> map, String TemporaryString)
    {
        final int ElementNotFound = -1;
        if (map.containsKey(TemporaryString))       // если содержится значение в коллекции, то true
        {
            int value = map.getOrDefault(TemporaryString, ElementNotFound);
            if (value == ElementNotFound)
            {
                System.out.println("Value is not found.");
                System.out.println("Printed by Reader.");
                return false;
            }
            value++;
            map.put(TemporaryString, value);
        }
        else // если в мапе не лежит этого слова, то добавляем его
        {
            map.put(TemporaryString, 1);
        }
        return true;
    }
}
