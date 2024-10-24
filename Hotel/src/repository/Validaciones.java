package repository;
import javax.swing.JOptionPane;

public interface Validaciones {
	public default String validarString(String mensaje) {
		String variable;
		boolean flag=true;
		do {
			flag=true;
			variable=JOptionPane.showInputDialog(mensaje);
			
			if (variable.isEmpty()) {
				JOptionPane.showMessageDialog(null, "No puede estar vacia");
				flag=false;
			}
		} while (flag==false);
		return variable;
		
	}
	public default int validarNumero(String mensaje){
		int variable=0;
		boolean flag=true;
		do {
			try {
				flag=true;
				variable=Integer.parseInt(JOptionPane.showInputDialog(mensaje));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Tiene que ser un numero");
				flag=false;
			}
		} while (flag==false);
		return variable;
		
		
	}
}
