import java.time.LocalDate;

public class Cliente {

	private int id;
	private String nombre;
	private String apellido;
	private int dni;
	private int cantidad;
	private int celular;
	private LocalDate fecha_entrada;
	private LocalDate fecha_salida;
	public Cliente(int id, String nombre, String apellido, int dni, int cantidad, int celular,
			LocalDate fecha_entrada, LocalDate fecha_salida) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.cantidad = cantidad;
		this.celular = celular;
		this.fecha_entrada = fecha_entrada;
		this.fecha_salida = fecha_salida;
	}
	public Cliente(int id, String nombre, String apellido, int dni, int cantidad, int celular,
			LocalDate fecha_entrada) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.cantidad = cantidad;
		this.celular = celular;
		this.fecha_entrada = fecha_entrada;
		this.fecha_salida = null;
	}
	public Cliente() {
		super();
		this.id = 0;
		this.nombre = "";
		this.apellido = "";
		this.dni = 0;
		this.cantidad = 0;
		this.celular = 0;
		this.fecha_entrada = null;
		this.fecha_salida = null;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getCelular() {
		return celular;
	}
	public void setCelular(int celular) {
		this.celular = celular;
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
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", cantidad="
				+ cantidad + ", celular=" + celular + ", fecha_entrada=" + fecha_entrada + ", fecha_salida="
				+ fecha_salida + "]";
	}
	
	
	
	
	
	
}
