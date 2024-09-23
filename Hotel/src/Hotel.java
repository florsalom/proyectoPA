import java.util.LinkedList;

public class Hotel {
	
	private LinkedList <Empleado>empleados=new LinkedList<Empleado>();
	private LinkedList <Cliente>clientes=new LinkedList <Cliente>();
	private LinkedList <Recreacion>recreaciones=new LinkedList <Recreacion>();
	private LinkedList <ReservaHabitaciones>reservas_habitacion=new LinkedList <ReservaHabitaciones>();
	private LinkedList <ReservaRecreacion>reservas_recreacion=new LinkedList<ReservaRecreacion>();
	private LinkedList <Factura>facturas=new LinkedList<Factura>();
	public Hotel() {
		super();
		this.empleados = empleados;
		this.clientes = clientes;
		this.recreaciones = recreaciones;
		this.reservas_habitacion = reservas_habitacion;
		this.reservas_recreacion = reservas_recreacion;
		this.facturas = facturas;
	}
	public LinkedList<Empleado> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(LinkedList<Empleado> empleados) {
		this.empleados = empleados;
	}
	public LinkedList<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(LinkedList<Cliente> clientes) {
		this.clientes = clientes;
	}
	public LinkedList<Recreacion> getRecreaciones() {
		return recreaciones;
	}
	public void setRecreaciones(LinkedList<Recreacion> recreaciones) {
		this.recreaciones = recreaciones;
	}
	public LinkedList<ReservaHabitaciones> getReservas_habitacion() {
		return reservas_habitacion;
	}
	public void setReservas_habitacion(LinkedList<ReservaHabitaciones> reservas_habitacion) {
		this.reservas_habitacion = reservas_habitacion;
	}
	public LinkedList<ReservaRecreacion> getReservas_recreacion() {
		return reservas_recreacion;
	}
	public void setReservas_recreacion(LinkedList<ReservaRecreacion> reservas_recreacion) {
		this.reservas_recreacion = reservas_recreacion;
	}
	public LinkedList<Factura> getFacturas() {
		return facturas;
	}
	public void setFacturas(LinkedList<Factura> facturas) {
		this.facturas = facturas;
	}
	@Override
	public String toString() {
		return "Hotel [empleados=" + empleados + ", clientes=" + clientes + ", recreaciones=" + recreaciones
				+ ", reservas_habitacion=" + reservas_habitacion + ", reservas_recreacion=" + reservas_recreacion
				+ ", facturas=" + facturas + "]";
	}
	
	
	
	
	
}
