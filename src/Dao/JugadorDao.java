/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.Conexion;
import Modelo.Jugador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author MMont
 */
public class JugadorDao {
    private static final String SQL_READ = "SELECT * FROM jugador WHERE nombre = ?";
    
    private static final Conexion con = Conexion.Connectar();
    
    private ArrayList<Jugador> Jugadores= new ArrayList();
    
    public Jugador search(String name){
        Jugador j=null;
        PreparedStatement ps;
        ResultSet rs;
        try{
            ps = con.getCon().prepareStatement(SQL_READ);
            ps.setString(1, name);
            rs = ps.executeQuery();
                
            rs.next();
            j = new Jugador(rs.getString(2), rs.getString(3), rs.getInt(4));
               
            
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            con.cerrarConexion();
        }
        return j;
        
    }
}
