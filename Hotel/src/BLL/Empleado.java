package BLL;

public class Empleado {

	private int id;
	private int cargo;
	private String nombre;
	private String apellido;
	private int dni;
	private String mail;
	private String contrasena;
	public Empleado(int id, int cargo, String nombre, String apellido, int dni, String mail, String contrasena) {
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
	public int getCargo() {
		return cargo;
	}
	public void setCargo(int cargo) {
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
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
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
	public static Empleado Login(String mail, String contrasena) {
		Hotel hotel= Hotel_Singleton.getHotel();
		Empleado a=null;
		for (Empleado empleado : hotel.getEmpleados()) {
			if (mail.equals(empleado.getMail())&&contrasena.equals(empleado.getContrasena())) {
				a=empleado;
				break;
			}
		}
		return a;
		
	}
	
	
}
