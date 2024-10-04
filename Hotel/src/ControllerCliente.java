import com.mysql.jdbc.Connection;

public class ControllerCliente {
	private static Connection con = Conexion.getInstance().getConnection();
}
