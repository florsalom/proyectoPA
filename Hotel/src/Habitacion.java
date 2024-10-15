import java.time.LocalDate;

public class Habitacion {
	private int id;
	private int tipo_habitacion_fk;
	private int cant_huespedes;
	private int estado_limpieza;
	public Habitacion(int id, int tipo_habitacion_fk, int cant_huespedes, int estado_limpieza) {
		super();
		this.id = id;
		this.tipo_habitacion_fk = tipo_habitacion_fk;
		this.cant_huespedes = cant_huespedes;
		this.estado_limpieza = estado_limpieza;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTipo_habitacion_fk() {
		return tipo_habitacion_fk;
	}
	public void setTipo_habitacion_fk(int tipo_habitacion_fk) {
		this.tipo_habitacion_fk = tipo_habitacion_fk;
	}
	public int getCant_huespedes() {
		return cant_huespedes;
	}
	public void setCant_huespedes(int cant_huespedes) {
		this.cant_huespedes = cant_huespedes;
	}
	public int getEstado_limpieza() {
		return estado_limpieza;
	}
	public void setEstado_limpieza(int estado_limpieza) {
		this.estado_limpieza = estado_limpieza;
	}
	@Override
	public String toString() {
		return "Habitacion [id=" + id + ", tipo_habitacion_fk=" + tipo_habitacion_fk + ", cant_huespedes="
				+ cant_huespedes + ", estado_limpieza=" + estado_limpieza + "]";
	}
	
	
	
}
