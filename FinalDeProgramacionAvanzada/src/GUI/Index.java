package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Index extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	JLabel lbl_usuario;
	int numeroDeCuenta;
	private JLabel lblNewLabel_3;
	
	


	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index index = new Index();
					index.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Index() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 906, 543);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("DNI");
		model.addColumn("Rol");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 892, 506);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel_3 = new JLabel("Bienvenido/a");
		lblNewLabel_3.setBounds(107, 38, 178, 33);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("KG Red Hands", Font.PLAIN, 25));
		
		btnNewButton = new JButton("Cerrar sesi\u00F3n");
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton.setBounds(688, 27, 162, 63);
		panel.add(btnNewButton);
		
		lbl_usuario = new JLabel("Usuario");
		lbl_usuario.setBounds(307, 38, 231, 33);
		panel.add(lbl_usuario);
		lbl_usuario.setForeground(new Color(38, 217, 65));
		lbl_usuario.setFont(new Font("KG Red Hands", Font.PLAIN, 25));
		
		JButton btnNewButton_1 = new JButton("Deposito");
		btnNewButton_1.setBackground(new Color(38, 217, 65));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				DepositarOperacion frame = new DepositarOperacion();
				frame.setVisible(true);
				frame.numeroDeCuentaDepositar = numeroDeCuenta;
				
			}
		});
		btnNewButton_1.setBounds(374, 288, 194, 63);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Tranferencia");
		btnNewButton_2.setBackground(new Color(38, 217, 65));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				TranferirOperacion frame = new TranferirOperacion();
				frame.setVisible(true);
				frame.numeroDeCuentaTranferir = numeroDeCuenta;
				
			}
		});
		btnNewButton_2.setBounds(374, 392, 194, 63);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Consultar saldo");
		btnNewButton_3.setBackground(new Color(38, 217, 65));
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
		        ConsultarSaldoOperacion frame = new ConsultarSaldoOperacion(numeroDeCuenta);
		        frame.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(99, 288, 240, 63);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Extracci\u00F3n");
		btnNewButton_4.setBackground(new Color(38, 217, 65));
		btnNewButton_4.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ExtraerOperacion frame = new ExtraerOperacion();
				frame.setVisible(true);
				frame.numeroDeCuentaExtraer = numeroDeCuenta;
				
			}
		});
		btnNewButton_4.setBounds(374, 180, 184, 63);
		panel.add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Index.class.getResource("/Iconos/city.png")));
		lblNewLabel.setBounds(640, 0, 262, 506);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_5 = new JButton("Movimientos");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				UltimosMovimientosOperacion frame = new UltimosMovimientosOperacion(numeroDeCuenta);
		        frame.setVisible(true);
			}
		});
		btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.setBackground(new Color(38, 217, 65));
		btnNewButton_5.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton_5.setBounds(99, 180, 240, 63);
		panel.add(btnNewButton_5);
		
		JLabel lblNewLabel_1 = new JLabel("Seleccione que operaci\u00F3n desea realizar");
		lblNewLabel_1.setFont(new Font("KG Red Hands", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(107, 100, 489, 27);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Index.class.getResource("/Iconos/favicon.png")));
		lblNewLabel_2.setBounds(29, 38, 45, 30);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton_3_1 = new JButton("Modificar pin");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ModificarPinOperacion frame = new ModificarPinOperacion();
				frame.setVisible(true);
				frame.numeroDeCuentaPinNuevo = numeroDeCuenta;
				
			}
		});
		btnNewButton_3_1.setForeground(Color.WHITE);
		btnNewButton_3_1.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton_3_1.setBackground(new Color(38, 217, 65));
		btnNewButton_3_1.setBounds(99, 392, 240, 63);
		panel.add(btnNewButton_3_1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login frame = new Login();
				frame.setVisible(true);
				
			}
		});

	}
}
