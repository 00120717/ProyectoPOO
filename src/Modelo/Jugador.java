/*
Plain
Old
Java
Object
Jugador
 */
package Modelo;

/**
 *
 * @author MMont
 */
public class Jugador {
    private String firstName;
    private String lastName;
    private int edad;

    public Jugador(String firstName, String lastName, int edad) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.edad = edad;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
}
