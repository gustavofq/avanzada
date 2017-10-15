/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.ControladoraPersistencia;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.OneToMany;
import jdk.nashorn.internal.runtime.Undefined;

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
       
        
        
        
    }
    
    public Hotel() {
        CargarListas();
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
        return misCamareros;
    }
    
    
    
    //CLIENTE
    
    public void altaCliente(int dni, String nombre, String apellido, Double tarjetaDeCredito, String usuario, String contraseña) throws Exception {
        if (comprobarCliente(dni) == false) {
            Cliente unCliente = new Cliente(dni, nombre, apellido, tarjetaDeCredito, usuario, contraseña);
            misClientes.add(unCliente);
            miPersistencia.AltaCliente(unCliente);
        }
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
        return misClientes;
    }
    
    
    
    
    //DEPARTAMENTO
    
    public void altaDepartamento(int id, String nombre) throws Exception {
        if (comprobarDepartamento(id) == false) {
            Departamento unDepartamento = new Departamento(id, nombre);
            misDepartamentos.add(unDepartamento);
            miPersistencia.AltaDepartamento(unDepartamento);
        }
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
        miPersistencia.EditarDepartamento(unDepartamento);
    }

    public void borrarDepartamento(Departamento unDepartamento) throws Exception {
        misDepartamentos.remove(unDepartamento);
        miPersistencia.BajaDepartamento(unDepartamento);
    }

    public List<Departamento> mostrarDepartamentos() {
        return misDepartamentos;
    }

    
    
    
    
    //FACTURA
    
    public void altaFactura(int id, String Tipo, Double total) throws Exception {
        if (comprobarFactura(id) == false) {
            DetalleFactura unDetalleFactura = new DetalleFactura(id, descripcion, cantidad, Subtotal);
            misDetalleFacu.add(unDepartamento);
            miPersistencia.AltaDepartamento(unDepartamento);
        }
    }
    
    public Departamento DameElDepartamento(int ID) {
        return this.miPersistencia.dameUnDepartamento(ID);
    }

    public boolean comprobarFactura(int id) {
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

    public void borrarDepartamento(Departamento unDepartamento) throws Exception {
        misDepartamentos.remove(unDepartamento);
        miPersistencia.BajaDepartamento(unDepartamento);
    }

    public List<Departamento> mostrarDepartamentos() {
        return misDepartamentos;
    }
    
    
    
    
    //HABITACION
    
    public void altaHabitacion(int id, String estado, int montoPorNoche, Tipo unTipo) throws Exception {
        if (comprobarHabitacion(id) == false) {
            Habitacion unaHabitacion = new Habitacion(id, estado, montoPorNoche, unTipo);
            misHabitaciones.add(unaHabitacion);
            miPersistencia.AltaHabitacion(unaHabitacion);
        }
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
    

    public void modificarHabitacion(int id, String estado, int montoPorNoche, Tipo unTipo, Habitacion unaHabitacion) throws Exception {
        misHabitaciones.remove(unaHabitacion);
        unaHabitacion.setEstado(estado);
        unaHabitacion.setMontoPorNoche(montoPorNoche);
        unaHabitacion.setUnTipo(unTipo);
        miPersistencia.EditarHabitacion(unaHabitacion);
    }

    public void borrarHabitacion(Habitacion unaHabitacion) throws Exception {
        misHabitaciones.remove(unaHabitacion);
        miPersistencia.BajaHabitacion(unaHabitacion);
    }

    public List<Habitacion> mostrarHabitaciones() {
        return misHabitaciones;
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
        return misMesas;
    }
    
    
    
    
    //PLATOS
    
    public void altaPlato(int id, String nombre, String descripcion, int precio) throws Exception {
        if (comprobarPlato(id) == false) {
            Plato unPlato = new Plato(id, nombre, descripcion, precio);
            misPlatos.add(unPlato);
            miPersistencia.AltaPlato(unPlato);
        }
    }
    
    public Mesa DameElPlato(int ID) {
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
        return misPlatos;
    }
    
    
    
    //Proveedor
    
    public void altaProveedor(int id, String nombre, String direccion, int telefono) throws Exception {
        if (comprobarProveedor(id) == false) {
            Proveedor unProveedor = new Proveedor(id, nombre, direccion, telefono);
            misProveedores.add(unProveedor);
            miPersistencia.AltaProveedor(unProveedor);
        }
    }
    
    public Mesa DameElProveedor(int ID) {
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
        return misProveedores;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
