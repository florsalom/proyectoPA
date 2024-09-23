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
		String [] opciones = {"Ver Trabajo","Salir"};
		do {
			menu=JOptionPane.showOptionDialog(null, "Que desea realizar hoy", null, 0, 0, null, opciones, opciones[0]);
			switch (menu) {
			case 0:
				ver_Trabajo();
				break;
	
		}
		} while (menu!=1);
	}
	public void ver_Trabajo() {
		JOptionPane.showMessageDialog(null, "Ver Trabajo");
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
