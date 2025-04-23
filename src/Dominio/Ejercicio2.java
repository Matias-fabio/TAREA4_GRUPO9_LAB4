package Dominio;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Ejercicio2 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtNota1;
    private JTextField txtNota2;
    private JTextField txtNota3;
    private JTextField txtPromedio;
    private JTextField txtCondicion;
    private JComboBox<String> cbTP;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Ejercicio2 frame = new Ejercicio2();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Ejercicio2() {
        setTitle("Promedio");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        
        JLabel lblTituloEntrada = new JLabel("Notas del estudiante");
        lblTituloEntrada.setBounds(40, 20, 150, 20);
        contentPane.add(lblTituloEntrada);
        
        JLabel lblNota1 = new JLabel("Nota 1:");
        lblNota1.setBounds(50, 50, 60, 20);
        contentPane.add(lblNota1);
        
        txtNota1 = new JTextField();
        txtNota1.setBounds(110, 50, 150, 20);
        contentPane.add(txtNota1);
        txtNota1.setColumns(10);
        
        JLabel lblNota2 = new JLabel("Nota 2:");
        lblNota2.setBounds(50, 80, 60, 20);
        contentPane.add(lblNota2);
        
        txtNota2 = new JTextField();
        txtNota2.setBounds(110, 80, 150, 20);
        contentPane.add(txtNota2);
        txtNota2.setColumns(10);
        
        JLabel lblNota3 = new JLabel("Nota 3:");
        lblNota3.setBounds(50, 110, 60, 20);
        contentPane.add(lblNota3);
        
        txtNota3 = new JTextField();
        txtNota3.setBounds(110, 110, 150, 20);
        contentPane.add(txtNota3);
        txtNota3.setColumns(10);
        
        JLabel lblTP = new JLabel("TP:");
        lblTP.setBounds(50, 145, 60, 20);
        contentPane.add(lblTP);
        
        cbTP = new JComboBox<>();
        cbTP.setModel(new DefaultComboBoxModel<>(new String[] {"Aprobado", "Desaprobado"}));
        cbTP.setBounds(110, 140, 150, 30);
        contentPane.add(cbTP);
        
        
        
        
        JButton btnCalcular = new JButton("CALCULAR");
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularResultado();
            }
        });
        btnCalcular.setBounds(274, 99, 100, 30);
        contentPane.add(btnCalcular);
        
        
        
        JButton btnNuevo = new JButton("NUEVO");
        btnNuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });
        btnNuevo.setBounds(274, 140, 100, 30);
        contentPane.add(btnNuevo);
        
        
        
        JButton btnSalir = new JButton("SALIR");
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnSalir.setBounds(274, 189, 100, 30);
        contentPane.add(btnSalir);
        
        
        
        
        JLabel lblTituloResultados = new JLabel("Notas del estudiante");
        lblTituloResultados.setBounds(38, 199, 150, 20);
        contentPane.add(lblTituloResultados);
        
        JLabel lblPromedio = new JLabel("Promedio:");
        lblPromedio.setBounds(48, 230, 80, 20);
        contentPane.add(lblPromedio);
        
        txtPromedio = new JTextField();
        txtPromedio.setEditable(false);
        txtPromedio.setBounds(150, 230, 100, 20);
        contentPane.add(txtPromedio);
        txtPromedio.setColumns(10);
        
        JLabel lblCondicion = new JLabel("Condición:");
        lblCondicion.setBounds(48, 260, 80, 20);
        contentPane.add(lblCondicion);
        
        txtCondicion = new JTextField();
        txtCondicion.setEditable(false);
        txtCondicion.setBounds(150, 261, 100, 20);
        contentPane.add(txtCondicion);
        txtCondicion.setColumns(10);
    }
    
    private void calcularResultado() {
        try {
            
            double nota1 = Double.parseDouble(txtNota1.getText());
            double nota2 = Double.parseDouble(txtNota2.getText());
            double nota3 = Double.parseDouble(txtNota3.getText());         
            
            String tpEstado = (String) cbTP.getSelectedItem();
            
            
            double promedio =(nota1 + nota2 + nota3) / 3;
            txtPromedio.setText(String.format("%.2f",promedio));
            
            
            String condicion = null;
            
            
            if (tpEstado.equals("Desaprobado") || nota1 < 6 || nota2 < 6 || nota3 < 6) {
                condicion = "Libre";
            }           
          
            
            txtCondicion.setText(condicion);
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese valores numéricos válidos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void limpiarCampos() {
        txtNota1.setText("");
        txtNota2.setText("");
        txtNota3.setText("");
        txtPromedio.setText("");
        txtCondicion.setText("");
        cbTP.setSelectedIndex(0); 
    }
}
