package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.Administracion;
import BLL.Cliente;
import BLL.Factura;
import BLL.ReservaHabitaciones;
import BLL.ReservaRecreacion;
import DLL.ControllerReservaHabitaciones;
import DLL.ControllerReservaRecreacion;

public class Checkout extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public Checkout(Administracion administrador, Cliente cliente) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
	    JLabel lblDatos = new JLabel("Datos del cliente");
	    lblDatos.setBounds(20, 20, 400, 30);
	    contentPane.add(lblDatos);
	    
	    
	    JLabel lblNombre = new JLabel("Cliente: " + cliente.getNombre());
	    lblNombre.setBounds(20, 50, 400, 30);
	    contentPane.add(lblNombre);

	    JLabel lblHabitacion = new JLabel("Habitación: " + administrador.obtenerHabitacion(cliente));
	    lblHabitacion.setBounds(20, 80, 400, 30);
	    contentPane.add(lblHabitacion);

	    JLabel lblFechaEntrada = new JLabel("Fecha de entrada: " + cliente.getFecha_entrada());
	    lblFechaEntrada.setBounds(20, 110, 400, 30);
	    contentPane.add(lblFechaEntrada);

	    JLabel lblActividades = new JLabel("Actividades reservadas: " + administrador.obtenerActividades(cliente));
	    lblActividades.setBounds(20, 140, 400, 30);
	    contentPane.add(lblActividades);

	    JButton btnCheckout = new JButton("Check Out");
	    btnCheckout.setBounds(130, 200, 100, 23);
	    contentPane.add(btnCheckout);
	   
	    
	    JLabel lblerror = new JLabel("");
		lblerror.setForeground(new Color(255, 0, 0));
		lblerror.setBounds(230, 220, 210, 14);
		contentPane.add(lblerror);

	    btnCheckout.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	
	                administrador.checkOut(cliente);
	                lblerror.setText(administrador.generar_factura(cliente));
}
	        }
	    );

	    JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Administrador pantallaAdmin = new Administrador(administrador);
				pantallaAdmin.setVisible(true);
				dispose();

				}
			}
		);
		btnVolver.setBounds(20, 200, 89, 23);
		contentPane.add(btnVolver);



}}