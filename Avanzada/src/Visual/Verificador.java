/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;

import Logica.Camarero;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

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
    /**
     
     Determina si alguna fila de la tabla esta seleccionada
     * @param tabla
     * @return 
     */
    public boolean tablaSeleccionada(javax.swing.JTable tabla){
        boolean seleccionado = false;
        int fila = tabla.getSelectedRow();
        if (fila != -1 ){
            seleccionado = true;
        }
    return seleccionado;
    }
    
    public boolean datoNumerico(javax.swing.JTextField unCampo){
        boolean isNumeric = false;
        try {
		Integer.parseInt(unCampo.getText());
		isNumeric =  true;
	} catch (NumberFormatException nfe){
		isNumeric = false;
	}
        return isNumeric;
    }
    
    public void lipiarTabla(javax.swing.JTable tabla){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = (DefaultTableModel) tabla.getModel();																	
        int filas = tabla.getRowCount(); 
        for (int i = 0; i < filas; i++) {   
            modelo.removeRow(0);
        }    
    }
    
}
