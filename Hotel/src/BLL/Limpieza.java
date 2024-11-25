package BLL;


import java.util.LinkedList;

import javax.swing.JOptionPane;

import DLL.ControllerHabitacion;

public class Limpieza extends Empleado{

	public Limpieza(int id, int cargo, String nombre, String apellido, int dni, String mail,
			String contrasena) {
		super(id, cargo, nombre, apellido, dni, mail, contrasena);
		
	}
//	@Override
//	public void menu() {
//		int menu=5;
//		String [] opciones = {"Ver Trabajo","Salir"};
//		do {
//			menu=JOptionPane.showOptionDialog(null, "Que desea realizar hoy", null, 0, 0, null, opciones, opciones[0]);
//			switch (menu) {
//			case 0:
//				ver_Trabajo();
//				break;
//				
//	
//		}
//		} while (menu!=1);
//	}
		public void ver_Trabajo(asignar_Trabajo()) {
			if(t==1){
				JOptionPane.showMessageDialog(null, " Hay trabajo asignado para nombre: "+
			empleado.getNombre()+" apellido: "+empleado.getApellido() +" asigando a limpiar la habitacion: "+
						habitacion.getTipo_habitacion_fk() );			
			}

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


	
}
