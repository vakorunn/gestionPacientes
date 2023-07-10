/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deercompany.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author EvakOrunn
 * @version 1.0.0
 * 
 * 
 * 
 */
public class Connector {
    
    private Connection connector;
    private final String URL = "jdbc:mysql://localhost:3306/gestion";
    private final String USER = "root";
    private final String PASSWORD = "Pascal261";
    
    public Connector() {
        this.connector = null;
    }
    
    public Connection getConnection() {
        try {
            connector = DriverManager.getConnection(URL,USER,PASSWORD);
            return connector;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al establecer conexión con la base de datos");
            if (e.getErrorCode() == 1049) {
                JOptionPane.showMessageDialog(null, "Motivo:La base de datos no se encuentra en los registros");
            }
            return connector;
        }
    }
    
    public void disconnect() {
        try {
            connector.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al desconectar la base de datos");
        }
    }   
    
}
