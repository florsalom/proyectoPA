import java.time.LocalDate;
import java.util.LinkedList;

public class listaEmpleados {
	private static 	LinkedList<Empleados> empleados;
	//Constructor
	private listaEmpleados() {
		
	}
	//
	public static LinkedList<Empleados> getInstance(){
		if (empleados==null) {
			empleados = new LinkedList<Empleados>();
			rellenarLista();
			
		} else {
			System.out.println("Ya existe");
		}
		
		return empleados;
	}
	public static void guardar(Empleados Empleados) {	
		empleado.add(empleado);

	}
	
	public static void rellenarLista() {
		empleados.add(1,"admin","Andres","ElTrabajador","231","a@a","a");
		empleados.add(2,"admin","Flor","Fala","231","a@a","a");
		empleados.add(3,"admin","Jenni","abandono","231","a@a","a");

	}
	
}
