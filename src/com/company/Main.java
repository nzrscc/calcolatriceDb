package com.company;
import com.company.util.EspressioneToArray;

import java.util.*;
public class Main {

    public static String scelta;
    public static int controllo;

    public static void main(String[] args) {
        //ConnessioneDb con=new ConnessioneDb();
        //con.Connessionedb();
        //con.CreaTabella();
        Scanner in = new Scanner(System.in);
        System.out.println("Scrivi espressione : ");
        String espressione=in.next();
        Integer operandi[]= EspressioneToArray.getNumbersArrayFromExp(espressione);
        char operations[]=EspressioneToArray.getOperatorsArrayFromExp(espressione);
        for (int i=0;i<operandi.length;i++) System.out.println("Operando["+i+"]="+operandi[i]);
        for (int i=0;i<operations.length;i++) System.out.println("Operatore["+i+"]="+operations[i]);

        /*Calcolatrice ope = new Calcolatrice();
        do
        {
            controllo=0;
            System.out.println("Quale operazione si vuole effettuare? 1) Somma\t2) Differenza\t3) Moltiplicazione\t4) Divisione");
            controlloCarattere();
            switch(controllo)
            {
                case 0: break;
                case 1: {
                    ope.setOp();
                    ope.setRisultato(ope.somma());
                    con.setOperazione("\t+");
                    System.out.println("Il risultato è: "+ope.getRisultato());
                    break;
                }
                case 2:{
                    ope.setOp();
                    ope.setRisultato(ope.differenza());
                    con.setOperazione("\t-");
                    System.out.println("Il risultato è: "+ope.getRisultato());
                    break;
                }
                case 3:{
                    ope.setOp();
                    ope.setRisultato(ope.moltiplicazione());
                    con.setOperazione("\t*");
                    System.out.println("Il risultato è: "+ope.getRisultato());
                    break;
                }
                case 4:{
                    ope.setOp();
                    ope.setRisultato(ope.divisione());
                    con.setOperazione("\t/");
                    System.out.println("Il risultato è: "+ope.getRisultato());
                    break;
                }
                default:
                {
                    System.out.println("Scelta non valida!\n");
                    break;
                }
            }
            con.PopolaTabella(ope);
            con.ScaricoDati();
            System.out.print("\nSi vuole effettuare una nuova operazione?\t");
            System.out.println();
            scelta=in.next();
            scelta=scelta.toUpperCase();
        }while(scelta.equals("SI"));
        con.ChiudiConnessione();
        */
    }

    public static int controlloCarattere()
    {
        Scanner in=new Scanner(System.in);
        try
        {
            controllo=in.nextInt();
            return controllo;
        }catch(InputMismatchException ime)
        {
            System.out.println("Valore non valido!!\t("+ime.toString()+")\n");
            return 0;
        }
    }
}
