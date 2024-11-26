package GUI;
import java.time.LocalDate;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import BLL.Administracion;
import BLL.Empleado;
import BLL.Hotel;
import BLL.Hotel_Singleton;
import BLL.JefeLimpieza;
import BLL.Limpieza;
import BLL.Recreacion;
import BLL.ReservaHabitaciones;
import BLL.ReservaRecreacion;
import DLL.ControllerCliente;
import DLL.ControllerEmpleados;
import DLL.ControllerFactura;
import DLL.ControllerRecreacion;
import DLL.ControllerReservaHabitaciones;
import DLL.ControllerReservaRecreacion;

public class Main {

public static void main(String[] args) {
	
	 LinkedList<Recreacion> recreaciones= ControllerRecreacion.MostrarRecreacion();
	    JOptionPane.showMessageDialog(null, recreaciones);
	
	Hotel hotel= Hotel_Singleton.getHotel();
	hotel.getEmpleados().add(new Empleado(0,1,"","",0,"a@a","1234"));
	hotel.getEmpleados().add(new Empleado(0,2,"","",0,"b@b","1234"));
	hotel.getEmpleados().add(new Empleado(0,3,"","",0,"c@c","1234"));
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
		
	menu= JOptionPane.showOptionDialog(null, "¿Qué desea realizar hoy?", null, 0, 0, null, opcionEmpleado, opcionEmpleado[0]);
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
