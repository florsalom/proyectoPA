import javax.swing.JOptionPane;

public class Main {

public static void main(String[] args) {
	
	Hotel hotel= Hotel_Singleton.getHotel();
	hotel.getEmpleados().add(new Empleado(0,"Administrador","","","","a@a","1234"));
	hotel.getEmpleados().add(new Empleado(0,"JefeLimpieza","","","","b@b","1234"));
	hotel.getEmpleados().add(new Empleado(0,"Limpieza","","","","c@c","1234"));
	
	
	
	//listaEmpleados.getInstance();

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
		
		Empleado encontrado = Empleado.Login(mail, cont) ;
		
		if(encontrado!=null) {
			JOptionPane.showMessageDialog(null, encontrado);
			if (encontrado.getCargo().equals("Administrador")) {
				Administracion nuevo = new Administracion(encontrado.getId(),encontrado.getCargo(),encontrado.getNombre(),encontrado.getApellido(),encontrado.getDni(),encontrado.getMail(),encontrado.getContrasena());
				nuevo.menu();
			} else if (encontrado.getCargo().equals("JefeLimpieza")) {
				
				JefeLimpieza nuevo = new JefeLimpieza(encontrado.getId(),encontrado.getCargo(),encontrado.getNombre(),encontrado.getApellido(),encontrado.getDni(),encontrado.getMail(),encontrado.getContrasena());
				nuevo.menu();

				
			}else if (encontrado.getCargo().equals("Limpieza")) {
				Limpieza nuevo = new Limpieza(encontrado.getId(),encontrado.getCargo(),encontrado.getNombre(),encontrado.getApellido(),encontrado.getDni(),encontrado.getMail(),encontrado.getContrasena());
				nuevo.menu();
			}
		}else {
			JOptionPane.showMessageDialog(null, "No existe");

		}
		break;
		case 1: 
			//REgistrarse 
			 mail = JOptionPane.showInputDialog("Ingrese mail");
			 cont = JOptionPane.showInputDialog("Ingrese contraseña");
			
			//ListaEmpleados.getInstance().add(new Empleado());
			break;
		case 2: 
			JOptionPane.showMessageDialog(null, "Salir");
			break;
	}
	

	

	
	} while (menu!=2);

}}
