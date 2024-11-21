package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
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
		
		
		JButton btnCheckin = new JButton("Asignar Trabajo");
		btnCheckin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jefeLimpieza.asignar_Trabajo();
			}
		}
		);
		btnCheckin.setBounds(26, 70, 200, 23);
		contentPane.add(btnCheckin);
		
		JButton btnCheckout = new JButton("Ver habitacion");
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jefeLimpieza.ver_Habitacion();
			}
		}
		);
		btnCheckout.setBounds(26, 130, 200, 23);
		contentPane.add(btnCheckout);
		
		
		JButton Salir = new JButton("Salir");
		Salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaLogin pantalla= new PantallaLogin();
				pantalla.setVisible(true);
				
				dispose();
			}
		}
		);
		Salir.setBounds(26, 220, 120, 23);
		contentPane.add(Salir);
		
		
		
		
		JLabel usuario = new JLabel("Bienvenido " + jefeLimpieza.getNombre());
		usuario.setBounds(26, 30, 300, 30);
		contentPane.add(usuario);
		
		usuario.setFont(new Font("Ubuntu Medium", Font.BOLD, 20));
		
}
}
