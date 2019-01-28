package com.company;

import com.company.interfaccia.OperazioniInterface;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calcolatrice implements OperazioniInterface {
    private double [] op;
    private int numOp;
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
        System.out.println("Su quanti operatori si vuole effettuare l'operazione?\t");
        this.numOp=in.nextInt();//controllore da fare
        this.op=new double[this.numOp];
        for(int i=0; i<this.numOp; i++)
        {
            this.op[i]=this.controllore();
        }
    }

    public double controllore()
    {
        double operatore=0.0D;
        controlloOp="false";
        while(this.controlloOp.equals("false"))
        {
            System.out.print("Inserire operatore:\t");
            try
            {
                operatore=in.nextDouble();
                this.controlloOp="true";
            }catch(InputMismatchException ime)
            {
                this.controlloOp="false";
                System.out.println("Valore non valido!!");
                in.nextLine();
            }
        }
        return operatore;
    }


    public double somma()
    {
        this.risultato=this.op[0];
        for(int i=1; i<this.numOp;i++)
        {
            this.risultato+=this.op[i];
        }
        return this.risultato;
    }

    public double differenza()
    {
        this.risultato=this.op[0];
        for(int i=1; i<this.numOp;i++)
        {
            this.risultato-=this.op[i];
        }
        return this.risultato;
    }

    public double moltiplicazione()
    {
        this.risultato=this.op[0];
        for(int i=1; i<this.numOp;i++)
        {
            this.risultato*=this.op[i];
        }
        return this.risultato;
    }

    public double divisione()
    {
        this.risultato=this.op[0];
        for(int i=1; i<this.numOp;i++)
        {
            this.risultato/=this.op[i];
        }
        return this.risultato;
    }

}
