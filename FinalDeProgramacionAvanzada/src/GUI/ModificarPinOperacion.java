package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.Controller_Cuenta;
import Controllers.Controller_DataBase;
import Controllers.Controller_Transaccion;
import Controllers.Controller_Usuario;
import Modelo.Cuenta;
import Modelo.TipoTransaccion;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarPinOperacion extends JFrame {

	private JPanel contentPane;
	private JTextField pinActual;
	private JTextField pinNuevo;
		private Controller_DataBase conexion;
	int numeroDeCuentaPinNuevo;
	
	
	public void modificarPin() {
	    conexion = new Controller_DataBase();
	    Controller_Cuenta controller_cuenta = new Controller_Cuenta(conexion.conectar());

	    // Verificar que ambos campos estén completados
	    if (pinActual.getText().isEmpty() || pinNuevo.getText().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Por favor complete ambos campos.");
	        return;
	    }

	    // Verificar si los valores ingresados son números enteros
	    try {
	        int pinActualInt = Integer.parseInt(pinActual.getText());
	        int pinNuevoInt = Integer.parseInt(pinNuevo.getText());

	        // Verificar si los valores ingresados no superan los 10 dígitos
	        if (pinActual.getText().length() > 4 || pinNuevo.getText().length() > 4) {
	            JOptionPane.showMessageDialog(null, "El número de pin debe tener 4 dígitos.");
	            return;
	        }

	        int numero_de_cuenta = numeroDeCuentaPinNuevo;
	        Cuenta cuenta = controller_cuenta.obtenerCuentaPorNumeroDeCuenta(numeroDeCuentaPinNuevo);

	        if (controller_cuenta.autenticar(numeroDeCuentaPinNuevo, pinActualInt)) {
	            JOptionPane.showMessageDialog(null, "Pin actual ingresado correctamente.");

	            // Mostrar cuadro de diálogo de confirmación
	            String mensaje = "¿Estás seguro de cambiar tu pin de " + pinActualInt + " a " + pinNuevoInt + "?";
	            int confirmacion = JOptionPane.showConfirmDialog(null, mensaje, "Confirmación de cambio de PIN", JOptionPane.YES_NO_OPTION);

	            if (confirmacion == JOptionPane.YES_OPTION) {
	                boolean modificado = controller_cuenta.modificarPin(cuenta.getId(), pinNuevo.getText());
	                if (modificado) {
	                    JOptionPane.showMessageDialog(null, "PIN modificado correctamente.");
	                    
	                    OperacionExitosa frame = new OperacionExitosa(pinNuevo.getText(), "MODIFICAR_PIN");
                        frame.numeroDeCuentaOperacionExitosa = numeroDeCuentaPinNuevo;
                        frame.setVisible(true);
                        // Cerrar la ventana actual
                        dispose();
	                } else {
	                    JOptionPane.showMessageDialog(null, "Error al modificar el PIN.");
	                }
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "El PIN actual no coincide con la cuenta en sesión.");
	        }
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(null, "Por favor ingrese un valor numérico válido para ambos campos.");
	    }
	}
		
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarPinOperacion frame = new ModificarPinOperacion();
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
	public ModificarPinOperacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(ModificarPinOperacion.class.getResource("/Iconos/favicon.png")));
		lblNewLabel_2_1.setBounds(35, 42, 45, 30);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese el pin actual de la cuenta");
		lblNewLabel_1.setFont(new Font("KG Red Hands", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(69, 98, 489, 27);
		contentPane.add(lblNewLabel_1);
		
		pinActual = new JTextField();
		pinActual.setColumns(10);
		pinActual.setBounds(69, 154, 319, 45);
		contentPane.add(pinActual);
		
		pinNuevo = new JTextField();
		pinNuevo.setColumns(10);
		pinNuevo.setBounds(69, 279, 319, 45);
		contentPane.add(pinNuevo);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ingrese el nuevo pin de la cuenta");
		lblNewLabel_1_1.setFont(new Font("KG Red Hands", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(69, 226, 489, 27);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				modificarPin();
			}
		});
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnModificar.setBackground(new Color(0, 128, 255));
		btnModificar.setBounds(69, 365, 122, 48);
		contentPane.add(btnModificar);
		
		JButton btnCancelar = new JButton("Volver");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
	    		Index frame = new Index();
	    		frame.setVisible(true);
	    		conexion = new Controller_DataBase();
	    		Controller_Usuario usuariocontroller = new Controller_Usuario(conexion.conectar());
		        String nombreUsuario = null;
				try {
					nombreUsuario = usuariocontroller.obtenerNombreUsuario(numeroDeCuentaPinNuevo);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        
	    		
	    		frame.lbl_usuario.setText(nombreUsuario);
		        frame.numeroDeCuenta = numeroDeCuentaPinNuevo;
			}
		});
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnCancelar.setBackground(Color.RED);
		btnCancelar.setBounds(584, 42, 162, 63);
		contentPane.add(btnCancelar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ModificarPinOperacion.class.getResource("/Iconos/city.png")));
		lblNewLabel.setBounds(538, 0, 248, 463);
		contentPane.add(lblNewLabel);
	}
}
