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

public class OperacionExitosa extends JFrame {

	private JPanel contentPane;
    private String valor;
    private String operacion;
    int numeroDeCuentaOperacionExitosa;
    private Controller_DataBase conexion;
	
	
	
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OperacionExitosa(String valor, String operacion) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(OperacionExitosa.class.getResource("/Iconos/favicon.png")));
		lblNewLabel_2_1.setBounds(53, 38, 45, 30);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1 = new JLabel("Operaci\u00F3n exitosa");
		lblNewLabel_1.setFont(new Font("KG Red Hands", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(210, 89, 196, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(OperacionExitosa.class.getResource("/Iconos/tilde.png")));
		lblNewLabel_2.setBounds(205, 133, 201, 200);
		contentPane.add(lblNewLabel_2);
		
		  JLabel lblOperacion = new JLabel("Operación: " + operacion);
		    lblOperacion.setFont(new Font("Arial", Font.BOLD, 20));
		    lblOperacion.setBounds(196, 358, 283, 27);
		    contentPane.add(lblOperacion);

		    JLabel lblValor = new JLabel("Valor: "+valor + " $");
		    lblValor.setForeground(new Color(47, 255, 17));
		    lblValor.setFont(new Font("Arial", Font.BOLD, 20));
		    lblValor.setBounds(196, 384, 243, 44);
		    contentPane.add(lblValor);
		    
		    JButton btnVolver = new JButton("Seguir operando");
		    btnVolver.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		
		    		dispose();
		    		Index frame = new Index();
		    		frame.setVisible(true);
		    		conexion = new Controller_DataBase();
		    		Controller_Usuario usuariocontroller = new Controller_Usuario(conexion.conectar());
			        String nombreUsuario = null;
					try {
						nombreUsuario = usuariocontroller.obtenerNombreUsuario(numeroDeCuentaOperacionExitosa);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			        
		    		
		    		frame.lbl_usuario.setText(nombreUsuario);
			        frame.numeroDeCuenta = numeroDeCuentaOperacionExitosa;
		    		
		    	}
		    });
		    btnVolver.setForeground(Color.WHITE);
		    btnVolver.setFont(new Font("Arial", Font.PLAIN, 20));
		    btnVolver.setBackground(new Color(0, 221, 0));
		    btnVolver.setBounds(564, 117, 212, 63);
		    contentPane.add(btnVolver);
		    
		    JButton btnCerraSesion_1 = new JButton("Cerra sesion");
		    btnCerraSesion_1.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		
		    		dispose();
					Login frame = new Login();
					frame.setVisible(true);
	        		
					
		    	}
		    });
		    btnCerraSesion_1.setForeground(Color.WHITE);
		    btnCerraSesion_1.setFont(new Font("Arial", Font.PLAIN, 20));
		    btnCerraSesion_1.setBackground(Color.RED);
		    btnCerraSesion_1.setBounds(564, 26, 212, 63);
		    contentPane.add(btnCerraSesion_1);
		    
		    JLabel lblNewLabel = new JLabel("");
		    lblNewLabel.setIcon(new ImageIcon(OperacionExitosa.class.getResource("/Iconos/city.png")));
		    lblNewLabel.setBounds(541, 0, 255, 463);
		    contentPane.add(lblNewLabel);
	}

}
