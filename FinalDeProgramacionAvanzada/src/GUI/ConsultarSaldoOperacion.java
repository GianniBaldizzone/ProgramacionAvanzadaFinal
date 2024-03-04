package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.Controller_Cuenta;
import Controllers.Controller_DataBase;
import Controllers.Controller_Transaccion;
import Controllers.Controller_Usuario;
import Modelo.TipoTransaccion;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultarSaldoOperacion extends JFrame {

    private JPanel contentPane;
    int numeroDeCuentaConsultarSaldo;
    private Controller_DataBase conexion;
    private Controller_Cuenta controllerCuenta;

    /**
     * Launch the application.
     */
   

    /**
     * Create the frame.
     */
    public ConsultarSaldoOperacion(int numeroDeCuentaAConsultar) {
    	
    	 this.numeroDeCuentaConsultarSaldo = numeroDeCuentaAConsultar;
    	
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Saldo disponible en cuenta");
        lblNewLabel_1.setFont(new Font("KG Red Hands", Font.PLAIN, 18));
        lblNewLabel_1.setBounds(99, 112, 489, 27);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2_1 = new JLabel("");
        lblNewLabel_2_1.setIcon(new ImageIcon(ConsultarSaldoOperacion.class.getResource("/Iconos/favicon.png")));
        lblNewLabel_2_1.setBounds(30, 35, 45, 30);
        contentPane.add(lblNewLabel_2_1);

        JLabel Saldo = new JLabel("Saldo");
        Saldo.setFont(new Font("Arial", Font.BOLD, 25));
        Saldo.setBounds(159, 206, 156, 49);
        contentPane.add(Saldo);

        JButton btnCancelar = new JButton("Seguir operando");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	dispose();
	    		Index frame = new Index();
	    		frame.setVisible(true);
	    		conexion = new Controller_DataBase();
	    		Controller_Usuario usuariocontroller = new Controller_Usuario(conexion.conectar());
		        String nombreUsuario = null;
				try {
					nombreUsuario = usuariocontroller.obtenerNombreUsuario(numeroDeCuentaConsultarSaldo);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        
	    		
	    		frame.lbl_usuario.setText(nombreUsuario);
		        frame.numeroDeCuenta = numeroDeCuentaConsultarSaldo;
            }
        });
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setFont(new Font("Arial", Font.PLAIN, 20));
        btnCancelar.setBackground(new Color(0, 221, 0));
        btnCancelar.setBounds(527, 108, 229, 63);
        contentPane.add(btnCancelar);

        conexion = new Controller_DataBase();
        controllerCuenta = new Controller_Cuenta(conexion.conectar());
        

        // Obtener y mostrar el saldo al iniciar el JFrame
        System.out.println(numeroDeCuentaConsultarSaldo);
        double saldo = controllerCuenta.consultarSaldo(numeroDeCuentaConsultarSaldo);
        Saldo.setText("$" + saldo);
        
        JButton btnCerraSesion = new JButton("Cerra sesion");
        btnCerraSesion.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		
        		dispose();
				Login frame = new Login();
				frame.setVisible(true);
        		
        	}
        });
        btnCerraSesion.setForeground(Color.WHITE);
        btnCerraSesion.setFont(new Font("Arial", Font.PLAIN, 20));
        btnCerraSesion.setBackground(Color.RED);
        btnCerraSesion.setBounds(527, 23, 229, 63);
        contentPane.add(btnCerraSesion);
        
                JLabel lblNewLabel = new JLabel("");
                lblNewLabel.setIcon(new ImageIcon(ConsultarSaldoOperacion.class.getResource("/Iconos/city.png")));
                lblNewLabel.setBounds(500, 0, 296, 477);
                contentPane.add(lblNewLabel);
    }
}

