package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import Controllers.Controller_Cuenta;
import Controllers.Controller_DataBase;
import Controllers.Controller_Transaccion;
import Modelo.Cuenta;
import Modelo.TipoTransaccion;
import Modelo.Transaccion;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TranferirOperacion extends JFrame {

	private JPanel contentPane;
	private JTextField numeroDeCuentaDestino;
	private JTextField cantidad;
	private Controller_DataBase conexion;
	int numeroDeCuentaTranferir;

	
	public void transferir(int numeroCuentaOrigen, int numeroCuentaDestino) {
	    conexion = new Controller_DataBase();
	    Controller_Cuenta controller_cuenta = new Controller_Cuenta(conexion.conectar());
	    Controller_Transaccion controller_transaccion = new Controller_Transaccion(conexion.conectar());

	    // Verificar que ambos campos est�n completados
	    if (cantidad.getText().isEmpty() || numeroDeCuentaDestino.getText().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Por favor complete ambos campos.");
	        return;
	    }

	    // Verificar si los valores ingresados son n�meros enteros
	    if (!cantidad.getText().matches("\\d+") || !numeroDeCuentaDestino.getText().matches("\\d+")) {
	        JOptionPane.showMessageDialog(null, "Por favor ingrese valores num�ricos enteros v�lidos.");
	        return;
	    }
	    
	    String numeroDeCuentaTranferirString = String.valueOf(numeroDeCuentaTranferir);

	    int numeroCuentaOrigen1 = Integer.parseInt(numeroDeCuentaTranferirString);
	    int numeroCuentaDestino1 = Integer.parseInt(numeroDeCuentaDestino.getText());

	    // Obtener cuentas de origen y destino
	    Cuenta cuentaOrigen = controller_cuenta.obtenerCuentaPorNumeroDeCuenta(numeroCuentaOrigen1);
	    Cuenta cuentaDestino = controller_cuenta.obtenerCuentaPorNumeroDeCuenta(numeroCuentaDestino1);

	    if (cuentaOrigen != null && cuentaDestino != null) {
	        // Verificar que se haya ingresado un valor en el textFieldcantidad
	        String cantidadText = cantidad.getText();
	        if (!cantidadText.isEmpty()) {
	            // Verificar si el valor ingresado es un n�mero entero positivo
	            if (cantidadText.matches("\\d+")) {
	                int montoTransferencia = Integer.parseInt(cantidadText);

	                // Verificar si el monto de transferencia es v�lido
	                if (montoTransferencia > 0 && montoTransferencia <= 2000000) {
	                    // Extraer saldo de la cuenta de origen
	                    controller_cuenta.extraerSaldo(cuentaOrigen, montoTransferencia);

	                    // Depositar saldo en la cuenta de destino
	                    controller_cuenta.depositarSaldo(cuentaDestino, montoTransferencia);

	                    // Crear transacci�n de transferencia
	                    Transaccion transaccion = new Transaccion();
	                    transaccion.setMonto(montoTransferencia);
	                    transaccion.setCuentaId(cuentaOrigen.getId()); // Usar cuenta origen para identificar la transacci�n
	                    transaccion.setTipo(TipoTransaccion.TRANSFERIR);

	                    // Generar transacci�n
	                    controller_transaccion.generarTransaccion(transaccion);

	                    // Mostrar mensaje de �xito
	                    JOptionPane.showMessageDialog(null, "Transferencia exitosa");

	                    // Cerrar la ventana actual (si es necesario)
	                    dispose();
	                } else {
	                    JOptionPane.showMessageDialog(null, "El monto de transferencia debe ser un valor entre 1 y 2,000,000.");
	                }
	            } else {
	                JOptionPane.showMessageDialog(null, "Por favor ingrese un valor num�rico entero v�lido.");
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "Por favor ingrese un valor en el campo.");
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "Una de las cuentas no se encontr�.");
	    }
	}
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TranferirOperacion frame = new TranferirOperacion();
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
	public TranferirOperacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese la cuenta a tranferir ");
		lblNewLabel_1.setFont(new Font("KG Red Hands", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(39, 79, 313, 47);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setBounds(28, 27, 45, 30);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ingrese monto a tranferir");
		lblNewLabel_1_1.setFont(new Font("KG Red Hands", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(39, 217, 313, 47);
		contentPane.add(lblNewLabel_1_1);
		
		numeroDeCuentaDestino = new JTextField();
		numeroDeCuentaDestino.setBounds(39, 136, 319, 45);
		contentPane.add(numeroDeCuentaDestino);
		numeroDeCuentaDestino.setColumns(10);
		
		cantidad = new JTextField();
		cantidad.setColumns(10);
		cantidad.setBounds(39, 274, 319, 45);
		contentPane.add(cantidad);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("");
		lblNewLabel_2_1_1.setIcon(new ImageIcon(TranferirOperacion.class.getResource("/Iconos/favicon.png")));
		lblNewLabel_2_1_1.setBounds(28, 27, 45, 30);
		contentPane.add(lblNewLabel_2_1_1);
		
		JButton btnTranferir = new JButton("Tranferir");
		btnTranferir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTranferir.setForeground(Color.WHITE);
		btnTranferir.setFont(new Font("Arial", Font.PLAIN, 20));
		btnTranferir.setBackground(new Color(0, 128, 255));
		btnTranferir.setBounds(39, 356, 122, 48);
		contentPane.add(btnTranferir);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				// se cancela la operaci�n
				OperacionCancelada frame = new OperacionCancelada(TipoTransaccion.TRANSFERIR.toString());
                frame.numeroDeCuentaOperacionCancelada = numeroDeCuentaTranferir;
                frame.setVisible(true);
                dispose();
				
			}
		});
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnCancelar.setBackground(Color.RED);
		btnCancelar.setBounds(582, 27, 162, 63);
		contentPane.add(btnCancelar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TranferirOperacion.class.getResource("/Iconos/city.png")));
		lblNewLabel.setBounds(540, 0, 259, 478);
		contentPane.add(lblNewLabel);
	}

}