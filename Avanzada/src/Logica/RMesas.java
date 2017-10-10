/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.Calendar;
import javax.persistence.Basic;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Facu
 */
public class RMesas extends Reservas{
    
    @GeneratedValue
    @Id
    private int ID;
    @Basic
    private int numeroMesa;
    @Basic
    private Calendar fecha;
    @OneToOne
    private Cliente unCliente;
    
    
    
}
