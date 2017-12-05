/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;

import Logica.Habitacion;
import Logica.RHabitacion;
import Logica.Servicio;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Facu
 */
public class Presupuesto extends javax.swing.JInternalFrame {
    
    ControladoraVisual unaControladoraVisual = null;
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel modelo1 = new DefaultTableModel();
    DefaultTableModel modelo2 = new DefaultTableModel();
    DefaultComboBoxModel comboServicio = new DefaultComboBoxModel();
    Verificador unVerificador = new Verificador();
    /**
     * Creates new form Presupuesto
     */
    public Presupuesto(ControladoraVisual unaControladora) {
        initComponents();
        unaControladoraVisual = unaControladora;
        modelo.addColumn("Numero Hab.");
        modelo.addColumn("Tipo Hab.");
        modelo.addColumn("Precio");
        modelo1.addColumn("Servicio");
        modelo1.addColumn("Descripcion");
        modelo1.addColumn("Precio");
        modelo2.addColumn("Tipo Hab.");
        modelo2.addColumn("Cantidad");
        modelo2.addColumn("Total");
        cargarComboServicio();
        cargarTabla();
    }
    
    public void cargarComboServicio(){
        
        List<Servicio> misServicios = unaControladoraVisual.mostrarServicios();
        
        for (Servicio unServicio : misServicios) {
            comboServicio.addElement(unServicio.getNombre());
        }
        
        cmbServicio.setModel(comboServicio);
        
    }
    
    
    private void cargarTabla() {
        try {
            
            //ACA LIMPIAMOS LA TABLA ANTES DE CARGARLA
            
            DefaultTableModel modelo4 = (DefaultTableModel) tblHabitacion.getModel(); //GENERO UN NUEVO TABLE MODEL.. AL CUAL LE ASIGNO EL MODELO DE LA TABLA QUE CARGAMOS 																			CON ANTERIORIDAD

            int filas = tblHabitacion.getRowCount(); ///GENERO UN INDICE PARA SABER CUANTAS FILAS TIENE MI TABLA

            for (int i = 0; i < filas; i++) {    ////RECORRO EL INDICE A TRAVES DE UN CICLO FOR

                modelo4.removeRow(0);   /////DE ESTA MANERA VOY QUITANDO EL SIEMPRE LA PRIMER FILA DEL MODELO...ESTO UNA VEZ FINALIZADO EL RECORRIDO DEL FOR NOS 								     ELIMINA TODOS LOS ELEMENTOS DE LA TABLA

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "HA OCURRIDO UN ERROR" + ex);
        }

        //ACA LA CARGAMOS
        
        List<Habitacion> misHabitaciones = new LinkedList();
        
        try {
            
            misHabitaciones = unaControladoraVisual.mostrarHabitaciones(); ///CARGO EN UNA COLECCION LOS ELEMENTOS QUE DESEO CARGAR; EN ESTE CASO LOS TRAIGO DESDE LA CONTROLADORA 													    VISUAL
            
            Object[] fila = new Object[3];  ///GENERO UN VECTOR DE TIPO OBJECT DADO QUE EN EL VOY A CARGAR DISTINTOS TIPOS DE DATOS

            for (Habitacion unaHabitacion : misHabitaciones) { ///RECORRO LA LISTA UTILIZANDO UN FOR EACH
                
                ////AQUI LE ASIGNO A CADA ELEMENTO DE UN VECTOR LOS DATOS QUE QUIERO QUE SE MUESTREN
                fila[0] = unaHabitacion.getId();
                fila[1] = unaHabitacion.getUnTipo().getNombre();
                fila[2] = unaHabitacion.getMontoPorNoche();

                modelo.addRow(fila);  ////AGREGO A MI MODELO UNA FILA (ES IMPORTANTE SABER QUE CADA VECTOR ES UNA FILA DA LA TABLA)
                
            }
            

            tblHabitacion.setModel(modelo); ////UNA VEZ FINALIZADO LE ASIGNO A MI TABLA EL MODELO Y ESTO MOSTRARIA LOS DATOS 
            
            TableRowSorter <TableModel> ordenar = new TableRowSorter <TableModel> (modelo);
            tblHabitacion.setRowSorter(ordenar);
            
            txtCantidad.setText(null);
            
            
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jdcEntrada = new com.toedter.calendar.JDateChooser();
        jdcSalida = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHabitacion = new javax.swing.JTable();
        btnConsultar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        cmbServicio = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblServicio = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        lblTotal = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHabitacionTotal = new javax.swing.JTable();
        btnAgregarHab = new javax.swing.JButton();
        btnBorrarHab = new javax.swing.JButton();
        btnCalcular = new javax.swing.JButton();
        btnCancelarTotal = new javax.swing.JButton();
        lblDias = new javax.swing.JLabel();
        btnCalcularDias = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setText("Fecha Entrada:");

        jLabel2.setText("Servicio:");

        jLabel3.setText("Precio Final:");

        jLabel4.setText("Fecha Salida:");

        tblHabitacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Numero Hab.", "Tipo Hab.", "Precio"
            }
        ));
        jScrollPane1.setViewportView(tblHabitacion);

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        cmbServicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tblServicio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Servicio", "Descripcion", "Precio"
            }
        ));
        jScrollPane2.setViewportView(tblServicio);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        lblTotal.setText("xxx");

        jLabel5.setText("Cantidad:");

        tblHabitacionTotal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tipo Hab.", "Cantidad", "Total"
            }
        ));
        jScrollPane3.setViewportView(tblHabitacionTotal);

        btnAgregarHab.setText("Agregar Hab.");
        btnAgregarHab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarHabActionPerformed(evt);
            }
        });

        btnBorrarHab.setText("Borrar Hab.");
        btnBorrarHab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarHabActionPerformed(evt);
            }
        });

        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        btnCancelarTotal.setText("Cancelar");
        btnCancelarTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarTotalActionPerformed(evt);
            }
        });

        lblDias.setText("xxx");

        btnCalcularDias.setText("Calcular Dias");
        btnCalcularDias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularDiasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jdcSalida, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jdcEntrada, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCantidad, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(31, 31, 31))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(btnConsultar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnCancelar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(btnAgregar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnBorrar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(50, 50, 50)
                                                .addComponent(jLabel2))
                                            .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(btnCalcularDias)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmbServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblDias))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(btnCalcular)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelarTotal)
                                .addGap(38, 38, 38)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(lblTotal)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAgregarHab)
                        .addGap(18, 18, 18)
                        .addComponent(btnBorrarHab)
                        .addGap(173, 173, 173)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnAgregarHab)
                                    .addComponent(btnBorrarHab)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jdcEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jdcSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnConsultar)
                                    .addComponent(btnCancelar))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblDias)
                                    .addComponent(btnCalcularDias))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmbServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnAgregar)
                                    .addComponent(btnBorrar)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(lblTotal))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCalcular)
                        .addComponent(btnCancelarTotal)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        Calendar fechaEntrada = jdcEntrada.getCalendar();
        Calendar fechaSalida = jdcSalida.getCalendar();
        List <RHabitacion> misRHabitaciones = unaControladoraVisual.filtrarReservas(fechaEntrada, fechaSalida);
              
        modelo = (DefaultTableModel) tblHabitacion.getModel(); //GENERO UN NUEVO TABLE MODEL.. AL CUAL LE ASIGNO EL MODELO DE LA TABLA QUE CARGAMOS 																			CON ANTERIORIDAD

            int filas = tblHabitacion.getRowCount(); ///GENERO UN INDICE PARA SABER CUANTAS FILAS TIENE MI TABLA

            for (int i = 0; i < filas; i++) {    ////RECORRO EL INDICE A TRAVES DE UN CICLO FOR

                modelo.removeRow(0);   /////DE ESTA MANERA VOY QUITANDO EL SIEMPRE LA PRIMER FILA DEL MODELO...ESTO UNA VEZ FINALIZADO EL RECORRIDO DEL FOR NOS 								     ELIMINA TODOS LOS ELEMENTOS DE LA TABLA

            }
        
        Object[] fila = new Object[3];
        
        for (RHabitacion unaRHabitacion : misRHabitaciones) {
            fila[0] = unaRHabitacion.getUnaHabitacion().getId();
            fila[1] = unaRHabitacion.getUnaHabitacion().getUnTipo().getNombre();
            fila[2] = unaRHabitacion.getUnaHabitacion().getMontoPorNoche();
            
            modelo.addRow(fila);
        }    
            
        
        tblHabitacion.setModel(modelo);
        
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        jdcEntrada.setCalendar(null);
        jdcSalida.setCalendar(null);
        txtCantidad.setText(null);
        tblHabitacion.clearSelection();
        lblDias.setText(null);
        cargarTabla();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        Double total = 0.0;
        Double total1 = 0.0;
        
        DefaultTableModel modelo3 = (DefaultTableModel) tblServicio.getModel();
        
        modelo3.removeRow(tblServicio.getSelectedRow());
        
        tblServicio.setModel(modelo3);
        
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
 
        String nombre = cmbServicio.getSelectedItem().toString();
        
        Servicio unServicio = unaControladoraVisual.DameElServicio(nombre);
        
        Object[] fila = new Object[3];
        
        fila[0] = unServicio.getNombre();
        fila[1] = unServicio.getDescripcion();
        fila[2] = unServicio.getPrecio();
        
        modelo1.addRow(fila);
        
        tblServicio.setModel(modelo1);
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnAgregarHabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarHabActionPerformed
     
        Object[] fila = new Object[3];
        
        
        if(unVerificador.campoVacio(txtCantidad)){
        fila[0] = tblHabitacion.getValueAt(tblHabitacion.getSelectedRow(), 1);
        fila[1] = txtCantidad.getText();
        int cant = Integer.parseInt(txtCantidad.getText());
        Double precio = Double.parseDouble(tblHabitacion.getValueAt(tblHabitacion.getSelectedRow(), 2).toString());
        int dias = unaControladoraVisual.calcularDias(jdcEntrada.getCalendar(), jdcSalida.getCalendar());
        fila[2] = cant * precio * dias;
        }
        else{
        JOptionPane.showMessageDialog(null, "DEBE INGRESAR UNA CANTIDAD EN CANTIDAD");
        }

        modelo2.addRow(fila);
        
        tblHabitacionTotal.setModel(modelo2);
        
    }//GEN-LAST:event_btnAgregarHabActionPerformed

    private void btnBorrarHabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarHabActionPerformed
 
        DefaultTableModel modelo3 = (DefaultTableModel) tblHabitacionTotal.getModel();
        
        modelo3.removeRow(tblHabitacionTotal.getSelectedRow());
        
        tblHabitacionTotal.setModel(modelo3);
        
    }//GEN-LAST:event_btnBorrarHabActionPerformed

    private void btnCancelarTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarTotalActionPerformed
        Double total = 0.0;
                
        lblTotal.setText(String.valueOf(total));
    }//GEN-LAST:event_btnCancelarTotalActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        Double total = 0.0;
        Double total1 = 0.0;
        
        int fila = tblHabitacionTotal.getRowCount();
        int fila2 = tblServicio.getRowCount();
        
        for (int i = 0; i < fila; i++) {
            total = total + Double.parseDouble(tblHabitacionTotal.getValueAt(i, 2).toString());
        }
        
        for (int i = 0; i < fila2; i++) {
            total1 = total1 + Double.parseDouble(tblServicio.getValueAt(i, 2).toString());
        }
        
        lblTotal.setText(String.valueOf(total + total1));
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void btnCalcularDiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularDiasActionPerformed
        Calendar entrada = jdcEntrada.getCalendar();
        Calendar salida = jdcSalida.getCalendar();
        
        int dias = unaControladoraVisual.calcularDias(entrada, salida);
        
        lblDias.setText(String.valueOf(dias));
        
    }//GEN-LAST:event_btnCalcularDiasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregarHab;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBorrarHab;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnCalcularDias;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelarTotal;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JComboBox<String> cmbServicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private com.toedter.calendar.JDateChooser jdcEntrada;
    private com.toedter.calendar.JDateChooser jdcSalida;
    private javax.swing.JLabel lblDias;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblHabitacion;
    private javax.swing.JTable tblHabitacionTotal;
    private javax.swing.JTable tblServicio;
    private javax.swing.JTextField txtCantidad;
    // End of variables declaration//GEN-END:variables
}
