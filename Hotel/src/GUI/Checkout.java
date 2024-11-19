package GUI;

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

	public Checkout(Administracion administrador) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnEnviar = new JButton("Check Out"); //hay que alargar el boton pero no funciona windowbuilder y no lo quiero arruinar :)
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		}
		
		
		
		);
		
		
	    JLabel lblDatos = new JLabel("Datos del cliente");
	    lblDatos.setBounds(20, 20, 400, 20);
	    contentPane.add(lblDatos);
		
		
		JButton btnBuscarCliente = new JButton("Buscar Cliente");
	    btnBuscarCliente.setBounds(20, 60, 150, 30);
	    contentPane.add(btnBuscarCliente);
	    
	    
	    btnBuscarCliente.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            Cliente clienteSeleccionado = administrador.buscar_Cliente();
	            if (clienteSeleccionado != null) {
	                lblDatos.setText("Cliente: " + clienteSeleccionado.getNombre() +
	                                    "Habitación: " + obtenerHabitacion(clienteSeleccionado) +
	                                    "Fecha de entrada: " + clienteSeleccionado.getFecha_entrada() +
	                                    "Actividades reservadas: " + obtenerActividades(clienteSeleccionado));
	            } else {
	                JOptionPane.showMessageDialog(null, "No se seleccionó un cliente.");
	            }
	        }
	    });


	    JButton btnCheckout = new JButton("Check Out");
	    btnCheckout.setBounds(20, 150, 150, 30);
	    contentPane.add(btnCheckout);


	    btnCheckout.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            Cliente clienteSeleccionado = administrador.buscar_Cliente();
	            if (clienteSeleccionado != null) {
	                administrador.checkOut(clienteSeleccionado);
	                Factura factura = administrador.generar_factura(clienteSeleccionado);
	                JOptionPane.showMessageDialog(null, "Checkout realizado con éxito" + factura.toString());
	            } else {
	                JOptionPane.showMessageDialog(null, "Seleccione un cliente");
	            }
	        }
	    });

	    JButton btnVolver = new JButton("Volver");
	    btnVolver.setBounds(20, 200, 150, 30);
	    contentPane.add(btnVolver);
	        }




//	private String obtenerHabitacion(Cliente cliente) {
//	    LinkedList<ReservaHabitaciones> reservas = ControllerReservaHabitaciones.MostrarReservaHabitaciones();
//	    for (ReservaHabitaciones reserva : reservas) {
//	        if (reserva.getId_cliente_fk() == cliente.getId()) {
//	            return "ID: " + reserva.getId_habitacion_fk();
//	        }
//	    }
//	    return "No asignada";
//	}
//
//	private String obtenerActividades(Cliente cliente) {
//	    LinkedList<ReservaRecreacion> actividades = ControllerReservaRecreacion.MostrarReservaRecreacion();
//	    for (ReservaRecreacion actividad : actividades) {
//	        if (actividad.getId_cliente_fk() == cliente.getId()) {
//	            return "Reservado, ID: " + actividad.getId_recreacion_fk();
//	        }
//	    }
//	    return "No reservadas";
//	}}
	
	//quizas?? no se si serian por id