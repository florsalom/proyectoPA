package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BLL.Administracion;
import BLL.Empleado;
import BLL.JefeLimpieza;
import BLL.Limpieza;



public class PantallaLogin extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inpMail;
	private JPasswordField pswPass;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaLogin frame = new PantallaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public PantallaLogin(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titulo = new JLabel("Login");
		titulo.setFont(new Font("Ubuntu Medium", Font.BOLD, 20));
		titulo.setBounds(29, -70, 220, 198);
		contentPane.add(titulo);
		
		JLabel lblNombre = new JLabel("Mail:");
		lblNombre.setBounds(29, 54, 210, 14);
		contentPane.add(lblNombre);
		
		inpMail = new JTextField();
		inpMail.setBounds(29, 80, 86, 20);
		contentPane.add(inpMail);
		inpMail.setColumns(10);
		
		JLabel lblcontrasena = new JLabel("Contraseña:");
		lblcontrasena.setBounds(29, 137, 91, 14);
		contentPane.add(lblcontrasena);
		
		pswPass = new JPasswordField();
		pswPass.setBounds(29, 166, 86, 20);
		contentPane.add(pswPass);
		JLabel lblerror = new JLabel("");
		lblerror.setForeground(new Color(255, 0, 0));
		lblerror.setBounds(214, 117, 210, 14);
		contentPane.add(lblerror);
		JButton btnEnviar = new JButton("Logearse");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if (inpMail.getText().isEmpty() || pswPass.getText().isEmpty()) {
					lblerror.setText("No puede ser vacio");
				} else {
					lblerror.setVisible(false);
					Empleado encontrado = Empleado.login(inpMail.getText(), pswPass.getText()) ;
					
					if(encontrado!=null) {
						if (encontrado.getCargo()==1) {
							Administracion nuevo = new Administracion(encontrado.getId(),encontrado.getCargo(),encontrado.getNombre(),encontrado.getApellido(),encontrado.getDni(),encontrado.getMail(),encontrado.getContrasena());
							Administrador pantallaAdmin = new Administrador(nuevo);
							pantallaAdmin.setVisible(true);
							dispose();
						} else if (encontrado.getCargo()==2) {
							
							JefeLimpieza nuevo = new JefeLimpieza(encontrado.getId(),encontrado.getCargo(),encontrado.getNombre(),encontrado.getApellido(),encontrado.getDni(),encontrado.getMail(),encontrado.getContrasena());
							Jefe pantallaJefe = new Jefe(nuevo);
							pantallaJefe.setVisible(true);
							dispose();nuevo.menu();

							
						}else if (encontrado.getCargo()==3) {
							Limpieza nuevo = new Limpieza(encontrado.getId(),encontrado.getCargo(),encontrado.getNombre(),encontrado.getApellido(),encontrado.getDni(),encontrado.getMail(),encontrado.getContrasena());
							Limpiador pantallaLimp = new Limpiador(nuevo);
							pantallaLimp.setVisible(true);
							dispose();
						}
					}else {
						lblerror.setText("No encontrado");

					}

					
				}
			

				}
			}
		);
		btnEnviar.setBounds(26, 215, 89, 23);
		contentPane.add(btnEnviar);
	
	}
	
	
	
	
}