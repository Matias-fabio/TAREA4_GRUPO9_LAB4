package Dominio;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textTelefono;
	private JTextField textFechaNac;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio1 frame = new Ejercicio1();
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
	public Ejercicio1() {
		setTitle("Ejercicio 1");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // CAMBIO PARA CERRAR SOLO LA VENTANA DE EJERCICIO 1
		setBounds(100, 100, 474, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(39, 24, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(39, 63, 46, 14);
		contentPane.add(lblApellido);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(39, 96, 67, 14);
		contentPane.add(lblTelefono);
		
		JLabel lblFechaNac = new JLabel("Fecha Nac.");
		lblFechaNac.setBounds(39, 130, 67, 14);
		contentPane.add(lblFechaNac);
		
		textNombre = new JTextField();
		textNombre.setBounds(169, 21, 86, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textApellido = new JTextField();
		textApellido.setBounds(169, 60, 86, 20);
		contentPane.add(textApellido);
		textApellido.setColumns(10);
		
		textTelefono = new JTextField();
		textTelefono.setBounds(169, 93, 86, 20);
		contentPane.add(textTelefono);
		textTelefono.setColumns(10);
		
		textFechaNac = new JTextField();
		textFechaNac.setBounds(169, 127, 86, 20);
		contentPane.add(textFechaNac);
		textFechaNac.setColumns(10);
		
		JLabel lblDatosIngresados = new JLabel("Los Datos Ingresadors Fueron:");
		lblDatosIngresados.setBounds(10, 209, 333, 14);
		contentPane.add(lblDatosIngresados);
		
		JLabel lblMostrarDatos = new JLabel("");
		lblMostrarDatos.setBounds(10, 234, 442, 55);
		contentPane.add(lblMostrarDatos);
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.setBounds(169, 168, 89, 23);
		contentPane.add(btnMostrar);
		
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textNombre.setBackground(Color.white);
				textApellido.setBackground(Color.white);
				textTelefono.setBackground(Color.white);
				textFechaNac.setBackground(Color.white);
				
				String nombre = textNombre.getText().trim();
				String apellido = textApellido.getText().trim();
				String telefono = textTelefono.getText().trim();
				String fechanac= textFechaNac.getText().trim();
				
				boolean camposVacios = false;
				
				if(nombre.isEmpty()) {
					textNombre.setBackground(Color.red);
					camposVacios = true;
				}
				if(apellido.isEmpty()) {
					textApellido.setBackground(Color.red);
					camposVacios = true;
				}
				if(telefono.isEmpty()) {
					textTelefono.setBackground(Color.red);
					camposVacios = true;
				}
				
				if(fechanac.isEmpty()) {
					textFechaNac.setBackground(Color.red);
					camposVacios = true;
				}
				
				
				if(!camposVacios) {
					lblMostrarDatos.setText("Persona: " + nombre + " " + apellido +" - FechaNac: " + fechanac + " - Tel: " + telefono);
					textNombre.setText("");
					textApellido.setText("");
					textTelefono.setText("");
					textFechaNac.setText("");
					
				}
				else {
					lblMostrarDatos.setText("Hay campos incompletos");
				}
				
			}
		});
		
	}
}
