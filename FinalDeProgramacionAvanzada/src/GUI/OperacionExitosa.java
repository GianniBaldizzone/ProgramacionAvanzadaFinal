package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class OperacionExitosa extends JFrame {

	private JPanel contentPane;
	private String valor;
	private String operacion;
	

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OperacionExitosa frame = new OperacionExitosa();
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
	public OperacionExitosa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(OperacionExitosa.class.getResource("/Iconos/city.png")));
		lblNewLabel.setBounds(617, 0, 169, 463);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Operaci\u00F3n exitosa");
		lblNewLabel_1.setFont(new Font("KG Red Hands", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(206, 75, 196, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(OperacionExitosa.class.getResource("/Iconos/tilde.png")));
		lblNewLabel_2.setBounds(201, 127, 201, 200);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Has");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_3.setBounds(167, 349, 41, 44);
		contentPane.add(lblNewLabel_3);
		
		JLabel valor = new JLabel();
		valor.setText(getValor());
		valor.setForeground(new Color(47, 255, 17));
		valor.setFont(new Font("Arial", Font.BOLD, 20));
		valor.setBounds(381, 349, 113, 44);
		contentPane.add(valor);
		
		JLabel operacion = new JLabel();
		operacion.setText(getOperacion());
		operacion.setFont(new Font("Arial", Font.BOLD, 20));
		operacion.setBounds(231, 358, 140, 27);
		contentPane.add(operacion);
	}

}
