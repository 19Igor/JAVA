package ru.nsu.epov.lab3.game.C;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Ники уникальные в мапе. Я должен проверить
 *
 * */

public class PlayersTop {
    public static String nick;
    private static String separator = " ";
    public static int score = 0;
    private static final String playersTopPath = "PlayersTop.txt";

    public static void addPlayerInTable(int score)
    {
        Scanner file = null;
        try{
            HashMap<String, Integer> players = new HashMap<>();
            String sen;
            try{
                file = new Scanner(new File(playersTopPath));
            }catch (Exception e)
            {
                System.out.println("Не удалось создать сканер.");
            }

            if (!file.hasNextLine())
            {
                FileWriter fw = new FileWriter(playersTopPath);
                fw.write(nick + separator + score + separator);
                fw.flush();
                fw.close();
                return;
            }
            else
            {
                while (file.hasNextLine())
                {
                    sen = file.nextLine();
                    String[] tempArr = sen.split(separator);
                    players.put(tempArr[0], Integer.parseInt(tempArr[1]));
                }
                // проверка на то, что игрок не побил свой рекорд
                for (Map.Entry<String, Integer> entry: players.entrySet())
                {
                    if (entry.getKey().equals(nick))
                    {
                        if (entry.getValue() < score)
                            players.put(nick, score);
                        break;
                    }
                    else
                    {
                        players.put(nick, score);
                    }
                }
                players = sortMap(players);
                // считываю в файл
                FileWriter fw = new FileWriter("PlayersTop.txt");
                for (Map.Entry<String, Integer> entry: players.entrySet())
                {
                    fw.write(entry.getKey() + separator + entry.getValue() + separator);
                    fw.flush();
                }
                fw.close();
            }
            file.close();
        }catch(IOException e) {
            System.out.println("Файл не открылся.");
        }
    }

    public static HashMap<String, Integer> sortMap(HashMap<String, Integer> map)
    {
        map = map.entrySet()
                .stream()
                .sorted((i1, i2) -> i2.getValue().compareTo(i1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (z1, z2) -> z1, LinkedHashMap::new));
        return map;
    }
}
