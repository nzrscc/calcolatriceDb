package com.company;

import java.util.Scanner;

public class calcolatrice {
    private double op1;
    private double op2;
    private Scanner in=new Scanner(System.in);

    public void setOp()
    {
        System.out.print("Inserire il primo operatore:\t");
        this.op1=this.in.nextDouble();
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
