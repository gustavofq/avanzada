/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import javax.persistence.Entity;

/**
 *
 * @author Facu
 */
@Entity
public class Recepcionista extends Empleado{

    public Recepcionista() {
    }

    public Recepcionista(int DNI, String nombre, String apellido) {
        super(DNI, nombre, apellido);
    }
    
    
}
