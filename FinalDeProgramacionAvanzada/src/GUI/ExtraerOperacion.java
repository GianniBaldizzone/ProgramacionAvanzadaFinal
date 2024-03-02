package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.Controller_Cuenta;
import Controllers.Controller_DataBase;
import Controllers.Controller_Transaccion;
import Modelo.Cuenta;
import Modelo.Transaccion;
import Modelo.Extraer;
import Modelo.TipoTransaccion;

import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ExtraerOperacion extends JFrame {

	private JPanel contentPane;
	private JSpinner cantidad;
	int numeroDeCuentaExtraer;
	private Controller_DataBase conexion;
	private JTextField textFieldcantidad;
	
	
	
	
	public void extraer(int numeroDeCuenta) {
	    conexion = new Controller_DataBase();
	    Controller_Cuenta controller_cuenta = new Controller_Cuenta(conexion.conectar());
	    Controller_Transaccion controller_transaccion = new Controller_Transaccion(conexion.conectar());
	    Cuenta cuenta = controller_cuenta.obtenerCuentaPorNumeroDeCuenta(numeroDeCuenta);
	    Transaccion transaccion = null;
	    
	    if (cuenta != null) {
	        // Verificar que se haya ingresado un valor en el textFieldcantidad
	        String cantidadText = textFieldcantidad.getText();
	        if (!cantidadText.isEmpty()) {
	            // Verificar si el valor ingresado es un número entero positivo
	            if (cantidadText.matches("\\d+")) {
	               
	                
	                // Verificar si la longitud de saldoAExtraer no excede 10 dígitos
	                if (cantidadText.length() <= 10) {
	                    // Verificar si el saldo a extraer no excede el límite de 1,000,000
	                	
	                	 int saldoAExtraer = Integer.parseInt(cantidadText);
	                	
	                    if (saldoAExtraer <= 2000000) {
	                        // Verificar si la cuenta es de tipo CAJA_DE_AHORRO o CUENTA_CORRIENTE
	                        // Tu lógica de verificación y extracción aquí
	                        controller_cuenta.extraerSaldo(cuenta, saldoAExtraer);
	                        transaccion = new Extraer();
	                        transaccion.setMonto(saldoAExtraer);
	                        transaccion.setCuentaId(cuenta.getId());
	                        transaccion.setTipo(TipoTransaccion.EXTRAER);
	                        
	                        // Se crea la transacción correspondiente a la extracción
	                        controller_transaccion.generarTransaccion(transaccion);
	                        String saldotexto = String.valueOf(saldoAExtraer);
	                        OperacionExitosa frame = new OperacionExitosa(saldotexto, transaccion.getTipo().toString());
	                        frame.numeroDeCuentaOperacionExitosa = numeroDeCuentaExtraer;
	                        frame.setVisible(true);
	                        dispose();
	                        
	                    } else {
	                        JOptionPane.showMessageDialog(null, "El monto de extracción no puede exceder 2,000,000.");
	                    }
	                } else {
	                    JOptionPane.showMessageDialog(null, "La longitud del saldo a extraer no puede exceder 10 dígitos.");
	                }
	            } else {
	                JOptionPane.showMessageDialog(null, "Por favor ingrese un valor numérico entero válido.");
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "Por favor ingrese un valor en el campo.");
	        }
	    }
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExtraerOperacion frame = new ExtraerOperacion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ExtraerOperacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(ExtraerOperacion.class.getResource("/Iconos/favicon.png")));
		lblNewLabel_2.setBounds(33, 32, 45, 30);
		contentPane.add(lblNewLabel_2);
		

		
		JLabel lblNewLabel_1 = new JLabel("Seleccione el monto que desea extraer");
		lblNewLabel_1.setFont(new Font("KG Red Hands", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(82, 89, 489, 27);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Extraer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				extraer(numeroDeCuentaExtraer);
			}
		});
		btnNewButton.setBackground(new Color(0, 128, 255));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton.setBounds(222, 265, 105, 48);
		contentPane.add(btnNewButton);
		
		textFieldcantidad = new JTextField();
		textFieldcantidad.setBounds(185, 177, 184, 37);
		contentPane.add(textFieldcantidad);
		textFieldcantidad.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// se cancela la operación
				OperacionCancelada frame = new OperacionCancelada(TipoTransaccion.EXTRAER.toString());
                frame.numeroDeCuentaOperacionCancelada = numeroDeCuentaExtraer;
                frame.setVisible(true);
                dispose();
				
			}
		});
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnCancelar.setBackground(Color.RED);
		btnCancelar.setBounds(614, 22, 162, 63);
		contentPane.add(btnCancelar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ExtraerOperacion.class.getResource("/Iconos/city.png")));
		lblNewLabel.setBounds(596, 0, 200, 463);
		contentPane.add(lblNewLabel);
	}
}
