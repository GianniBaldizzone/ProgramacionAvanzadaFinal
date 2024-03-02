package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.Controller_DataBase;
import Controllers.Controller_Usuario;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OperacionCancelada extends JFrame {

	private JPanel contentPane;
    private String valor;
    private String operacion;
    int numeroDeCuentaOperacionCancelada;
    private Controller_DataBase conexion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OperacionCancelada frame = new OperacionCancelada("");
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
	public OperacionCancelada(String tipoDeTransaccion) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Operaci\u00F3n cancelada");
		lblNewLabel_1.setFont(new Font("KG Red Hands", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(143, 72, 221, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblOperacion = new JLabel("Operaci\u00F3n: " + tipoDeTransaccion);
		lblOperacion.setFont(new Font("Arial", Font.BOLD, 20));
		lblOperacion.setBounds(139, 372, 283, 27);
		contentPane.add(lblOperacion);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(OperacionCancelada.class.getResource("/Iconos/favicon.png")));
		lblNewLabel_2_1.setBounds(37, 43, 45, 30);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(OperacionCancelada.class.getResource("/Iconos/cancel1_77976 1.png")));
		lblNewLabel_2.setBounds(152, 120, 200, 210);
		contentPane.add(lblNewLabel_2);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
	    		Index frame = new Index();
	    		frame.setVisible(true);
	    		conexion = new Controller_DataBase();
	    		Controller_Usuario usuariocontroller = new Controller_Usuario(conexion.conectar());
		        String nombreUsuario = null;
				try {
					nombreUsuario = usuariocontroller.obtenerNombreUsuario(numeroDeCuentaOperacionCancelada);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        
	    		
	    		frame.lbl_usuario.setText(nombreUsuario);
		        frame.numeroDeCuenta = numeroDeCuentaOperacionCancelada;
				
				
			}
		});
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setFont(new Font("Arial", Font.PLAIN, 20));
		btnVolver.setBackground(Color.RED);
		btnVolver.setBounds(577, 29, 162, 63);
		contentPane.add(btnVolver);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(OperacionCancelada.class.getResource("/Iconos/city.png")));
		lblNewLabel.setBounds(529, 0, 257, 473);
		contentPane.add(lblNewLabel);
	}

}
