package com.company;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        calcolatrice op = new calcolatrice();
        System.out.println("Quale operazione si vuole effettuare? 1) Somma\t2)Differenza\t3)Moltiplicazione\t4)Divisione");
        switch(in.nextInt())
        {
            case 1: {
                op.setOp();
                op.somma();
                break;
            }
            case 2:{
                op.setOp();
                op.differenza();
                break;
            }
            case 3:{
                op.setOp();
                op.moltiplicazione();
                break;
            }
            case 4:{
                op.setOp();
                op.divisione();
                break;
            }
            default:
            {
                System.out.println("Scelta non valida!");
                break;
            }
        }

    }
}
