package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controllers.Controller_Cuenta;
import Controllers.Controller_DataBase;
import Controllers.Controller_Usuario;
import Modelo.Cuenta;
import Modelo.Transaccion;

public class MostrarCuentas extends JFrame {

	private JPanel contentPane;

	  private JTable table;
	    private Controller_Cuenta controllerCuenta;
	    private Controller_DataBase conexion;
	    int numeroDeCuentaUltimosMovimientos;
	    private JLabel lblNewLabel;
	    private JLabel lblNewLabel_2;
	    private JLabel lblNewLabel_1;
	    private JButton btnVolver;
	    
	    private void cargarTodasLasCuentas() {
	        // Obtenemos todas las cuentas
	        List<Cuenta> todasLasCuentas = controllerCuenta.obtenerCuentas();

	        // Creamos un modelo de tabla para almacenar los datos de las cuentas
	        DefaultTableModel model = new DefaultTableModel();
	        
	        model.addColumn("Numero de Cuenta");
	        model.addColumn("Saldo");
	        model.addColumn("Pin");
	        model.addColumn("Tipo de Cuenta");
	        

	        // Agregamos las cuentas al modelo de la tabla
	        for (Cuenta cuenta : todasLasCuentas) {
	            Object[] rowData = {
	                
	                cuenta.getNumeroCuenta(),
	                cuenta.getSaldo(),
	                cuenta.getPin(),
	                cuenta.getTipoCuenta(),
	                
	            };
	            model.addRow(rowData);
	        }

	        // Establecemos el modelo de tabla en la tabla
	        table.setModel(model);
	    }

	    public MostrarCuentas() {
	        
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 800, 500);
	        contentPane = new JPanel();
	        contentPane.setBackground(new Color(255, 255, 255));
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);

	        // Creamos un JScrollPane que contendrá la tabla de los últimos movimientos
	        JScrollPane scrollPane = new JScrollPane();
	        scrollPane.setBounds(23, 93, 494, 340);
	        contentPane.add(scrollPane);

	        // Creamos la tabla
	        table = new JTable();
	        scrollPane.setViewportView(table);

	        // Configuramos la etiqueta y el ícono
	        lblNewLabel_2 = new JLabel("");
	        lblNewLabel_2.setIcon(new ImageIcon(UltimosMovimientosOperacion.class.getResource("/Iconos/favicon.png")));
	        lblNewLabel_2.setBounds(23, 31, 45, 30);
	        contentPane.add(lblNewLabel_2);

	        // Configuramos la etiqueta de "Ultimos movimientos"
	        lblNewLabel_1 = new JLabel("Cuentas");
	        lblNewLabel_1.setFont(new Font("KG Red Hands", Font.PLAIN, 18));
	        lblNewLabel_1.setBounds(78, 25, 403, 47);
	        contentPane.add(lblNewLabel_1);

	        // Configuramos el botón de "Volver" para regresar a la ventana anterior
	        btnVolver = new JButton("Volver");
	        btnVolver.addActionListener(e -> {
	        	ABMCuenta frame = new ABMCuenta();
                frame.setVisible(true);
                dispose();
	        });
	        btnVolver.setForeground(Color.WHITE);
	        btnVolver.setFont(new Font("Arial", Font.PLAIN, 20));
	        btnVolver.setBackground(Color.RED);
	        btnVolver.setBounds(592, 31, 162, 63);
	        contentPane.add(btnVolver);

	        // Configuramos la etiqueta y el ícono
	        lblNewLabel = new JLabel("");
	        lblNewLabel.setIcon(new ImageIcon(UltimosMovimientosOperacion.class.getResource("/Iconos/city.png")));
	        lblNewLabel.setBounds(548, 0, 248, 463);
	        contentPane.add(lblNewLabel);

	        // Establecemos la conexión a la base de datos y cargamos todos los movimientos de la cuenta
	        conexion = new Controller_DataBase();
	        controllerCuenta = new Controller_Cuenta(conexion.conectar());
	        cargarTodasLasCuentas();
	    }

	    // Método para cargar todos los movimientos de la cuenta y mostrarlos en la tabla
	    
	}