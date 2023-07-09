/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deercompany.databaseQuery;

import com.deercompany.connection.Connector;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author gitEv
 */
public class InsertarPaciente {

    private final String QUERY = "INSERT INTO paciente(pac_dni,pac_obra,pac_apellido,pac_nombre,pac_sexo,pac_fechaNacimiento) VALUES(?,?,?,?,?,?);";
    private final Connector CONNECTOR;
    private PreparedStatement statement;

    public InsertarPaciente() {
        this.CONNECTOR = new Connector();
    }

    public int registrarEntrada(String dni, String obraSocial, String apellido, String nombre, String sexo, String fechaNacimiento) {
        int res = 0;
        try {
            statement = CONNECTOR.getConnection().prepareStatement(QUERY);
            statement.setString(1, dni);
            statement.setString(2, obraSocial);
            statement.setString(3, apellido);
            statement.setString(4, nombre);
            statement.setString(5, sexo);
            statement.setString(6, fechaNacimiento);
            res = statement.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Paciente añadido con exito");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo registrar la entrada.");
        }
        return res;
    }

}
