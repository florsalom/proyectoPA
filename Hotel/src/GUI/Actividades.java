package GUI;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import BLL.Administracion;
import BLL.Cliente;

public class Actividades extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField filtro;
	
//	public static void main(String[] args) {
//		Actividades nueva = new Actividades(null);
//		nueva.setVisible(true);
//	}

	public Actividades(Administracion administrador, Cliente cliente) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		
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

		JLabel lblfiltro = new JLabel("Ingresar nombre de la recreacion:");
		lblfiltro.setBounds(180, 20, 200, 14);
		contentPane.add(lblfiltro);
		
		 filtro = new JTextField();
		 filtro.setBounds(180, 50, 100,30);		 
	     contentPane.add(filtro);
	     filtro.setVisible(true);
	     
	     JLabel lblerror = new JLabel("");
			lblerror.setForeground(new Color(255, 0, 0));
			lblerror.setBounds(253, 220, 210, 14);
			contentPane.add(lblerror);

			JLabel lblfecha = new JLabel("Ingresar fecha:");
			lblfecha.setBounds(26, 20, 200, 14);
			contentPane.add(lblfecha);
			
	        JDateChooser dateChooser1 = new JDateChooser();
	        dateChooser1.setBounds(26, 50, 100,30);
	        dateChooser1.setDateFormatString("dd/MM/yyyy");
	        dateChooser1.setVisible(true);
	   
	        Calendar today = Calendar.getInstance();
	        today.add(Calendar.DAY_OF_YEAR, 1); 
	        dateChooser1.setMinSelectableDate(today.getTime());

	        JLabel lblhora1 = new JLabel("Ingresar hora de inicio:");
	        lblhora1.setBounds(26, 80, 200,30);
			contentPane.add(lblhora1);
	        
	        SpinnerNumberModel hourModel = new SpinnerNumberModel(0, 0, 23, 1);
	        JSpinner hourSpinner = new JSpinner(hourModel);
	        JSpinner.NumberEditor hourEditor = new JSpinner.NumberEditor(hourSpinner, "00");
	        hourSpinner.setEditor(hourEditor);
	        hourSpinner.setBounds(26, 110, 70,30);

	        SpinnerNumberModel minuteModel = new SpinnerNumberModel(0, 0, 59, 10);
	        JSpinner minuteSpinner = new JSpinner(minuteModel);
	        JSpinner.NumberEditor minuteEditor = new JSpinner.NumberEditor(minuteSpinner, "00");
	        minuteSpinner.setEditor(minuteEditor);
	        minuteSpinner.setBounds(180, 110, 70, 30);
	        
	        JLabel lblhora2 = new JLabel("Ingresar hora de fin:");
	        lblhora2.setBounds(26, 140, 200,30);
			contentPane.add(lblhora2);
	        
	        SpinnerNumberModel hourModel2 = new SpinnerNumberModel(0, 0, 23, 1);
	        JSpinner hourSpinner2 = new JSpinner(hourModel2);
	        JSpinner.NumberEditor hourEditor2 = new JSpinner.NumberEditor(hourSpinner2, "00");
	        hourSpinner2.setEditor(hourEditor2);
	        hourSpinner2.setBounds(26, 170, 70,30);

	        SpinnerNumberModel minuteModel2 = new SpinnerNumberModel(0, 0, 59, 10);
	        JSpinner minuteSpinner2 = new JSpinner(minuteModel2);
	        JSpinner.NumberEditor minuteEditor2 = new JSpinner.NumberEditor(minuteSpinner2, "00");
	        minuteSpinner2.setEditor(minuteEditor2);
	        minuteSpinner2.setBounds(180, 170, 70,30);

//	        JDateChooser dateChooser2 = new JDateChooser();
//	        dateChooser2.setDateFormatString("dd/MM/yyyy");
//	        dateChooser2.setEnabled(false); 
////	        dateChooser2.setBounds(70, 150, 200,30);
//	        JButton getDateTimeButton = new JButton("Obtener Fecha y Hora");
	        JLabel dateTimeLabel = new JLabel();
//	        getDateTimeButton.setBounds(200, 200, 70,30);
//
//	        getDateTimeButton.addActionListener(e -> {
//	            
//	        });

	        dateChooser1.addPropertyChangeListener("date", evt -> {
	            Date selectedDate = dateChooser1.getDate();
	            if (selectedDate != null) {
	                Calendar cal = Calendar.getInstance();
	                cal.setTime(selectedDate);
	                cal.add(Calendar.DAY_OF_YEAR, 1);
//	                dateChooser2.setMinSelectableDate(cal.getTime());
//	                dateChooser2.setEnabled(true);
	            }
	        });
	        
	        JButton btnEnviar = new JButton("Reservar");
			btnEnviar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 int id = 0;
				     
				     if (filtro.getText().equalsIgnoreCase("Pileta")) {
						id=5;
					} else if (filtro.getText().equalsIgnoreCase("Voley")) {
						id=3;
					} else if (filtro.getText().equalsIgnoreCase("Futbol")) {
						id=4;
					} else if (filtro.getText().equalsIgnoreCase("Paddle")) {
						id=2;
					} else if (filtro.getText().equalsIgnoreCase("Patio")) {
						id=1;
					}
					
					
					
					Date selectedDate1 = dateChooser1.getDate();
		            //Date selectedDate2 = dateChooser2.getDate();
		            if (selectedDate1 != null && hourSpinner!=null && minuteSpinner!=null && hourSpinner2!=null && minuteSpinner2!=null && id>0 && id<=5) {
		                int selectedHour = (int) hourSpinner.getValue();
		                int selectedMinute = (int) minuteSpinner.getValue();
		                int selectedHour2 = (int) hourSpinner2.getValue();
		                int selectedMinute2 = (int) minuteSpinner2.getValue();

		                Calendar selectedDateTime1 = Calendar.getInstance();
		                selectedDateTime1.setTime(selectedDate1);
		                selectedDateTime1.set(Calendar.HOUR_OF_DAY, selectedHour);
		                selectedDateTime1.set(Calendar.MINUTE, selectedMinute);
		                
		                Calendar selectedDateTime2 = Calendar.getInstance();
		                selectedDateTime2.setTime(selectedDate1);
		                selectedDateTime2.set(Calendar.HOUR_OF_DAY, selectedHour2);
		                selectedDateTime2.set(Calendar.MINUTE, selectedMinute2);


		                SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		                String dateTimeString1 = dateTimeFormat.format(selectedDateTime1.getTime());
		                
		                SimpleDateFormat dateTimeFormat2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		                String dateTimeString2 = dateTimeFormat.format(selectedDateTime2.getTime());

		                
		               administrador.reservar_Actividades(cliente, dateTimeString1, dateTimeString2, id);

		               lblerror.setText( administrador.reservar_Actividades(cliente, dateTimeString1, dateTimeString2, id));
		               
		            } else {
		                lblerror.setText("Debes seleccionar todo.");
		            }
				}
			}
			);
			btnEnviar.setBounds(26, 215, 89, 23);
			contentPane.add(btnEnviar);

	        contentPane.add(new JLabel("Fecha 1:"));
	        contentPane.add(dateChooser1);
	        contentPane.add(new JLabel("Hora:"));
	        contentPane.add(hourSpinner);
	        contentPane.add(new JLabel("Minutos:"));
	        contentPane.add(minuteSpinner);
	        contentPane.add(new JLabel("Hora 2:"));
	        contentPane.add(hourSpinner2);
	        contentPane.add(new JLabel("Minutos 2:"));
	        contentPane.add(minuteSpinner2);
	        contentPane.add(new JLabel("Fecha 2:"));
	      //  contentPane.add(dateChooser2);
	      //  contentPane.add(getDateTimeButton);
	        contentPane.add(dateTimeLabel);

	
	        
	}
     
}
