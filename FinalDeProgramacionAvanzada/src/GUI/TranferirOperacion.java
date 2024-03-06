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
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class TranferirOperacion extends JFrame {

	private JPanel contentPane;
	private JTextField numeroDeCuentaDestino;
	private JTextField cantidad;
	private Controller_DataBase conexion;
	int numeroDeCuentaTranferir;

	
	public void transferir(int numeroCuentaOrigen) {
	    conexion = new Controller_DataBase();
	    Controller_Cuenta controller_cuenta = new Controller_Cuenta(conexion.conectar());
	    Controller_Transaccion controller_transaccion = new Controller_Transaccion(conexion.conectar());

	    // Verificar que ambos campos estén completados
	    if (cantidad.getText().isEmpty() || numeroDeCuentaDestino.getText().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Por favor complete ambos campos.");
	        return;
	    }

	    // Verificar si los valores ingresados son números enteros
	    if (!cantidad.getText().matches("\\d+") || !numeroDeCuentaDestino.getText().matches("\\d+")) {
	        JOptionPane.showMessageDialog(null, "Por favor ingrese un valor numérico válido para ambos campos.");
	        return;
	    }

	    // Verificar si los valores ingresados no superan los 10 dígitos
	    if (cantidad.getText().length() > 10 || numeroDeCuentaDestino.getText().length() > 10) {
	        JOptionPane.showMessageDialog(null, "El número de cuenta destino y el monto de transferencia deben tener hasta 10 dígitos.");
	        return;
	    }
	    
	
	   
	    // Convertir los valores de texto a números enteros
	    int numeroCuentaDestino1 = Integer.parseInt(numeroDeCuentaDestino.getText());
	    int montoTransferencia = Integer.parseInt(cantidad.getText());
	    
	    if (numeroCuentaDestino1 == numeroDeCuentaTranferir) {
	        JOptionPane.showMessageDialog(null, "No es posible tranferirse a uno mismo dinero. Pruebe nuevamente con otro numero");
	        return;
	    }


	    // Obtener cuentas de origen y destino
	    Cuenta cuentaOrigen = controller_cuenta.obtenerCuentaPorNumeroDeCuenta(numeroCuentaOrigen);
	    Cuenta cuentaDestino = controller_cuenta.obtenerCuentaPorNumeroDeCuenta(numeroCuentaDestino1);

	    if (cuentaOrigen != null && cuentaDestino != null) {
	        // Verificar si el monto de transferencia es válido
	        if (montoTransferencia > 0 && montoTransferencia <= 2000000) {
	            String mensaje = "¿Estás seguro de transferir $" + cantidad.getText() + " a la cuenta " + numeroDeCuentaDestino.getText() + "?";
	            int confirmacion = JOptionPane.showConfirmDialog(null, mensaje, "Confirmación de Transferencia", JOptionPane.YES_NO_OPTION);

	            // Mostrar cuadro de diálogo de confirmación
	            if (confirmacion == JOptionPane.YES_OPTION) {
	                // Intentar realizar la transferencia
	                boolean extraccionExitosa = controller_cuenta.extraerSaldo(cuentaOrigen, montoTransferencia);
	                
	                // Verificar si la extracción fue exitosa
	                if (extraccionExitosa) {
	                    // Intentar realizar el depósito
	                    boolean depositoExitoso = controller_cuenta.depositarSaldo(cuentaDestino, montoTransferencia);
	                    
	                    // Verificar si el depósito fue exitoso
	                    if (depositoExitoso) {
	                        // Crear transacción de transferencia origen
	                        Transaccion transaccionOrigen = new Transaccion();
	                        transaccionOrigen.setMonto(montoTransferencia);
	                        transaccionOrigen.setCuentaId(cuentaOrigen.getId()); // Usar cuenta origen para identificar la transacción
	                        transaccionOrigen.setTipo(TipoTransaccion.TRANSFENCIA_ORIGEN);
	                        // Generar transacción ORIGEN
	                        controller_transaccion.generarTransaccion(transaccionOrigen);

	                        // Crear transacción de transferencia destino
	                        Transaccion transaccionDestino = new Transaccion();
	                        transaccionDestino.setMonto(montoTransferencia);
	                        transaccionDestino.setCuentaId(cuentaDestino.getId()); // Usar cuenta destino para identificar la transacción
	                        transaccionDestino.setTipo(TipoTransaccion.TRANFERENCIA_DESTINO);
	                        // Generar transacción DESTINO
	                        controller_transaccion.generarTransaccion(transaccionDestino);

	                        // Mostrar mensaje de éxito
	                        JOptionPane.showMessageDialog(null, "Transferencia exitosa");
	                        OperacionExitosa frame = new OperacionExitosa(cantidad.getText(), TipoTransaccion.TRANFERENCIA.toString());
	                        frame.numeroDeCuentaOperacionExitosa = numeroDeCuentaTranferir;
	                        frame.setVisible(true);
	                        // Cerrar la ventana actual (si es necesario)
	                        dispose();
	                    } else {
	                        JOptionPane.showMessageDialog(null, "No se pudo completar la transferencia. El depósito falló.");
	                    }
	                } else {
	                    JOptionPane.showMessageDialog(null, "No se pudo completar la transferencia. La extracción falló.");
	                }
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "El monto de transferencia debe ser un valor entre 1 y 2,000,000.");
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "La cuenta destino no se encontro.");
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
				
				
				
				
				transferir(numeroDeCuentaTranferir);
				
				

		       
				
				
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
		
				// se cancela la operación
				OperacionCancelada frame = new OperacionCancelada(TipoTransaccion.TRANFERENCIA.toString());
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
