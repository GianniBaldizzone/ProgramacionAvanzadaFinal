package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ABMCuenta extends JFrame {

	private JPanel contentPane;
	
	private JButton btnNewButton;
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
	public ABMCuenta() {
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
		
		lblNewLabel_3 = new JLabel("ABM Cuenta testing");
		lblNewLabel_3.setBounds(107, 38, 291, 33);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("KG Red Hands", Font.PLAIN, 25));
		
		btnNewButton = new JButton("Volver al Login");
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton.setBounds(658, 38, 191, 63);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton(" Baja Cuenta");
		btnNewButton_1.setBackground(new Color(0, 128, 255));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				BajaCuenta frame = new BajaCuenta();
				frame.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(29, 281, 256, 63);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton(" Mostrar Cuentas");
		btnNewButton_2.setBackground(new Color(0, 128, 255));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MostrarCuentas frame = new MostrarCuentas();
				frame.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_2.setBounds(29, 388, 256, 63);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("Alta Cuenta");
		btnNewButton_4.setBackground(new Color(0, 128, 255));
		btnNewButton_4.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AltaCuenta frame = new AltaCuenta();
				frame.setVisible(true);
				
			}
		});
		btnNewButton_4.setBounds(29, 168, 256, 63);
		panel.add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Index.class.getResource("/Iconos/city.png")));
		lblNewLabel.setBounds(606, 0, 296, 506);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Seleccione que operaci\u00F3n desea realizar");
		lblNewLabel_1.setFont(new Font("KG Red Hands", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(107, 100, 489, 27);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Index.class.getResource("/Iconos/favicon.png")));
		lblNewLabel_2.setBounds(29, 38, 45, 30);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton_4_1 = new JButton("Alta Usuario");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Alta usuario
			}
		});
		btnNewButton_4_1.setForeground(Color.WHITE);
		btnNewButton_4_1.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton_4_1.setBackground(new Color(0, 128, 255));
		btnNewButton_4_1.setBounds(318, 168, 257, 63);
		panel.add(btnNewButton_4_1);
		
		JButton btnNewButton_1_1 = new JButton("Baja Usuario");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton_1_1.setBackground(new Color(0, 128, 255));
		btnNewButton_1_1.setBounds(318, 281, 257, 63);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_2_1 = new JButton("Mostrar Usuarios");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Modificar usuario
			}
		});
		btnNewButton_2_1.setForeground(Color.WHITE);
		btnNewButton_2_1.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton_2_1.setBackground(new Color(0, 128, 255));
		btnNewButton_2_1.setBounds(318, 388, 257, 63);
		panel.add(btnNewButton_2_1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login frame = new Login();
				frame.setVisible(true);
				
			}
		});

	}

}
