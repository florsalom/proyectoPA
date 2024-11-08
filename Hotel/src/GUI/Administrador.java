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
				Checkin pantallaCheckin = new Checkin(administrador);
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
				Checkout pantallaCheckout = new Checkout();
				pantallaCheckout.setVisible(true);
				dispose();
			}
		}
		);
		btnCheckout.setBounds(26, 100, 100, 23);
		contentPane.add(btnCheckout);
		
		
		JButton btnRactividades = new JButton("Reservar Actividades");
		btnRactividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Actividades pantallaRactividades = new Actividades();
				pantallaRactividades.setVisible(true);
				dispose();
			}
		}
		);
		btnRactividades.setBounds(26, 150, 100, 23);
		contentPane.add(btnRactividades);
		
		
		JButton btnBucarCliente = new JButton("Buscar Cliente");
		btnBucarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				administrador.buscar_Cliente();
			}
		}
		);
		btnBucarCliente.setBounds(26, 70, 100, 23);
		contentPane.add(btnBucarCliente);
		
		
		JButton btnVhabitacion = new JButton("Ver Habitación");
		btnCheckin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				administrador.ver_Habitacion();
			}
		}
		);
		btnVhabitacion.setBounds(26, 175, 100, 23);
		contentPane.add(btnVhabitacion);
		
		
		JButton btnVRhabitacion = new JButton("Ver Reserva Habitación");
		btnVRhabitacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				administrador.ver_Reserva_Habitacion();
			}
		}
		);
		btnVRhabitacion.setBounds(26, 230, 100, 23);
		contentPane.add(btnVRhabitacion);
		
		
		JButton btnVRrecreacion = new JButton("Ver Reserva Recreacion");
		btnVRrecreacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				administrador.ver_Reserva_Recreacion();
			}
		}
		);
		btnVRrecreacion.setBounds(26, 250, 100, 23);
		contentPane.add(btnVRrecreacion);
		
		
		JButton btnVfactura = new JButton("Ver Factura");
		btnVfactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				administrador.ver_Factura();
			}
		}
		);
		btnVfactura.setBounds(26, 275, 100, 23);
		contentPane.add(btnVfactura);
		
		JLabel usuario = new JLabel("Bienvenido " + administrador.getNombre());
		usuario.setBounds(100, 46, 300, 14);
		contentPane.add(usuario);
}
}
