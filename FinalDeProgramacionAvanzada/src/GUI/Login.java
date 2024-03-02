package GUI;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.Controller_Cuenta;
import Controllers.Controller_DataBase;
import Controllers.Controller_Usuario;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JMenuBar;
import javax.swing.ImageIcon;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtIngreseNumeroDe;
	
	private int numero_de_cuenta;
	private int pin;
	private JPasswordField textField;
	private Controller_DataBase conexion;
	
	
	
	private void ingresar() {
	    conexion = new Controller_DataBase();
	    Controller_Cuenta cuentaController = new Controller_Cuenta(conexion.conectar());
	    
	    // Leer valores de los JTextField
	    String numeroCuentaTexto = txtIngreseNumeroDe.getText().trim(); // Trim para eliminar espacios en blanco
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
	    
	    if (numeroCuentaTexto.length() > 10 || pinTexto.length() > 10) {
	        JOptionPane.showMessageDialog(null, "Has ingresado una cantidad incorrecta para estos campos, prueba nuevamente.");
	        return; // Salir del método si los campos contienen más de 10 dígitos
	    }

	    
	    // Convertir los valores de texto a int
	    int numero_de_cuenta = Integer.parseInt(numeroCuentaTexto);
	    int pin = Integer.parseInt(pinTexto);
	   
	    if (cuentaController.autenticar(numero_de_cuenta, pin)) {
	        JOptionPane.showMessageDialog(null, "Autenticación exitosa !!!");
	        
	        Controller_Usuario usuariocontroller = new Controller_Usuario(conexion.conectar());
	        String nombreUsuario = null;
			try {
				nombreUsuario = usuariocontroller.obtenerNombreUsuario(numero_de_cuenta);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        // Se cierra el Login
	        dispose();
	        
	        // Se abre el Index con los datos de la cuenta
	        Index frame = new Index();
	        frame.setVisible(true);
	        
	        // Asignar el nombre del usuario al lbl_usuario en el Index
	        frame.lbl_usuario.setText(nombreUsuario);
	        frame.numeroDeCuenta = numero_de_cuenta;
	        
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
		
		// Obtener el tamaño de la pantalla
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        // Calcular la ubicación central para la ventana
        int centerX = (screenSize.width - 902) / 2;
        int centerY = (screenSize.height - 528) / 2;
        
        // Establecer la ubicación de la ventana
        setLocation(centerX, centerY);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(centerX, centerY, 902, 528);

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 528);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		
		
		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton.setIcon(null);
		btnNewButton.setBounds(72, 342, 98, 42);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ingresar();

				
			}
		});
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Banco Davinci");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel_2.setBounds(657, 270, 184, 36);
		contentPane.add(lblNewLabel_2);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 128, 255));
		contentPane.add(btnNewButton);
		
		txtIngreseNumeroDe = new JTextField();
		txtIngreseNumeroDe.setForeground(new Color(192, 192, 192));
		txtIngreseNumeroDe.setBounds(72, 183, 408, 36);
		contentPane.add(txtIngreseNumeroDe);
		txtIngreseNumeroDe.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Iniciar sesi\u00F3n");
		lblNewLabel.setBounds(72, 103, 267, 42);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 27));
		contentPane.add(lblNewLabel);
		
		textField = new JPasswordField();
		textField.setBounds(72, 270, 408, 36);
		contentPane.add(textField);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/Iconos/logo.png")));
		lblNewLabel_1.setBounds(664, 110, 163, 150);
		contentPane.add(lblNewLabel_1);
		
		JLabel city = new JLabel("");
		city.setBounds(599, 0, 329, 491);
		city.setIcon(new ImageIcon(Login.class.getResource("/Iconos/city.png")));
		contentPane.add(city);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Login.class.getResource("/Iconos/favicon.png")));
		lblNewLabel_3.setBounds(72, 44, 45, 36);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2_1 = new JLabel("Banco Davinci");
		lblNewLabel_2_1.setForeground(new Color(0, 109, 219));
		lblNewLabel_2_1.setFont(new Font("Impact", Font.PLAIN, 25));
		lblNewLabel_2_1.setBounds(127, 44, 184, 36);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_4 = new JLabel("Numero de cuenta");
		lblNewLabel_4.setBounds(72, 155, 105, 18);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Numero de pin");
		lblNewLabel_5.setBounds(72, 247, 85, 13);
		contentPane.add(lblNewLabel_5);
	}
}
