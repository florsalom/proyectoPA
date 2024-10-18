import java.sql.Date;
import java.sql.ResultSet;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ControllerReservaHabitaciones {
	private static Connection con = Conexion.getInstance().getConnection();
	public static void agregarReservaHabitacion(ReservaHabitaciones reservahabitaciones) {
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("INSERT INTO `reserva_habitaciones`(`id_cliente_fk`, `id_habitacion_fk`, `fecha_entrada`, `fecha_salida`) VALUES (?,?,?,?)");
			statement.setInt(1, reservahabitaciones.getId_cliente_fk());
			statement.setInt(2, reservahabitaciones.getId_habitacion_fk());
			statement.setDate(3, Date.valueOf(reservahabitaciones.getFecha_entrada()));
			statement.setDate(4, Date.valueOf(reservahabitaciones.getFecha_salida()));
			int filas = statement.executeUpdate();
			if(filas>0) {
				JOptionPane.showMessageDialog(null, "Se agregó");
			}

			
		} catch (Exception e) {
System.out.println("No se agregó");		}
		
		
	}
	public static LinkedList<ReservaHabitaciones> MostrarReservaHabitaciones() {
		 LinkedList<ReservaHabitaciones> reservahabitaciones = new  LinkedList<ReservaHabitaciones>();
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("SELECT * FROM `reserva_habitaciones`");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				 
				reservahabitaciones.add(new ReservaHabitaciones(resultSet.getInt("id"),resultSet.getInt("id_cliente_fk"),resultSet.getInt("id_habitacion_fk"),resultSet.getDate("fecha_entrada").toLocalDate(),resultSet.getDate("fecha_salida").toLocalDate()));
			}
			
		} catch (Exception e) {
System.out.println("No se agregó");		}
		
		
		return reservahabitaciones;
	}
	public static ReservaHabitaciones BuscarReservaHabitaciones(int id) {
		ReservaHabitaciones nuevo = null;
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("SELECT * FROM `reserva_habitaciones` WHERE id= ? ");
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				nuevo = new ReservaHabitaciones(resultSet.getInt("id"),resultSet.getInt("id_cliente_fk"),resultSet.getInt("id_habitacion_fk"),resultSet.getDate("fecha_entrada").toLocalDate(),resultSet.getDate("fecha_salida").toLocalDate());
			}
		
		} catch (Exception e) {
			System.out.println("No se agregó");		
		}
		
		
		return nuevo;
	}
	public static void EliminarReservaHabitaciones(int id) {
		ReservaHabitaciones nuevo = null;
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("DELETE FROM `reserva_habitaciones` WHERE id= ? ");
			statement.setInt(1, id);
			int fila = statement.executeUpdate();
			if (fila>0) {
				JOptionPane.showMessageDialog(null, "Se borró");
			}
		
		} catch (Exception e) {
			System.out.println("No se borró");		
		}
		
		
	}
	public static void ActualizarReservaHabitaciones(ReservaHabitaciones reservahabitaciones) {
		
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("UPDATE `reserva_habitacion` SET `id_cliente_fk`=?,`id_habitacion_fk`=?,`fecha_entrada`=?,`fecha_salida`=? WHERE `id`=?");
			statement.setInt(1, reservahabitaciones.getId_cliente_fk());
			statement.setInt(2, reservahabitaciones.getId_habitacion_fk());
			statement.setDate(3, Date.valueOf(reservahabitaciones.getFecha_entrada()));
			statement.setDate(4, Date.valueOf(reservahabitaciones.getFecha_salida()));
			int filas = statement.executeUpdate();
			if(filas>0) {
				JOptionPane.showMessageDialog(null, "Se actualizó");
			}
		
		} catch (Exception e) {
			System.out.println("No se borró");		
		}
		
		
	}
}
