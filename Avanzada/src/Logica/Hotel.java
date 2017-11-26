/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.ControladoraPersistencia;
import Persistencia.exceptions.NonexistentEntityException;
import Visual.MenuPrincipal;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.OneToMany;

/**
 *
 * @author maquinola
 */
public class Hotel {

    @OneToMany
    private List<Camarero> misCamareros = new LinkedList();
    @OneToMany
    private List<Cliente> misClientes = new LinkedList();
    @OneToMany
    private List<Departamento> misDepartamentos = new LinkedList();
    @OneToMany
    private List<Factura> misFacturas = new LinkedList();
    @OneToMany
    private List<Habitacion> misHabitaciones = new LinkedList();
    @OneToMany
    private List<Mesa> misMesas = new LinkedList();
    @OneToMany
    private List<Plato> misPlatos = new LinkedList();
    @OneToMany
    private List<Proveedor> misProveedores = new LinkedList();
    @OneToMany
    private List<RHabitacion> misRHabitaciones = new LinkedList();
    @OneToMany
    private List<RMesas> misRMesas = new LinkedList();
    @OneToMany
    private List<Recepcionista> misRecepcionistas = new LinkedList();
    @OneToMany
    private List<Servicio> misServicios = new LinkedList();
    @OneToMany
    private List<Tipo> misTipos = new LinkedList();

    
    ControladoraPersistencia miPersistencia = new ControladoraPersistencia();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Hotel unHotel = new Hotel();
        MenuPrincipal miMenu = new MenuPrincipal();
        miMenu.show();
    }
    
    public Hotel() {
        CargarListas();
    }
    
    private void CargarListas() {

        this.misCamareros = this.miPersistencia.obtenerCamareros();
        this.misClientes = this.miPersistencia.obtenerClientes();
        this.misDepartamentos = this.miPersistencia.obtenerDepartamentos();
        this.misFacturas = this.miPersistencia.obtenerFacturas();
        this.misHabitaciones = this.miPersistencia.obtenerHabitaciones();
        this.misMesas = this.miPersistencia.obtenerMesas();
        this.misPlatos = this.miPersistencia.obtenerPlatos();
        this.misProveedores = this.miPersistencia.obtenerProveedores();
        this.misRHabitaciones = this.miPersistencia.obtenerRHabitaciones();
        this.misRMesas = this.miPersistencia.obtenerRMesas();
        this.misRecepcionistas = this.miPersistencia.obtenerRecepcionistas();
        this.misServicios = this.miPersistencia.obtenerServicios();
        this.misTipos = this.miPersistencia.obtenerTipos();
        
    }

    public List<Camarero> getMisCamareros() {
        return misCamareros;
    }

    public List<Cliente> getMisClientes() {
        return misClientes;
    }

    public List<Departamento> getMisDepartamentos() {
        return misDepartamentos;
    }

    public List<Factura> getMisFacturas() {
        return misFacturas;
    }

    public List<Habitacion> getMisHabitaciones() {
        return misHabitaciones;
    }

    public List<Mesa> getMisMesas() {
        return misMesas;
    }

    public List<Plato> getMisPlatos() {
        return misPlatos;
    }

    public List<Proveedor> getMisProveedores() {
        return misProveedores;
    }

    public List<RHabitacion> getMisRHabitaciones() {
        return misRHabitaciones;
    }

    public List<RMesas> getMisRMesas() {
        return misRMesas;
    }

    public List<Recepcionista> getMisRecepcionistas() {
        return misRecepcionistas;
    }

    public List<Servicio> getMisServicios() {
        return misServicios;
    }

    public List<Tipo> getMisTipos() {
        return misTipos;
    }

    public void setMisCamareros(List<Camarero> misCamareros) {
        this.misCamareros = misCamareros;
    }

    public void setMisClientes(List<Cliente> misClientes) {
        this.misClientes = misClientes;
    }

    public void setMisDepartamentos(List<Departamento> misDepartamentos) {
        this.misDepartamentos = misDepartamentos;
    }

    public void setMisFacturas(List<Factura> misFacturas) {
        this.misFacturas = misFacturas;
    }

    public void setMisHabitaciones(List<Habitacion> misHabitaciones) {
        this.misHabitaciones = misHabitaciones;
    }

    public void setMisMesas(List<Mesa> misMesas) {
        this.misMesas = misMesas;
    }

    public void setMisPlatos(List<Plato> misPlatos) {
        this.misPlatos = misPlatos;
    }

    public void setMisProveedores(List<Proveedor> misProveedores) {
        this.misProveedores = misProveedores;
    }

    public void setMisRHabitaciones(List<RHabitacion> misRHabitaciones) {
        this.misRHabitaciones = misRHabitaciones;
    }

    public void setMisRMesas(List<RMesas> misRMesas) {
        this.misRMesas = misRMesas;
    }

    public void setMisRecepcionistas(List<Recepcionista> misRecepcionistas) {
        this.misRecepcionistas = misRecepcionistas;
    }

    public void setMisServicios(List<Servicio> misServicios) {
        this.misServicios = misServicios;
    }

    public void setMisTipos(List<Tipo> misTipos) {
        this.misTipos = misTipos;
    }

    
    
    ///////////// METODOS ABML: ///////////////////
    
    //CAMARERO
    
    public void altaCamarero(int dni, String nombre, String apellido) throws Exception {
        if (comprobarCamarero(dni) == false) {
            Camarero unCamarero = new Camarero(dni, nombre, apellido);
            misCamareros.add(unCamarero);
            miPersistencia.AltaCamarero(unCamarero);
        }
    }
    

    public Camarero DameElCamarero(int ID) {
        return this.miPersistencia.dameUnCamarero(ID);
    }

    public boolean comprobarCamarero(int dni) {
        boolean aux = false;
        
        for(Camarero unCamarero : misCamareros){
            if(unCamarero.getDni() == dni){
                aux = true;
            }
        }
        
        return aux;
    }
    

    public void modificarCamarero(int dni, String nombre, String apellido, Camarero unCamarero) throws Exception {
        misCamareros.remove(unCamarero);
        unCamarero.setNombre(nombre);
        unCamarero.setApellido(apellido);
        miPersistencia.EditarCamarero(unCamarero);
    }

    public void borrarCamarero(Camarero unCamarero) throws Exception {
        misCamareros.remove(unCamarero);
        miPersistencia.BajaCamarero(unCamarero);
    }

    public List<Camarero> mostrarCamareros() {
        return miPersistencia.obtenerCamareros();
    }
    
    
    
    //CLIENTE
    
    public void altaCliente(int dni, String nombre, String apellido, Double tarjetaDeCredito, String usuario, String contraseña) throws Exception {
        if (comprobarCliente(dni) == false) {
            Cliente unCliente = new Cliente(dni, nombre, apellido, tarjetaDeCredito, usuario, contraseña);
            misClientes.add(unCliente);
            miPersistencia.AltaCliente(unCliente);
        }
    }
    
    public Cliente buscarClientePorNombre(String nombre, String apellido) {

        Cliente cli = null;
        
        for (Cliente unCliente : this.misClientes) {
            if(unCliente.getNombre().equals(nombre) && unCliente.getApellido().equals(apellido)){
                cli = unCliente;
            }
        }
        
        return cli;
    }
    
    public Cliente DameElCliente(int ID) {
        return this.miPersistencia.dameUnCliente(ID);
    }

    public boolean comprobarCliente(int dni) {
        boolean aux = false;
        
        for(Cliente unCliente : misClientes){
            if(unCliente.getDni() == dni){
                aux = true;
            }
        }
        
        return aux;
    }
    

    public void modificarCliente(int dni, String nombre, String apellido, Double tarjetaDeCredito, String usuario, String contraseña, Cliente unCliente) throws Exception {
        misClientes.remove(unCliente);
        unCliente.setNombre(nombre);
        unCliente.setApellido(apellido);
        unCliente.setTarjetaDeCredito(tarjetaDeCredito);
        unCliente.setUsuario(usuario);
        unCliente.setContraseña(contraseña);
        miPersistencia.EditarCliente(unCliente);
    }

    public void borrarCliente(Cliente unCliente) throws Exception {
        misClientes.remove(unCliente);
        miPersistencia.BajaCliente(unCliente);
    }

    public List<Cliente> mostrarClientes() {
        return miPersistencia.obtenerClientes();
    }
    
    public boolean existeUsuario(String user, String pass){
        boolean existe = false;
        Cliente unCliente = new Cliente();
        Iterator it = this.misClientes.iterator();
        while ((it.hasNext()) && (existe == false)){
            unCliente = (Cliente) it.next();
            if( (unCliente.getUsuario().equals(user)) && (unCliente.getContraseña().equals(pass))){
                existe = true;
            }
        }
        return existe;
    }
    
    
    
    //DEPARTAMENTO
    
    public void altaDepartamento(int id, String nombre) throws Exception {
        if (comprobarDepartamento(id) == false) {
            Departamento unDepartamento = new Departamento(id, nombre);
            misDepartamentos.add(unDepartamento);
            miPersistencia.AltaDepartamento(unDepartamento);
        }
    }
    /**
     * Registara un nuevo departamento.
     * @param nombre del delpartamento.
     * @throws java.lang.Exception */
    public void altaDepartamento(String nombre) throws Exception {
        Departamento unDepartamento = new Departamento(nombre);
        misDepartamentos.add(unDepartamento);
        miPersistencia.AltaDepartamento(unDepartamento);
    }
    
    public Departamento DameElDepartamento(int ID) {
        return this.miPersistencia.dameUnDepartamento(ID);
    }

    public boolean comprobarDepartamento(int id) {
        boolean aux = false;
        
        for(Departamento unDepartamento : misDepartamentos){
            if(unDepartamento.getId() == id){
                aux = true;
            }
        }
        
        return aux;
    }
    

    public void modificarDepartamento(int id, String nombre, Departamento unDepartamento) throws Exception {
        misDepartamentos.remove(unDepartamento);
        unDepartamento.setNombre(nombre);
        miPersistencia.EditarDepartamento(unDepartamento);
    }

    public void modificarDepartamento(String nombre, Departamento unDepartamento) throws Exception {
        misDepartamentos.remove(unDepartamento);
        unDepartamento.setNombre(nombre);
        miPersistencia.EditarDepartamento(unDepartamento);
    }
    
    public void borrarDepartamento(Departamento unDepartamento) throws Exception {
        misDepartamentos.remove(unDepartamento);
        miPersistencia.BajaDepartamento(unDepartamento);
    }

    public List<Departamento> mostrarDepartamentos() {
        return miPersistencia.obtenerDepartamentos();
    }

    
    
    
    
    //FACTURA
    
    public void altaFactura(String Tipo, Double total, Cliente unCliente, List<DetalleFactura> unosDetalles) throws Exception {
         
            Factura unaFactura = new Factura(Tipo, total, unCliente);
            misFacturas.add(unaFactura);
            miPersistencia.AltaFactura(unaFactura);
            
            for (DetalleFactura unDetalle : unosDetalles) {
                unaFactura.agregarDetalleFactura(unDetalle.getDescripcion(), unDetalle.getCantidad(), unDetalle.getSubtotal(), unDetalle.getUnaHabitacion());
                miPersistencia.AltaDetalleFactura(unDetalle);
                miPersistencia.EditarFactura(unaFactura);
            }
            
            
    }
    
    
    
    public Factura DameLaFactura(int ID) {
        return this.miPersistencia.dameUnaFactura(ID);
    }

    public boolean comprobarFactura(int id) {
        boolean aux = false;
        
        for(Factura unaFactura : misFacturas){
            if(unaFactura.getId() == id){
                aux = true;
            }
        }
        
        return aux;
    }
    

    public void modificarFactura(int id, String Tipo, Double total, Factura unaFactura) throws Exception {
        misFacturas.remove(unaFactura);
        unaFactura.setTipo(Tipo);
        unaFactura.setTotal(total);
        miPersistencia.EditarFactura(unaFactura);
    }

    public void borrarFactura(Factura unaFactura) throws Exception {
        misFacturas.remove(unaFactura);
        miPersistencia.BajaFactura(unaFactura);
    }

    public List<Factura> mostrarFacturas() {
        return miPersistencia.obtenerFacturas();
    }
    
    
    //HABITACION
    
    public void altaHabitacion(int id, boolean estado, int montoPorNoche, Tipo unTipo) throws Exception {
        if (comprobarHabitacion(id) == false) {
            Habitacion unaHabitacion = new Habitacion(id, estado, montoPorNoche, unTipo);
            misHabitaciones.add(unaHabitacion);
            miPersistencia.AltaHabitacion(unaHabitacion);
        }
    }
    /**
     * 
     * crea una habitacion desocupada 
     * @param ocupado
     * @param montoPorNoche
     * @param nombreTipo
     */
    public void altaHabitacion(boolean ocupado, int montoPorNoche, String nombreTipo){
        
            Habitacion unaHabitacion = new Habitacion(ocupado, montoPorNoche, this.DameElTipo(this.buscarTipoPorNombre(nombreTipo)));
            this.misHabitaciones.add(unaHabitacion);
            this.miPersistencia.AltaHabitacion(unaHabitacion);
        
    }
    
    public void cambiarEstadoHabitacion(Habitacion unaHabitacion, boolean estado) throws Exception{
           misHabitaciones.remove(unaHabitacion);
           unaHabitacion.setEstado(estado);
           miPersistencia.EditarHabitacion(unaHabitacion);
    }
    
    public Habitacion DameLaHabitacion(int ID) {
        return this.miPersistencia.dameUnaHabitacion(ID);
    }

    public boolean comprobarHabitacion(int id) {
        boolean aux = false;
        
        for(Habitacion unaHabitacion : misHabitaciones){
            if(unaHabitacion.getId() == id){
                aux = true;
            }
        }
        
        return aux;
    }
    

    public void modificarHabitacion(int id, boolean estado, int montoPorNoche, Tipo unTipo, Habitacion unaHabitacion) throws Exception {
        misHabitaciones.remove(unaHabitacion);
        unaHabitacion.setEstado(estado);
        unaHabitacion.setMontoPorNoche(montoPorNoche);
        unaHabitacion.setUnTipo(unTipo);
        miPersistencia.EditarHabitacion(unaHabitacion);
    }

    public void modificarHabitacion(int numero,int montoPorNoche, String nombreTipo) throws Exception{
        if(this.misHabitaciones.isEmpty() != true){
            Habitacion unaHabitacion = this.DameLaHabitacion(numero);
            this.misHabitaciones.remove(unaHabitacion);
            unaHabitacion.setMontoPorNoche(montoPorNoche);
            unaHabitacion.setUnTipo(this.DameElTipo(this.buscarTipoPorNombre(nombreTipo)));
            this.misHabitaciones.add(unaHabitacion);
            this.miPersistencia.EditarHabitacion(unaHabitacion);
        }
    }
    
    public void borrarHabitacion(Habitacion unaHabitacion) throws Exception {
        misHabitaciones.remove(unaHabitacion);
        miPersistencia.BajaHabitacion(unaHabitacion);
    }
    
    public void borrarHabitacion(int numero) throws NonexistentEntityException{
        if(this.misHabitaciones.isEmpty() != true){
            Habitacion unaHabitacion = this.DameLaHabitacion(numero);
            this.misHabitaciones.remove(unaHabitacion);
            this.miPersistencia.BajaHabitacion(unaHabitacion);
        }
    }

    public List<Habitacion> mostrarHabitaciones() {
        return miPersistencia.obtenerHabitaciones();
    }
    

    
    
    
    
    //MESAS
    
    public void altaMesa(int id, String Estado) throws Exception {
        if (comprobarMesa(id) == false) {
            Mesa unaMesa = new Mesa(id, Estado);
            misMesas.add(unaMesa);
            miPersistencia.AltaMesa(unaMesa);
        }
    }
    
    public Mesa DameLaMesa(int ID) {
        return this.miPersistencia.dameUnaMesa(ID);
    }

    public boolean comprobarMesa(int id) {
        boolean aux = false;
        
        for(Mesa unaMesa : misMesas){
            if(unaMesa.getId() == id){
                aux = true;
            }
        }
        
        return aux;
    }
    

    public void modificarMesa(int id, String Estado, Mesa unaMesa) throws Exception {
        misMesas.remove(unaMesa);
        unaMesa.setEstado(Estado);
        miPersistencia.EditarMesa(unaMesa);
    }

    public void borrarMesa(Mesa unaMesa) throws Exception {
        misMesas.remove(unaMesa);
        miPersistencia.BajaMesa(unaMesa);
    }

    public List<Mesa> mostrarMesas() {
        return miPersistencia.obtenerMesas();
    }
    
    
    
    
    //PLATOS
    
    public void altaPlato(int id, String nombre, String descripcion, int precio) throws Exception {
        if (comprobarPlato(id) == false) {
            Plato unPlato = new Plato(id, nombre, descripcion, precio);
            misPlatos.add(unPlato);
            miPersistencia.AltaPlato(unPlato);
        }
    }
    
    public Plato DameElPlato(int ID) {
        return this.miPersistencia.dameUnPlato(ID);
    }

    public boolean comprobarPlato(int id) {
        boolean aux = false;
        
        for(Plato unPlato : misPlatos){
            if(unPlato.getId() == id){
                aux = true;
            }
        }
        
        return aux;
    }
    

    public void modificarPlato(int id, String nombre, String descripcion, int precio, Plato unPlato) throws Exception {
        misPlatos.remove(unPlato);
        unPlato.setNombre(nombre);
        unPlato.setDescripcion(descripcion);
        unPlato.setPrecio(precio);
        miPersistencia.EditarPlato(unPlato);
    }

    public void borrarPlato(Plato unPlato) throws Exception {
        misPlatos.remove(unPlato);
        miPersistencia.BajaPlato(unPlato);
    }

    public List<Plato> mostrarPlatos() {
        return miPersistencia.obtenerPlatos();
    }
    
    
    
    //Proveedor
    
    public void altaProveedor(int id, String nombre, String direccion, int telefono) throws Exception {
        if (comprobarProveedor(id) == false) {
            Proveedor unProveedor = new Proveedor(id, nombre, direccion, telefono);
            misProveedores.add(unProveedor);
            miPersistencia.AltaProveedor(unProveedor);
        }
    }
    
    public Proveedor DameElProveedor(int ID) {
        return this.miPersistencia.dameUnProveedor(ID);
    }

    public boolean comprobarProveedor(int id) {
        boolean aux = false;
        
        for(Proveedor unProveedor : misProveedores){
            if(unProveedor.getId() == id){
                aux = true;
            }
        }
        
        return aux;
    }
    

    public void modificarProveedor(int id, String nombre, String direccion, int telefono, Proveedor unProveedor) throws Exception {
        misProveedores.remove(unProveedor);
        unProveedor.setNombre(nombre);
        unProveedor.setDireccion(direccion);
        unProveedor.setTelefono(telefono);
        miPersistencia.EditarProveedor(unProveedor);
    }

    public void borrarProveedor(Proveedor unProveedor) throws Exception {
        misProveedores.remove(unProveedor);
        miPersistencia.BajaProveedor(unProveedor);
    }

    public List<Proveedor> mostrarProveedores() {
        return miPersistencia.obtenerProveedores();
    }
    
    //RH HABITACION
    
    public void altaRHabitacion(Calendar fechaEntrada, Calendar fechaSalida, int cantidad, Habitacion unaHabitacion, Cliente unCliente) throws Exception {
            RHabitacion unaRHabitacion = new RHabitacion(fechaEntrada, fechaSalida, cantidad, unaHabitacion, unCliente);
            misRHabitaciones.add(unaRHabitacion);
            miPersistencia.AltaRHabitacion(unaRHabitacion);
    }
    
    
    public RHabitacion DameLaRHabitacion(int ID) {
        return this.miPersistencia.dameUnaRHabitacion(ID);
    }

    public boolean comprobarRHabitacion(int id) {
        boolean aux = false;
        
        for(RHabitacion unaRHabitacion : misRHabitaciones){
            if(unaRHabitacion.getId() == id){
                aux = true;
            }
        }
        
        return aux;
    }
    
    public void modificarFechas(int numHabitacion, Calendar fechaEntrada, Calendar fechaSalida) throws Exception{
        
        for (RHabitacion unaRHabitacion : misRHabitaciones) {
            
            if(unaRHabitacion.getUnaHabitacion().getId() == numHabitacion){
                
                misRHabitaciones.remove(unaRHabitacion);
                unaRHabitacion.setFechaEntrada(fechaEntrada);
                unaRHabitacion.setFechaSalida(fechaSalida);
                miPersistencia.EditarRHabitacion(unaRHabitacion);
                
            }
        }

    }
    
    public void BorrarRHabitacion(int numHabitacion) throws Exception{
        
        for (RHabitacion unaRHabitacion : misRHabitaciones) {
            if(unaRHabitacion.getUnaHabitacion().getId() == numHabitacion){
                
                misRHabitaciones.remove(unaRHabitacion);
                miPersistencia.BajaRHabitacion(unaRHabitacion);
                
            }
        }
        
        for (Habitacion unaHabitacion : misHabitaciones) {
            if(unaHabitacion.getId() == numHabitacion){
                misHabitaciones.remove(unaHabitacion);
                unaHabitacion.setEstado(false);
                miPersistencia.EditarHabitacion(unaHabitacion);
            }
        }
        
    }
    

    public void modificarRHabitacion(Calendar fechaEntrada, Calendar fechaSalida, int cantidad, Habitacion unaHabitacion, Cliente unCliente, int id, RHabitacion unaRHabitacion) throws Exception {
        misRHabitaciones.remove(unaRHabitacion);
        unaRHabitacion.setFechaEntrada(fechaEntrada);
        unaRHabitacion.setFechaSalida(fechaSalida);
        unaRHabitacion.setCantidad(cantidad);
        unaRHabitacion.setUnCliente(unCliente);
        unaRHabitacion.setUnaHabitacion(unaHabitacion);
        miPersistencia.EditarRHabitacion(unaRHabitacion);
    }

    public void borrarRHabitacion(RHabitacion unaRHabitacion) throws Exception {
        misRHabitaciones.remove(unaRHabitacion);
        miPersistencia.BajaRHabitacion(unaRHabitacion);
    }

    public List<RHabitacion> mostrarRHabitaciones() {
        return miPersistencia.obtenerRHabitaciones();
    }
    
    
    
    //R MESAS
    
    public void altaRMesa(int numeroMesa, Calendar fecha, Cliente unCliente) throws Exception {
   
            RMesas unaRMesas = new RMesas(numeroMesa, fecha, unCliente);
            misRMesas.add(unaRMesas);
            miPersistencia.AltaRMesas(unaRMesas);
        
    }
    
    public RMesas DameLaRMesa(int ID) {
        return this.miPersistencia.dameUnaRMesa(ID);
    }

    public boolean comprobarRMesa(int id) {
        boolean aux = false;
        
        for(RMesas unaRMesas : misRMesas){
            if(unaRMesas.getId() == id){
                aux = true;
            }
        }
        
        return aux;
    }
    

    public void modificarRMesa(int numeroMesa, Calendar fecha, Cliente unCliente, RMesas unaRMesas) throws Exception {
        misRMesas.remove(unaRMesas);
        unaRMesas.setNumeroMesa(numeroMesa);
        unaRMesas.setFecha(fecha);
        unaRMesas.setUnCliente(unCliente);
        miPersistencia.EditarRMesas(unaRMesas);
    }

    public void borrarRMesa(RMesas unaRMesas) throws Exception {
        misRMesas.remove(unaRMesas);
        miPersistencia.BajaRMesas(unaRMesas);
    }

    public List<RMesas> mostrarRMesas() {
        return miPersistencia.obtenerRMesas();
    }
    
    
    
    
    //Recepcionista
    
    public void altaRecepcionista(int dni, String nombre, String apellido) throws Exception {
        if (comprobarRecepcionista(dni) == false) {
            Recepcionista unaRecepcionista = new Recepcionista(dni, nombre, apellido);
            misRecepcionistas.add(unaRecepcionista);
            miPersistencia.AltaRecepcionista(unaRecepcionista);
        }
    }
    
    public Recepcionista DameLaRecepcionista(int ID) {
        return this.miPersistencia.dameUnaRecepcionista(ID);
    }

    public boolean comprobarRecepcionista(int dni) {
        boolean aux = false;
        
        for(Recepcionista unaRecepcionista : misRecepcionistas){
            if(unaRecepcionista.getDni() == dni){
                aux = true;
            }
        }
        
        return aux;
    }
    

    public void modificarRecepcionista(int dni, String nombre, String apellido, Recepcionista unaRecepcionista) throws Exception {
        misRecepcionistas.remove(unaRecepcionista);
        unaRecepcionista.setNombre(nombre);
        unaRecepcionista.setApellido(apellido);
        miPersistencia.EditarRecepcionista(unaRecepcionista);
    }

    public void borrarRecepcionista(Recepcionista unaRecepcionista) throws Exception {
        misRecepcionistas.remove(unaRecepcionista);
        miPersistencia.BajaRecepcionista(unaRecepcionista);
    }

    public List<Recepcionista> mostrarRecepcionistas() {
        return miPersistencia.obtenerRecepcionistas();
    }
    
    
    
    //Servicios
    
    public void altaServicio(int id, String nombre, String descripcion) throws Exception {
        if (comprobarServicio(id) == false) {
            Servicio unServicio = new Servicio(id, nombre, descripcion);
            misServicios.add(unServicio);
            miPersistencia.AltaServicio(unServicio);
        }
    }
    
    public Servicio DameElServicio(int ID) {
        return this.miPersistencia.dameUnServicio(ID);
    }

    public boolean comprobarServicio(int id) {
        boolean aux = false;
        
        for(Servicio unServicio : misServicios){
            if(unServicio.getId() == id){
                aux = true;
            }
        }
        
        return aux;
    }
    

    public void modificarServicio(int id, String nombre, String descripcion, Servicio unServicio) throws Exception {
        misServicios.remove(unServicio);
        unServicio.setNombre(nombre);
        unServicio.setDescripcion(descripcion);
        miPersistencia.EditarServicio(unServicio);
    }

    public void borrarServicio(Servicio unServicio) throws Exception {
        misServicios.remove(unServicio);
        miPersistencia.BajaServicio(unServicio);
    }

    public List<Servicio> mostrarServicios() {
        return miPersistencia.obtenerServicios();
    }
    
    
    
    
    //TIPO
    
    public void altaTipo(int id, String nombre) throws Exception {
        if (comprobarTipo(id) == false) {
            Tipo unTipo = new Tipo(id, nombre);
            misTipos.add(unTipo);
            miPersistencia.AltaTipo(unTipo);
        }
    }
    
    public void altaTipo(String nombre){
            Tipo unTipo = new Tipo(nombre);
            misTipos.add(unTipo);
            miPersistencia.AltaTipo(unTipo);
    }
    
    public Tipo DameElTipo(int ID) {
        return this.miPersistencia.dameUnTipo(ID);
    }

    public boolean comprobarTipo(int id) {
        boolean aux = false;
        
        for(Tipo unTipo : misTipos){
            if(unTipo.getId() == id){
                aux = true;
            }
        }
        
        return aux;
    }
    /**
     * @param nombre
     * @return id en el caso de no encontrar retorna -1
     */
    public int buscarTipoPorNombre(String nombre){
        int id=-1;
        Tipo unTipo = null;
            if(this.mostrarTipos().isEmpty()!= true){
                Iterator it = this.mostrarTipos().iterator();
                while(it.hasNext()){
                    unTipo = (Tipo)it.next();
                    if(unTipo.getNombre().equals(nombre)){
                        id = unTipo.getId();
                    }
                }
            }
        return id;
    }
    

    public void modificarTipo(int id, String nombre, Tipo unTipo) throws Exception {
        misTipos.remove(unTipo);
        unTipo.setNombre(nombre);
        miPersistencia.EditarTipo(unTipo);
    }
    
    public void modificarTipo(String oldName, String newName) throws Exception{
        int id = 0;
        if(this.misTipos.isEmpty() != true){
            id= this.buscarTipoPorNombre(oldName);
            if(id != -1){
                Tipo unTipo = new Tipo(id, oldName);
                this.misTipos.remove(unTipo);
                unTipo.setNombre(newName);
                this.misTipos.add(unTipo);
                this.miPersistencia.EditarTipo(unTipo);
            }
        }
    }

    public void borrarTipo(Tipo unTipo) throws Exception {
        misTipos.remove(unTipo);
        miPersistencia.BajaTipo(unTipo);
    }

    public void borrarTipo(int id) throws NonexistentEntityException{
        if(this.misTipos.isEmpty() != true){
            this.miPersistencia.BajaTipo(id);
            this.misTipos.remove(this.DameElTipo(id));
        }
    }   
    
    public List<Tipo> mostrarTipos() {
        return miPersistencia.obtenerTipos();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
