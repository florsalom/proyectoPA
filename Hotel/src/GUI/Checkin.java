package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BLL.Administracion;
import BLL.Empleado;
import BLL.JefeLimpieza;
import BLL.Limpieza;

public class Checkin extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nombre;
	private JTextField apellido;
	private JTextField dni;
	private JTextField cantidad;
	private JTextField celular;
	

	public Checkin(Administracion administrador) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titulo = new JLabel("Check-in");
		titulo.setFont(new Font("Ubuntu Medium", Font.BOLD, 20));
		titulo.setBounds(29, -70, 220, 198);
		contentPane.add(titulo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(29, 54, 210, 14);
		contentPane.add(lblNombre);
		
		nombre = new JTextField();
		nombre.setBounds(29, 80, 86, 20);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		JLabel lblapellido = new JLabel("Apellido:");
		lblapellido.setBounds(150, 54, 91, 14);
		contentPane.add(lblapellido);
		
		apellido = new JTextField();
		apellido.setBounds(150, 80, 86, 20);
		contentPane.add(apellido);
		
		JLabel lbldni = new JLabel("DNI:");
		lbldni.setBounds(29, 137, 91, 14);
		contentPane.add(lbldni);
		
		dni = new JTextField();
		dni.setBounds(29, 166, 86, 20);
		contentPane.add(dni);
		
		JLabel lblcantidad = new JLabel("Cantidad:");
		lblcantidad.setBounds(150, 137, 91, 14);
		contentPane.add(lblcantidad);
		
		cantidad = new JTextField();
		cantidad.setBounds(150, 166, 86, 20);
		contentPane.add(cantidad);
		
		JLabel lblcelular = new JLabel("Celular:");
		lblcelular.setBounds(271, 137, 91, 14);
		contentPane.add(lblcelular);
		
		celular = new JTextField();
		celular.setBounds(271, 166, 86, 20);
		contentPane.add(celular);
		
		JLabel lblerror = new JLabel("");
		lblerror.setForeground(new Color(255, 0, 0));
		lblerror.setBounds(253, 220, 210, 14);
		contentPane.add(lblerror);
		JButton btnEnviar = new JButton("Check-in");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String label=administrador.checkIn(nombre.getText(), apellido.getText(), dni.getText(), cantidad.getText(), celular.getText());	
				
				lblerror.setText(label);
			

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
	
	}
}
