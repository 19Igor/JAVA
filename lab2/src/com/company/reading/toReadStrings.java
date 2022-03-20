package com.company.reading;

import javax.swing.plaf.synth.SynthToolTipUI;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Scanner;

public class toReadStrings
{
    public static String[] ReadString(File InFile) throws FileNotFoundException {
        String TempString = "";
        Scanner scan = new Scanner(InFile);

        while (scan.hasNextLine())
        {
            TempString += " " + scan.nextLine() + " ";
        }

        String TempAr_1[] = TempString.split(" ");
        scan.close();
        return TempAr_1;
    }
}
