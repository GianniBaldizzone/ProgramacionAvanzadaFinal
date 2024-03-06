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
import Modelo.TipoTransaccion;
import Modelo.Transaccion;

public class AltaCuenta extends JFrame {

    private JPanel contentPane;
    private JTextField dni;
    private JTextField pin;

    private void realizarAltaCuenta(String tipoCuentaSeleccionado) {
        Controller_DataBase conexion = new Controller_DataBase();
        Controller_Cuenta cuentaController = new Controller_Cuenta(conexion.conectar());
        Controller_Usuario usuarioController = new Controller_Usuario(conexion.conectar());

        if (dni.getText().isEmpty() || pin.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor complete ambos campos.");
            return;
        }

        // Verificar si los valores ingresados son números enteros
        if (!dni.getText().matches("\\d+") || !pin.getText().matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese un valor numérico válido para ambos campos.");
            return;
        }

        // Verificar si los valores ingresados no superan los 10 dígitos
        if (dni.getText().length() > 8 || pin.getText().length() > 4) {
            JOptionPane.showMessageDialog(null, "Cantidad de dígitos incorrecta en alguno de los campos.");
            return;
        }

        int dniInt = Integer.parseInt(dni.getText());

        int idUsuario = usuarioController.obtenerIdUsuarioPorDNI(dniInt);

        if (idUsuario == -1) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún usuario con el DNI ingresado.");
            return;
        }

        Cuenta cuenta;
        if (tipoCuentaSeleccionado.equals("CAJA_DE_AHORRO")) {
            cuenta = new CuentaAhorro(0, 123456789, 0, pin.getText(), idUsuario);
        } else if (tipoCuentaSeleccionado.equals("CUENTA_CORRIENTE")) {
            cuenta = new CuentaCorriente(0, 123456789, 0, pin.getText(), idUsuario);
        } else {
            JOptionPane.showMessageDialog(null, "Tipo de cuenta no válido.");
            return;
        }

        // Intentar agregar la cuenta
        if (cuentaController.altaCuenta(cuenta)) {
            JOptionPane.showMessageDialog(null, "Se ha agregado la cuenta correctamente.");
            dispose();
            ABMCuenta frame = new ABMCuenta();
            frame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Error al agregar la cuenta.");
        }
    }

    public AltaCuenta() {
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

        JLabel lblNewLabel_1 = new JLabel("Ingrese los datos de la cuenta");
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

        JComboBox<String> comboBoxTipoCuenta = new JComboBox<>();
        comboBoxTipoCuenta.addItem("CAJA_DE_AHORRO");
        comboBoxTipoCuenta.addItem("CUENTA_CORRIENTE");
        comboBoxTipoCuenta.setBounds(82, 177, 189, 39);
        contentPane.add(comboBoxTipoCuenta);

        JLabel lblNewLabel_1_1 = new JLabel("Seleccionar el tipo de cuenta");
        lblNewLabel_1_1.setFont(new Font("KG Red Hands", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(82, 140, 489, 27);
        contentPane.add(lblNewLabel_1_1);

        dni = new JTextField();
        dni.setBounds(340, 182, 189, 30);
        contentPane.add(dni);
        dni.setColumns(10);

        JLabel lblNewLabel_1_1_1 = new JLabel("DNI del usuario");
        lblNewLabel_1_1_1.setFont(new Font("KG Red Hands", Font.PLAIN, 15));
        lblNewLabel_1_1_1.setBounds(340, 140, 489, 27);
        contentPane.add(lblNewLabel_1_1_1);

        pin = new JTextField();
        pin.setColumns(10);
        pin.setBounds(82, 285, 189, 30);
        contentPane.add(pin);

        JLabel lblNewLabel_1_1_1_1 = new JLabel("Pin");
        lblNewLabel_1_1_1_1.setFont(new Font("KG Red Hands", Font.PLAIN, 15));
        lblNewLabel_1_1_1_1.setBounds(82, 248, 489, 27);
        contentPane.add(lblNewLabel_1_1_1_1);

        JButton btnAlta = new JButton("Alta");
        btnAlta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String tipoCuentaSeleccionado = (String) comboBoxTipoCuenta.getSelectedItem();
                realizarAltaCuenta(tipoCuentaSeleccionado);
            }
        });
        btnAlta.setForeground(Color.WHITE);
        btnAlta.setFont(new Font("Arial", Font.PLAIN, 20));
        btnAlta.setBackground(new Color(0, 128, 255));
        btnAlta.setBounds(82, 354, 122, 48);
        contentPane.add(btnAlta);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(AltaCuenta.class.getResource("/Iconos/city.png")));
        lblNewLabel.setBounds(562, 0, 224, 463);
        contentPane.add(lblNewLabel);
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