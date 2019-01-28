package com.company;
import java.util.*;
public class Main {

    public static String scelta;
    public static int controllo;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        calcolatrice op = new calcolatrice();
        do
        {
            controllo=0;
            System.out.println("Quale operazione si vuole effettuare? 1) Somma\t2) Differenza\t3) Moltiplicazione\t4) Divisione");
            controlloCarattere();
            switch(controllo)
            {
                case 0: break;
                case 1: {
                    op.setOp();
                    op.setRisultato(op.somma());
                    System.out.println("Il risultato è: "+op.getRisultato());
                    break;
                }
                case 2:{
                    op.setOp();
                    op.setRisultato(op.differenza());
                    System.out.println("Il risultato è: "+op.getRisultato());
                    break;
                }
                case 3:{
                    op.setOp();
                    op.setRisultato(op.moltiplicazione());
                    System.out.println("Il risultato è: "+op.getRisultato());
                    break;
                }
                case 4:{
                    op.setOp();
                    op.setRisultato(op.divisione());
                    System.out.println("Il risultato è: "+op.getRisultato());
                    break;
                }
                default:
                {
                    System.out.println("Scelta non valida!\n");
                    break;
                }
            }
            System.out.print("Si vuole effettuare una nuova operazione?\t");
            System.out.println();
            scelta=in.next();
            scelta=scelta.toUpperCase();
        }while(scelta.equals("SI"));

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
