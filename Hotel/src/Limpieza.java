import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Limpieza extends Empleado{

	public Limpieza(int id, String cargo, String nombre, String apellido, String dni, String mail,
			String contrasena) {
		super(id, cargo, nombre, apellido, dni, mail, contrasena);
		
	}
	@Override
	public void menu() {
		int menu=5;
		String [] opciones = {"Asignar Trabajo","Salir"};
		do {
			menu=JOptionPane.showOptionDialog(null, "Que desea realizar hoy", null, 0, 0, null, opciones, opciones[0]);
			switch (menu) {
			case 0:
				asignar_Trabajo();
				break;

		}
		} while (menu!=1);
	}
	public void asignar_Trabajo() {
		JOptionPane.showMessageDialog(null, "Asignar Trabajo");
	}
}
