package DLL;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import BLL.Cliente;
import BLL.Factura;

public class ControllerFactura {
	private static Connection con = Conexion.getInstance().getConnection();
	public static void agregarFactura(Factura factura) {
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					
					con.prepareStatement ("INSERT INTO `factura`(`id_cliente_fk`, `id_habitacion_fk`, `fecha_entrada`, `fecha_salida`, `id_reserva_recreacion_fk`, `costoXhabitacion`, `costoXrecreacion`, `costo_Final`) VALUES (?,?,?,?,?,?,?,?)");
			statement.setInt(1, factura.getId_cliente_fk());
			statement.setInt(2, factura.getId_habitacion_fk());
			statement.setDate(3, Date.valueOf(factura.getFecha_entrada()));
			statement.setDate(4, Date.valueOf(factura.getFecha_salida()));
			statement.setInt(5, factura.getid_reserva_recreacion_fk());
			statement.setDouble(6, factura.getCostoXhabitacion());
			statement.setDouble(7, factura.getCostoXrecreacion());
			statement.setDouble(8, factura.getCosto_Final());
			System.out.println("Insertando factura con valores:");
			System.out.println("ID Cliente FK: " + factura.getId_cliente_fk());
			System.out.println("ID Habitación FK: " + factura.getId_habitacion_fk());
			System.out.println("Fecha Entrada: " + factura.getFecha_entrada());
			System.out.println("Fecha Salida: " + factura.getFecha_salida());
			System.out.println("ID Reserva Recreación FK: " + factura.getid_reserva_recreacion_fk());
			System.out.println("Costo por Habitación: " + factura.getCostoXhabitacion());
			System.out.println("Costo por Recreación: " + factura.getCostoXrecreacion());
			System.out.println("Costo Final: " + factura.getCosto_Final());
			int filas = statement.executeUpdate();
			if(filas>0) {
				JOptionPane.showMessageDialog(null, "Se agregó");
			}

			
		} catch (Exception e) {
System.out.println("No se agregó");		}
		
		
	}
	public static LinkedList<Factura> MostrarFacturas() {
		 LinkedList<Factura> factura = new  LinkedList<Factura>();
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("SELECT * FROM `factura`");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				 
				factura.add(new Factura(resultSet.getInt("id"),resultSet.getInt("id_cliente_fk"), resultSet.getInt("id_habitacion_fk"),resultSet.getDate("fecha_entrada").toLocalDate(),resultSet.getDate("fecha_salida").toLocalDate(),resultSet.getInt("id_reserva_recreacion_fk"),resultSet.getInt("costoXhabitacion"),resultSet.getInt("costoXrecreacion"), resultSet.getInt("costo_Final")));
			}
			
		} catch (Exception e) {
System.out.println("No se agregó");		}
		
		
		return factura;
	}
	
	public static LinkedList<Factura> MostrarFacturas2() {
		 LinkedList<Factura> factura = new  LinkedList<Factura>();
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("SELECT * FROM `factura`");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				 
				//factura.add(new Factura(resultSet.getInt("id"),resultSet.getInt("id_cliente_fk"), resultSet.getInt("id_habitacion_fk"),resultSet.getDate("fecha_entrada").toLocalDate(),resultSet.getDate("fecha_salida").toLocalDate(),resultSet.getInt("costoXhabitacion"), resultSet.getInt("costo_Final")));
			}
			
		} catch (Exception e) {
System.out.println("No se agregó");		}
		
		
		return factura;
	}
	
	
	public static Factura BuscarFactura(int id) {
		Factura nuevo = null;
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("SELECT * FROM `factura` WHERE id= ? ");
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				nuevo = new Factura(resultSet.getInt("id"),resultSet.getInt("id_cliente_fk"), resultSet.getInt("id_habitacion_fk"),resultSet.getDate("fecha_entrada").toLocalDate(),resultSet.getDate("fecha_salida").toLocalDate(),resultSet.getInt("id_reserva_recreacion"),resultSet.getInt("costoXhabitacion"),resultSet.getInt("costoXrecreacion"), resultSet.getInt("costo_Final"));
			}
		
		} catch (Exception e) {
			System.out.println("No se agregó");		
		}
		
		
		return nuevo;
	}
	public static void EliminarFactura(int id) {
		Cliente nuevo = null;
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("DELETE FROM `factura` WHERE id= ? ");
			statement.setInt(1, id);
			int fila = statement.executeUpdate();
			if (fila>0) {
				JOptionPane.showMessageDialog(null, "Se borró");
			}
		
		} catch (Exception e) {
			System.out.println("No se borró");		
		}
		
		
	}
	public static void ActualizarFactura(Factura factura) {
		
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("UPDATE `factura` SET `id_cliente_fk`=?,`id_habitacion_fk`=?,`fecha_entrada`=?,`fecha_salida`=?,`id_reserva_recreacion_fk`=?,`costoXhabitacion`=?,`costoXrecreacion`=?,`costo_Final`=? WHERE `id`=?");
			statement.setInt(1, factura.getId_cliente_fk());
			statement.setInt(2, factura.getId_habitacion_fk());
			statement.setDate(3, Date.valueOf(factura.getFecha_entrada()));
			statement.setDate(4, Date.valueOf(factura.getFecha_salida()));
			statement.setInt(5, factura.getid_reserva_recreacion_fk());
			statement.setDouble(6, factura.getCostoXhabitacion());
			statement.setDouble(7, factura.getCostoXrecreacion());
			statement.setDouble(8, factura.getCosto_Final());

			statement.setInt(9, factura.getId());
			

			int fila = statement.executeUpdate();
			if (fila>0) {
				JOptionPane.showMessageDialog(null, "Se actualizó");
			}
		
		} catch (Exception e) {
			System.out.println("No se actualizó");		
		}
		
		
	}
}
