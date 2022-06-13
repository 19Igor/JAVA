package ru.nsu.epov.lab2.core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is needed to create and load classes in map.
 * */
public class CommandList
{
    public Map<String, Operations> returnCommandList(){
        Map<String, Operations> CommandsMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/java/ru/nsu/epov/lab2/core/CommandList.txt"))) {
            String address = reader.readLine();

            while (address != null) {
                // substring возвращает подстроку начиная с 0 символа и до первого пробела
                String key = address.substring(0, address.indexOf(' ')).trim();  // кладется PLUS
                // substring возвращает подстроку начиная с первго символа после пробела и до конца
                address = address.substring(address.indexOf(' ') + 1);     // кладется com.company.OperationFabric.Plus
                // создание класса по полному пути
                Class myClass = Class.forName(address);
                // operation commandPlus = new Plus()

                //getDeclaredConstructor() - возвращает массив с конструкторами, объявлеными в классе myClass
                Operations command = (Operations) myClass.getDeclaredConstructor().newInstance();   // создание объекта типа (Operations)

                CommandsMap.put(key, command);
                address = reader.readLine();
            }
        } catch (FileNotFoundException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        finally{
            return CommandsMap;
        }
    }
}
