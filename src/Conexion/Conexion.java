/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

/**
 *
 * @author MMont
 */
public class Conexion {
    private String user, pass, driver,url;
    private static Conexion instance;
    private Connection con;
    
    public synchronized static Conexion Connectar(){
        if (instance==null){
            instance= new Conexion();
        }
        return instance;
    }

    public Conexion() {
    cargarCredenciales();
    try{
        Class.forName(this.driver);
        con = (Connection) DriverManager.getConnection(url, user, pass);
        
    }catch(Exception e){
        
        }
    }
    
    public void cargarCredenciales(){
        this.user="root";
        pass="";
        driver="com.mysql.jdbc.Driver";
        url = "jdbc:mysql://localhost:3306/videojuego";
    }

    public Connection getCon() {
        return con;
    }
    public void cerrarConexion(){
        instance = null;
    }
    
    
}
