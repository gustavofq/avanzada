/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;

/**
 *
 * @author maquinola
 */
public class Verificador {
    
    public Verificador(){}
    
    public boolean campoVacio(javax.swing.JTextField unCampo){
        boolean vacio = false;
        if(unCampo.getText().equals("")!= true){
            vacio= true;
        }
    return vacio;  
    }  
    
    public boolean tablaSeleccionada(javax.swing.JTable tabla){//no se como determianar si al lista esta seleccionada
        boolean seleccionado = false;
        if (tabla.getColumnSelectionAllowed()){
            seleccionado = true;
        }
    return seleccionado;
    }
    
    public boolean datoNumerico(javax.swing.JTextField unCampo){
        try {
		Integer.parseInt(unCampo.getText());
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
    }
    
}
