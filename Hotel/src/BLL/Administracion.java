package BLL;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import DLL.ControllerCliente;
import DLL.ControllerHabitacion;
import DLL.ControllerHabitaciones;
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
		String [] opciones = {"Check-In","Check-out","Reservar Actividades","Buscar Cliente","Ver habitación","Ver reservas de habitacion","Ver reservas de recreacion","Salir"};
		
		do {
			menu=JOptionPane.showOptionDialog(null, "Que desea realizar hoy", null, 0, 0, null, opciones, opciones[0]);
			switch (menu) {
			case 0:
				checkIn();
				break;

			case 1:
				checkOut(buscar_Cliente());
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
		
		case 5:
			ver_Habitacion();
			break;
		
		case 6:
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
			flag=true;
			dni=validarNumero("Ingrese dni");
			if (dni==0 || dni<1000000 || dni<0) {
				JOptionPane.showMessageDialog(null, "El número de dni no es valido");
				flag=false;
			} 
		} while (flag==false);
		do {
			flag=true;
			cantidad=validarNumero("Ingrese cantidad");
			if (cantidad==0 || cantidad>8 || cantidad<0) {
				JOptionPane.showMessageDialog(null, "La cantidad no es valida");
				flag=false;
			} 
		} while (flag==false);
		do {
			flag=true;
			celular=validarNumero("ingrese celular");
			if (celular==0 || celular<1100000000 || celular<0) {
				JOptionPane.showMessageDialog(null, "El celular no es valido");
				flag=false;
			} 
		} while (flag==false);
		
	
		
	

		
	
		LinkedList<Cliente> clientes =ControllerCliente.MostrarClientes2();
		for (Cliente cliente : clientes) {
			if (dni==cliente.getDni()) {
				flag=true;
				JOptionPane.showMessageDialog(null, "Ya existe un cliente con este dni: "+dni);
				flag=false;
				break;
			}
		}
			if (flag==true) {
				ControllerCliente.agregarCliente(new Cliente(0,nombre,apellido,dni,cantidad,celular,fecha_entrada));
				
			}
			// asignacion de habitacion
			
			LinkedList<Habitacion> habitaciones= ControllerHabitacion.MostrarHabitacion();
			String [] opciones = new String[habitaciones.size()];
			Habitacion elegida=null;
			int i=0;
			int id=0;
			for (Habitacion habitacion : habitaciones) {
				if (habitacion.getCant_huespedes()>=cantidad && habitacion.getEstado_limpieza()==1) {
					opciones[i] ="Id: "+habitacion.getId()+" Tipo: "+habitacion.getTipo_habitacion_fk()+" Cantidad disponible: "+habitacion.getCant_huespedes();
					i++;
				}
			}		
			
			String habitacion_seleccionada=(String)JOptionPane.showInputDialog(null, "Seleccione una habitacion","Seleccione una Habitacion", 0, null, opciones, opciones[0]);
			try {
				String[] habitacion_espacio=habitacion_seleccionada.split(" ");
				id =Integer.parseInt(habitacion_espacio[1]);
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error");
			}
			for (Habitacion habitacion : habitaciones) {
				if (habitacion.getId()==id) {
					elegida=habitacion;
					break;
				}
			}

			LinkedList<Cliente> clientes2 =ControllerCliente.MostrarClientes2();
			Cliente reservando=null;
			for (Cliente cliente : clientes2) {
				if (dni==cliente.getDni()) {
					reservando=cliente;
					break;
				}
			}
			if (reservando!=null&&elegida!=null) {
				ControllerReservaHabitaciones.agregarReservaHabitacion(new ReservaHabitaciones(reservando.getId(),elegida.getId(),reservando.getFecha_entrada()));
				JOptionPane.showMessageDialog(null, "Habitación asignada correctamente");
				elegida.setCant_huespedes(elegida.getCant_huespedes()-1);
				ControllerHabitacion.ActualizarHabitacion(elegida);
			} 
			
			
			
			
			
			
			
		
	}
	public void checkOut(Cliente cliente) {
		
	LinkedList<ReservaHabitaciones> reservas=	ControllerReservaHabitaciones.MostrarReservaHabitaciones();
	LinkedList<Habitacion> habitaciones = ControllerHabitacion.MostrarHabitacion();
		for (ReservaHabitaciones reservaHabitaciones : reservas) {
			if (cliente.getId()==reservaHabitaciones.getId_cliente_fk()) {
			 int id_habitacion=	reservaHabitaciones.getId_habitacion_fk();
			 	for (Habitacion habitacion : habitaciones) {
					if (habitacion.getId()==id_habitacion) {
						habitacion.setEstado_limpieza(0);
						habitacion.setCant_huespedes(habitacion.getCant_huespedes()+1);
						ControllerHabitacion.ActualizarHabitacion(habitacion);
						break;
					}
				}
			 	break;
			}
		}
		
		
		Factura factura= generar_factura();
		
		
		
	}
	public Factura generar_factura() {
		Factura factura=null;
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

	public Cliente buscar_Cliente(){
		Cliente cliente=null;
		JOptionPane.showMessageDialog(null, "Buscar Cliente");
		return cliente;
	}
	
	
	
	
	
	
}
