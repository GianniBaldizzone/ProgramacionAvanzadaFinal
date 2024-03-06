package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controllers.Controller_Cuenta;
import Controllers.Controller_DataBase;
import Controllers.Controller_Usuario;
import Modelo.Cuenta;
import Modelo.CuentaAhorro;
import Modelo.CuentaCorriente;

public class BajaCuenta extends JFrame {

	 private JPanel contentPane;
	    private JTextField numeroDeCuentaAEliminar;

	    private void realizarBajaCuenta() {
	        Controller_DataBase conexion = new Controller_DataBase();
	        Controller_Cuenta cuentaController = new Controller_Cuenta(conexion.conectar());
	        Controller_Usuario usuarioController = new Controller_Usuario(conexion.conectar());

	        if (numeroDeCuentaAEliminar.getText().isEmpty()) {
	            JOptionPane.showMessageDialog(null, "Por favor complete ambos campos.");
	            return;
	        }

	        // Verificar si los valores ingresados son números enteros
	        if (!numeroDeCuentaAEliminar.getText().matches("\\d+")) {
	            JOptionPane.showMessageDialog(null, "Por favor ingrese un valor numérico válido para ambos campos.");
	            return;
	        }

	        // Verificar si los valores ingresados no superan los 10 dígitos
	        if (numeroDeCuentaAEliminar.getText().length() > 10) {
	            JOptionPane.showMessageDialog(null, "Cantidad de dígitos incorrecta no puedes superar los 10.");
	            return;
	        }

	        int NumeroDeCuentaInt = Integer.parseInt(numeroDeCuentaAEliminar.getText());

	        Cuenta cuenta = cuentaController.obtenerCuentaPorNumeroDeCuenta(NumeroDeCuentaInt);
	        

	        if (cuenta  == null) {
	            JOptionPane.showMessageDialog(null, "No se encontró ninguna cuenta con el numero de cuenta ingresado.");
	            return;
	        }

	        
	        

	        // Intentar agregar la cuenta
	        if (cuentaController.bajaCuenta(cuenta.getId())) {
	            JOptionPane.showMessageDialog(null, "Se ha eliminado la cuenta correctamente.");
	            dispose();
	            ABMCuenta frame = new ABMCuenta();
	            frame.setVisible(true);
	        } else {
	            JOptionPane.showMessageDialog(null, "Error al eliminar la cuenta.");
	        }
	    }

	    public BajaCuenta() {
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 800, 500);
	        contentPane = new JPanel();
	        contentPane.setBackground(new Color(255, 255, 255));
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	        setContentPane(contentPane);
	        contentPane.setLayout(null);

	        JLabel lblNewLabel_2 = new JLabel("");
	        lblNewLabel_2.setIcon(new ImageIcon(ExtraerOperacion.class.getResource("/Iconos/favicon.png")));
	        lblNewLabel_2.setBounds(33, 32, 45, 30);
	        contentPane.add(lblNewLabel_2);

	        JLabel lblNewLabel_1 = new JLabel("Ingrese los datos de la cuenta a eliminar");
	        lblNewLabel_1.setForeground(new Color(0, 128, 255));
	        lblNewLabel_1.setBackground(new Color(255, 255, 255));
	        lblNewLabel_1.setFont(new Font("KG Red Hands", Font.PLAIN, 18));
	        lblNewLabel_1.setBounds(82, 89, 489, 27);
	        contentPane.add(lblNewLabel_1);

	        JButton btnCancelar = new JButton("Volver");
	        btnCancelar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                ABMCuenta frame = new ABMCuenta();
	                frame.setVisible(true);
	                dispose();
	            }
	        });
	        btnCancelar.setForeground(Color.WHITE);
	        btnCancelar.setFont(new Font("Arial", Font.PLAIN, 20));
	        btnCancelar.setBackground(Color.RED);
	        btnCancelar.setBounds(597, 27, 162, 63);
	        contentPane.add(btnCancelar);

	        numeroDeCuentaAEliminar = new JTextField();
	        numeroDeCuentaAEliminar.setColumns(10);
	        numeroDeCuentaAEliminar.setBounds(82, 208, 224, 39);
	        contentPane.add(numeroDeCuentaAEliminar);

	        JButton btnAlta = new JButton("Baja");
	        btnAlta.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                
	                realizarBajaCuenta();
	            }
	        });
	        btnAlta.setForeground(new Color(255, 255, 255));
	        btnAlta.setFont(new Font("Arial", Font.PLAIN, 20));
	        btnAlta.setBackground(new Color(255, 0, 0));
	        btnAlta.setBounds(82, 291, 122, 48);
	        contentPane.add(btnAlta);

	        JLabel lblNewLabel = new JLabel("");
	        lblNewLabel.setIcon(new ImageIcon(AltaCuenta.class.getResource("/Iconos/city.png")));
	        lblNewLabel.setBounds(562, 0, 224, 463);
	        contentPane.add(lblNewLabel);
	        
	        JLabel lblNewLabel_1_1 = new JLabel("Numero de cuenta");
	        lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
	        lblNewLabel_1_1.setFont(new Font("KG Red Hands", Font.PLAIN, 15));
	        lblNewLabel_1_1.setBackground(Color.WHITE);
	        lblNewLabel_1_1.setBounds(82, 165, 489, 27);
	        contentPane.add(lblNewLabel_1_1);
	    }

	    public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                    AltaCuenta frame = new AltaCuenta();
	                    frame.setVisible(true);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	    }

}
