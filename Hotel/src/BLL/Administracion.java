package BLL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.LinkedList;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import DLL.ControllerCliente;
import DLL.ControllerFactura;
import DLL.ControllerHabitacion;
import DLL.ControllerHabitaciones;
import DLL.ControllerRecreacion;
import DLL.ControllerReservaHabitaciones;
import DLL.ControllerReservaRecreacion;
import repository.Validaciones;

public class Administracion extends Empleado implements Validaciones{
	public Administracion(int id, int cargo, String nombre, String apellido, int dni, String mail,
			String contrasena) {
		super(id, cargo, nombre, apellido, dni, mail, contrasena);
		
	}
	//@Override
//	public void menu() {
//		int menu=6;
//		String [] opciones = {"Check-In","Check-out","Reservar Actividades","Buscar Cliente","Ver habitación","Ver reservas de habitacion","Ver reservas de recreacion","Ver facturas","Salir"};
//		
//		do {
//			menu=JOptionPane.showOptionDialog(null, "¿Qué desea realizar hoy?", null, 0, 0, null, opciones, opciones[0]);
//			switch (menu) {
//			case 0:
//				checkIn();
//				break;
//
//			case 1:
//				checkOut(buscar_Cliente());
//				break;
//			
//		case 2:
//			reservar_Actividades();
//			break;
//		case 3:
//			buscar_Cliente();
//			break;
//		case 4:
//			ver_Habitacion();
//			break;
//		
//		case 5:
//			ver_Reserva_Habitacion();
//			break;
//		
//		case 6:
//			ver_Reserva_Recreacion();
//			break;
//		case 7:
//			ver_Factura();
//			break;
//		}
//		} while (menu!=8);
//		
//	}
	public void ver_Factura() {
		
		LinkedList<Factura> reservas=ControllerFactura.MostrarFacturas();
	    if (reservas.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "No hay facturas para mostrar.");
	        return;
	    }
		String lista="";
		for (int i = 0; i < reservas.size(); i++) {
			lista=lista+"\n"+reservas.get(i);
		}
		JOptionPane.showMessageDialog(null, lista);}
		

		
	
	public void ver_Reserva_Recreacion() {
		LinkedList<ReservaRecreacion> reservas=ControllerReservaRecreacion.MostrarReservaRecreacion();
		String lista="";
		for (int i = 0; i < reservas.size(); i++) {
			lista=lista+"\n"+reservas.get(i);
			//ver_Reserva_Recreacion ventana = new ver_Reserva_Recreacion(this); esta loco como que si quiero agregar esta clase, ya existe esta clase
		}
		JOptionPane.showMessageDialog(null, lista);
		
	}
	public void ver_Reserva_Habitacion() {
		LinkedList<ReservaHabitaciones> reservas=ControllerReservaHabitaciones.MostrarReservaHabitaciones();
		String lista="";
		for (int i = 0; i < reservas.size(); i++) {
			lista=lista+"\n"+reservas.get(i);
		}
		JOptionPane.showMessageDialog(null, lista);
	}
	public void ver_Habitacion() {
		LinkedList<Habitacion> habitaciones= ControllerHabitacion.MostrarHabitacion();

		String [] opciones = new String[habitaciones.size()];

		Habitacion elegida=null;

		int i=0;

		int id=0;

		for (Habitacion habitacion : habitaciones) {
			
			//1=limpia
			
			if (habitacion.getEstado_limpieza()==1) {

				opciones[i] ="Id: "+habitacion.getId()+" Tipo: "+habitacion.getTipo_habitacion_fk()+" Cantidad de huspedes: "+habitacion.getCant_huespedes();

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

				JOptionPane.showMessageDialog(null, " Tipo: " + habitacion.getTipo_habitacion_fk()+" Cantidad de huspedes: " + habitacion.getCant_huespedes());			

				break;

			}
		}	
	}
	public String checkIn(String nombre, String apellido, String dni, String cantidad, String celular) {
		// creacion del cliente
		boolean flag=true;
		
		LocalDate fecha_entrada= LocalDate.now();
		
		if (nombre.isEmpty() ||  apellido.isEmpty() || dni.isEmpty() || cantidad.isEmpty() || celular.isEmpty()) {
			
			return "No pueden estar vacios";
		}
		
		try {
			if (Integer.parseInt(dni)==0 || Integer.parseInt(dni)<10000000 || Integer.parseInt(dni)<0) {
				return "El número de dni no es valido";
			}
		} catch (Exception e) {
			return "El DNI debe ser un número";
		}
	
		try {
			if (Integer.parseInt(cantidad)==0 || Integer.parseInt(cantidad)>8 || Integer.parseInt(cantidad)<0) {
				return "La cantidad de huespedes dno es valida";
			}
		} catch (Exception e) {
			return "La cantidad de huespedes debe ser un número";
		}
		try {
			if (Integer.parseInt(celular)==0 || Integer.parseInt(celular)<1100000000 || Integer.parseInt(celular)<0) {
				return "El numero de celular no es valido";
			}
		} catch (Exception e) {
			return "El número de celular debe ser un número";
		}

	
		LinkedList<Cliente> clientes =ControllerCliente.MostrarClientes2();
		for (Cliente cliente : clientes) {
			if (Integer.parseInt(dni)==cliente.getDni()) {
				return "Ya existe un cliente con ese DNI";
			}
		}
			
				
		ControllerCliente.agregarCliente(new Cliente(0,nombre,apellido,Integer.parseInt(dni),Integer.parseInt(cantidad),Integer.parseInt(celular),fecha_entrada));
				
			
			
			
			
			// asignacion de habitacion
			
			LinkedList<Habitacion> habitaciones= ControllerHabitacion.MostrarHabitacion();
			String [] opciones = new String[habitaciones.size()];
			Habitacion elegida=null;
			int i=0;
			int id=0;
			for (Habitacion habitacion : habitaciones) {
				if (habitacion.getCant_huespedes()>=Integer.parseInt(cantidad) && habitacion.getEstado_limpieza()==1) {
					opciones[i] ="Id: "+habitacion.getId()+" Tipo: " + habitacion.getTipo_habitacion_fk() + " Cantidad disponible: "+habitacion.getCant_huespedes();
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
				if (Integer.parseInt(dni)==cliente.getDni()) {
					reservando=cliente;
					break;
				}
			}
			if (reservando!=null&&elegida!=null) {
				ControllerReservaHabitaciones.agregarReservaHabitacion(new ReservaHabitaciones(reservando.getId(),elegida.getId(),reservando.getFecha_entrada()));
				JOptionPane.showMessageDialog(null, "Habitación asignada correctamente");
				elegida.setCant_huespedes(elegida.getCant_huespedes()-1);
				ControllerHabitacion.ActualizarHabitacion(elegida);
				return "Reserva creada correctamente";
			} 		
			return "Hubo un error";
	}
	public void checkOut(Cliente cliente) {

	    LocalDate fecha_salida = LocalDate.now();
	    cliente.setFecha_salida(fecha_salida);
	    ControllerCliente.ActualizarCliente(cliente);

	    LinkedList<ReservaHabitaciones> reservas = ControllerReservaHabitaciones.MostrarReservaHabitaciones();
	    LinkedList<Habitacion> habitaciones = ControllerHabitacion.MostrarHabitacion();

	    for (ReservaHabitaciones reservaHabitaciones : reservas) {
	        if (cliente.getId() == reservaHabitaciones.getId_cliente_fk()) {
	            reservaHabitaciones.setFecha_salida(fecha_salida);
	            ControllerReservaHabitaciones.ActualizarReservaHabitaciones(reservaHabitaciones);

	            int id_habitacion = reservaHabitaciones.getId_habitacion_fk();

	            for (Habitacion habitacion : habitaciones) {
	                if (habitacion.getId() == id_habitacion) {
	                    habitacion.setEstado_limpieza(0);
	                    habitacion.setCant_huespedes(habitacion.getCant_huespedes() + 1);
	                    ControllerHabitacion.ActualizarHabitacion(habitacion);
	                    break;
	                }
	            }
	            break;
	        }
	      
	    }
	}
	public String generar_factura(Cliente cliente) {
		
		
		LinkedList<ReservaHabitaciones> reservas = ControllerReservaHabitaciones.MostrarReservaHabitaciones();
		ReservaHabitaciones reservacliente = null;
		
		
		 LocalDate fecha_entrada = cliente.getFecha_entrada();
		 LocalDate fecha_salida = LocalDate.now();
		 for (ReservaHabitaciones reserva : reservas) {
		        if (reserva.getId_cliente_fk() == cliente.getId()) {
		            reservacliente = reserva;
		           break;
		        }
		    }

		 if (reservacliente == null) {
		        return "No se encontró la reserva";
		    }
		 
		

		    LinkedList<Habitacion> habitaciones = ControllerHabitacion.MostrarHabitacion();
		    Habitacion habitacionCliente = null;

		    for (Habitacion habitacion : habitaciones) {
		        if (habitacion.getId() == reservacliente.getId_habitacion_fk()) {
		            habitacionCliente = habitacion;
		            break;
		        }
		    }

		    if (habitacionCliente == null) {
		        return "No se encontró la habitación.";
		    }

		    int tipoHabitacion = habitacionCliente.getTipo_habitacion_fk();
		    
		    
		    LinkedList<Habitaciones> habitaciones2= ControllerHabitaciones.MostrarHabitaciones();
		    int habitacionCostoXDia = 0;
		    for (Habitaciones habitacion : habitaciones2) {
				if (habitacion.getId()==tipoHabitacion) {
					habitacionCostoXDia=habitacion.getCostoXdia();
					break;
				}
			}
		    
		    Period periodo = Period.between(fecha_entrada, fecha_salida);
		    int dias = periodo.getDays();
		    int costoXhabitacion = dias * habitacionCostoXDia;
		    
		    
		    
		    LinkedList<ReservaRecreacion> reservasRecreacion = ControllerReservaRecreacion.MostrarReservaRecreacion();
		    int costoXrecreacion=0;
		    int idRecreacion = 0;
		    int idReservaRecreacion = 0;
		    LocalDateTime fin = null;
		    LocalDateTime inicio = null;
		    int recreacionXhora = 0;
		    
		    for (ReservaRecreacion reservaRec : reservasRecreacion) {
		        if (reservaRec.getId_cliente_fk() == cliente.getId()) {
		        	idReservaRecreacion=reservaRec.getId();
		        	idRecreacion = reservaRec.getId_recreacion_fk();
		             inicio=reservaRec.getInicio();
		             fin=reservaRec.getFin();
		            break;
		        }}
		        
		        if (inicio != null && fin != null) {
		        	 LinkedList<Recreacion> recreaciones= ControllerRecreacion.MostrarRecreacion();
		 		    
		 		    for (Recreacion recreacion : recreaciones) {
		 				if (recreacion.getId()==idRecreacion) {
		 					recreacionXhora=recreacion.getCostoXhora();
		 					break;
		 				}
		 			}
		 		    
		        	
		        	long horas = Duration.between(inicio, fin).toHours();
		            JOptionPane.showMessageDialog(null, horas);
		            costoXrecreacion=(int) (horas*recreacionXhora);
		        
		    }
	
		   
		  
		    
		 
		   
		    
		    int costo_Final = costoXhabitacion + costoXrecreacion;
		    

		    
		  //  menu=JOptionPane.showOptionDialog(null, "¿Desea ingresar un descuento?", null, 0, 0, null, opciones, opciones[0]);
		    
		  //  if (menu==1) {
		   // 	int descuento = ingresar_descuento(costo_Final);
			    
			    
		//	    costo_Final = costo_Final - descuento;
			//}
		    

		    Factura factura = new Factura(
		        0, cliente.getId(), habitacionCliente.getId(), fecha_entrada, fecha_salida, idReservaRecreacion, costoXhabitacion, costoXrecreacion, costo_Final);

		    if (idReservaRecreacion!=0) {
		    	ControllerFactura.agregarFactura2(factura);
			} else {
				ControllerFactura.agregarFactura(factura);
			}
		    
		    
		    
		    
		    JOptionPane.showMessageDialog(null,  factura);

		
			return "Se genero la factura correctamente";

		   // return null;
	}
	public int ingresar_descuento(int costo){
		JOptionPane.showMessageDialog(null, "Ingresar Descuento");
		return costo;
	}

	public void reservar_Actividades(Cliente cliente, String inicio, String fin, int id){
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"); 
		LocalDateTime fechaOutput = LocalDateTime.parse(inicio, formatter);

		LocalDateTime fechaOutput2 = LocalDateTime.parse(fin, formatter);
		
		
		ReservaRecreacion nueva = new ReservaRecreacion(0,cliente.getId(),id,fechaOutput,fechaOutput2);
		
		ControllerReservaRecreacion.agregarReservaRecreacion(nueva);
		
		
		
		
		
	}

	public Cliente buscar_Cliente(){
		
		
		LinkedList<Cliente> clientes= ControllerCliente.MostrarClientes2();

		String [] opciones = new String[clientes.size()];

		Cliente cliente=null;


		int id=0;
		for (int i = 0; i < opciones.length; i++) {
			opciones[i]= clientes.get(i).getNombre();
		}
		String cliente_selec=(String)JOptionPane.showInputDialog(null, "Seleccione un Cliente","Seleccione un cliente", 0, null, opciones, opciones[0]);

		for (Cliente cliente2 : clientes) {

			if (cliente2.getNombre().equals(cliente_selec)) {

				cliente=cliente2;

				JOptionPane.showMessageDialog(null,cliente);			

				break;

			}

		}
		return cliente;
	}
	
	
	
	public String obtenerHabitacion(Cliente cliente) {
	    LinkedList<ReservaHabitaciones> reservas = ControllerReservaHabitaciones.MostrarReservaHabitaciones();
	    for (ReservaHabitaciones reserva : reservas) {
	        if (reserva.getId_cliente_fk() == cliente.getId()) {
           return "ID: " + reserva.getId_habitacion_fk();
        }
	    }
	    return "No asignada";
	}

	public String obtenerActividades(Cliente cliente) {
	    LinkedList<ReservaRecreacion> actividades = ControllerReservaRecreacion.MostrarReservaRecreacion();
	    for (ReservaRecreacion actividad : actividades) {
	        if (actividad.getId_cliente_fk() == cliente.getId()) {
	            return "Reservado, ID: " + actividad.getId_recreacion_fk();
	        }
	    }
	    return "No reservadas";
	}
	
	
}
