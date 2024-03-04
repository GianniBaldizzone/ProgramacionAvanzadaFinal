package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.Controller_Cuenta;
import Controllers.Controller_DataBase;
import Controllers.Controller_Transaccion;
import Controllers.Controller_Usuario;

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
	
	
	/*public void modificarPin() {
		
		
        conexion = new Controller_DataBase();
	    Controller_Cuenta controller_cuenta = new Controller_Cuenta(conexion.conectar());
	    
	    // Verificar que ambos campos estén completados
	    if (pinActualText.getText().isEmpty() || pinNuevoText.getText().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Por favor complete ambos campos.");
	        return;
	    }

	    // Verificar si los valores ingresados son números enteros
	    if (!pinNuevoText.getText().matches("\\d+") || !pinNuevoText.getText().matches("\\d+")) {
	        JOptionPane.showMessageDialog(null, "Por favor ingrese un valor numérico válido para ambos campos.");
	        return;
	    }

	    // Verificar si los valores ingresados no superan los 10 dígitos
	    if (cantidad.getText().length() > 10 || numeroDeCuentaDestino.getText().length() > 10) {
	        JOptionPane.showMessageDialog(null, "El número de cuenta destino y el monto de transferencia deben tener hasta 10 dígitos.");
	        return;
	    }
	    
	    String pinActualText = pinActual.getText();
        String pinNuevoText = pinNuevo.getText();
	    
       
            int pinActualInt = Integer.parseInt(pinActualText);
            
            boolean modificado = controller_cuenta.modificarPin(numeroDeCuentaPinNuevo, pinNuevoText);
            if (modificado) {
                System.out.println("PIN modificado correctamente");
            } else {
                System.out.println("Error al modificar el PIN");
            }
        } else {
            System.out.println("Por favor, complete ambos campos");
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
