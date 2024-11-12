package DLL;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import BLL.Empleado;

public class ControllerEmpleados {
	private static Connection con = Conexion.getInstance().getConnection();
	public static void agregarEmpleado(Empleado empleado) {
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("INSERT INTO `empleados`(`cargo_fk`, `nombre`, `apellido`, `dni`, `mail`, `contrasena`) VALUES (?,?,?,?,?,?)");
			statement.setInt(1, empleado.getCargo());
			statement.setString(2, empleado.getNombre());
			statement.setString(3, empleado.getApellido());
			statement.setInt(4, empleado.getDni());
			statement.setString(5, empleado.getMail());
			statement.setString(6, empleado.getContrasena());
			int filas = statement.executeUpdate();
			if(filas>0) {
				JOptionPane.showMessageDialog(null, "Se agregó");
			}

			
		} catch (Exception e) {
System.out.println("No se agregó");		}
		
		
	}
	public static LinkedList<Empleado> MostrarEmpleados() {
		 LinkedList<Empleado> empleados = new  LinkedList<Empleado>();
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("SELECT * FROM `empleados`");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				 
				empleados.add(new Empleado(resultSet.getInt("id"),resultSet.getInt("cargo_fk"), resultSet.getString("nombre"), resultSet.getString("apellido"),resultSet.getInt("dni"),resultSet.getString("mail"),resultSet.getString("contrasena")));
			}
			
		} catch (Exception e) {
System.out.println("No se agregó");		}
		
		
		return empleados;
	}
	public static Empleado BuscarEmpleado(int id) {
		Empleado nuevo = null;
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("SELECT * FROM `empleados` WHERE id= ? ");
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				nuevo = new Empleado(resultSet.getInt("id"),resultSet.getInt("cargo_fk"), resultSet.getString("nombre"), resultSet.getString("apellido"),resultSet.getInt("dni"),resultSet.getString("mail"),resultSet.getString("contrasena"));
			}
		
		} catch (Exception e) {
			System.out.println("No se agregó");		
		}
		
		
		return nuevo;
	}
public static void EliminarEmpleado(int id) {
		Empleado nuevo = null;
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("DELETE FROM `empleados` WHERE id= ? ");
			statement.setInt(1, id);
			int fila = statement.executeUpdate();
			if (fila>0) {
				JOptionPane.showMessageDialog(null, "Se borró");
			}
		
		} catch (Exception e) {
			System.out.println("No se borró");		
		}
		
		
}
	public static void ActualizarEmpleado(Empleado empleado) {
		
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("UPDATE `empleados` SET `cargo_fk`=?,`nombre`=?,`apellido`=?,`dni`=?,`mail`=?,`contrasena`=? WHERE `id`=?");
			statement.setInt(1, empleado.getCargo());
			statement.setString(2, empleado.getNombre());
			statement.setString(3, empleado.getApellido());
			statement.setInt(4, empleado.getDni());
			statement.setString(5, empleado.getMail());
			statement.setString(6, empleado.getContrasena());

			statement.setInt(7, empleado.getId());

			int fila = statement.executeUpdate();
			if (fila>0) {
				JOptionPane.showMessageDialog(null, "Se actualizó");
			}
		} catch (Exception e) {
			System.out.println("No se actualizó");		
		}


	}
}
