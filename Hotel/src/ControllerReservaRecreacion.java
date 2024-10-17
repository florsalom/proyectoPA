import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ControllerReservaRecreacion {
	private static Connection con = Conexion.getInstance().getConnection();
	public static void agregarReservaRecreacion(ReservaRecreacion reservarecreacion) {
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("INSERT INTO `reserva_recreacion`(`id_cliente_fk`, `id_recreacion_fk`, `inicio`, `fin`) VALUES (?,?,?,?)");
			statement.setInt(1, reservarecreacion.getId_cliente_fk());
			statement.setInt(2, reservarecreacion.getId_recreacion_fk());
			statement.setTimestamp(3, Timestamp.valueOf(reservarecreacion.getInicio()));
			statement.setTimestamp(4, Timestamp.valueOf(reservarecreacion.getFin()));
			int filas = statement.executeUpdate();
			if(filas>0) {
				JOptionPane.showMessageDialog(null, "Se agregó");
			}
			
			
		} catch (Exception e) {
System.out.println("No se agregó");		}
		
		
	}
	public static LinkedList<ReservaRecreacion> MostrarReservaRecreacion() {
		 LinkedList<ReservaRecreacion> reservarecreacion = new  LinkedList<ReservaRecreacion>();
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("SELECT * FROM `reserva_recreacion`");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				
				reservarecreacion.add(new ReservaRecreacion(resultSet.getInt("id"),resultSet.getInt("id_cliente_fk"), resultSet.getInt("id_recreacion_fk"),
						resultSet.getTimestamp("inicio").toLocalDateTime(),resultSet.getTimestamp("fin").toLocalDateTime()));
			}
			
		} catch (Exception e) {
System.out.println("No se agregó");		}
		
		
		return reservarecreacion;
	}
	public static ReservaRecreacion BuscarReservaRecreacion(int id) {
		ReservaRecreacion nuevo = null;
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("SELECT * FROM `reserva_recreacion` WHERE id= ? ");
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				nuevo = new ReservaRecreacion(resultSet.getInt("id"),resultSet.getInt("id_cliente_fk"), resultSet.getInt("id_recreacion_fk"),
						resultSet.getTimestamp("inicio").toLocalDateTime(),resultSet.getTimestamp("fin").toLocalDateTime());
			}
		
		} catch (Exception e) {
			System.out.println("No se agregó");		
		}
		
		
		return nuevo;
	}
	public static void EliminarReservaRecreacion(int id) {
		ReservaRecreacion nuevo = null;
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("DELETE FROM `reserva_recreacion` WHERE id= ? ");
			statement.setInt(1, id);
			int fila = statement.executeUpdate();
			if (fila>0) {
				JOptionPane.showMessageDialog(null, "Se borró");
			}
		
		} catch (Exception e) {
			System.out.println("No se borró");		
		}
		
		
	}
	public static void ActualizarReservaRecreacion(ReservaRecreacion reservarecreacion) {
		
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("UPDATE `reserva_recreacion` SET `id_cliente_fk`=?,`id_recreacion_fk`=?,`inicio`=?,`fin`=? WHERE `id`=?");
			statement.setInt(1, reservarecreacion.getId_cliente_fk());
			statement.setInt(2, reservarecreacion.getId_recreacion_fk());
			statement.setTimestamp(3, Timestamp.valueOf(reservarecreacion.getInicio()));
			statement.setTimestamp(4, Timestamp.valueOf(reservarecreacion.getFin()));
			int filas = statement.executeUpdate();
			if(filas>0) {
				JOptionPane.showMessageDialog(null, "Se actualizó");
			}
		
		} catch (Exception e) {
			System.out.println("No se borró");		
		}
		
		
	}
}
