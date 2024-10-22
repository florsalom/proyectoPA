package BLL;
import java.time.LocalDate;

public class ReservaHabitaciones {

	private int id;
	private int id_cliente_fk;
	private int id_habitacion_fk;
	private LocalDate fecha_entrada;
	private LocalDate fecha_salida;
	public ReservaHabitaciones(int id, int id_cliente_fk, int id_habitacion_fk, LocalDate fecha_entrada,
			LocalDate fecha_salida) {
		super();
		this.id = id;
		this.id_cliente_fk = id_cliente_fk;
		this.id_habitacion_fk = id_habitacion_fk;
		this.fecha_entrada = fecha_entrada;
		this.fecha_salida = fecha_salida;
	}
	public ReservaHabitaciones(int id_cliente_fk, int id_habitacion_fk, LocalDate fecha_entrada) {
		super();
		this.id = 0;
		this.id_cliente_fk = id_cliente_fk;
		this.id_habitacion_fk = id_habitacion_fk;
		this.fecha_entrada = fecha_entrada;
		this.fecha_salida = null;
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
	@Override
	public String toString() {
		return "ReservaHabitaciones [id=" + id + ", id_cliente_fk=" + id_cliente_fk + ", id_habitacion_fk="
				+ id_habitacion_fk + ", fecha_entrada=" + fecha_entrada + ", fecha_salida=" + fecha_salida + "]";
	}
	
	
}
