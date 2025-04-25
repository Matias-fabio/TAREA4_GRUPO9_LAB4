package Dominio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setTitle("TP4 - GRUPO 9");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("GRUPO NRO: 9");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(58, 25, 112, 23);
		contentPane.add(lblNewLabel);
		
		JButton btnEjercicio1 = new JButton("Ejercicio 1");
		btnEjercicio1.setBounds(150, 70, 150, 30);
		btnEjercicio1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				Ejercicio1 ventanaEj1 = new Ejercicio1();
				ventanaEj1.setVisible(true);
			}
			
		});

		contentPane.add(btnEjercicio1);

		
		JButton btnEjercicio2 = new JButton("Ejercicio 2");
		btnEjercicio2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ejercicio2 ventanaEj2 = new Ejercicio2();
				ventanaEj2.setVisible(true);
			}
		});
		btnEjercicio2.setBounds(150, 130, 150, 30);
		contentPane.add(btnEjercicio2);
		
		JButton btnEjercicio3 = new JButton("Ejercicio 3");
		btnEjercicio3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ejercicio3 ventanaEj3 = new Ejercicio3();
				ventanaEj3.setVisible(true);
			}
		});
		btnEjercicio3.setBounds(150, 190, 150, 30);
		contentPane.add(btnEjercicio3);
	}
}
