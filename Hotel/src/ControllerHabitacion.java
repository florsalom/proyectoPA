import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.util.LinkedList;

import javax.swing.JOptionPane;
import com.mysql.jdbc.PreparedStatement;

	public class ControllerHabitacion {
	private static Connection con = Conexion.getInstance().getConnection();
	public static void agregarHabitacion(Habitacion habitacion) {
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("INSERT INTO `habitacion`(`tipo_habitacion_fk`, `cant_huespedes`, `estado_limpieza`) VALUES (?,?,?)");
			statement.setInt(1, habitacion.getTipo_habitacion_fk());
			statement.setInt(2, habitacion.getCant_huespedes());
			statement.setInt(3, habitacion.getEstado_limpieza());
			int filas = statement.executeUpdate();
			if(filas>0) {
				JOptionPane.showMessageDialog(null, "Se agregó");
			}

			
		} catch (Exception e) {
System.out.println("No se agregó");		}
		
		
	}
	public static LinkedList<Habitacion> MostrarHabitacion() {
		 LinkedList<Habitacion> habitacion = new  LinkedList<Habitacion>();
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("SELECT * FROM `habitacion`");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				 
				habitacion.add(new Habitacion(resultSet.getInt("id"),resultSet.getInt("tipo_habitacion_fk"),resultSet.getInt("cant_huespedes"), resultSet.getInt("estado_limpieza")));
			}
			
		} catch (Exception e) {
System.out.println("No se agregó");		}
		
		
		return habitacion;
	}
	public static Habitacion BuscarHabitacion(int id) {
		Habitacion nuevo = null;
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("SELECT * FROM `habitacion` WHERE id= ? ");
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				nuevo = new Habitacion(resultSet.getInt("id"),resultSet.getInt("tipo_habitacion_fk"),resultSet.getInt("cant_huespedes"), resultSet.getInt("estado_limpieza"));
			}
		
		} catch (Exception e) {
			System.out.println("No se agregó");		
		}
		
		
		return nuevo;
	}
	public static void EliminarHabitacion(int id) {
		Habitacion nuevo = null;
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("DELETE FROM `habitacion` WHERE id= ? ");
			statement.setInt(1, id);
			int fila = statement.executeUpdate();
			if (fila>0) {
				JOptionPane.showMessageDialog(null, "Se borró");
			}
		
		} catch (Exception e) {
			System.out.println("No se borró");		
		}
		
		
	}
	public static void ActualizarHabitacion(Habitacion habitacion) {
		
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("UPDATE `habitacion` SET `tipo_habitacion_fk`=?,`cant_huespedes`=?,`estado_limpieza`=? WHERE `id`=?");
			statement.setInt(1, habitacion.getTipo_habitacion_fk());
			statement.setInt(2, habitacion.getCant_huespedes());
			statement.setInt(3, habitacion.getEstado_limpieza());
	
			int filas = statement.executeUpdate();
			if(filas>0) {
				JOptionPane.showMessageDialog(null, "Se actualizó");
			}
		
		} catch (Exception e) {
			System.out.println("No se borró");		
		}
		
		
	}
}