package com.company;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        String scelta;
        Scanner in = new Scanner(System.in);
        calcolatrice op = new calcolatrice();
        do
        {
            System.out.println("Quale operazione si vuole effettuare? 1) Somma\t2)Differenza\t3)Moltiplicazione\t4)Divisione");
            switch(in.nextInt())
            {
                case 1: {
                    op.setOp();
                    op.setRisultato(op.somma());
                    break;
                }
                case 2:{
                    op.setOp();
                    op.setRisultato(op.differenza());
                    break;
                }
                case 3:{
                    op.setOp();
                    op.setRisultato(op.moltiplicazione());
                    break;
                }
                case 4:{
                    op.setOp();
                    op.setRisultato(op.divisione());
                    break;
                }
                default:
                {
                    System.out.println("Scelta non valida!");
                    break;
                }
            }
            System.out.println("Il risultato è: "+op.getRisultato());
            System.out.print("Si vuole effettuare una nuova operazione?\t");
            System.out.println();
            scelta=in.next();
            scelta=scelta.toUpperCase();
        }while(scelta.equals("SI"));

    }
}
