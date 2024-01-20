package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import javax.swing.JLabel;
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
	private JLabel lbl_usuario;
	private JLabel lbl_contraseña;
	private JLabel lblNewLabel_3;
	
	

	public void setearNombre(String usuario) {
		lbl_usuario.setText(usuario);
	}

	

	public void setearContraseña(String contrasena) {
		lbl_contraseña.setText(contrasena);
	}
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index frame = new Index();
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
		
		btnNewButton = new JButton("Volver");
		btnNewButton.setBounds(84, 150, 187, 85);
		btnNewButton.setIcon(null);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login frame = new Login();
				frame.setVisible(true);
				
			}
		});
		contentPane.add(btnNewButton);
		
		lbl_usuario = new JLabel("Usuario");
		lbl_usuario.setForeground(new Color(0, 0, 255));
		lbl_usuario.setFont(new Font("KG Red Hands", Font.PLAIN, 25));
		lbl_usuario.setBounds(449, 169, 231, 33);
		contentPane.add(lbl_usuario);
		
		lbl_contraseña = new JLabel("Contrase\u00F1a");
		lbl_contraseña.setBackground(Color.MAGENTA);
		lbl_contraseña.setForeground(Color.MAGENTA);
		lbl_contraseña.setFont(new Font("KG Red Hands", Font.PLAIN, 25));
		lbl_contraseña.setBounds(449, 234, 162, 48);
		contentPane.add(lbl_contraseña);
		
		lblNewLabel_3 = new JLabel("Bienvenido");
		lblNewLabel_3.setFont(new Font("KG Red Hands", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(449, 97, 231, 33);
		contentPane.add(lblNewLabel_3);

	}

}
