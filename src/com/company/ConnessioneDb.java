package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    /*public ConnessioneDb() {

        this.url = "jdbc:mysql://" + this.serverName + "/" + this.databaseName + "?user=" + this.username + "?password=" + this.password;
    }*/

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
                String sql = "CREATE TABLE IF NOT EXISTS REGISTRAZIONE (id INTEGER not NULL,  nome VARCHAR(255),  cognome VARCHAR(255),  età INTEGER,  PRIMARY KEY ( id ))";
                this.stmt.executeUpdate(sql);
                System.out.println("La tabella REGISTRAZIONE è stata creata!");
            }
        } catch (SQLException var4) {
            var4.printStackTrace();
        }

    }

    public void PopolaTabella() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Inserire id: ");
        this.id = scan.nextInt();
        System.out.print("Inserire nome: ");
        this.nome = scan.next();
        System.out.print("Inserire cognome: ");
        this.cognome = scan.next();
        System.out.print("Inserire età: ");
        this.età = scan.nextInt();

        try {
            String sql = "INSERT INTO REGISTRAZIONE ( id, nome, cognome, età) VALUES ('" + this.id + "', '" + this.nome + "', '" + this.cognome + "', '" + this.età + "')";
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