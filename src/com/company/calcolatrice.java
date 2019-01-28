package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class calcolatrice {
    private double op1;
    private double op2;
    private double risultato;
    private String controlloOp;
    private Scanner in=new Scanner(System.in);

    public void setRisultato(double risultato)
    {
        this.risultato=risultato;
    }

    public double getRisultato()
    {
        return this.risultato;
    }

    public void setOp()
    {
        this.setOp1();
        this.setOp2();
    }

    public void setOp1()
    {
        controlloOp="false";
        while(this.controlloOp.equals("false"))
        {
            System.out.print("Inserire il primo operatore:\t");
            try
            {
                this.op1=this.in.nextDouble();
                this.controlloOp="true";
            }catch(InputMismatchException ime)
            {
                this.controlloOp="false";
                System.out.println("Valore non valido!!");
                in.nextLine();
            }
        }
    }

    public void setOp2()
    {
        controlloOp="false";
        while(this.controlloOp.equals("false"))
        {
            System.out.print("Inserire il secondo operatore:\t");
            try
            {
                this.op2=this.in.nextDouble();
                this.controlloOp="true";
            }catch(InputMismatchException ime)
            {
                this.controlloOp="false";
                System.out.println("Valore non valido!!");
                in.nextLine();
            }
        }
    }

    public double somma()
    {
        return this.op1+this.op2;
    }

    public double differenza()
    {
        return this.op1-this.op2;
    }

    public double moltiplicazione()
    {
        return this.op1*this.op2;
    }

    public double divisione()
    {
        return this.op1/this.op2;
    }

}
