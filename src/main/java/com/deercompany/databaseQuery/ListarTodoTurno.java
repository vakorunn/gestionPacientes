/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deercompany.databaseQuery;

import com.deercompany.connection.Connector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gitEv
 */
public class ListarTodoTurno {
    
    private PreparedStatement statement;
    private ResultSet resultSet;
    private final Connector CONNECTOR;
    private final String SQL_QUERY = "SELECT * FROM cita WHERE DATEDIFF(CURDATE(),cit_fechaTurno) < 3;";
    private DefaultTableModel tableModel;
    
    public ListarTodoTurno() {
        this.CONNECTOR = new Connector();
        this.statement = null;
    }
    
    private DefaultTableModel setTableModel() {
        tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableModel.addColumn("ID");
        tableModel.addColumn("OBRA SOCIAL");
        tableModel.addColumn("APELLIDO");
        tableModel.addColumn("NOMBRE");
        tableModel.addColumn("FECHA TURNO");
        tableModel.addColumn("HORA TURNO");
        return tableModel;
    }
    
    public DefaultTableModel getDatosTurno(){
        try {
            setTableModel();
            statement = CONNECTOR.getConnection().prepareStatement(SQL_QUERY);
            resultSet = statement.executeQuery();
            Object[] fila = new Object[6];
            while(resultSet.next()){
                fila[0] = resultSet.getInt(1);
                fila[1] = resultSet.getString(2);
                fila[2] = resultSet.getString(3);
                fila[3] = resultSet.getString(4);
                fila[4] = resultSet.getDate(5);
                fila[5] = resultSet.getTime(6);
                tableModel.addRow(fila);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar los datos."+e.getMessage());
        } finally{
            statement = null;
            resultSet = null;
            CONNECTOR.disconnect();
        }
        return tableModel;
    }
    
}
