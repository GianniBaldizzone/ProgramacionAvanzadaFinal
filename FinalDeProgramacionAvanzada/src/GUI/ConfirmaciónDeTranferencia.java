package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class ConfirmaciónDeTranferencia extends JFrame {

	private JPanel contentPane;
    private String Monto;
    private String CuentaDestinatario;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfirmaciónDeTranferencia frame = new ConfirmaciónDeTranferencia();
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
	public ConfirmaciónDeTranferencia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ConfirmaciónDeTranferencia.class.getResource("/Iconos/city.png")));
		lblNewLabel.setBounds(500, 0, 296, 477);
		contentPane.add(lblNewLabel);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setForeground(Color.WHITE);
		btnConfirmar.setFont(new Font("Arial", Font.BOLD, 16));
		btnConfirmar.setBackground(new Color(0, 255, 0));
		btnConfirmar.setBounds(78, 298, 107, 42);
		contentPane.add(btnConfirmar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 16));
		btnCancelar.setBackground(new Color(255, 0, 0));
		btnCancelar.setBounds(295, 298, 98, 42);
		contentPane.add(btnCancelar);
		
		JLabel lblNewLabel_1 = new JLabel("Confirma los datos ingresados");
		lblNewLabel_1.setFont(new Font("KG Red Hands", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(92, 97, 489, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(ConfirmaciónDeTranferencia.class.getResource("/Iconos/favicon.png")));
		lblNewLabel_2_1.setBounds(30, 35, 45, 30);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel CuentaDestinatario = new JLabel("Cuenta destinatario: <dynamic>");
		CuentaDestinatario.setFont(new Font("Arial", Font.BOLD, 20));
		CuentaDestinatario.setBounds(92, 165, 398, 27);
		contentPane.add(CuentaDestinatario);
		
		JLabel Monto = new JLabel("Monto: <dynamic>");
		Monto.setFont(new Font("Arial", Font.BOLD, 20));
		Monto.setBounds(92, 212, 283, 27);
		contentPane.add(Monto);
	}

}
