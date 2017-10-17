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
}
