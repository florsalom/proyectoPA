package DLL;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import BLL.Cliente;

public class ControllerCliente {
	private static Connection con = Conexion.getInstance().getConnection();
	public static void agregarCliente(Cliente cliente) {
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("INSERT INTO `cliente`(`nombre`, `apellido`, `dni`, `cantidad`, `celular`, `fecha_entrada`) VALUES (?,?,?,?,?,?)");
			statement.setString(1, cliente.getNombre());
			statement.setString(2, cliente.getApellido());
			statement.setInt(3, cliente.getDni());
			statement.setInt(4, cliente.getCantidad());
			statement.setInt(5, cliente.getCelular());
			statement.setDate(6, Date.valueOf(cliente.getFecha_entrada()));
			int filas = statement.executeUpdate();
			if(filas>0) {
				JOptionPane.showMessageDialog(null, "Se agregó");
			}

			
		} catch (Exception e) {
System.out.println("No se agregó");		}
		
		
	}
	public static LinkedList<Cliente> MostrarClientes() {
		 LinkedList<Cliente> cliente = new  LinkedList<Cliente>();
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("SELECT * FROM `cliente`");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				 
				cliente.add(new Cliente(resultSet.getInt("id"),resultSet.getString("nombre"), resultSet.getString("apellido"),resultSet.getInt("dni"),resultSet.getInt("cantidad"),resultSet.getInt("celular"),resultSet.getDate("fecha_entrada").toLocalDate(),resultSet.getDate("fecha_salida").toLocalDate()));
			}
			
		} catch (Exception e) {
System.out.println("No se agregó");		}
		
		
		return cliente;
	}
	public static Cliente BuscarCliente(int id) {
		Cliente nuevo = null;
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("SELECT * FROM `cliente` WHERE id= ? ");
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				nuevo = new Cliente(resultSet.getInt("id"),resultSet.getString("nombre"), resultSet.getString("apellido"),resultSet.getInt("dni"),resultSet.getInt("cantidad"),resultSet.getInt("celular"),resultSet.getDate("fecha_entrada").toLocalDate(),   resultSet.getDate("fecha_salida").toLocalDate());
			}
		
		} catch (Exception e) {
			System.out.println("No se agregó");		
		}
		
		
		return nuevo;
	}
	public static void EliminarCliente(int id) {
		Cliente nuevo = null;
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("DELETE FROM `cliente` WHERE id= ? ");
			statement.setInt(1, id);
			int fila = statement.executeUpdate();
			if (fila>0) {
				JOptionPane.showMessageDialog(null, "Se borró");
			}
		
		} catch (Exception e) {
			System.out.println("No se borró");		
		}
		
		
	}
	public static void ActualizarEmpleado(Cliente cliente) {
		
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("UPDATE `cliente` SET `nombre`=?,`apellido`=?,`dni`=?,`cantidad`=?,`celular`=?,`fecha_entrada`=?,`fecha_salida`=? WHERE `id`=?");
			statement.setString(1, cliente.getNombre());
			statement.setString(2, cliente.getApellido());
			statement.setInt(3, cliente.getDni());
			statement.setInt(4, cliente.getCantidad());
			statement.setInt(5, cliente.getCelular());
			statement.setDate(6, Date.valueOf(cliente.getFecha_entrada()));
			statement.setDate(7, Date.valueOf(cliente.getFecha_salida()));

			statement.setInt(8, cliente.getId());

			int fila = statement.executeUpdate();
			if (fila>0) {
				JOptionPane.showMessageDialog(null, "Se actualizó");
			}
		
		} catch (Exception e) {
			System.out.println("No se borró");		
		}
		
		
	}
}
