package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import BLL.Administracion;
import BLL.Empleado;
import BLL.Habitacion;
import DLL.ControllerHabitacion;

public class Ver_habitacion extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private JLabel elemento;
    private JTextField filtro;

    
	private Habitacion seleccionado;
	

	public Ver_habitacion(Empleado empleado) {
		this.setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 909, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		// Inicializar controlador y usuario seleccionado
		Habitacion seleccionado = new Habitacion();

		// Crear la tabla y el modelo
		String[] columnNames = { "ID", "Tipo de Habitacion", "Cantidad de huespedes", "Estado de limpeza" };
		model = new DefaultTableModel(columnNames, 0);
		table = new JTable(model);
		actualizarTabla();
		contentPane.setLayout(null);

		// Crear el JScrollPane y agregar la tabla
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(5, 19, 911, 190);
		contentPane.add(scrollPane);

		// Crear el JLabel para mostrar la selección
		elemento = new JLabel("Seleccionado:");
		elemento.setBounds(5, 5, 911, 14);
		contentPane.add(elemento);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (empleado.getCargo()==1) {
					Administrador pantallaAdmin = new Administrador(empleado);
					pantallaAdmin.setVisible(true);
					dispose();
				} else {
					Jefe pantallaJefe = new Jefe(empleado);
					pantallaJefe.setVisible(true);
					dispose();
				}
				
				

				}
			}
		);
		btnVolver.setBounds(150, 215, 89, 23);
		contentPane.add(btnVolver);
		
		 filtro = new JTextField();
		 filtro.setBounds(140, 250, 200, 40);		 
	     contentPane.add(filtro);
	     filtro.setVisible(true);
	     //Hacer que esto sea un optionmessage
	     
	     JComboBox comboBox = new JComboBox();
			comboBox.setBounds(200, 250, 135, 22);
			contentPane.add(comboBox);
			comboBox.addItem("Sucio");
			comboBox.addItem("Limpio");
			comboBox.addItem("Chica");
			comboBox.addItem("Grande");
	     
	     
	     JButton btnLimpiar = new JButton("Limpiar");
	     btnLimpiar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					actualizarTabla();

					}
				}
			);
	     btnLimpiar.setBounds(250, 215, 89, 23);
			contentPane.add(btnLimpiar);
	     
	     
//	     JButton Eliminar = new JButton("Eliminar");
//	     Eliminar.setBounds(540, 300, 100, 30);
//	        contentPane.add(Eliminar);
//	        Eliminar.setVisible(true);
//	        Eliminar.addActionListener(new ActionListener() {
//	        	  public void actionPerformed(ActionEvent e) {
//	        		  if (seleccionado.getId()!=0) {
//						
//	        			  
//	        			  ControllerHabitacion.EliminarHabitacion(seleccionado.getId());
//	        			  JOptionPane.showMessageDialog(null, "Se elimino");
//	        				actualizarTabla();
//	        				seleccionado.setId(0);
//
//	        		  } else {
//	        			  JOptionPane.showMessageDialog(null, "No se selecciono nada");
//
//	        		  }
//	        		  
//	        	  }
//	        });
	     
	     JButton filtrarNombre = new JButton("Filtrar por tipo");
	     filtrarNombre.setBounds(340, 300, 200, 30);
	        contentPane.add(filtrarNombre);
	        filtrarNombre.setVisible(true);
	        filtrarNombre.addActionListener(new ActionListener() {
	        	  public void actionPerformed(ActionEvent e) {
	        		  FiltrarTipo_habitacion_fk(filtro.getText());
	        	  }
	        });
		
	        
	        JButton btnRegistrar = new JButton("Filtrar por estado");
		btnRegistrar.setBounds(140, 300, 200, 30);
        contentPane.add(btnRegistrar);
        btnRegistrar.setVisible(true);

        btnRegistrar.addActionListener(new ActionListener() {
        	  public void actionPerformed(ActionEvent e) {
        		  Filtrar(filtro.getText());
        	  }
        });
		

		ListSelectionModel selectionModel = table.getSelectionModel();
		selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// Agregar un escuchador de selección
		selectionModel.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int selectedRow = table.getSelectedRow();
					if (selectedRow != -1) {
						int id = (int) table.getValueAt(selectedRow, 0);
						int tipo_habitacion_fk = (int) table.getValueAt(selectedRow, 1);
						int  cant_huespedes= (int) table.getValueAt(selectedRow, 2);
						int estado_limpieza = (int) table.getValueAt(selectedRow, 3);

						elemento.setText("Seleccionado: ID=" + id + ", Tipo de habitacion=" + tipo_habitacion_fk + ", Cantidad de huespedes=" + cant_huespedes + ", Estado de limpieza="+ estado_limpieza);
						seleccionado.setId(id);
						seleccionado.setTipo_habitacion_fk(tipo_habitacion_fk);
						seleccionado.setCant_huespedes(cant_huespedes);
						seleccionado.setEstado_limpieza(estado_limpieza);
					}
				}
			}
		});
	}

	private void actualizarTabla() {
		// Limpiar el modelo de la tabla
		model.setRowCount(0);
		// Obtener la lista actualizada de usuarios
		List<Habitacion> habitacion = ControllerHabitacion.MostrarHabitacion();
		// Agregar los datos al modelo
		for (Habitacion  habitaciones: habitacion) {
			model.addRow(new Object[] { habitaciones.getId(), habitaciones.getTipo_habitacion_fk(), habitaciones.getCant_huespedes(), habitaciones.getEstado_limpieza() });
		}
	}
	private void Filtrar(String filtro) {
		// Limpiar el modelo de la tabla
		model.setRowCount(0);
		// Obtener la lista actualizada de usuarios
		List<Habitacion> habitaciones2 = ControllerHabitacion.MostrarHabitacion();
		// Agregar los datos al modelo
		int il=3;
		if (filtro.equals("limpio")) {
			il=0;
		}	
		if (filtro.equals("Sucio")) {
			il=1;
		}	
		for (Habitacion habitacion2 : habitaciones2) {
			if ( habitacion2.getEstado_limpieza()==(il)) {
				model.addRow(new Object[] { habitacion2.getId(), 
						habitacion2.getTipo_habitacion_fk(), habitacion2.getCant_huespedes(), habitacion2.getEstado_limpieza() });
			}
			
		}
	}
	private void FiltrarTipo_habitacion_fk(String filtro) {
		// Limpiar el modelo de la tabla
		model.setRowCount(0);
		// Obtener la lista actualizada de usuarios
		List<Habitacion> habitaciones2 = ControllerHabitacion.MostrarHabitacion();
		// Agregar los datos al modelo
		int il=3;
		if (filtro.equals("Chica")) {
			il=2;
		}	
		if (filtro.equals("Grande")) {
			il=1;
		}	
		for (Habitacion habitacion2 : habitaciones2) {
			if ( habitacion2.getTipo_habitacion_fk()==(il)) {
				model.addRow(new Object[] { habitacion2.getId(), 
						habitacion2.getTipo_habitacion_fk(), habitacion2.getCant_huespedes(), habitacion2.getEstado_limpieza() });
			
		}
	}
	
	}
	
}
