/*
Plain
Old
Java
Object
Jugador
 */
package Modelo;

import java.util.logging.Logger;

/**
 *
 * @author MMont
 */
public class Jugador {
    private int idJugador;
    private String name;
    private int puntos;

    public Jugador() {
    }

    public Jugador(int idJugador, String name, int puntos) {
        this.idJugador = idJugador;
        this.name = name;
        this.puntos = puntos;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

   
    
    

    
    
    
}
