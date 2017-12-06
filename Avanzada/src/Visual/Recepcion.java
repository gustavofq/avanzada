/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;

import Logica.Cliente;
import Logica.Habitacion;
import Logica.RHabitacion;
import Persistencia.exceptions.NonexistentEntityException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author maquinola
 */
public class Recepcion extends javax.swing.JInternalFrame {
    private ControladoraVisual unaControladoraVisual = null;
    private Verificador unVerificador = new Verificador();
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel modelo1 = new DefaultTableModel();
    DefaultTableModel modelo2 = new DefaultTableModel();
    
    
    /**
     * Creates new form Recepcion
     */
    public Recepcion(ControladoraVisual unaControladora) {
        initComponents();
        unaControladoraVisual = unaControladora;
        modelo.addColumn("Numero");
        modelo.addColumn("Tipo");
        modelo.addColumn("Estado");
        modelo1.addColumn("Numero");
        modelo1.addColumn("Tipo");
        modelo1.addColumn("Estado");
        modelo2.addColumn("ID");
        modelo2.addColumn("Fecha Entrada");
        modelo2.addColumn("Fecha Salida");
        modelo2.addColumn("Habitacion");
        modelo2.addColumn("Cliente");
        cargarTabla(); 
    }

    /*public void cargarLista(){
        this.unVerificador.lipiarTabla(tblHabitaciones);
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Número");
        modelo.addColumn("Tipo");
        modelo.addColumn("Estado");
        Object[] fila = new Object[this.unaControladoraVisual.mostrarHabitaciones().size()];
        Object[] cod = new Object[this.unaControladoraVisual.mostrarHabitaciones().size()];
        cod = this.unaControladoraVisual.mostrarHabitaciones().toArray();
        for (int i=0;i < this.unaControladoraVisual.mostrarHabitaciones().size();i++){
            fila[0]=cod[i];
            int id = Integer.parseInt(cod[i].toString());
            fila[1]=this.unaControladoraVisual.DameLaHabitacion(id).getUnTipo().getNombre();
            fila[2]=this.unaControladoraVisual.DameLaHabitacion(id).verificarEstado();
            modelo.addRow(fila);
        }
        this.tblHabitaciones.setModel(modelo);
    }*/
    
    private void cargarTabla() {
        try {
            
            //ACA LIMPIAMOS LA TABLA ANTES DE CARGARLA
            
            modelo1 = (DefaultTableModel) tblHabitaciones.getModel(); //GENERO UN NUEVO TABLE MODEL.. AL CUAL LE ASIGNO EL MODELO DE LA TABLA QUE CARGAMOS 																			CON ANTERIORIDAD

            int filas = tblHabitaciones.getRowCount(); ///GENERO UN INDICE PARA SABER CUANTAS FILAS TIENE MI TABLA

            for (int i = 0; i < filas; i++) {    ////RECORRO EL INDICE A TRAVES DE UN CICLO FOR

                modelo1.removeRow(0);   /////DE ESTA MANERA VOY QUITANDO EL SIEMPRE LA PRIMER FILA DEL MODELO...ESTO UNA VEZ FINALIZADO EL RECORRIDO DEL FOR NOS 								     ELIMINA TODOS LOS ELEMENTOS DE LA TABLA

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "HA OCURRIDO UN ERROR" + ex);
        }
        
        
        try {
            
            //ACA LIMPIAMOS LA TABLA ANTES DE CARGARLA
            
            modelo2 = (DefaultTableModel) tblReservas.getModel(); //GENERO UN NUEVO TABLE MODEL.. AL CUAL LE ASIGNO EL MODELO DE LA TABLA QUE CARGAMOS 																			CON ANTERIORIDAD

            int filas = tblReservas.getRowCount(); ///GENERO UN INDICE PARA SABER CUANTAS FILAS TIENE MI TABLA

            for (int i = 0; i < filas; i++) {    ////RECORRO EL INDICE A TRAVES DE UN CICLO FOR

                modelo2.removeRow(0);   /////DE ESTA MANERA VOY QUITANDO EL SIEMPRE LA PRIMER FILA DEL MODELO...ESTO UNA VEZ FINALIZADO EL RECORRIDO DEL FOR NOS 								     ELIMINA TODOS LOS ELEMENTOS DE LA TABLA

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "HA OCURRIDO UN ERROR" + ex);
        }
        
        
        
        //ACA LA CARGAMOS
        List<Habitacion> misHabitaciones = new LinkedList();
        
        try {
            
            misHabitaciones = unaControladoraVisual.mostrarHabitaciones();///CARGO EN UNA COLECCION LOS ELEMENTOS QUE DESEO CARGAR; EN ESTE CASO LOS TRAIGO DESDE LA CONTROLADORA 													    VISUAL
            
            Object[] fila = new Object[3];   ///GENERO UN VECTOR DE TIPO OBJECT DADO QUE EN EL VOY A CARGAR DISTINTOS TIPOS DE DATOS

            for (Habitacion unaHabitacion : misHabitaciones) { ///RECORRO LA LISTA UTILIZANDO UN FOR EACH
                
                ////AQUI LE ASIGNO A CADA ELEMENTO DE UN VECTOR LOS DATOS QUE QUIERO QUE SE MUESTREN
                fila[0] = unaHabitacion.getId();
                fila[1] = unaHabitacion.getUnTipo().getNombre();
                fila[2] = unaHabitacion.getEstado();
                
                modelo1.addRow(fila);  ////AGREGO A MI MODELO UNA FILA (ES IMPORTANTE SABER QUE CADA VECTOR ES UNA FILA DA LA TABLA)
                
            }
            
            tblHabitaciones.setModel(modelo1); ////UNA VEZ FINALIZADO LE ASIGNO A MI TABLA EL MODELO Y ESTO MOSTRARIA LOS DATOS 

            
            txtDni.setText(null);
            lblCliente.setText(null);
            
        } catch (Exception EX) {
            JOptionPane.showMessageDialog(null, "HA OCURRIDO UN ERROR" + EX);
        }
        
        
        
        try {
            
            List<RHabitacion> misRHabitaciones = unaControladoraVisual.mostrarRHabitaciones();///CARGO EN UNA COLECCION LOS ELEMENTOS QUE DESEO CARGAR; EN ESTE CASO LOS TRAIGO DESDE LA CONTROLADORA 													    VISUAL
            
            Object[] fila2 = new Object[5];   ///GENERO UN VECTOR DE TIPO OBJECT DADO QUE EN EL VOY A CARGAR DISTINTOS TIPOS DE DATOS

            for (RHabitacion unaRHabitacion : misRHabitaciones) { ///RECORRO LA LISTA UTILIZANDO UN FOR EACH
                
                Calendar cal = unaRHabitacion.getFechaEntrada();
                Date dat = cal.getTime();
                Format formatter = new SimpleDateFormat("yyyy-MM-dd");
                String s = formatter.format(dat);
                
                
                Calendar cal2 = unaRHabitacion.getFechaSalida();
                Date dat2 = cal2.getTime();
                Format formatter2 = new SimpleDateFormat("yyyy-MM-dd");
                String s2 = formatter2.format(dat2);
                
                ////AQUI LE ASIGNO A CADA ELEMENTO DE UN VECTOR LOS DATOS QUE QUIERO QUE SE MUESTREN
                fila2[0] = unaRHabitacion.getId();
                fila2[1] = s;
                fila2[2] = s2;
                fila2[3] = unaRHabitacion.getUnaHabitacion().getId();
                fila2[4] = unaRHabitacion.getUnCliente().getNombre() +" "+ unaRHabitacion.getUnCliente().getApellido();
                
                
                modelo2.addRow(fila2);  ////AGREGO A MI MODELO UNA FILA (ES IMPORTANTE SABER QUE CADA VECTOR ES UNA FILA DA LA TABLA)
                
            }
            
            tblReservas.setModel(modelo2); ////UNA VEZ FINALIZADO LE ASIGNO A MI TABLA EL MODELO Y ESTO MOSTRARIA LOS DATOS 

            
            txtDni.setText(null);
            lblCliente.setText(null);
            
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

        jCalendar1 = new com.toedter.calendar.JCalendar();
        jdcInicio = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        btnReservar = new javax.swing.JButton();
        btnModficar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jLFechaFin = new javax.swing.JLabel();
        jdcSalida = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHabitaciones = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jdcConsultaEntrada = new com.toedter.calendar.JDateChooser();
        jdcConsultaSalida = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblConsulta = new javax.swing.JTable();
        btnConsulta = new javax.swing.JButton();
        btnCancelarConsulta = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblReservas = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Reservas");

        jLabel1.setText("Fecha de Inicio:");

        btnReservar.setText("Reservar");
        btnReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservarActionPerformed(evt);
            }
        });

        btnModficar.setText("Modificar Reserva");
        btnModficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModficarActionPerformed(evt);
            }
        });

        btnBorrar.setText("Borrar Reserva");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        jLFechaFin.setText("Fecha de Finalizacion:");

        jLabel5.setText("DNI:");

        jLabel6.setText("Cliente:");

        lblCliente.setText("xxx");

        tblHabitaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Número", "Tipo", "Estado"
            }
        ));
        tblHabitaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHabitacionesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHabitaciones);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel2.setText("Consultas:");

        tblConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Numero", "Tipo", "Estado"
            }
        ));
        jScrollPane2.setViewportView(tblConsulta);

        btnConsulta.setText("Consultar");
        btnConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaActionPerformed(evt);
            }
        });

        btnCancelarConsulta.setText("Cancelar");
        btnCancelarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarConsultaActionPerformed(evt);
            }
        });

        tblReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "fecha Entrada", "fecha Salida", "Habitacion", "Cliente"
            }
        ));
        jScrollPane3.setViewportView(tblReservas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel2)
                                            .addComponent(jdcConsultaEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                            .addComponent(jdcConsultaSalida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel5)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtDni))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(btnBuscar)
                                                    .addGap(50, 50, 50)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnConsulta)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnCancelarConsulta)))))
                                .addGap(9, 9, 9))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jdcInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLFechaFin)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jdcSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(btnReservar)
                        .addGap(38, 38, 38)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnModficar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBorrar)
                        .addGap(109, 109, 109))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jdcConsultaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jdcConsultaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnConsulta)
                                    .addComponent(btnCancelarConsulta)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCliente))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(btnBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jdcInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jdcSalida, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLFechaFin, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(28, 28, 28))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnReservar)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBorrar)
                        .addComponent(btnModficar)))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        // TODO add your handling code here:
        if(this.unVerificador.campoVacio(txtDni)){
            int dni = Integer.parseInt(this.txtDni.getText());
                if(unaControladoraVisual.DameElCliente(dni) != null){
                String nombre = this.unaControladoraVisual.DameElCliente(dni).getNombre();
                String apellido = this.unaControladoraVisual.DameElCliente(dni).getApellido();
                this.lblCliente.setText(nombre + " " + apellido);
                }
                else{
                    JOptionPane.showMessageDialog(null, "NO EXISTE EL CLIENTE");
                }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservarActionPerformed
        Calendar fechaEntrada = jdcInicio.getCalendar();
        Calendar fechaSalida = jdcSalida.getCalendar();
        int cantidad = 1;
        int dni = Integer.parseInt(txtDni.getText());
        if(unVerificador.campoVacio(txtDni)){
           if(fechaEntrada != null && fechaSalida != null){
               if(unaControladoraVisual.filtrarReservas(fechaEntrada, fechaSalida) != null){
                   
               }
           }
           else{
               JOptionPane.showMessageDialog(null, "FALTA PONER UNA FECHA DE ENTRADA O SALIDA");
           }
        }
        else{
            JOptionPane.showMessageDialog(null, "FALTA BUSCAR UN DNI");
        }
        
        
        
        
        
        
        
        
        
        Habitacion unaHabitacion = unaControladoraVisual.DameLaHabitacion(Integer.parseInt(tblHabitaciones.getValueAt(tblHabitaciones.getSelectedRow(), 0).toString()));
        
        try {
            unaControladoraVisual.cambiarEstadoHabitacion(unaHabitacion, true);
        } catch (Exception ex) {
            Logger.getLogger(Recepcion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Cliente unCliente = unaControladoraVisual.DameElCliente(dni);
        
        try {
            unaControladoraVisual.altaRHabitacion(fechaEntrada, fechaSalida, cantidad, unaHabitacion, unCliente);
        } catch (Exception ex) {
            Logger.getLogger(Recepcion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        cargarTabla();
    }//GEN-LAST:event_btnReservarActionPerformed

    private void tblHabitacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHabitacionesMouseClicked
        int numHabitacion = Integer.parseInt(tblHabitaciones.getValueAt(tblHabitaciones.getSelectedRow(), 0).toString());

        RHabitacion unaRHabitacion = unaControladoraVisual.dameUnaReservaHabitacion(numHabitacion);
        if(unaRHabitacion == null){
        lblCliente.setText(null);
        jdcInicio.setCalendar(null);
        jdcSalida.setCalendar(null);
        }
        else{
        txtDni.setText(String.valueOf(unaRHabitacion.getUnCliente().getDni()));
        lblCliente.setText(unaRHabitacion.getUnCliente().getNombre() +""+ unaRHabitacion.getUnCliente().getApellido());
        jdcInicio.setCalendar(unaRHabitacion.getFechaEntrada());
        jdcSalida.setCalendar(unaRHabitacion.getFechaSalida());    
        }
        
        
    }//GEN-LAST:event_tblHabitacionesMouseClicked

    private void btnModficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModficarActionPerformed
        int id = Integer.parseInt(tblReservas.getValueAt(tblReservas.getSelectedRow(), 0).toString());
        RHabitacion unaRHabitacion = unaControladoraVisual.DameLaRHabitacion(id);
        Calendar fechaEntrada = jdcInicio.getCalendar();
        Calendar fechaSalida = jdcSalida.getCalendar();
        
        try {
            unaControladoraVisual.modificarFechas(unaRHabitacion, fechaEntrada, fechaSalida);
        } catch (Exception ex) {
            Logger.getLogger(Recepcion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        cargarTabla();
    }//GEN-LAST:event_btnModficarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        
        if(tblReservas.getSelectedRow() != -1){
            
        int id = Integer.parseInt(tblReservas.getValueAt(tblReservas.getSelectedRow(), 0).toString());
        
        RHabitacion unaRHabitacion = unaControladoraVisual.DameLaRHabitacion(id);
        
        Habitacion unaHabitacion = unaRHabitacion.getUnaHabitacion();
        
        try {
            unaControladoraVisual.cambiarEstadoHabitacion(unaHabitacion, false);
        } catch (Exception ex) {
            Logger.getLogger(Recepcion.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            unaControladoraVisual.BorrarRHabitacion(unaRHabitacion);
        } catch (Exception ex) {
            Logger.getLogger(Recepcion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        cargarTabla();
        
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        lblCliente.setText(null);
        jdcInicio.setCalendar(null);
        jdcSalida.setCalendar(null);
        tblHabitaciones.clearSelection();
        txtDni.setText(null);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCancelarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarConsultaActionPerformed
        tblConsulta.clearSelection();
        jdcConsultaEntrada.setCalendar(null);
        jdcConsultaSalida.setCalendar(null);
        
        int filas = tblConsulta.getRowCount(); ///GENERO UN INDICE PARA SABER CUANTAS FILAS TIENE MI TABLA

            for (int i = 0; i < filas; i++) {    ////RECORRO EL INDICE A TRAVES DE UN CICLO FOR

                modelo.removeRow(0);   /////DE ESTA MANERA VOY QUITANDO EL SIEMPRE LA PRIMER FILA DEL MODELO...ESTO UNA VEZ FINALIZADO EL RECORRIDO DEL FOR NOS 								     ELIMINA TODOS LOS ELEMENTOS DE LA TABLA

            }
            
            tblConsulta.setModel(modelo);
        
    }//GEN-LAST:event_btnCancelarConsultaActionPerformed

    private void btnConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaActionPerformed
        Calendar fechaEntrada = jdcConsultaEntrada.getCalendar();
        Calendar fechaSalida = jdcConsultaSalida.getCalendar();
        List <RHabitacion> misRHabitaciones = unaControladoraVisual.filtrarReservas(fechaEntrada, fechaSalida);
                
        modelo = (DefaultTableModel) tblConsulta.getModel(); //GENERO UN NUEVO TABLE MODEL.. AL CUAL LE ASIGNO EL MODELO DE LA TABLA QUE CARGAMOS 																			CON ANTERIORIDAD

            int filas = tblConsulta.getRowCount(); ///GENERO UN INDICE PARA SABER CUANTAS FILAS TIENE MI TABLA

            for (int i = 0; i < filas; i++) {    ////RECORRO EL INDICE A TRAVES DE UN CICLO FOR

                modelo.removeRow(0);   /////DE ESTA MANERA VOY QUITANDO EL SIEMPRE LA PRIMER FILA DEL MODELO...ESTO UNA VEZ FINALIZADO EL RECORRIDO DEL FOR NOS 								     ELIMINA TODOS LOS ELEMENTOS DE LA TABLA

            }
            
        Object[] fila = new Object[3];
        
        for (RHabitacion unaRHabitacion : misRHabitaciones) {
            
                fila[0] = unaRHabitacion.getUnaHabitacion().getId();
                fila[1] = unaRHabitacion.getUnaHabitacion().getUnTipo().getNombre();
                fila[2] = unaRHabitacion.getUnaHabitacion().getEstado();
            
                modelo.addRow(fila);
        }
        
        tblConsulta.setModel(modelo);
        
    }//GEN-LAST:event_btnConsultaActionPerformed

    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelarConsulta;
    private javax.swing.JButton btnConsulta;
    private javax.swing.JButton btnModficar;
    private javax.swing.JButton btnReservar;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLFechaFin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private com.toedter.calendar.JDateChooser jdcConsultaEntrada;
    private com.toedter.calendar.JDateChooser jdcConsultaSalida;
    private com.toedter.calendar.JDateChooser jdcInicio;
    private com.toedter.calendar.JDateChooser jdcSalida;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JTable tblConsulta;
    private javax.swing.JTable tblHabitaciones;
    private javax.swing.JTable tblReservas;
    private javax.swing.JTextField txtDni;
    // End of variables declaration//GEN-END:variables
}
