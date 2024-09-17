import java.util.LinkedList;

public class Hotel {
	
	private LinkedList <Empleados>empleados=new LinkedList<Empleados>();
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
	public LinkedList getEmpleados() {
		return empleados;
	}
	public void setEmpleados(LinkedList empleados) {
		this.empleados = empleados;
	}
	public LinkedList getClientes() {
		return clientes;
	}
	public void setClientes(LinkedList clientes) {
		this.clientes = clientes;
	}
	public LinkedList getRecreaciones() {
		return recreaciones;
	}
	public void setRecreaciones(LinkedList recreaciones) {
		this.recreaciones = recreaciones;
	}
	public LinkedList getReservas_habitacion() {
		return reservas_habitacion;
	}
	public void setReservas_habitacion(LinkedList reservas_habitacion) {
		this.reservas_habitacion = reservas_habitacion;
	}
	public LinkedList getReservas_recreacion() {
		return reservas_recreacion;
	}
	public void setReservas_recreacion(LinkedList reservas_recreacion) {
		this.reservas_recreacion = reservas_recreacion;
	}
	public LinkedList getFacturas() {
		return facturas;
	}
	public void setFacturas(LinkedList facturas) {
		this.facturas = facturas;
	}
	@Override
	public String toString() {
		return "Hotel [empleados=" + empleados + ", clientes=" + clientes + ", recreaciones=" + recreaciones
				+ ", reservas_habitacion=" + reservas_habitacion + ", reservas_recreacion=" + reservas_recreacion
				+ ", facturas=" + facturas + "]";
	}
	
	
	
	
}
