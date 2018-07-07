/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.Conexion;
import Modelo.Jugador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MMont
 */
public class JugadorDao extends BaseDao<Jugador>{

    public JugadorDao() {
        table = new TableData("Jugador","idJugador",new String[]{"nombre","puntos"});
    }
    

    @Override
    Jugador mapToObject(ResultSet resultSet) {
        Jugador j = new Jugador();
        try {
            
            j.setIdJugador(resultSet.getInt(table.PRIMARY_KEY));
            j.setName(resultSet.getString(table.fields[0]));
            j.setPuntos(resultSet.getInt(table.fields[1]));
            
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return j;
    
    }

    @Override
    PreparedStatement getSelectStatement(Connection con, Jugador find, String by) {
     String query = "SELECT * FROM " + table.TABLE_NAME + " WHERE " + by + " = ? ";
     PreparedStatement preparedStatement = null;
     
     
        try {
            preparedStatement = con.prepareStatement(query);
            if(by.equals(table.PRIMARY_KEY)){
                preparedStatement.setInt(1,find.getIdJugador());
            }
            else if(by.equals(table.fields[0])){
                preparedStatement.setString(1,find.getName());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return preparedStatement;
    
    }

    @Override
    PreparedStatement getInsertStatement(Connection con, Jugador _new) {
        PreparedStatement pStatement = null;
        
        try {
                    
                    pStatement = con.prepareStatement(
                            "INSERT INTO " + table.TABLE_NAME +
                                    "(" + table.fields[0] + "," + table.fields[1] + ")"
                                            + " VALUES(?,?)");
                    
            pStatement.setString(1, _new.getName());
            pStatement.setInt(2, _new.getPuntos());
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return pStatement;        
    
    }

    @Override
    PreparedStatement getDeleteStatement(Connection con, Jugador deleteObject) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = con.prepareStatement("DELETE FROM " + table.TABLE_NAME +" WHERE " + table.PRIMARY_KEY + " = ?" );
            preparedStatement.setInt(1,deleteObject.getIdJugador());
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
 
    }
    
    public List<Jugador> findById(Jugador j) {
        return findBy(j, table.PRIMARY_KEY);
    }

    public List<Jugador> findByNombre(Jugador j) {
        return findBy(j, table.fields[0]);
    }


    
}
