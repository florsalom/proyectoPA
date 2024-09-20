import javax.swing.JOptionPane;

public class JefeLimpieza extends Empleados implements Menu{

<<<<<<< Updated upstream
public class JefeLimpieza {

=======
	public JefeLimpieza(int id, String cargo, String nombre, String apellido, String dni, String mail,
			String contrasena) {
		super(id, cargo, nombre, apellido, dni, mail, contrasena);
	}
		@Override
		public void menu() {
				JOptionPane.showMessageDialog(null, "Menu admin");

			}
			@Override
			public void menuPrincipal() {
				JOptionPane.showMessageDialog(null, "Menu admin desde interface");
				JOptionPane.showMessageDialog(null, "Stock \n " + ListaLimpieza.getInstance("Tropitango"));
			}

		
	
		
		
		
	}
	
>>>>>>> Stashed changes
}
