package GUI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Conexion;

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

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	
	private String nombre;
	private String contraseña;
	private JLabel lbl_error;
	private JPasswordField textField;
	private Conexion conexion;
	
	
	
	private void ingresar() {
		nombre = textField_1.getText();
        contraseña = textField.getText();
        
        
		if( nombre.isEmpty() ) {
		
			lbl_error.setVisible(true);
        
        
    }else {
    	dispose();
        Index frame = new Index();
        frame.setVisible(true);

        frame.setearNombre(nombre);
        frame.setearContraseña(contraseña);
    }}
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
		
		conexion = new Conexion();
		conexion.conectar();
         
		
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
