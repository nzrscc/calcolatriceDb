package com.company.util;

public class  EspressioneToArray {

    public static Integer[] getNumbersArrayFromExp(String espressione)
    {
        String delimiters = "\\+|\\-|\\*|\\/";
        String[] tokensVal = espressione.split(delimiters);
        Integer result[] = new Integer[tokensVal.length];
        //System.out.println("Count of tokens = " + tokensVal.length);
        for(int i=0;i<tokensVal.length;i++) {
            result[i]=Integer.parseInt(tokensVal[i]);
        }
        return result;
    }

    public static char[] getOperatorsArrayFromExp(String espressione)
    {
        StringBuilder temp = new StringBuilder();
        char tempArray[]=espressione.toCharArray();
        for (int i=0;i<espressione.length();i++)
        {
            if((tempArray[i]=='+')||(tempArray[i]=='-')||(tempArray[i]=='/')||(tempArray[i]=='*'))
            {
                temp.append(tempArray[i]);
            }
        }
        String stringaOperatori=temp.toString();
        char []arrayOperatori=stringaOperatori.toCharArray();
        return arrayOperatori;
    }
}
