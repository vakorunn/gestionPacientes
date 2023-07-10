/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deercompany.databaseQuery;

import com.deercompany.connection.Connector;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author gitEv
 */
public class InsertarTurno {
    
    private final String QUERY = "INSERT INTO cita(cit_id,cit_obra,cit_apellido,cit_nombre,cit_fechaTurno,cit_horaTurno) VALUES(?,?,?,?,?,?)";
    private final Connector CONNECTOR;
    private PreparedStatement statement;
    
    public InsertarTurno() {
        this.CONNECTOR = new Connector();
        this.statement = null;
    }
    
    public int registrarTurno(String obraSocial, String apellido, String nombre, String fechaTurno, String horaTurno) {
        int res = 0;
        try {
            statement = CONNECTOR.getConnection().prepareStatement(QUERY);
            statement.setInt(1, 0);
            statement.setString(2, obraSocial);
            statement.setString(3, apellido);
            statement.setString(4, nombre);
            statement.setString(5, fechaTurno);
            statement.setString(6, horaTurno);
            res = statement.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Turno añadido con exito");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo registrar la entrada.");
        }
        return res;
    }
    
}
