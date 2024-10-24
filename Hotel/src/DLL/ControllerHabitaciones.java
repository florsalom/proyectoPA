package DLL;
import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import BLL.Habitaciones;

public class ControllerHabitaciones {
	private static Connection con = Conexion.getInstance().getConnection();
	public static void agregarHabitaciones(Habitaciones habitaciones) {
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("INSERT INTO `habitaciones`(`costoXdia`, `tipo`) VALUES (?,?)");
			statement.setInt(1, habitaciones.getCostoXdia());
			statement.setString(2, habitaciones.getTipo());
			int filas = statement.executeUpdate();
			if(filas>0) {
				JOptionPane.showMessageDialog(null, "Se agregó");
			}
			
		} catch (Exception e) {
System.out.println("No se agregó");		}
		
		
	}
	public static LinkedList<Habitaciones> MostrarHabitaciones() {
		 LinkedList<Habitaciones> habitaciones = new  LinkedList<Habitaciones>();
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("SELECT * FROM `habitaciones`");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				 
				habitaciones.add(new Habitaciones(resultSet.getInt("id"),resultSet.getInt("costoXdia"), resultSet.getString("tipo")));
			}
			
		} catch (Exception e) {
System.out.println("No se agregó");		}
		
		
		return habitaciones;
	}
	public static Habitaciones BuscarHabitaciones(int id) {
		Habitaciones nuevo = null;
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("SELECT * FROM `habitaciones` WHERE id= ? ");
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				nuevo = new Habitaciones(resultSet.getInt("id"),resultSet.getInt("costoXdia"), resultSet.getString("tipo"));
			}
		
		} catch (Exception e) {
			System.out.println("No se agregó");		
		}
		
		
		return nuevo;
	}
	public static void EliminarHabitaciones(int id) {
		Habitaciones nuevo = null;
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("DELETE FROM `habitaciones` WHERE id= ? ");
			statement.setInt(1, id);
			int fila = statement.executeUpdate();
			if (fila>0) {
				JOptionPane.showMessageDialog(null, "Se borró");
			}
		
		} catch (Exception e) {
			System.out.println("No se borró");		
		}
		
		
	}
	public static void ActualizarHabitaciones(Habitaciones habitaciones) {
		
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("UPDATE `habitaciones` SET `costoXdia`=?,`tipo`=? WHERE `id`=?");
			statement.setInt(1, habitaciones.getCostoXdia());
			statement.setString(2, habitaciones.getTipo());
			int filas = statement.executeUpdate();
			if(filas>0) {

			statement.setInt(3, habitaciones.getId());
			}

			int fila = statement.executeUpdate();
			if (fila>0) {
				JOptionPane.showMessageDialog(null, "Se actualizó");
			}
		
		} catch (Exception e) {
			System.out.println("No se borró");		
		}}}
		
		