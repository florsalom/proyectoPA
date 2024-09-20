import java.util.LinkedList;

public class Empleados {

	private int id;
	private String cargo;
	private String nombre;
	private String apellido;
	private String dni;
	private String mail;
	private String contrasena;
	public Empleados(int id, String cargo, String nombre, String apellido, String dni, String mail, String contrasena) {
		super();
		this.id = id;
		this.cargo = cargo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.mail = mail;
		this.contrasena = contrasena;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
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
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	@Override
	public String toString() {
		return "Empleados [id=" + id + ", cargo=" + cargo + ", nombre=" + nombre + ", apellido=" + apellido + ", dni="
				+ dni + ", mail=" + mail + ", contrasena=" + contrasena + "]";
	}
	
	public void menu() {
		
	}
	
	
}
