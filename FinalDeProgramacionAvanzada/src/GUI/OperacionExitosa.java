package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;

public class OperacionExitosa extends JFrame {

	private JPanel contentPane;
    private String valor;
    private String operacion;
	
	
	


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

		    JLabel lblValor = new JLabel("Valor: <dynamic>$");
		    lblValor.setForeground(new Color(47, 255, 17));
		    lblValor.setFont(new Font("Arial", Font.BOLD, 20));
		    lblValor.setBounds(196, 384, 243, 44);
		    contentPane.add(lblValor);
		    
		    JButton btnVolver = new JButton("Volver");
		    btnVolver.setForeground(Color.WHITE);
		    btnVolver.setFont(new Font("Arial", Font.PLAIN, 20));
		    btnVolver.setBackground(Color.RED);
		    btnVolver.setBounds(614, 21, 162, 63);
		    contentPane.add(btnVolver);
		    
		    JLabel lblNewLabel = new JLabel("");
		    lblNewLabel.setIcon(new ImageIcon(OperacionExitosa.class.getResource("/Iconos/city.png")));
		    lblNewLabel.setBounds(600, 0, 196, 463);
		    contentPane.add(lblNewLabel);
	}

}
