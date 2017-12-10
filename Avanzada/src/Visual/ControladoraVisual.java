/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;

import Logica.Camarero;
import Logica.Cliente;
import Logica.Departamento;
import Logica.DetalleFactura;
import Logica.Factura;
import Logica.Habitacion;
import Logica.Hotel;
import Logica.Mesa;
import Logica.Plato;
import Logica.Proveedor;
import Logica.RHabitacion;
import Logica.RMesas;
import Logica.Recepcionista;
import Logica.Servicio;
import Logica.Tipo;
import Persistencia.exceptions.NonexistentEntityException;
import com.itextpdf.text.DocumentException;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

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

    
    //METODOS QUE LLAMAN A HOTEL
    
    //CAMARERO
    
    public void altaCamarero(int dni, String nombre, String apellido) throws Exception {
        this.unHotel.altaCamarero(dni, nombre, apellido);
    }
    
    public Camarero DameElCamarero(int ID) {
        return this.unHotel.DameElCamarero(ID);
    }

    public void modificarCamarero(int dni, String nombre, String apellido, Camarero unCamarero) throws Exception {
        this.unHotel.modificarCamarero(dni, nombre, apellido, unCamarero);
    }

    public void borrarCamarero(Camarero unCamarero) throws Exception {
        this.unHotel.borrarCamarero(unCamarero);
    }

    public List<Camarero> mostrarCamareros() {
        return this.unHotel.mostrarCamareros();
    }
    
    
    
 
    //CLIENTE
    
    public void altaCliente(int dni, String nombre, String apellido, Double tarjetaDeCredito, String usuario, String contraseña) throws Exception {
        this.unHotel.altaCliente(dni, nombre, apellido, tarjetaDeCredito, usuario, contraseña);
    }
    
    public Cliente DameElCliente(int ID) {
        return this.unHotel.DameElCliente(ID);
    }
    
    public Cliente buscarClientePorNombre(String nombre, String apellido) {
        return this.unHotel.buscarClientePorNombre(nombre, apellido);
    }

    public void modificarCliente(int dni, String nombre, String apellido, Double tarjetaDeCredito, String usuario, String contraseña, Cliente unCliente) throws Exception {
        this.unHotel.modificarCliente(dni, nombre, apellido, tarjetaDeCredito, usuario, contraseña, unCliente);
    }

    public void borrarCliente(Cliente unCliente) throws Exception {
        this.unHotel.borrarCliente(unCliente);
    }

    public List<Cliente> mostrarClientes() {
        return this.unHotel.mostrarClientes();
    }
    
    
    
    
    
    //DEPARTAMENTO
    
    public void altaDepartamento(int id, String nombre) throws Exception {
        this.unHotel.altaDepartamento(id, nombre);
    }
    
    public void altaDepartamento(String nombre) throws Exception {
        this.unHotel.altaDepartamento(nombre);
    }
    
    public Departamento DameElDepartamento(int ID) {
        return this.unHotel.DameElDepartamento(ID);
    }

    public void modificarDepartamento(int id, String nombre, Departamento unDepartamento) throws Exception {
        this.unHotel.modificarDepartamento(id, nombre, unDepartamento);
    }

    public void borrarDepartamento(Departamento unDepartamento) throws Exception {
        this.unHotel.borrarDepartamento(unDepartamento);
    }

    public List<Departamento> mostrarDepartamentos() {
        return this.unHotel.mostrarDepartamentos();
    }
    
    
    //FACTURA
    
    public void altaFactura(String Tipo, Double total, Cliente unCliente, List<DetalleFactura> unosDetalles) throws Exception {
        this.unHotel.altaFactura(Tipo, total, unCliente, unosDetalles);
    }
        
    public  Factura DameLaFactura(int ID) {
        return this.unHotel.DameLaFactura(ID);
    }
    
    public void modificarFactura(int id, String Tipo, Double total, Factura unaFactura) throws Exception {
        this.unHotel.modificarFactura(id, Tipo, total, unaFactura);
    }

    public void borrarFactura(Factura unaFactura) throws Exception {
        this.unHotel.borrarFactura(unaFactura);
    }

    public List<Factura> mostrarFacturas() {
        return this.unHotel.mostrarFacturas();
    }
    
    
    
    
    //HABITACION
    
    public void altaHabitacion(int id, boolean estado, int montoPorNoche, Tipo unTipo) throws Exception {
        this.unHotel.altaHabitacion(id, estado, montoPorNoche, unTipo);
    }
    
    public void altaHabitacion(boolean ocupado, int montoPorNoche, String nombreTipo){
        this.unHotel.altaHabitacion(ocupado, montoPorNoche, nombreTipo);
    }
    
    public Habitacion DameLaHabitacion(int ID) {
        return this.unHotel.DameLaHabitacion(ID);
    }
    

    public void modificarHabitacion(int id, boolean estado, int montoPorNoche, Tipo unTipo, Habitacion unaHabitacion) throws Exception {
        this.unHotel.modificarHabitacion(id, estado, montoPorNoche, unTipo, unaHabitacion);
    }

    public void modificarHabitacion(int numero,int montoPorNoche, String nombreTipo) throws Exception{
        this.unHotel.modificarHabitacion(numero, montoPorNoche, nombreTipo);
    }
    
    public void borrarHabitacion(Habitacion unaHabitacion) throws Exception {
        this.unHotel.borrarHabitacion(unaHabitacion);
    }

    public void borrarHabitacion(int numero) throws NonexistentEntityException{
        this.unHotel.borrarHabitacion(numero);
    }
    
    public List<Habitacion> mostrarHabitaciones() {
        return this.unHotel.mostrarHabitaciones();
    }
    
    
    
    
    //MESAS
    
    public void altaMesa(String Estado) throws Exception {
        this.unHotel.altaMesa(Estado);
    }
    
    public Mesa DameLaMesa(int ID) {
        return this.unHotel.DameLaMesa(ID);
    }

    public void modificarMesa(int id, String Estado, Mesa unaMesa) throws Exception {
        this.unHotel.modificarMesa(id, Estado, unaMesa);
    }

    public void borrarMesa(Mesa unaMesa) throws Exception {
        this.unHotel.borrarMesa(unaMesa);
    }

    public List<Mesa> mostrarMesas() {
        return this.unHotel.mostrarMesas();
    }
    
    
    //PLATOS
    
    public void altaPlato(String nombre, String descripcion, int precio) throws Exception {
        this.unHotel.altaPlato(nombre, descripcion, precio);
    }
    
    public Plato DameElPlato(int ID) {
        return this.unHotel.DameElPlato(ID);
    }
    
    public Plato DameElPlato(String nombrePlato) {
        return this.unHotel.DameElPlato(nombrePlato);
    }

    public void modificarPlato(int id, String nombre, String descripcion, int precio, Plato unPlato) throws Exception {
        this.unHotel.modificarPlato(id, nombre, descripcion, precio, unPlato);
    }

    public void borrarPlato(Plato unPlato) throws Exception {
        this.unHotel.borrarPlato(unPlato);
    }

    public List<Plato> mostrarPlatos() {
        return this.unHotel.mostrarPlatos();
    }
    
    
    
    
    //Proveedor
    
    public void altaProveedor(int id, String nombre, String direccion, int telefono) throws Exception {
        this.unHotel.altaProveedor(id, nombre, direccion, telefono);
    }
    
    public Proveedor DameElProveedor(int ID) {
        return this.unHotel.DameElProveedor(ID);
    }

    public void modificarProveedor(int id, String nombre, String direccion, int telefono, Proveedor unProveedor) throws Exception {
        this.unHotel.modificarProveedor(id, nombre, direccion, telefono, unProveedor);
    }

    public void borrarProveedor(Proveedor unProveedor) throws Exception {
        this.unHotel.borrarProveedor(unProveedor);
    }

    public List<Proveedor> mostrarProveedores() {
        return this.unHotel.mostrarProveedores();
    }
    
    
    
    //RH HABITACION
    
    public void altaRHabitacion(Calendar fechaEntrada, Calendar fechaSalida, int cantidad, Habitacion unaHabitacion, Cliente unCliente) throws Exception {
        this.unHotel.altaRHabitacion(fechaEntrada, fechaSalida, cantidad, unaHabitacion, unCliente);
    }
    
    public void cambiarEstadoHabitacion(Habitacion unaHabitacion, boolean estado) throws Exception{
        this.unHotel.cambiarEstadoHabitacion(unaHabitacion, estado);
    }
    
    public RHabitacion DameLaRHabitacion(int ID) {
        return this.unHotel.DameLaRHabitacion(ID);
    }

    public void modificarRHabitacion(Calendar fechaEntrada, Calendar fechaSalida, int cantidad, Habitacion unaHabitacion, Cliente unCliente, int id, RHabitacion unaRHabitacion) throws Exception {
        this.unHotel.modificarRHabitacion(fechaEntrada, fechaSalida, cantidad, unaHabitacion, unCliente, id, unaRHabitacion);
    }

    public void borrarRHabitacion(RHabitacion unaRHabitacion) throws Exception {
        this.unHotel.borrarRHabitacion(unaRHabitacion);
    }

    public List<RHabitacion> mostrarRHabitaciones() {
        return this.unHotel.mostrarRHabitaciones();
    }
    
    
    
    
    
    //R MESAS
    
    public void altaRMesa(int numeroMesa, Calendar fecha, Cliente unCliente) throws Exception {
        this.unHotel.altaRMesa(numeroMesa, fecha, unCliente);
    }
    
    public RMesas DameLaRMesa(int ID) {
        return this.unHotel.DameLaRMesa(ID);
    }

    public void modificarRMesa(int numeroMesa, Calendar fecha, Cliente unCliente, RMesas unaRMesas) throws Exception {
        this.unHotel.modificarRMesa(numeroMesa, fecha, unCliente, unaRMesas);
    }

    public void borrarRMesa(RMesas unaRMesas) throws Exception {
        this.unHotel.borrarRMesa(unaRMesas);
    }

    public List<RMesas> mostrarRMesas() {
        return this.unHotel.mostrarRMesas();
    }
    
    
    
    
    //Recepcionista
    
    public void altaRecepcionista(int dni, String nombre, String apellido) throws Exception {
        this.unHotel.altaRecepcionista(dni, nombre, apellido);
    }
    
    public Recepcionista DameLaRecepcionista(int ID) {
        return this.unHotel.DameLaRecepcionista(ID);
    } 

    public void modificarRecepcionista(int dni, String nombre, String apellido, Recepcionista unaRecepcionista) throws Exception {
        this.unHotel.modificarRecepcionista(dni, nombre, apellido, unaRecepcionista);
    }

    public void borrarRecepcionista(Recepcionista unaRecepcionista) throws Exception {
        this.unHotel.borrarRecepcionista(unaRecepcionista);
    }

    public List<Recepcionista> mostrarRecepcionistas() {
        return this.unHotel.mostrarRecepcionistas();
    }
    
    
    
    
    
    //Servicios
    
    public void altaServicio(String nombre, String descripcion, int precio) throws Exception {
        this.unHotel.altaServicio(nombre, descripcion, precio);
    }
    
    public Servicio DameElServicio(int ID) {
        return this.unHotel.DameElServicio(ID);
    }
    
    public Servicio DameElServicio(String nombre) {
        return this.unHotel.DameElServicio(nombre);
    }

    public void modificarServicio(String nombre, String descripcion, int precio, Servicio unServicio) throws Exception {
        this.unHotel.modificarServicio(nombre, descripcion, precio, unServicio);
    }

    public void borrarServicio(Servicio unServicio) throws Exception {
        this.unHotel.borrarServicio(unServicio);
    }

    public List<Servicio> mostrarServicios() {
        return this.unHotel.mostrarServicios();
    }
    
    
    //TIPO
    
    public void altaTipo(int id, String nombre) throws Exception {
        this.unHotel.altaTipo(id, nombre);
    }
    
    public void altaTipo(String nombre){
        this.unHotel.altaTipo(nombre);
    }
    
    public Tipo DameElTipo(int ID) {
        return this.unHotel.DameElTipo(ID);
    }
    
    public void modificarTipo(int id, String nombre, Tipo unTipo) throws Exception {
        this.unHotel.modificarTipo(id, nombre, unTipo);
    }

    public void borrarTipo(Tipo unTipo) throws Exception {
        this.unHotel.borrarTipo(unTipo);
    }

    public void borrarTipo(int id) throws NonexistentEntityException{
        this.unHotel.borrarTipo(id);
    }
    
    public List<Tipo> mostrarTipos() {
        return this.unHotel.mostrarTipos();
    }
    
    public int buscarTipoPorNombre(String nombre){
        return this.unHotel.buscarTipoPorNombre(nombre);
    }
    
    public void modificarTipo(String oldName, String newName) throws Exception{
        this.unHotel.modificarTipo(oldName, newName);
    }

    
    public void modificarFechas(RHabitacion unaRHabitacion, Calendar fechaEntrada, Calendar fechaSalida) throws Exception{
        this.unHotel.modificarFechas(unaRHabitacion, fechaEntrada, fechaSalida);
    }
    
    public void BorrarRHabitacion(RHabitacion unaRHabitacion) throws Exception{
        this.unHotel.BorrarRHabitacion(unaRHabitacion);
    }
    
    public RHabitacion dameUnaReservaHabitacion(int numHabitacion) {
        return this.unHotel.dameUnaReservaHabitacion(numHabitacion);
    }
    

    public int calcularDias(Calendar fechaEntrada, Calendar fechaSalida){
        return this.unHotel.calcularDias(fechaEntrada, fechaSalida);
    }
    
    public List<Habitacion> filtrarReservas(Calendar fechaEntrada, Calendar fechaSalida){
        return this.unHotel.filtrarReservas(fechaEntrada, fechaSalida);
    }
    
    
    
    
    public void imprimirFactura(String tipo, String cliente, Double total, List<DetalleFactura> unosDetalles) throws DocumentException, IOException{
        this.unHotel.imprimirFactura(tipo, cliente, total, unosDetalles);
    }
    
    
    
    
    
    
    
    
    
}
