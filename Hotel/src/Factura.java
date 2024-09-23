import java.time.LocalDate;

public class Factura {

	private int id;
	private int id_cliente_fk;
	private int id_habitacion_fk;
	private LocalDate fecha_entrada;
	private LocalDate fecha_salida;
	private  int id_reserva_recreacion;
	private int costoXhabitacion;
	private int costoXrecreacion;
	private double descuento;
	private double costo_Final;
	public Factura(int id, int id_cliente_fk, int id_habitacion_fk, LocalDate fecha_entrada, LocalDate fecha_salida,
			int id_reserva_recreacion, int costoXhabitacion, int costoXrecreacion, double costo_final, double descuento) {
		super();
		this.id = id;
		this.id_cliente_fk = id_cliente_fk;
		this.id_habitacion_fk = id_habitacion_fk;
		this.fecha_entrada = fecha_entrada;
		this.fecha_salida = fecha_salida;
		this.id_reserva_recreacion = id_reserva_recreacion;
		this.costoXhabitacion = costoXhabitacion;
		this.costoXrecreacion = costoXrecreacion;
		this.costo_Final = costo_final;
		this.descuento = descuento;
	}
	public Factura(int id, int id_cliente_fk, int id_habitacion_fk, LocalDate fecha_entrada, LocalDate fecha_salida,
			int id_reserva_recreacion, int costoXhabitacion, int costoXrecreacion, double costo_final) {
		super();
		this.id = id;
		this.id_cliente_fk = id_cliente_fk;
		this.id_habitacion_fk = id_habitacion_fk;
		this.fecha_entrada = fecha_entrada;
		this.fecha_salida = fecha_salida;
		this.id_reserva_recreacion = id_reserva_recreacion;
		this.costoXhabitacion = costoXhabitacion;
		this.costoXrecreacion = costoXrecreacion;
		this.costo_Final = costo_final;
		this.descuento = 0;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_cliente_fk() {
		return id_cliente_fk;
	}
	public void setId_cliente_fk(int id_cliente_fk) {
		this.id_cliente_fk = id_cliente_fk;
	}
	public int getId_habitacion_fk() {
		return id_habitacion_fk;
	}
	public void setId_habitacion_fk(int id_habitacion_fk) {
		this.id_habitacion_fk = id_habitacion_fk;
	}
	public LocalDate getFecha_entrada() {
		return fecha_entrada;
	}
	public void setFecha_entrada(LocalDate fecha_entrada) {
		this.fecha_entrada = fecha_entrada;
	}
	public LocalDate getFecha_salida() {
		return fecha_salida;
	}
	public void setFecha_salida(LocalDate fecha_salida) {
		this.fecha_salida = fecha_salida;
	}
	public int getId_reserva_recreacion() {
		return id_reserva_recreacion;
	}
	public void setId_reserva_recreacion(int id_reserva_recreacion) {
		this.id_reserva_recreacion = id_reserva_recreacion;
	}
	public int getCostoXhabitacion() {
		return costoXhabitacion;
	}
	public void setCostoXhabitacion(int costoXhabitacion) {
		this.costoXhabitacion = costoXhabitacion;
	}
	public int getCostoXrecreacion() {
		return costoXrecreacion;
	}
	public void setCostoXrecreacion(int costoXrecreacion) {
		this.costoXrecreacion = costoXrecreacion;
	}
	public double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	public double getCosto_Final() {
		return costo_Final;
	}
	public void setCosto_Final(double costo_Final) {
		this.costo_Final = costo_Final;
	}
	@Override
	public String toString() {
		return "Factura [id=" + id + ", id_cliente_fk=" + id_cliente_fk + ", id_habitacion_fk=" + id_habitacion_fk
				+ ", fecha_entrada=" + fecha_entrada + ", fecha_salida=" + fecha_salida + ", id_reserva_recreacion="
				+ id_reserva_recreacion + ", costoXhabitacion=" + costoXhabitacion + ", costoXrecreacion="
				+ costoXrecreacion + ", descuento=" + descuento + ", costo_Final=" + costo_Final + "]";
	}
	                                                           
	
	
	
	
	
	
}
