package GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.JefeLimpieza;

public class Jefe extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public Jefe(JefeLimpieza jefeLimpieza) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(41, 0, 289, 250);
		contentPane.add(lblNewLabel);
		
		JLabel usuario = new JLabel("Bienvenido" + jefeLimpieza.getNombre());
		usuario.setBounds(302, 46, 46, 14);
		contentPane.add(usuario);
}
}
