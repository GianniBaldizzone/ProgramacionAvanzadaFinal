package GUI;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.Controller_Cuenta;
import Controllers.Controller_DataBase;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JMenuBar;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	
	private int numero_de_cuenta;
	private int pin;
	private JLabel lbl_error;
	private JPasswordField textField;
	private Controller_DataBase conexion;
	
	
	
	private void ingresar() {
	    conexion = new Controller_DataBase();
	    Controller_Cuenta cuentaController = new Controller_Cuenta(conexion.conectar());
	    
	    // Leer valores de los JTextField
	    String numeroCuentaTexto = textField_1.getText().trim(); // Trim para eliminar espacios en blanco
	    String pinTexto = textField.getText().trim(); // Trim para eliminar espacios en blanco
	    
	    // Validar que los campos no estén vacíos
	    if (numeroCuentaTexto.isEmpty() || pinTexto.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
	        return; // Salir del método si los campos están vacíos
	    }
	    
	    // Validar que los campos contengan solo números
	    if (!numeroCuentaTexto.matches("\\d+") || !pinTexto.matches("\\d+")) {
	        JOptionPane.showMessageDialog(null, "Por favor, ingrese solo números válidos.");
	        return; // Salir del método si los campos no contienen solo números
	    }
	    
	    // Convertir los valores de texto a int
	    int numero_de_cuenta = Integer.parseInt(numeroCuentaTexto);
	    int pin = Integer.parseInt(pinTexto);
	   
	    if (cuentaController.autenticar(numero_de_cuenta, pin)) {
	        JOptionPane.showMessageDialog(null, "Autenticación exitosa !!!");
	        // se cierra el Login y se abre el index con los datos de la cuenta
	        dispose();
	        Index frame = new Index();
	        frame.setVisible(true);
	        
	    } else {
	        JOptionPane.showMessageDialog(null, "Autenticación fallida, revise el número de cuenta o el PIN !!!");
	    }
	}
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 528);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ingresar();

				
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(new Color(0, 255, 64));
		btnNewButton.setBounds(393, 281, 98, 42);
		contentPane.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(334, 166, 218, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("KG Red Hands", Font.PLAIN, 30));
		lblNewLabel.setBounds(400, 102, 121, 42);
		contentPane.add(lblNewLabel);
		
		lbl_error = new JLabel("Usuario o contrase\u00F1a no ingresados");
		lbl_error.setForeground(Color.RED);
		lbl_error.setBounds(361, 257, 177, 13);
		lbl_error.setVisible(false);
		contentPane.add(lbl_error);
		
		textField = new JPasswordField();
		textField.setBounds(334, 215, 218, 28);
		contentPane.add(textField);
	}
}
