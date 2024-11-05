package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.Administracion;

public class Administrador extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public Administrador(Administracion administrador) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnCheckin = new JButton("Check-In");
		btnCheckin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Checkin pantallaCheckin = new Checkin();
				pantallaCheckin.setVisible(true);
				dispose();
			}
		}
		);
		btnCheckin.setBounds(26, 215, 100, 23);
		contentPane.add(btnCheckin);
		
		JButton btnCheckout = new JButton("Check-Out");
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Checkin pantallaCheckout = new Checkin();
				pantallaCheckout.setVisible(true);
				dispose();
			}
		}
		);
		btnCheckout.setBounds(26, 100, 100, 23);
		contentPane.add(btnCheckout);
		
		
		JLabel usuario = new JLabel("Bienvenido " + administrador.getNombre());
		usuario.setBounds(100, 46, 300, 14);
		contentPane.add(usuario);
}
}
