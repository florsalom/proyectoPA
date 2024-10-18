import java.sql.Date;
import java.sql.ResultSet;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ControllerCargos {
	private static Connection con = Conexion.getInstance().getConnection();
	public static void agregarCargo(Cargos cargo) {
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("INSERT INTO `cargos`(`cargo`) VALUES (?)");
			statement.setString(2, cargo.getCargo());
			int filas = statement.executeUpdate();
			if(filas>0) {
				JOptionPane.showMessageDialog(null, "Se agregó");
			}

			
		} catch (Exception e) {
System.out.println("No se agregó");		}
		
		
	}
	public static LinkedList<Cargos> MostrarCargos() {
		 LinkedList<Cargos> cargo = new  LinkedList<Cargos>();
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("SELECT * FROM `cargos`");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				 
				cargo.add(new Cargos(resultSet.getInt("id"),resultSet.getString("cargo")));
			}
			
		} catch (Exception e) {
System.out.println("No se agregó");		}
		
		
		return cargo;
	}
	public static Cargos BuscarCargos(int id) {
		Cargos nuevo = null;
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("SELECT * FROM `cargos` WHERE id= ? ");
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				nuevo = new Cargos(resultSet.getInt("id"),resultSet.getString("cargo"));
			}
		
		} catch (Exception e) {
			System.out.println("No se agregó");		
		}
		
		
		return nuevo;
	}
	public static void EliminarCargo(int id) {
		Cargos nuevo = null;
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("DELETE FROM `cargos` WHERE id= ? ");
			statement.setInt(1, id);
			int fila = statement.executeUpdate();
			if (fila>0) {
				JOptionPane.showMessageDialog(null, "Se borró");
			}
		
		} catch (Exception e) {
			System.out.println("No se borró");		
		}
		
		
	}
	public static void ActualizarCargos(Cargos cargo) {
		
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("UPDATE `cargos` SET `nombre`=?,`apellido`=?,`dni`=?,`cantidad`=?,`celular`=?,`fecha_entrada`=?,`fecha_salida`=? WHERE `id`=?");
			statement.setInt(1, cargo.getId());
			statement.setString(2, cargo.getCargo());

			int fila = statement.executeUpdate();
			if (fila>0) {
				JOptionPane.showMessageDialog(null, "Se actualizó");
			}
		
		} catch (Exception e) {
			System.out.println("No se borró");		
		}
		
		
	}
}