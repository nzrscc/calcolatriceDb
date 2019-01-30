package com.company.util;

import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.split;

public class  EspressioneToArray {
    public static int[] getNumbersArrayFromExp(String espressione)
    {

        String tempEspression [] = espressione.split("\\+|\\*|\\|\\-|");
        int result[] = new int[tempEspression.length];
        for (int i=0;i<tempEspression.length;i++) {
            result[i]=Integer.parseInt(tempEspression[i]);
        }
        return result;
    }

    public static String[] getOperatorsArrayFromExp(String espressione)
    {

        String tempEspression [] = espressione.split("  |D");
        String result[] = new String[tempEspression.length];
        for (int i=0;i<tempEspression.length;i++) {
            result[i]=tempEspression[i];
        }
        return result;
    }
}
