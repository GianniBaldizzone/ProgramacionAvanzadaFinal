package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;

import Controllers.Controller_Cuenta;
import Controllers.Controller_DataBase;
import Controllers.Controller_Transaccion;
import Modelo.Cuenta;
import Modelo.Extraer;
import Modelo.TipoTransaccion;
import Modelo.Transaccion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DepositarOperacion extends JFrame {

	private JPanel contentPane;
	
	int numeroDeCuentaDepositar;
	private Controller_DataBase conexion;
	private JTextField cantidad;


	
	public void depositar(int numeroDeCuentaDepositar) {
	    conexion = new Controller_DataBase();
	    Controller_Cuenta controller_cuenta = new Controller_Cuenta(conexion.conectar());
	    Controller_Transaccion controller_transaccion = new Controller_Transaccion(conexion.conectar());
	    Cuenta cuenta = controller_cuenta.obtenerCuentaPorNumeroDeCuenta(numeroDeCuentaDepositar);
	    Transaccion transaccion = null;
	    
	    if (cuenta != null) {
	        // Verificar que se haya ingresado un valor en el textFieldcantidad
	        String cantidadText = cantidad.getText();
	        if (!cantidadText.isEmpty()) {
	            // Verificar si el valor ingresado es un número entero positivo
	            if (cantidadText.matches("\\d+")) {
	               
	                
	                // Verificar si la longitud de saldoAExtraer no excede 10 dígitos
	                if (cantidadText.length() <= 10) {
	                    // Verificar si el saldo a extraer no excede el límite de 1,000,000
	                	
	                	 int saldoADepositar = Integer.parseInt(cantidadText);
	                	
	                    if (saldoADepositar <= 2000000 && saldoADepositar > 0) {
	                    	
	                    	//Valida que el metodo haya corrido correctamente
	                    	if(controller_cuenta.depositarSaldo(cuenta, saldoADepositar)) {
	                        // Verificar si la cuenta es de tipo CAJA_DE_AHORRO o CUENTA_CORRIENTE
	                        // Tu lógica de verificación y extracción aquí
	                        controller_cuenta.depositarSaldo(cuenta, saldoADepositar);
	                        transaccion = new Extraer();
	                        transaccion.setMonto(saldoADepositar);
	                        transaccion.setCuentaId(cuenta.getId());
	                        transaccion.setTipo(TipoTransaccion.DEPOSITAR);
	                        
	                        // Se crea la transacción correspondiente a la extracción
	                        controller_transaccion.generarTransaccion(transaccion);
	                        String saldotexto = String.valueOf(saldoADepositar);
	                        OperacionExitosa frame = new OperacionExitosa(saldotexto, transaccion.getTipo().toString());
	                        frame.numeroDeCuentaOperacionExitosa = numeroDeCuentaDepositar;
	                        frame.setVisible(true);
	                        dispose();
	                    	}
	                    	
	                    	
	                    } else {
	                        JOptionPane.showMessageDialog(null, "El monto de deposito no puede exceder 2,000,000 o ser menor a 0 $.");
	                    }
	                } else {
	                    JOptionPane.showMessageDialog(null, "La longitud del saldo a depositar no puede exceder 10 dígitos.");
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
					DepositarOperacion frame = new DepositarOperacion();
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
	public DepositarOperacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Seleccione el monto que desea depositar");
		lblNewLabel_1.setFont(new Font("KG Red Hands", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(93, 96, 489, 27);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Depositar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				depositar(numeroDeCuentaDepositar);
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton.setBackground(new Color(0, 128, 255));
		btnNewButton.setBounds(224, 272, 133, 48);
		contentPane.add(btnNewButton);
		
		cantidad = new JTextField();
		cantidad.setBounds(196, 177, 191, 40);
		contentPane.add(cantidad);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//cancela la operacion
				OperacionCancelada frame = new OperacionCancelada(TipoTransaccion.EXTRAER.toString());
                frame.numeroDeCuentaOperacionCancelada = numeroDeCuentaDepositar;
                frame.setVisible(true);
                dispose();
				
				
			}
		});
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnCancelar.setBackground(Color.RED);
		btnCancelar.setBounds(614, 22, 162, 63);
		contentPane.add(btnCancelar);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(DepositarOperacion.class.getResource("/Iconos/favicon.png")));
		lblNewLabel_2.setBounds(39, 38, 45, 30);
		contentPane.add(lblNewLabel_2);
		
		JButton btnCancelar_1 = new JButton("Cancelar");
		btnCancelar_1.setForeground(Color.WHITE);
		btnCancelar_1.setFont(new Font("Arial", Font.PLAIN, 20));
		btnCancelar_1.setBackground(Color.RED);
		btnCancelar_1.setBounds(614, 22, 162, 63);
		contentPane.add(btnCancelar_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(DepositarOperacion.class.getResource("/Iconos/city.png")));
		lblNewLabel.setBounds(603, 0, 183, 500);
		contentPane.add(lblNewLabel);
		
		
	}
}
