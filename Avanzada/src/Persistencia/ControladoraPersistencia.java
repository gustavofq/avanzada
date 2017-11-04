/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.*;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;

/**
 *
 * @author Facu
 */
public class ControladoraPersistencia {
    
    private static CamareroJpaController miCamarero;
    private static ClienteJpaController miCliente;
    private static DepartamentoJpaController miDepartamento;
    private static DetalleFacturaJpaController miDetalleFactura;
    private static FacturaJpaController miFactura;
    private static HabitacionJpaController miHabitacion;
    private static MesaJpaController miMesa;
    private static PlatoJpaController miPlato;
    private static ProveedorJpaController miProveedor;
    private static RHabitacionJpaController miRHabitacion;
    private static RMesasJpaController miRMesas;
    private static RecepcionistaJpaController miRecepcionista;
    private static ServicioJpaController miServicio;
    private static TipoJpaController miTipo;

    
    static {
    miCamarero = new CamareroJpaController();
    miCliente = new ClienteJpaController();
    miDepartamento = new DepartamentoJpaController();
    miDetalleFactura = new DetalleFacturaJpaController();
    miFactura = new FacturaJpaController();
    miHabitacion = new HabitacionJpaController();
    miMesa = new MesaJpaController();
    miPlato = new PlatoJpaController();
    miProveedor = new ProveedorJpaController();
    miRHabitacion = new RHabitacionJpaController();
    miRMesas = new RMesasJpaController();
    miRecepcionista = new RecepcionistaJpaController();
    miServicio = new ServicioJpaController();
    miTipo = new TipoJpaController();
    }
    
    
    //camarero
    
    public void AltaCamarero(Camarero unCamarero){
        miCamarero.create(unCamarero);
    }
    
    public Camarero dameUnCamarero(int id){
        return miCamarero.findCamarero(id);
    }
    
    public void EditarCamarero(Camarero unCamarero) throws Exception{
        miCamarero.edit(unCamarero);
    }
    
    public void BajaCamarero(Camarero unCamarero) throws NonexistentEntityException{
        miCamarero.destroy(unCamarero.getDni());
    }
    
    public List<Camarero> obtenerCamareros(){
        return miCamarero.findCamareroEntities();
    }
    
    //cliente
    
    public void AltaCliente(Cliente unCliente) throws Exception{
        miCliente.create(unCliente);
    }
    
    public Cliente dameUnCliente(int id){
        return miCliente.findCliente(id);
    }
    
    public void EditarCliente(Cliente unCliente) throws Exception{
        miCliente.edit(unCliente);
    }
    
    public void BajaCliente(Cliente unCliente) throws NonexistentEntityException{
        miCliente.destroy(unCliente.getDni());
    }
    
    public List<Cliente> obtenerClientes(){
        return miCliente.findClienteEntities();
    }
   
    //Departamento 
    
    public void AltaDepartamento(Departamento unDepartamento){
        miDepartamento.create(unDepartamento);
    }
    
    public Departamento dameUnDepartamento(int id){
        return miDepartamento.findDepartamento(id);
    }
    
    public void EditarDepartamento(Departamento unDepartamento) throws Exception{
        miDepartamento.edit(unDepartamento);
    }
    
    public void BajaDepartamento(Departamento unDepartamento) throws NonexistentEntityException{
        miDepartamento.destroy(unDepartamento.getId());
    }
    
    public List<Departamento> obtenerDepartamentos(){
        return miDepartamento.findDepartamentoEntities();
    }
    
    //facturas 
    
    public void AltaFactura(Factura unaFactura){
        miFactura.create(unaFactura);
    }
    
    public Factura dameUnaFactura(int id){
        return miFactura.findFactura(id);
    }
    
    public void EditarFactura(Factura unaFactura) throws Exception{
        miFactura.edit(unaFactura);
    }
    
    public void BajaFactura(Factura unaFactura) throws NonexistentEntityException{
        miFactura.destroy(unaFactura.getId());
    }
    
    public List<Factura> obtenerFacturas(){
        return miFactura.findFacturaEntities();
    }
    
    //facturas 
    
    public void AltaDetalleFactura(DetalleFactura unDetalleFactura){
        miDetalleFactura.create(unDetalleFactura);
    }
    
    public DetalleFactura dameUnDetalleFactura(int id){
        return miDetalleFactura.findDetalleFactura(id);
    }
    
    public void EditarDetalleFactura(DetalleFactura unDetalleFactura) throws Exception{
        miDetalleFactura.edit(unDetalleFactura);
    }
    
    public void BajaDetalleFactura(DetalleFactura unDetalleFactura) throws NonexistentEntityException{
        miFactura.destroy(unDetalleFactura.getId());
    }
    
    public List<DetalleFactura> obtenerDetallesFacturas(){
        return miDetalleFactura.findDetalleFacturaEntities();
    }
    
    //habitacion 
    
    public void AltaHabitacion(Habitacion unaHabitacion){
        miHabitacion.create(unaHabitacion);
    }
    
    public Habitacion dameUnaHabitacion(int id){
        return miHabitacion.findHabitacion(id);
    }
    
    public void EditarHabitacion(Habitacion unaHabitacion) throws Exception{
        miHabitacion.edit(unaHabitacion);
    }
    
    public void BajaHabitacion(Habitacion unaHabitacion) throws NonexistentEntityException{
        miHabitacion.destroy(unaHabitacion.getId());
    }
    
    public List<Habitacion> obtenerHabitaciones(){
        return miHabitacion.findHabitacionEntities();
    }
    
    //Mesas
    
    public void AltaMesa(Mesa unaMesa){
        miMesa.create(unaMesa);
    }
    
    public Mesa dameUnaMesa(int id){
        return miMesa.findMesa(id);
    }
    
    public void EditarMesa(Mesa unMesa) throws Exception{
        miMesa.edit(unMesa);
    }
    
    public void BajaMesa(Mesa unMesa) throws NonexistentEntityException{
        miMesa.destroy(unMesa.getId());
    }
    
    public List<Mesa> obtenerMesas(){
        return miMesa.findMesaEntities();
    }
    
    //platos
    
    public void AltaPlato(Plato unPlato){
        miPlato.create(unPlato);
    }
    
    public Plato dameUnPlato(int id){
        return miPlato.findPlato(id);
    }
    
    public void EditarPlato(Plato unPlato) throws Exception{
        miPlato.edit(unPlato);
    }
    
   public void BajaPlato(Plato unPlato) throws NonexistentEntityException{
       miPlato.destroy(unPlato.getId());
   }
   
   public List<Plato> obtenerPlatos(){
       return miPlato.findPlatoEntities();
   }
    
   //proveedores
   
   public void AltaProveedor(Proveedor unProveedor){
       miProveedor.create(unProveedor);
   }
   
   public Proveedor dameUnProveedor(int id){
       return miProveedor.findProveedor(id);
   }
   
   public void EditarProveedor(Proveedor unProveedor) throws Exception{
       miProveedor.edit(unProveedor);
   }
   
   public void BajaProveedor(Proveedor unProveedor) throws NonexistentEntityException{
       miProveedor.destroy(unProveedor.getId());
   }
   
   public List<Proveedor>obtenerProveedores(){
       return miProveedor.findProveedorEntities();
   }
   
   //rh habitacion 
   
   public void AltaRHabitacion(RHabitacion unaRHabitacion){
       miRHabitacion.create(unaRHabitacion);
   }
   
   public RHabitacion dameUnaRHabitacion(int id){
       return miRHabitacion.findRHabitacion(id);
   }
   
   public void EditarRHabitacion(RHabitacion unaHabitacion) throws Exception{
       miRHabitacion.edit(unaHabitacion);
   }
   
   public void BajaRHabitacion(RHabitacion unaRHabitacion) throws NonexistentEntityException{
       miRHabitacion.destroy(unaRHabitacion.getId());
   }
   
   public List<RHabitacion> obtenerRHabitaciones(){
       return miRHabitacion.findRHabitacionEntities();
   }
   
   // R Mesas
   
   public void AltaRMesas(RMesas unaRMesas){
       miRMesas.create(unaRMesas);
   }
   
   public RMesas dameUnaRMesa(int id){
       return miRMesas.findRMesas(id);
   }
   
   public void EditarRMesas(RMesas unaRMesas) throws Exception{
       miRMesas.edit(unaRMesas);
   }
   
   public void BajaRMesas(RMesas unaRMesas) throws NonexistentEntityException{
       miRMesas.destroy(unaRMesas.getId());
   }
   
   public List<RMesas> obtenerRMesas(){
       return miRMesas.findRMesasEntities();
   }
   
   //Recepcionistas
   
   public void AltaRecepcionista(Recepcionista unaRecepcionista){
       miRecepcionista.create(unaRecepcionista);
   }
   
   public Recepcionista dameUnaRecepcionista(int id){
       return miRecepcionista.findRecepcionista(id);
   }
   
   public void EditarRecepcionista(Recepcionista unaRecepcionista) throws Exception{
       miRecepcionista.edit(unaRecepcionista);
   }
   
   public void BajaRecepcionista(Recepcionista unaRecepcionista) throws NonexistentEntityException{
       miRecepcionista.destroy(unaRecepcionista.getDni());
   }
   
   public List<Recepcionista> obtenerRecepcionistas(){
       return miRecepcionista.findRecepcionistaEntities();
   }
   
   //servicios
   
   public void AltaServicio(Servicio unServicio){
       miServicio.create(unServicio);
   }
   
   public Servicio dameUnServicio(int id){
       return miServicio.findServicio(id);
   }
   
   public void EditarServicio(Servicio unServicio) throws Exception{
       miServicio.edit(unServicio);
   }
   
   public void BajaServicio(Servicio unServicio) throws NonexistentEntityException{
       miServicio.destroy(unServicio.getId());
   }
   
   public List<Servicio> obtenerServicios(){
       return miServicio.findServicioEntities();
   }
   
   //tipo
   public void AltaTipo(Tipo unTipo){
       miTipo.create(unTipo);
   }
   
   public Tipo dameUnTipo(int id){
       return miTipo.findTipo(id);
   }
   
   public void EditarTipo(Tipo unTipo) throws Exception{
       miTipo.edit(unTipo);
   }
   
   public void BajaTipo(Tipo unTipo) throws NonexistentEntityException{
       miTipo.destroy(unTipo.getId());
   }
   
   public void BajaTipo(int id) throws NonexistentEntityException{
       miTipo.destroy(id);
   }
   
   public List<Tipo> obtenerTipos(){
       return miTipo.findTipoEntities();
   }
}
