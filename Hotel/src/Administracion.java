import java.time.LocalDate;

import javax.swing.JOptionPane;

public class Administracion extends Empleado {
	public Administracion(int id, int cargo, String nombre, String apellido, int dni, String mail,
			String contrasena) {
		super(id, cargo, nombre, apellido, dni, mail, contrasena);
		
	}
	@Override
	public void menu() {
		int menu=6;
		String [] opciones = {"Check-In","Check-out","Reservar Actividades","Buscar Cliente","Ver habitación","Salir"};
		Cliente a = new Cliente();
		do {
			menu=JOptionPane.showOptionDialog(null, "Que desea realizar hoy", null, 0, 0, null, opciones, opciones[0]);
			switch (menu) {
			case 0:
				checkIn();
				break;

			case 1:
				checkOut(a);
				break;
			
		case 2:
			reservar_Actividades();
			break;
		case 3:
			buscar_Cliente();
			break;
		case 4:
			ver_Habitacion();
			break;
		}
		} while (menu!=5);
		
	}
	public void ver_Habitacion() {
		JOptionPane.showMessageDialog(null, "Ver habitación");
	}
	public void checkIn() {
		boolean flag=true;
		String nombre, apellido;
		int dni=0, cantidad=0, celular=0;
		LocalDate fecha_entrada= LocalDate.now();
		nombre=JOptionPane.showInputDialog("Ingrese nombre");
		if (nombre.isEmpty()) {
			flag=false;
		}
		apellido=JOptionPane.showInputDialog("Ingrese apellido");
		if (apellido.isEmpty()) {
			flag=false;
		}
		
		try {
			dni=Integer.parseInt(JOptionPane.showInputDialog("Ingrese dni"));
		} catch (Exception e) {
			flag=false;
			JOptionPane.showMessageDialog(null, "El dni debe ser un numero");
		}try {
			cantidad=Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad"));
		} catch (Exception e) {
			flag=false;
			JOptionPane.showMessageDialog(null, "La cantidad debe ser un numero");
		}try {
			celular=Integer.parseInt(JOptionPane.showInputDialog("ingrese celular"));
		} catch (Exception e) {
			flag=false;
			JOptionPane.showMessageDialog(null, "El celular debe ser un numero");
		}
		
		if (flag=true) {
			ControllerCliente.agregarCliente(new Cliente(0,nombre,apellido,dni,cantidad,celular,fecha_entrada));
		}
	}
	public void checkOut(Cliente cliente) {
		JOptionPane.showMessageDialog(null, "Check-Out");
	}
	public String generar_factura() {
		String factura="";
		JOptionPane.showMessageDialog(null, "Generar Factura");
		return factura;
	}

	public int ingresar_descuento(int costo){
		JOptionPane.showMessageDialog(null, "Ingresar Descuento");
		return costo;
	}

	public void reservar_Actividades(){
		JOptionPane.showMessageDialog(null, "Reservar Actividades");
	}

	public void buscar_Cliente(){
		JOptionPane.showMessageDialog(null, "Buscar Cliente");
	}
	
	
	
	
	
}
