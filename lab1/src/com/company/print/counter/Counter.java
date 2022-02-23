package com.company.print.counter;

import java.util.Map;

public class Counter
{
    public static int FreqCounter(Map<String, Integer> map)
    {
        int WordsAmount = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet())
        {
            WordsAmount += entry.getValue();
        }
        return WordsAmount;
    }
}
