package com.company;
import java.util.*;
public class Main {

    public static String scelta;
    public static int controllo;

    public static void main(String[] args) {
        ConnessioneDb con=new ConnessioneDb();
        con.Connessionedb();
        con.CreaTabella();
        Scanner in = new Scanner(System.in);
        Calcolatrice ope = new Calcolatrice();
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
                    con.PopolaTabella(ope);
                    break;
                }
                case 2:{
                    ope.setOp();
                    ope.setRisultato(ope.differenza());
                    con.setOperazione("\t-");
                    System.out.println("Il risultato è: "+ope.getRisultato());
                    con.PopolaTabella(ope);
                    break;
                }
                case 3:{
                    ope.setOp();
                    ope.setRisultato(ope.moltiplicazione());
                    con.setOperazione("\t*");
                    System.out.println("Il risultato è: "+ope.getRisultato());
                    con.PopolaTabella(ope);
                    break;
                }
                case 4:{
                    ope.setOp();
                    ope.setRisultato(ope.divisione());
                    con.setOperazione("\t/");
                    System.out.println("Il risultato è: "+ope.getRisultato());
                    con.PopolaTabella(ope);
                    break;
                }
                default:
                {
                    System.out.println("Scelta non valida!\n");
                    break;
                }
            }
            System.out.print("\nSi vuole effettuare una nuova operazione?\t");
            System.out.println();
            scelta=in.next();
            scelta=scelta.toUpperCase();
        }while(scelta.equals("SI"));
        System.out.print("Si vogliono scaricare i dati dal Db? ");
        {
            scelta=in.next();
            scelta=scelta.toUpperCase();
            if(scelta.equals("SI"))
            {
                con.ScaricoDati();
            }
        }
        con.ChiudiConnessione();
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
