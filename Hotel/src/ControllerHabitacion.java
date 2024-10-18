import java.sql.Date;
import java.sql.ResultSet;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ControllerHabitacion {
	private static Connection con = Conexion.getInstance().getConnection();



public static LinkedList<Habitacion> MostrarHabitacions() {
	 LinkedList<Habitacion> Habitacion = new  LinkedList<Habitacion>();
	try {
		
		PreparedStatement statement = (PreparedStatement) 
				con.prepareStatement("SELECT * FROM `Habitacion`");
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			 
			Habitacion.add(new Habitacion(resultSet.getInt("id"),resultSet.getInt("tipo_habitacion_fk"), resultSet.getInt("cant_husped"),
					resultSet.getInt("estado_limpieza")));
		}
		
	} catch (Exception e) {
System.out.println("No se agregó");		}
	
	
	return Habitacion;
}





}