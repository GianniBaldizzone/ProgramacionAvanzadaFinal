package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.Controller_Cuenta;
import Controllers.Controller_DataBase;
import Controllers.Controller_Transaccion;
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
        lblNewLabel_1.setBounds(101, 97, 489, 27);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2_1 = new JLabel("");
        lblNewLabel_2_1.setIcon(new ImageIcon(ConsultarSaldoOperacion.class.getResource("/Iconos/favicon.png")));
        lblNewLabel_2_1.setBounds(30, 35, 45, 30);
        contentPane.add(lblNewLabel_2_1);

        JLabel Saldo = new JLabel("Saldo");
        Saldo.setFont(new Font("Arial", Font.BOLD, 25));
        Saldo.setBounds(159, 166, 156, 49);
        contentPane.add(Saldo);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	// se cancela la operación
				OperacionCancelada frame = new OperacionCancelada(TipoTransaccion.CONSULTAR_SALDO.toString());
                frame.numeroDeCuentaOperacionCancelada = numeroDeCuentaConsultarSaldo;
                frame.setVisible(true);
                dispose();
            }
        });
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setFont(new Font("Arial", Font.PLAIN, 20));
        btnCancelar.setBackground(Color.RED);
        btnCancelar.setBounds(570, 35, 162, 63);
        contentPane.add(btnCancelar);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(ConsultarSaldoOperacion.class.getResource("/Iconos/city.png")));
        lblNewLabel.setBounds(500, 0, 296, 477);
        contentPane.add(lblNewLabel);

        conexion = new Controller_DataBase();
        controllerCuenta = new Controller_Cuenta(conexion.conectar());
        

        // Obtener y mostrar el saldo al iniciar el JFrame
        System.out.println(numeroDeCuentaConsultarSaldo);
        double saldo = controllerCuenta.consultarSaldo(numeroDeCuentaConsultarSaldo);
        Saldo.setText("$" + saldo);

        JButton btnConfirmar = new JButton("Confirmar");
        btnConfirmar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes agregar código para ir a la operación exitosa
                OperacionExitosa frame = new OperacionExitosa(String.valueOf(saldo), "Consulta de Saldo");
                frame.numeroDeCuentaOperacionExitosa = numeroDeCuentaConsultarSaldo;
                frame.setVisible(true);
                dispose();
                // Cierra este JFrame después de abrir la operación exitosa
            }
        });
        btnConfirmar.setForeground(Color.WHITE);
        btnConfirmar.setFont(new Font("Arial", Font.BOLD, 16));
        btnConfirmar.setBackground(new Color(0, 255, 0));
        btnConfirmar.setBounds(175, 258, 123, 42);
        contentPane.add(btnConfirmar);
    }
}

