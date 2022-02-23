package com.company.sort;

import java.util.Map;

public class Sort
{
    public static void SortMap(Map<String, Integer> map)
    {
        map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed());
    }
}
