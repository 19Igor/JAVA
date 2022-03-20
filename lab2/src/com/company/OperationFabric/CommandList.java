package com.company.OperationFabric;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class CommandList
{
    private BufferedReader reader;
    private Map<String, Operations> CommandsMap;

    public Map<String, Operations> OperListReturn()
    {
        int a = 10;
        return CommandsMap;
    }

    public CommandList() throws IOException, NoSuchMethodException, InvocationTargetException
    {
        //CommandList a = new CommandList();
        //a.OperListReturn();
         try
         {
            reader = new BufferedReader(new FileReader("/Users/igorepov/IdeaProjects/JAVA/lab2/src/com/company/OperationFabric/NewFile1"));
            CommandsMap = new HashMap<>();
         }
         catch (FileNotFoundException e)
         {
            e.printStackTrace();
         }
         String address = reader.readLine();
         while (address != null)
         {
             try
             {
                 String key = address.substring(0, address.indexOf(' ')).trim();  // кладется +
                 address = address.substring(address.indexOf(' ') + 1);     // кладется com.company.OperationFabric.Plus
                 // создание класса по адрессу address
                 Class myClass = Class.forName(address);   // эксперимент <?>
                 // operation command = new Plus()

                 //getDeclaredConstructor() - возвращает массив с конструкторами, объявлеными в классе myClass
                 Operations command = (Operations)myClass.getDeclaredConstructor().newInstance();   // создание объекта типа (Operations)
                 // myClass = (Class<?>) myClass.newInstance();

                 CommandsMap.put(key, command);
                 address = reader.readLine();
             }
             catch (ClassNotFoundException | InstantiationException | IllegalAccessException e)
             {
                 e.printStackTrace();
             }
         }
         //for (String i : CommandsMap.keySet()) {System.out.println(i);}
    }
}
