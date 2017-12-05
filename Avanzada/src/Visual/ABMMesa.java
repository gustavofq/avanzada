/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;

import Logica.Mesa;
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
public class ABMMesa extends javax.swing.JInternalFrame {
    
    ControladoraVisual unaControladoraVisual = null;
    DefaultTableModel modelo = new DefaultTableModel();

    /**
     * Creates new form ABMMesa
     */
    public ABMMesa(ControladoraVisual unaControladora) {
        initComponents();
        unaControladoraVisual = unaControladora;
        modelo.addColumn("ID");
        modelo.addColumn("Estado");
        cargarTabla();
    }
    
    private void cargarTabla() {
        try {
            
            //ACA LIMPIAMOS LA TABLA ANTES DE CARGARLA
            
            DefaultTableModel modelo2 = (DefaultTableModel) tblMesas.getModel(); //GENERO UN NUEVO TABLE MODEL.. AL CUAL LE ASIGNO EL MODELO DE LA TABLA QUE CARGAMOS 																			CON ANTERIORIDAD

            int filas = tblMesas.getRowCount(); ///GENERO UN INDICE PARA SABER CUANTAS FILAS TIENE MI TABLA

            for (int i = 0; i < filas; i++) {    ////RECORRO EL INDICE A TRAVES DE UN CICLO FOR

                modelo2.removeRow(0);   /////DE ESTA MANERA VOY QUITANDO EL SIEMPRE LA PRIMER FILA DEL MODELO...ESTO UNA VEZ FINALIZADO EL RECORRIDO DEL FOR NOS 								     ELIMINA TODOS LOS ELEMENTOS DE LA TABLA

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "HA OCURRIDO UN ERROR" + ex);
        }

        //ACA LA CARGAMOS
        
        List<Mesa> misMesas = new LinkedList();
        
        try {
            
            misMesas = unaControladoraVisual.mostrarMesas();///CARGO EN UNA COLECCION LOS ELEMENTOS QUE DESEO CARGAR; EN ESTE CASO LOS TRAIGO DESDE LA CONTROLADORA 													    VISUAL
            
            Object[] fila = new Object[2];   ///GENERO UN VECTOR DE TIPO OBJECT DADO QUE EN EL VOY A CARGAR DISTINTOS TIPOS DE DATOS

            for (Mesa unaMesa : misMesas) { ///RECORRO LA LISTA UTILIZANDO UN FOR EACH
                
                ////AQUI LE ASIGNO A CADA ELEMENTO DE UN VECTOR LOS DATOS QUE QUIERO QUE SE MUESTREN
                
                fila[0] = unaMesa.getId();
                fila[1] = unaMesa.getEstado();
                
                
                modelo.addRow(fila);  ////AGREGO A MI MODELO UNA FILA (ES IMPORTANTE SABER QUE CADA VECTOR ES UNA FILA DA LA TABLA)
                
            }
            

            tblMesas.setModel(modelo); ////UNA VEZ FINALIZADO LE ASIGNO A MI TABLA EL MODELO Y ESTO MOSTRARIA LOS DATOS 
            
            TableRowSorter <TableModel> ordenar = new TableRowSorter <TableModel> (modelo);
            tblMesas.setRowSorter(ordenar);
            
            
            txtEstado.setText(null);
            
            
            
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

        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMesas = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        txtEstado = new javax.swing.JTextField();

        setClosable(true);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

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

        tblMesas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Estado"
            }
        ));
        tblMesas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMesasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMesas);

        jLabel4.setText("MESAS");

        jLabel2.setText("Estado:");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(138, 138, 138))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAgregar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnModificar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBorrar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                            .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
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

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        
        String estado = txtEstado.getText();

        try {
            unaControladoraVisual.altaMesa(estado);
        } catch (Exception ex) {
            Logger.getLogger(ABMMesa.class.getName()).log(Level.SEVERE, null, ex);
        }

        cargarTabla();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        int ID = Integer.parseInt(tblMesas.getValueAt(tblMesas.getSelectedRow(), 0).toString());
        String estado = txtEstado.getText();

        Mesa unaMesa = unaControladoraVisual.DameLaMesa(ID);

        try {
            unaControladoraVisual.modificarMesa(ID, estado, unaMesa);
        } catch (Exception ex) {
            Logger.getLogger(ABMMesa.class.getName()).log(Level.SEVERE, null, ex);
        }

        cargarTabla();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed

        int ID = Integer.parseInt(tblMesas.getValueAt(tblMesas.getSelectedRow(), 0).toString());

        Mesa unaMesa = unaControladoraVisual.DameLaMesa(ID);

        try {
            unaControladoraVisual.borrarMesa(unaMesa);
        } catch (Exception ex) {
            Logger.getLogger(ABMMesa.class.getName()).log(Level.SEVERE, null, ex);
        }

        cargarTabla();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void tblMesasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMesasMouseClicked
        txtEstado.setText(tblMesas.getValueAt(tblMesas.getSelectedRow(), 1).toString());
    }//GEN-LAST:event_tblMesasMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        txtEstado.setText(null);
        cargarTabla();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMesas;
    private javax.swing.JTextField txtEstado;
    // End of variables declaration//GEN-END:variables
}
