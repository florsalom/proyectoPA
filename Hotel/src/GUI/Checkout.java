package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.Administracion;

public class Checkout extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public Checkout(Administracion administrador) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnEnviar = new JButton("Check In");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		}
		);
		btnEnviar.setBounds(26, 215, 89, 23);
		contentPane.add(btnEnviar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Administrador pantallaAdmin = new Administrador(administrador);
				pantallaAdmin.setVisible(true);
				dispose();

				}
			}
		);
		btnVolver.setBounds(150, 215, 89, 23);
		contentPane.add(btnVolver);

		JLabel usuario = new JLabel("Bienvenido " );
		usuario.setBounds(100, 46, 300, 14);
		contentPane.add(usuario);
}
}
