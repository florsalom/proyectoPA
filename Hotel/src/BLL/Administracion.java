package BLL;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import DLL.ControllerCliente;
import DLL.ControllerHabitacion;
import DLL.ControllerReservaHabitaciones;
import repository.Validaciones;

public class Administracion extends Empleado implements Validaciones{
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
		// creacion del cliente
		boolean flag=true;
		String nombre, apellido;
		int dni=0, cantidad=0, celular=0;
		LocalDate fecha_entrada= LocalDate.now();
		
		nombre=validarString("Ingrese nombre");
	
		apellido=validarString("Ingrese apellido");
	
		do {
			dni=validarNumero("Ingrese dni");
			if (dni==0 || dni<1000000 || dni<0) {
				JOptionPane.showMessageDialog(null, "El número de dni no es valido");
				flag=false;
			} 
		} while (flag=false);
		do {
			cantidad=validarNumero("Ingrese cantidad");
			if (cantidad==0 || cantidad>8 || cantidad<0) {
				JOptionPane.showMessageDialog(null, "La cantidad no es valida");
				flag=false;
			} 
		} while (flag=false);
		do {
			celular=validarNumero("ingrese celular");
			if (celular==0 || celular<1100000000 || celular<0) {
				JOptionPane.showMessageDialog(null, "El celular no es valido");
				flag=false;
			} 
		} while (flag=false);
		
	
		
	

		
	
		LinkedList<Cliente> clientes =ControllerCliente.MostrarClientes();
		for (Cliente cliente : clientes) {
			if (dni==cliente.getDni()) {
				flag=true;
				JOptionPane.showMessageDialog(null, "Ya existe un cliente con este dni: "+dni);
				flag=false;
				break;
			}
		}
			if (flag=true) {
				ControllerCliente.agregarCliente(new Cliente(0,nombre,apellido,dni,cantidad,celular,fecha_entrada));
				
			}
			// asignacion de habitacion
			
			LinkedList<Habitacion> habitaciones= ControllerHabitacion.MostrarHabitacion();
			String [] opciones = new String[habitaciones.size()];
			Habitacion elegida=null;
			int i=0;
			int id=0;
			for (Habitacion habitacion : habitaciones) {
				if (habitacion.getCant_huespedes()<=cantidad && habitacion.getEstado_limpieza()==1) {
					opciones[i] ="Id: "+habitacion.getId()+" Tipo: "+habitacion.getTipo_habitacion_fk()+" Cantidad disponible: "+habitacion.getCant_huespedes();
					i++;
				}
			}
			
			String habitacion_seleccionada=(String)JOptionPane.showInputDialog(null, "","", 0, null, opciones, opciones[0]);
			try {
				String[] habitacion_espacio=habitacion_seleccionada.split(" ");
				id =Integer.parseInt(habitacion_espacio[1]);
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error");
			}
			for (Habitacion habitacion : habitaciones) {
				if (habitacion.getId()==id) {
					elegida=habitacion;
				}
			}
			Cliente reservando=null;
			for (Cliente cliente : clientes) {
				if (dni==cliente.getDni()) {
					reservando=cliente;
					break;
				}
			}
			ReservaHabitaciones reserva = new ReservaHabitaciones(reservando.getId(),elegida.getId(),reservando.getFecha_entrada());
			ControllerReservaHabitaciones.agregarReservaHabitacion(reserva);
			
			
			
			
			
			
		
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
