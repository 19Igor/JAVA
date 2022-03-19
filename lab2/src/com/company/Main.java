package com.company;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.HashMap;
import java.util.Map;


import com.company.OperationFabric.Operations;
import com.company.input.Input;
import com.company.perpetrator.Perpetrator;
import com.company.reading.toReadStrings;
import com.company.OperationFabric.CommandList;
import java.util.Stack;


public class Main {

    public static void main(String[] args) throws IOException, InvocationTargetException, NoSuchMethodException {
        String FilePath = Input.toEnterInputFilePath(args[0]);
        File InFile = new File(FilePath);
        Map<String, Double> DefineMap = new HashMap<String, Double>();
        Stack<Double> stack = new Stack<Double>();

        // счет FileToString начитать с 1, т.к. на нулевом месте пустота
        // Массив строк, где каждая строка является словом в файле
        String FileToString_1[] = toReadStrings.ReadString(InFile);

        CommandList A = new CommandList();
        Map<String, Operations> ReturnedOperations = A.OperListReturn();

        Perpetrator.Perp(FileToString_1, stack, DefineMap);
    }
}
