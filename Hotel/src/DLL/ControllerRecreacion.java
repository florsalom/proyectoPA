package DLL;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import BLL.Recreacion;

public class ControllerRecreacion {
	private static Connection con = Conexion.getInstance().getConnection();
	public static void agregarRecreacion(Recreacion recreacion) {
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("INSERT INTO `recreacion`(`costoXhora`,`tipo`, `capacidad`) VALUES (?,?,?)");
			statement.setInt(1, recreacion.getCostoXhora());
			statement.setString(2, recreacion.getTipo());
			statement.setInt(3, recreacion.getCapacidad());
			int filas = statement.executeUpdate();
			if(filas>0) {
				System.out.println("Se agregó");
			}

			
		} catch (Exception e) {
System.out.println("No se agregó");		}
		
		
	}
	public static LinkedList<Recreacion> MostrarRecreacion() {
		 LinkedList<Recreacion> recreacion = new  LinkedList<Recreacion>();
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("SELECT * FROM `recreacion`");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				 
				recreacion.add(new Recreacion(resultSet.getInt("id"),resultSet.getInt("costoXhora"),resultSet.getString("tipo"),resultSet.getInt("cantidad")));
			}
			
		} catch (Exception e) {
System.out.println("No se agregó");		}
		
		
		return recreacion;
	}
	public static Recreacion BuscarRecreacion(int id) {
		Recreacion nuevo = null;
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("SELECT * FROM `recreacion` WHERE id= ? ");
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				nuevo = new Recreacion(resultSet.getInt("id"),resultSet.getInt("costoXhora"),resultSet.getString("tipo"),resultSet.getInt("cantidad"));
			}
		
		} catch (Exception e) {
			System.out.println("No se agregó");		
		}
		
		
		return nuevo;
	}
	public static void EliminarRecreacion(int id) {
		Recreacion nuevo = null;
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("DELETE FROM `recreacion` WHERE id= ? ");
			statement.setInt(1, id);
			int fila = statement.executeUpdate();
			if (fila>0) {
				System.out.println("Se borró");
			}
		
		} catch (Exception e) {
			System.out.println("No se borró");		
		}
		
		
	}
	public static void ActualizarRecreacion(Recreacion recreacion) {
		
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("UPDATE `recreacion` SET `costoXhora`=?, `tipo`=?,`capacidad`=? WHERE `id`=?");
			statement.setInt(1, recreacion.getCostoXhora());
			statement.setString(2, recreacion.getTipo());
			statement.setInt(3, recreacion.getCapacidad());

			statement.setInt(4, recreacion.getId());

			int fila = statement.executeUpdate();
			if (fila>0) {
				System.out.println("Se actualizó");
			}
		
		} catch (Exception e) {
			System.out.println("No se actualizó");		
		}
		
		
	}
}