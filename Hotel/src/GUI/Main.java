package GUI;
import javax.swing.JOptionPane;

import BLL.Administracion;
import BLL.Empleado;
import BLL.Hotel;
import BLL.Hotel_Singleton;
import BLL.JefeLimpieza;
import BLL.Limpieza;
import DLL.ControllerCliente;
import DLL.ControllerEmpleados;
import DLL.ControllerFactura;
import DLL.ControllerRecreacion;
import DLL.ControllerReservaHabitaciones;
import DLL.ControllerReservaRecreacion;

public class Main {

public static void main(String[] args) {

	Hotel hotel= Hotel_Singleton.getHotel();
	    hotel.setEmpleados(ControllerEmpleados.MostrarEmpleados());	
	    hotel.setClientes(ControllerCliente.MostrarClientes());
		hotel.setRecreaciones(ControllerRecreacion.MostrarRecreacion());
		hotel.setReservas_habitacion(ControllerReservaHabitaciones.MostrarReservaHabitaciones());
		hotel.setFacturas(ControllerFactura.MostrarFacturas());
		hotel.setReservas_recreacion(ControllerReservaRecreacion.MostrarReservaRecreacion());
		
	//listaEmpleados.getInstance();

	String[] opcionEmpleado = {"Iniciar sesión",
			//"Registrarse",
			"Salir"};
	int menu =0 ;
	do {
		
	menu= JOptionPane.showOptionDialog(null, "Que desea realizar hoy", null, 0, 0, null, opcionEmpleado, opcionEmpleado[0]);
	switch (menu) {
	case 0:
		String mail = JOptionPane.showInputDialog("Ingrese mail");
		String cont = JOptionPane.showInputDialog("Ingrese contraseña");
		
		Empleado encontrado = Empleado.login(mail, cont) ;
		
		if(encontrado!=null) {
			JOptionPane.showMessageDialog(null, encontrado);
			if (encontrado.getCargo()==1) {
				Administracion nuevo = new Administracion(encontrado.getId(),encontrado.getCargo(),encontrado.getNombre(),encontrado.getApellido(),encontrado.getDni(),encontrado.getMail(),encontrado.getContrasena());
				nuevo.menu();
			} else if (encontrado.getCargo()==2) {
				
				JefeLimpieza nuevo = new JefeLimpieza(encontrado.getId(),encontrado.getCargo(),encontrado.getNombre(),encontrado.getApellido(),encontrado.getDni(),encontrado.getMail(),encontrado.getContrasena());
				nuevo.menu();

				
			}else if (encontrado.getCargo()==3) {
				Limpieza nuevo = new Limpieza(encontrado.getId(),encontrado.getCargo(),encontrado.getNombre(),encontrado.getApellido(),encontrado.getDni(),encontrado.getMail(),encontrado.getContrasena());
				nuevo.menu();
			}
		}else {
			JOptionPane.showMessageDialog(null, "No existe");

		}
		break;
		//case 1: 
			//REgistrarse 
			 //mail = JOptionPane.showInputDialog("Ingrese mail");
			// cont = JOptionPane.showInputDialog("Ingrese contraseña");
			
			//ListaEmpleados.getInstance().add(new Empleado());
			//break;
		case 1: 
			JOptionPane.showMessageDialog(null, "Salir");
			break;
	}
	

	

	
	} while (menu!=1);

}}
