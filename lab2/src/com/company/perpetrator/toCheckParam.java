package com.company.perpetrator;

public class toCheckParam {
    private static final double flag = - 0.0;

    public static boolean isDigit(String param2)
    {
        try{
            double val = Double.parseDouble(param2);
            return true;
        }catch (Exception e)
        {
            System.out.println("Incorrect second parameter.\n");
            System.out.println("Printed by toCheckSecParam\n");
            return false;
        }

    }
}
