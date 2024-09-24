import javax.swing.JOptionPane;

public class JefeLimpieza extends Empleado {

//<<<<<<< Updated upstream
//public class JefeLimpieza {

//=======
	public JefeLimpieza(int id, String cargo, String nombre, String apellido, String dni, String mail,
			String contrasena) {
		super(id, cargo, nombre, apellido, dni, mail, contrasena);
	}
	@Override
	public void menu() {
		int menu=5;
		String [] opciones = {"Asignar Trabajo","Ver habitación","Salir"};
		do {
			menu=JOptionPane.showOptionDialog(null, "Que desea realizar hoy", null, 0, 0, null, opciones, opciones[0]);
			switch (menu) {
			case 0:
				asignar_Trabajo();
				break;
			case 1:
				ver_Habitacion();
				break;

		}
		} while (menu!=1);
	}
	public void asignar_Trabajo() {
		JOptionPane.showMessageDialog(null, "Asignar Trabajo");
	}
public void ver_Habitacion() {
	JOptionPane.showMessageDialog(null, "Ver habitación");
}





//@Override
		//public void menu() {
			//	JOptionPane.showMessageDialog(null, "Menu admin");
			//}
			////@Override
			//public void menuPrincipal() {
			//	JOptionPane.showMessageDialog(null, "Menu admin desde interface");
			//	JOptionPane.showMessageDialog(null, "Stock \n " + ListaLimpieza.getInstance("Tropitango"));
			//}

		
	
		
		
		
	
	
//>>>>>>> Stashed changes
}
