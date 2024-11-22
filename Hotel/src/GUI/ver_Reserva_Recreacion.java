package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BLL.Administracion;
import BLL.ReservaRecreacion;
import DLL.ControllerReservaRecreacion;

public class ver_Reserva_Recreacion extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel model;
    private JLabel elemento;

    public ver_Reserva_Recreacion(Administracion administrador) {
        // Configuración inicial de la ventana
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 800, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Crear la tabla y el modelo
        String[] columnNames = { "ID", "ID Cliente", "ID Recreación", "Inicio", "Fin" };
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        actualizarTabla(); // Cargar datos en la tabla

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 50, 760, 250);
        contentPane.add(scrollPane);

        // Crear el JLabel para mostrar detalles del seleccionado
        elemento = new JLabel("Seleccionado: ");
        elemento.setBounds(10, 10, 760, 20);
        contentPane.add(elemento);

        // Botón para volver al menú principal
        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Administrador pantallaAdmin = new Administrador(administrador);
                pantallaAdmin.setVisible(true);
                dispose();
            }
        });
        btnVolver.setBounds(10, 320, 120, 30);
        contentPane.add(btnVolver);

        // Escuchar la selección en la tabla
        ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        selectionModel.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    int id = (int) table.getValueAt(selectedRow, 0);
                    int idCliente = (int) table.getValueAt(selectedRow, 1);
                    int idRecreacion = (int) table.getValueAt(selectedRow, 2);
                    String inicio = table.getValueAt(selectedRow, 3).toString();
                    String fin = table.getValueAt(selectedRow, 4).toString();

                    elemento.setText("Seleccionado: ID=" + id + ", ID Cliente=" + idCliente + ", ID Recreación=" + idRecreacion + 
                            ", Inicio=" + inicio + ", Fin=" + fin);
                }
            }
        });
    }

    private void actualizarTabla() {
        model.setRowCount(0);
        List<ReservaRecreacion> reservas = ControllerReservaRecreacion.MostrarReservaRecreacion();
        if (reservas == null || reservas.isEmpty()) {
            System.out.println("No se encontraron reservas");
        } else {
            for (ReservaRecreacion reserva : reservas) {
                System.out.println("Reserva encontrada: ID=" + reserva.getId() + ", Cliente=" + reserva.getId_cliente_fk());
                model.addRow(new Object[] {
                    reserva.getId(),
                    reserva.getId_cliente_fk(),
                    reserva.getId_recreacion_fk(),
                    reserva.getInicio(),
                    reserva.getFin()
                });
        }
    }
}}