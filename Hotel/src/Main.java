import javax.swing.JOptionPane;

public class Main {

public static void main(String[] args) {
	
	listaEmpleados.getInstance();

	String[] opcionEmpleado = {"Iniciar sesión",
			"Registrarse",
			"Salir"};
	int menu =0 ;
	do {
		
	menu= JOptionPane.showOptionDialog(null, "Que desea realizar hoy", null, 0, 0, null, opcionEmpleado, opcionEmpleado[0]);
	switch (menu) {
	case 0:
		String mail = JOptionPane.showInputDialog("Ingrese mail");
		String cont = JOptionPane.showInputDialog("Ingrese contraseña");
		
		Empleado econtrado = Empleado.Login( mail, cont) ;
		
		if(econtrado!=null) {
			JOptionPane.showMessageDialog(null, econtrado);
			if (econtrado.getRol().equals("admin")) {
				Admin nuevo = new Admin(econtrado.getMail(),econtrado.getContrasena(),econtrado.getRol());
				nuevo.menuPrincipal();
			} else if (econtrado.getRol().equals("encar")) {
				
				Encargado nuevo = new Encargado(econtrado.getMail(),econtrado.getContrasena(),econtrado.getRol());
				nuevo.menuPrincipal();

				
			}
			
		}else {
			JOptionPane.showMessageDialog(null, "No existe");

		}
		break;
	case 1: 
		//REgistrarse 
		 mail = JOptionPane.showInputDialog("Ingrese mail");
		 cont = JOptionPane.showInputDialog("Ingrese contraseña");
		
		ListaEmpleados.getInstance().add(new Empleado());
		break;
	case 2: 
		JOptionPane.showMessageDialog(null, "Salir");
		break;
	default:
		break;
	}
	

	

	
	} while (menu!=2);
	

	
	
	}
}
