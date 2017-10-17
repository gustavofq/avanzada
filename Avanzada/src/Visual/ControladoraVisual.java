/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;

import Logica.Hotel;

/**
 *
 * @author Facundo
 */
public class ControladoraVisual {
    
    //RELACIONES
    
    private Hotel unHotel = new Hotel();

    public ControladoraVisual(Hotel unHotel) {
        this.unHotel = unHotel;
    }
    
    public ControladoraVisual() {
    }

    
    //METODOS QUE LLAMAN A EMPRESA
    
    //CAMARERO
    
    public void altaOrdenDeTrabajo(int codigo, String descripcion, Calendar fechaEntrada, Calendar fechaSalida, Double costo, Time tiempoEstimado){
        this.unaEmpresa.altaOrdenDeTrabajo(codigo, descripcion, fechaEntrada, fechaSalida, costo, tiempoEstimado);
    }
     
    public void modificarOrdenTrabajo (String descripcion, Calendar fechaEntrada,Calendar fechaSalida, Double costo, Time tiempoEstimado, OrdenTrabajo unaOrdenTrabajo){
        this.unaEmpresa.modificarOrdenTrabajo(descripcion, fechaEntrada, fechaSalida, costo, tiempoEstimado, unaOrdenTrabajo);
    } 
    public void borrarOrdenTrabajo(OrdenTrabajo unaOrdenTrabajo){
        this.unaEmpresa.borrarOrdenTrabajo(unaOrdenTrabajo);
    }
    
    public List<OrdenTrabajo> mostrarOrdenesTrabajos(){
        return this.unaEmpresa.mostrarOrdenesTrabajos();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
