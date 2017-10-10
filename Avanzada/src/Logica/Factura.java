/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import javax.persistence.Basic;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Facu
 */
public class Factura {
    
    @GeneratedValue
    @Id
    private int ID;
    @Basic
    private String Tipo;
    @Basic
    private Double total;
    @OneToOne
    private Cliente unCliente;
    
}
