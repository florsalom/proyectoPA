package GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import BLL.Administracion;

public class Actividades extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public Actividades(Administracion administrador) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnEnviar = new JButton("Check In");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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

		JLabel usuario = new JLabel("Bienvenido " );
		usuario.setBounds(100, 46, 300, 14);
		contentPane.add(usuario);
		
		
		  setTitle("Calendario con Hora en JFrame");
	        setSize(500, 400);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);

	        JPanel panel = new JPanel();
	        panel.setLayout(new FlowLayout());

	        JDateChooser dateChooser1 = new JDateChooser();
	        dateChooser1.setDateFormatString("dd/MM/yyyy");

	        Calendar today = Calendar.getInstance();
	        today.add(Calendar.DAY_OF_YEAR, 1); 
	        dateChooser1.setMinSelectableDate(today.getTime());

	        SpinnerNumberModel hourModel = new SpinnerNumberModel(0, 0, 23, 1);
	        JSpinner hourSpinner = new JSpinner(hourModel);
	        JSpinner.NumberEditor hourEditor = new JSpinner.NumberEditor(hourSpinner, "00");
	        hourSpinner.setEditor(hourEditor);

	        SpinnerNumberModel minuteModel = new SpinnerNumberModel(0, 0, 59, 1);
	        JSpinner minuteSpinner = new JSpinner(minuteModel);
	        JSpinner.NumberEditor minuteEditor = new JSpinner.NumberEditor(minuteSpinner, "00");
	        minuteSpinner.setEditor(minuteEditor);

	        JDateChooser dateChooser2 = new JDateChooser();
	        dateChooser2.setDateFormatString("dd/MM/yyyy");
	        dateChooser2.setEnabled(false); 

	        JButton getDateTimeButton = new JButton("Obtener Fecha y Hora");
	        JLabel dateTimeLabel = new JLabel();

	        getDateTimeButton.addActionListener(e -> {
	            Date selectedDate1 = dateChooser1.getDate();
	            Date selectedDate2 = dateChooser2.getDate();
	            if (selectedDate1 != null && selectedDate2 != null) {
	                int selectedHour = (int) hourSpinner.getValue();
	                int selectedMinute = (int) minuteSpinner.getValue();

	                Calendar selectedDateTime1 = Calendar.getInstance();
	                selectedDateTime1.setTime(selectedDate1);
	                selectedDateTime1.set(Calendar.HOUR_OF_DAY, selectedHour);
	                selectedDateTime1.set(Calendar.MINUTE, selectedMinute);

	                SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	                String dateTimeString1 = dateTimeFormat.format(selectedDateTime1.getTime());

	                Calendar selectedDateTime2 = Calendar.getInstance();
	                selectedDateTime2.setTime(selectedDate2);
	                String dateTimeString2 = dateTimeFormat.format(selectedDateTime2.getTime());

	                dateTimeLabel.setText("Fecha y hora seleccionadas: " + dateTimeString1 + " y " + dateTimeString2);
	            } else {
	                dateTimeLabel.setText("No se ha seleccionado ninguna fecha.");
	            }
	        });

	        dateChooser1.addPropertyChangeListener("date", evt -> {
	            Date selectedDate = dateChooser1.getDate();
	            if (selectedDate != null) {
	                Calendar cal = Calendar.getInstance();
	                cal.setTime(selectedDate);
	                cal.add(Calendar.DAY_OF_YEAR, 1);
	                dateChooser2.setMinSelectableDate(cal.getTime());
	                dateChooser2.setEnabled(true);
	            }
	        });

	        panel.add(new JLabel("Fecha 1:"));
	        panel.add(dateChooser1);
	        panel.add(new JLabel("Hora:"));
	        panel.add(hourSpinner);
	        panel.add(new JLabel("Minutos:"));
	        panel.add(minuteSpinner);
	        panel.add(new JLabel("Fecha 2:"));
	        panel.add(dateChooser2);
	        panel.add(getDateTimeButton);
	        panel.add(dateTimeLabel);

	        add(panel);

	        setVisible(true);
	        
			
	}
//	        public static void main(String[] args) {
//	            SwingUtilities.invokeLater(Actividades::new);
//	        
//
//		
//
//}
}
