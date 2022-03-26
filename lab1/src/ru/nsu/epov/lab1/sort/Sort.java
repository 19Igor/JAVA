package ru.nsu.epov.lab1.sort;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Sort
{
    public static HashMap<String, Integer> SortMap(HashMap<String, Integer> map)
    {
         map = map.entrySet()
                .stream()
                .sorted((i1, i2) -> i2.getValue().compareTo(i1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (z1, z2) -> z1, LinkedHashMap::new));

         return map;
    }
}
