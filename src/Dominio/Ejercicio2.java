package Dominio;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
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
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 602, 481);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        
        
        
        JButton btnCalcular = new JButton("CALCULAR");
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularResultado();
            }
        });
        btnCalcular.setBounds(312, 31, 100, 30);
        contentPane.add(btnCalcular);
        
        
        
        JButton btnNuevo = new JButton("NUEVO");
        btnNuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });
        btnNuevo.setBounds(312, 83, 100, 30);
        contentPane.add(btnNuevo);
        
        
        
        JButton btnSalir = new JButton("SALIR");
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnSalir.setBounds(312, 134, 100, 30);
        contentPane.add(btnSalir);
        
        JPanel panelNotas = new JPanel();
        panelNotas.setBorder(BorderFactory.createTitledBorder(
       BorderFactory.createLineBorder(new Color(144, 192, 215)), "Notas del estudiante"));
        panelNotas.setBounds(24, 18, 270, 170);
        contentPane.add(panelNotas);
        panelNotas.setLayout(null);
        
        JLabel lblNota1 = new JLabel("Nota 1:");
        lblNota1.setBounds(10, 26, 60, 20);
        panelNotas.add(lblNota1);
        
        JLabel lblNota2 = new JLabel("Nota 2:");
        lblNota2.setBounds(10, 57, 60, 20);
        panelNotas.add(lblNota2);
        
        JLabel lblNota3 = new JLabel("Nota 3:");
        lblNota3.setBounds(10, 88, 60, 20);
        panelNotas.add(lblNota3);
        
        txtNota1 = new JTextField();
        txtNota1.setBounds(80, 26, 150, 20);
        panelNotas.add(txtNota1);
        txtNota1.setColumns(10);
        
        txtNota2 = new JTextField();
        txtNota2.setBounds(80, 57, 150, 20);
        panelNotas.add(txtNota2);
        txtNota2.setColumns(10);
        
        txtNota3 = new JTextField();
        txtNota3.setBounds(80, 88, 150, 20);
        panelNotas.add(txtNota3);
        txtNota3.setColumns(10);
        
        JLabel lblTP = new JLabel("TPS");
        lblTP.setBounds(10, 124, 60, 20);
        panelNotas.add(lblTP);
        
        cbTP = new JComboBox<>();
        cbTP.setBounds(80, 119, 150, 30);
        panelNotas.add(cbTP);
        cbTP.setModel(new DefaultComboBoxModel<>(new String[] {"Aprobado", "Desaprobado"}));
        
        JPanel panelPromedio = new JPanel();
        panelPromedio.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createLineBorder(new Color(144, 192, 215)), "Notas del estudiante"));
        panelPromedio.setBounds(24, 199, 270, 157);
        contentPane.add(panelPromedio);
        panelPromedio.setLayout(null);
        
        JLabel lblPromedio = new JLabel("Promedio:");
        lblPromedio.setBounds(10, 31, 80, 20);
        panelPromedio.add(lblPromedio);
        
        txtPromedio = new JTextField();
        txtPromedio.setBackground(new Color(255, 255, 255));
        txtPromedio.setBounds(100, 31, 124, 20);
        panelPromedio.add(txtPromedio);
        txtPromedio.setEditable(false);
        txtPromedio.setColumns(10);
        
        txtCondicion = new JTextField();
        txtCondicion.setBackground(new Color(255, 255, 255));
        txtCondicion.setBounds(100, 62, 124, 20);
        panelPromedio.add(txtCondicion);
        txtCondicion.setEditable(false);
        txtCondicion.setColumns(10);
        
        JLabel lblCondicion = new JLabel("Condición:");
        lblCondicion.setBounds(10, 62, 80, 20);
        panelPromedio.add(lblCondicion);
    }
    
    private void calcularResultado() {
        try {
        	
        	 if (txtNota1.getText().isEmpty() ||
		        txtNota2.getText().isEmpty() ||
		        txtNota3.getText().isEmpty()) {

		        JOptionPane.showMessageDialog(this,
		            "Por favor complete todos los campos de notas antes de calcular.","Campos incompletos", JOptionPane.WARNING_MESSAGE);
		        return; 
		    }
            
            double nota1 = Double.parseDouble(txtNota1.getText());
            double nota2 = Double.parseDouble(txtNota2.getText());
            double nota3 = Double.parseDouble(txtNota3.getText());         
            
            if (nota1 < 1 || nota1 > 10 || nota2 < 1 || nota2 > 10 || nota3 < 1 || nota3 > 10) {
                JOptionPane.showMessageDialog(this,
                    "Las notas deben estar entre 1 y 10.", "Valores fuera de rango", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            String tpEstado = (String) cbTP.getSelectedItem();
            
            
            double promedio =(nota1 + nota2 + nota3) / 3;
            txtPromedio.setText(String.format("%.2f",promedio));
            
            
            String condicion = null;
            
            
            if (tpEstado.equals("Desaprobado") || nota1 < 6 || nota2 < 6 || nota3 < 6) {
                condicion = "Libre";
            }   
            
            else if (tpEstado.equals("Aprobado") && promedio >= 8) {
                condicion = "Promocionado";
            } 
            
            else if (tpEstado.equals("Aprobado") && promedio >= 6 && promedio < 8) {
                condicion = "Regular";
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
