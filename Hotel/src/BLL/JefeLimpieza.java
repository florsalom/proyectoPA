package BLL;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import DLL.ControllerEmpleados;
import DLL.ControllerHabitacion;

public class JefeLimpieza extends Empleado {

//<<<<<<< Updated upstream
//public class JefeLimpieza {

//=======
	public JefeLimpieza(int id, int cargo, String nombre, String apellido, int dni, String mail,
			String contrasena) {
		super(id, cargo, nombre, apellido, dni, mail, contrasena);
	}
//	@Override
//	public void menu() {
//		int menu=5;
//		String [] opciones = {"Asignar Trabajo","Ver habitación","Salir"};
//		do {
//			menu=JOptionPane.showOptionDialog(null, "Que desea realizar hoy", null, 0, 0, null, opciones, opciones[0]);
//			switch (menu) {
//			case 0:
//				asignar_Trabajo();
//				break;
//			case 1:
//				ver_Habitacion();
//				break;
//
//		}
//		} while (menu!=2);
//	}
	 public void asignar_Trabajo() {

		 	int t = 0;
		 	
		    LinkedList<Habitacion> habitaciones = ControllerHabitacion.MostrarHabitacion();

		    String[] opciones = new String[habitaciones.size()];

		    Habitacion elegida = null;

		    int i = 0;

		    int id = 0;



		    boolean trabajoD = false;



		    for (Habitacion habitacion : habitaciones) {

		        if (habitacion.getEstado_limpieza() == 0) {

		            opciones[i] = "Id: " + habitacion.getId() + " Tipo: " + habitacion.getTipo_habitacion_fk() + " Cantidad de huspedes: " + habitacion.getCant_huespedes();

		            i++;

		            trabajoD = true;

		        }

		    }



		    if (!trabajoD) {

		        JOptionPane.showMessageDialog(null, "No hay trabajo disponible para asignar");

		        return; 

		    }



		    String habitacion_seleccionada = (String) JOptionPane.showInputDialog(null, "Seleccione una habitación", "Seleccione una Habitación", 0, null, opciones, opciones[0]);

		    

		    try {

		        String[] habitacion_espacio = habitacion_seleccionada.split(" ");

		        id = Integer.parseInt(habitacion_espacio[1]);

		    } catch (Exception e) {

		        JOptionPane.showMessageDialog(null, "Error");

		    }



		    for (Habitacion habitacion : habitaciones) {

		        if (habitacion.getId() == id) {

		            elegida = habitacion;

		            JOptionPane.showMessageDialog(null, "Tipo: " + habitacion.getTipo_habitacion_fk() + " Cantidad de huspedes: " + habitacion.getCant_huespedes());

		            break;

		        

		    }
		 
		    //seleccionar empleado
		    
			LinkedList<Empleado> empleados= ControllerEmpleados.MostrarEmpleados();

			String [] opciones2 = new String[empleados.size()];

			Empleado asignado=null;

			int n=0;

			int ide=0;

			for (Empleado empleado : empleados) {

				if (empleado.getCargo()==1) {				

					opciones2[n] ="Id: "+empleado.getId()+" cargo: "+empleado.getCargo()+" nombre: "+empleado.getNombre()+" apellido: "+empleado.getApellido();

					n++;

				}

			}				

			String empleado_seleccionado=(String)JOptionPane.showInputDialog(null, "Seleccionar empleado","Seleccionar empleado", 0, null, opciones2, opciones2[0]);

			try {

				String[] empleado_cargo=empleado_seleccionado.split(" ");

				ide =Integer.parseInt(empleado_cargo[1]);			

			} catch (Exception e) {

				JOptionPane.showMessageDialog(null, "Error");

			}

			for (Empleado empleado : empleados) {

				if (empleado.getId()==ide) {

					asignado=empleado;

					JOptionPane.showMessageDialog(null, " cargo: "+empleado.getCargo()+" nombre: "+empleado.getNombre()+" apellido: "+empleado.getApellido() +" asigando a limpiar la habitacion: "+habitacion.getTipo_habitacion_fk() + " Cantidad de huspedes: " + habitacion.getCant_huespedes());			
					t=1;
					break;

				}

			}	}
	 }
	 
	 
public void ver_Habitacion() {
	 LinkedList<Habitacion> habitaciones = ControllerHabitacion.MostrarHabitacion();

	    String[] opciones = new String[habitaciones.size()];

	    Habitacion elegida = null;

	    int i = 0;

	    int id = 0;



	    boolean trabajoD = false;



	    for (Habitacion habitacion : habitaciones) {

	        if (habitacion.getEstado_limpieza() == 0) {

	            opciones[i] = "Id: " + habitacion.getId() + " Tipo: " + habitacion.getTipo_habitacion_fk() + " Cantidad de huspedes: " + habitacion.getCant_huespedes();

	            i++;

	            trabajoD = true;

	        }

	    }



	    if (!trabajoD) {

	        JOptionPane.showMessageDialog(null, "No hay trabajo disponible");

	        return; 

	    }



	    String habitacion_seleccionada = (String) JOptionPane.showInputDialog(null, "Seleccione una habitación", "Seleccione una Habitación", 0, null, opciones, opciones[0]);

	    

	    try {

	        String[] habitacion_espacio = habitacion_seleccionada.split(" ");

	        id = Integer.parseInt(habitacion_espacio[1]);

	    } catch (Exception e) {

	        JOptionPane.showMessageDialog(null, "Error");

	    }



	    for (Habitacion habitacion : habitaciones) {

	        if (habitacion.getId() == id) {

	            elegida = habitacion;

	            JOptionPane.showMessageDialog(null, "Tipo: " + habitacion.getTipo_habitacion_fk() + " Cantidad de huspedes: " + habitacion.getCant_huespedes());

	            break;

	        }

	    }

	
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
