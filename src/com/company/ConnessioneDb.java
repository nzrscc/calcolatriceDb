package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;

public class ConnessioneDb {
    private String driverName = "com.mysql.cj.jdbc.Driver";
    private String serverName;
    private String databaseName;
    private String username;
    private String password;
    private FileInputStream fin;
    private Properties p;
    private String url;
    private Connection connection;
    private Statement stmt;
    private String nomeTabella;
    private int id;
    private String nome;
    private String cognome;
    private int età;
    private String operazione;
    private Timestamp timestamp;

    public void setOperazione(String operazione)
    {
        this.operazione=operazione;
    }

    public String getOperazione()
    {
        return this.operazione;
    }

    public void Connessionedb() {
        try {
            this.fin=new FileInputStream("src/com/company/db.properties");
            this.p = new Properties();
            this.p.load(fin);
            this.serverName=p.getProperty("sN");
            this.databaseName=p.getProperty("dN");
            this.username=p.getProperty("uN");
            this.password=p.getProperty("uP");
            this.url = "jdbc:mysql://" + this.serverName + "/" + this.databaseName + "?user=" + this.username + "?password=" + this.password;
            Class.forName(this.driverName);
            System.out.println("Connessione al database selezionato ...");
            this.connection = DriverManager.getConnection(this.url, this.username, this.password);
            System.out.println("Connessione effettuata!!");
            this.stmt = this.connection.createStatement();
        } catch (SQLException var2) {
            var2.printStackTrace();
        } catch (ClassNotFoundException var3) {
            var3.printStackTrace();
        }catch (FileNotFoundException fnfe)
        {
            fnfe.printStackTrace();
        }catch (IOException ie)
        {
            ie.printStackTrace();
        }

    }

    public void CreaTabella() {
        try {
            DatabaseMetaData dbm = this.connection.getMetaData();
            ResultSet tabella = dbm.getTables((String)null, (String)null, "CALCOLATRICE", (String[])null);
            if (tabella.next()) {
                System.out.println("La tabella esiste!");
            } else {
                String sql = "CREATE TABLE IF NOT EXISTS CALCOLATRICE (Operatori VARCHAR(100), Operazione VARCHAR(10), Risultato DOUBLE, Data_Operazione VARCHAR(30))";
                this.stmt.executeUpdate(sql);
                System.out.println("La tabella CALCOLATRICE è stata creata!");
            }
        } catch (SQLException var4) {
            var4.printStackTrace();
        }

    }

    public void PopolaTabella(Calcolatrice ope ) {
        Scanner scan = new Scanner(System.in);
        timestamp=new Timestamp(System.currentTimeMillis());
        /*System.out.print("Inserire id: ");
        this.id = scan.nextInt();
        System.out.print("Inserire nome: ");
        this.nome = scan.next();
        System.out.print("Inserire cognome: ");
        this.cognome = scan.next();
        System.out.print("Inserire età: ");
        this.età = scan.nextInt();
        */
        String operatori= Arrays.toString(ope.getOp()); //Stringa contenente tutti gli operatori
        System.out.println(operatori);

        try {
            String sql = "INSERT INTO CALCOLATRICE (Operatori, Operazione, Risultato, Data_Operazione) VALUES ('" + operatori + "', '" + this.operazione + "', '" + ope.getRisultato() + "', '" + timestamp + "')";
            this.stmt.executeUpdate(sql);
            System.out.println("\nRecord aggiunto!!");
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

    }

    public void ScaricoDati() {
        try {
            ResultSet resultset = this.stmt.executeQuery("SELECT id, nome, cognome, età FROM REGISTRAZIONE");
            System.out.println("Lettura informazioni...\n");

            while(resultset.next()) {
                int id = resultset.getInt(1);
                String nome = resultset.getString(2);
                String cognome = resultset.getString(3);
                int età = resultset.getInt(4);
                System.out.println("Id: " + id + ";\t\t Nome: " + nome + ";\t\tCognome: " + cognome + ";\t\tEtà: " + età);
            }
        } catch (SQLException var6) {
            var6.printStackTrace();
        }

    }

    public void ChiudiConnessione() {
        if (this.connection != null) {
            try {
                this.connection.close();
                System.out.println("Connessione chiusa!!");
            } catch (SQLException var2) {
                var2.printStackTrace();
            }
        }

    }
}
