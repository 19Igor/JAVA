package ru.nsu.epov.lab2.core;

import ru.nsu.epov.lab2.core.Operations;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class CommandList
{

    public Map<String, Operations> returnCommandList() throws IOException, NoSuchMethodException, InvocationTargetException {
        //CommandList a = new CommandList();
        //a.OperListReturn();
        Map<String, Operations> CommandsMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/igorepov/IdeaProjects/JAVA/lab2/src/main/java/ru/nsu/epov/lab2/core/CommandList.txt"))) {
            String address = reader.readLine();

            while (address != null) {

                String key = address.substring(0, address.indexOf(' ')).trim();  // кладется PLUS
                address = address.substring(address.indexOf(' ') + 1);     // кладется com.company.OperationFabric.Plus
                // создание класса по полному пути
                Class myClass = Class.forName(address);
                // operation command = new Plus()

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
         //for (String i : CommandsMap.keySet()) {System.out.println(i);}
}
