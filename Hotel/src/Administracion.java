import javax.swing.JOptionPane;

public class Administracion extends Empleado {
	public Administracion(int id, String cargo, String nombre, String apellido, String dni, String mail,
			String contrasena) {
		super(id, cargo, nombre, apellido, dni, mail, contrasena);
		
	}
	@Override
	public void menu() {
		int menu=5;
		String [] opciones = {"Check-In","Check-out","Reservar Actividades","Buscar Cliente","Salir"};
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
		}
		} while (menu!=4);
		
	}
	public void checkIn() {
		JOptionPane.showMessageDialog(null, "Check-In");
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
