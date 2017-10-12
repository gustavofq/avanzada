/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

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
    
    
    
}
