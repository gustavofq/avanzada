/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avanzada;

import java.util.Calendar;
import javax.persistence.Basic;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Facu
 */
public class RHabitacion extends Reservas{
    
    @GeneratedValue
    @Id
    private int ID;
    @Basic
    private Calendar fechaEntrada;
    @Basic
    private Calendar fechaSalida;
    @Basic
    private int cantidad;
    @OneToOne
    private Habitacion unaHabitacion;
    @OneToOne
    private Cliente unCliente;

    public RHabitacion() {
    }


}
