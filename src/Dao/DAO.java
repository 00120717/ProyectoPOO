/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.Conexion;
import java.util.List;

/**
 *
 * @author MMont
 */
public interface DAO<T> {
    Conexion con = Conexion.Connectar();
    
    List<T> findAll();
    List<T> findBy(T find, String by);
    boolean insert(T insertObject);
    boolean update(T updateObject);
    boolean delete(T deleteObject);
}
