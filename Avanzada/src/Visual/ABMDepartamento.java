/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;

import Logica.Departamento;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Facundo
 */
public class ABMDepartamento extends javax.swing.JInternalFrame {
    
    ControladoraVisual unaControladoraVisual = null;
    DefaultTableModel modelo = new DefaultTableModel();

    /**
     * Creates new form ABMDepartamento
     */
    public ABMDepartamento(ControladoraVisual unaControladora) {
        initComponents();
        unaControladoraVisual = unaControladora;
        modelo.addColumn("Número");
        modelo.addColumn("Nombre");
        cargarTabla();
    }
    
    private void cargarTabla() {
        try {
            
            //ACA LIMPIAMOS LA TABLA ANTES DE CARGARLA
            
            DefaultTableModel modelo2 = (DefaultTableModel) tblDepartamento.getModel(); //GENERO UN NUEVO TABLE MODEL.. AL CUAL LE ASIGNO EL MODELO DE LA TABLA QUE CARGAMOS 																			CON ANTERIORIDAD

            int filas = tblDepartamento.getRowCount(); ///GENERO UN INDICE PARA SABER CUANTAS FILAS TIENE MI TABLA

            for (int i = 0; i < filas; i++) {    ////RECORRO EL INDICE A TRAVES DE UN CICLO FOR

                modelo2.removeRow(0);   /////DE ESTA MANERA VOY QUITANDO EL SIEMPRE LA PRIMER FILA DEL MODELO...ESTO UNA VEZ FINALIZADO EL RECORRIDO DEL FOR NOS 								     ELIMINA TODOS LOS ELEMENTOS DE LA TABLA

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "HA OCURRIDO UN ERROR" + ex);
        }

        //ACA LA CARGAMOS
        
        List<Departamento> misDepartamentos = new LinkedList();
        
        try {
            
            misDepartamentos = unaControladoraVisual.mostrarDepartamentos();///CARGO EN UNA COLECCION LOS ELEMENTOS QUE DESEO CARGAR; EN ESTE CASO LOS TRAIGO DESDE LA CONTROLADORA 													    VISUAL
            
            Object[] fila = new Object[2];   ///GENERO UN VECTOR DE TIPO OBJECT DADO QUE EN EL VOY A CARGAR DISTINTOS TIPOS DE DATOS

            for (Departamento unDepartamento : misDepartamentos) { ///RECORRO LA LISTA UTILIZANDO UN FOR EACH
                
                ////AQUI LE ASIGNO A CADA ELEMENTO DE UN VECTOR LOS DATOS QUE QUIERO QUE SE MUESTREN
                
                fila[0] = unDepartamento.getId();
                fila[1] = unDepartamento.getNombre();
                
                
                modelo.addRow(fila);  ////AGREGO A MI MODELO UNA FILA (ES IMPORTANTE SABER QUE CADA VECTOR ES UNA FILA DA LA TABLA)
                
            }
            

            tblDepartamento.setModel(modelo); ////UNA VEZ FINALIZADO LE ASIGNO A MI TABLA EL MODELO Y ESTO MOSTRARIA LOS DATOS 
            
            TableRowSorter <TableModel> ordenar = new TableRowSorter <TableModel> (modelo);
            tblDepartamento.setRowSorter(ordenar);
            
            
            txtNombre.setText(null);
            
            
            
        } catch (Exception EX) {
            JOptionPane.showMessageDialog(null, "HA OCURRIDO UN ERROR" + EX);
        }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnModificar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDepartamento = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();

        setClosable(true);

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        tblDepartamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Nombre"
            }
        ));
        tblDepartamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDepartamentoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDepartamento);

        jLabel4.setText("DEPARTAMENTO");

        jLabel2.setText("Nombre:");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBorrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregar)
                            .addComponent(btnModificar)
                            .addComponent(btnBorrar)
                            .addComponent(btnCancelar)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        int ID = Integer.parseInt(tblDepartamento.getValueAt(tblDepartamento.getSelectedRow(), 0).toString());
        String nombre = txtNombre.getText();

        Departamento unDepartamento = unaControladoraVisual.DameElDepartamento(ID);

        try {
            unaControladoraVisual.modificarDepartamento(ID, nombre, unDepartamento);
        } catch (Exception ex) {
            Logger.getLogger(ABMDepartamento.class.getName()).log(Level.SEVERE, null, ex);
        }

        cargarTabla();

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed

        int ID = Integer.parseInt(tblDepartamento.getValueAt(tblDepartamento.getSelectedRow(), 0).toString());

        Departamento unDepartamento = unaControladoraVisual.DameElDepartamento(ID);

        try {
            unaControladoraVisual.borrarDepartamento(unDepartamento);
        } catch (Exception ex) {
            Logger.getLogger(ABMDepartamento.class.getName()).log(Level.SEVERE, null, ex);
        }

        cargarTabla();

    }//GEN-LAST:event_btnBorrarActionPerformed

    private void tblDepartamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDepartamentoMouseClicked
        txtNombre.setText(tblDepartamento.getValueAt(tblDepartamento.getSelectedRow(), 1).toString());
    }//GEN-LAST:event_tblDepartamentoMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        txtNombre.setText(null);
        cargarTabla();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        
        String nombre = txtNombre.getText();

        try {
            unaControladoraVisual.altaDepartamento(nombre);
        } catch (Exception ex) {
            Logger.getLogger(ABMDepartamento.class.getName()).log(Level.SEVERE, null, ex);
        }

        cargarTabla();

    }//GEN-LAST:event_btnAgregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDepartamento;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
