package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.Administracion;
import BLL.Cliente;

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
		btnCheckin.setBounds(26, 70, 120, 23);
		contentPane.add(btnCheckin);
		
		JButton btnCheckout = new JButton("Check-Out");
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente= administrador.buscar_Cliente();
				Checkout pantallaCheckout = new Checkout(administrador,  cliente);
				pantallaCheckout.setVisible(true);
				dispose();
			}
		}
		);
		btnCheckout.setBounds(26, 130, 120, 23);
		contentPane.add(btnCheckout);
		
		
		JButton btnRactividades = new JButton("Reservar Actividades");
		btnRactividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente= administrador.buscar_Cliente();
				Actividades pantallaRactividades = new Actividades(administrador, cliente);
				pantallaRactividades.setVisible(true);
				dispose();
			}
		}
		);
		btnRactividades.setBounds(180, 100, 200, 23);
		contentPane.add(btnRactividades);
		
		
		JButton btnBucarCliente = new JButton("Buscar Cliente");
		btnBucarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				administrador.buscar_Cliente();
			}
		}
		);
		btnBucarCliente.setBounds(26, 160, 120, 23);
		contentPane.add(btnBucarCliente);
		
		
		JButton btnVhabitacion = new JButton("Ver Habitación");
		btnVhabitacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ver_habitacion pantallaHabtacion = new Ver_habitacion(administrador);
				pantallaHabtacion.setVisible(true);
				dispose();
			}
		}
		);
		btnVhabitacion.setBounds(180, 70, 200, 23);
		contentPane.add(btnVhabitacion);
		
		
		JButton btnVRhabitacion = new JButton("Ver Reserva Habitación");
		btnVRhabitacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				administrador.ver_Reserva_Habitacion();
			}
		}
		);
		btnVRhabitacion.setBounds(180, 160, 200, 23);
		contentPane.add(btnVRhabitacion);
		
		
		JButton btnVRrecreacion = new JButton("Ver Reserva Recreacion");
		btnVRrecreacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				administrador.ver_Reserva_Recreacion();
			}
		}
		);
		btnVRrecreacion.setBounds(180, 130, 200, 23);
		contentPane.add(btnVRrecreacion);
		
		
		JButton btnVfactura = new JButton("Ver Factura");
		btnVfactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				administrador.ver_Factura();
			}
		}
		);
		btnVfactura.setBounds(26, 100, 120, 23);
		contentPane.add(btnVfactura);
		
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
		
		JLabel usuario = new JLabel("Bienvenido " + administrador.getNombre());
		usuario.setBounds(26, 30, 300, 30);
		contentPane.add(usuario);
		
		usuario.setFont(new Font("Ubuntu Medium", Font.BOLD, 20));
		
}
}
