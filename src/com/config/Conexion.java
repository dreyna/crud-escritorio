/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author dreyna
 */
public class Conexion {
    private final String url = "jdbc:mysql://localhost/bdcrud??autoReconnect=true&useSSL=false";
    private Connection con = null;
    public Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "root");
            System.out.println("Conectado");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: "+e);
        }
    }
    public Connection conectado(){
    return con;
    }
    public void close(){
    con=null;
        System.out.println("Desconectado...!");
    }
}
