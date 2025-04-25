package Dominio;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio3 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtHoras;
	private JRadioButton rdbtnWindows;
	private JRadioButton rdbtnMac;
	private JRadioButton rdbtnLinux;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio3 frame = new Ejercicio3();
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
	public Ejercicio3() {
		setTitle("Selección multiple");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelSistema = new JPanel();
		panelSistema.setBounds(46, 25, 400, 43);
		panelSistema.setBorder(new LineBorder(Color.black));
		contentPane.add(panelSistema);
		panelSistema.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Elije un sistema operativo");
		lblNewLabel.setBounds(10, 11, 159, 21);
		panelSistema.add(lblNewLabel);
		
		rdbtnWindows = new JRadioButton("Windows");
		rdbtnWindows.setBounds(175, 10, 80, 23);
		
		
		rdbtnMac = new JRadioButton("Mac");
		rdbtnMac.setBounds(257, 10, 58, 23);
		
		
		rdbtnLinux = new JRadioButton("Linux");
		rdbtnLinux.setBounds(317, 10, 65, 23);
		
		ButtonGroup grupoOpcionesSistema = new ButtonGroup();
		grupoOpcionesSistema.add(rdbtnWindows);
		grupoOpcionesSistema.add(rdbtnMac);
		grupoOpcionesSistema.add(rdbtnLinux);
		
		panelSistema.add(rdbtnWindows);
		panelSistema.add(rdbtnMac);
		panelSistema.add(rdbtnLinux);

		
		JPanel panelEspecialidad = new JPanel();
		panelEspecialidad.setBounds(46, 79, 400, 94);
		panelEspecialidad.setBorder(new LineBorder(Color.black));
		contentPane.add(panelEspecialidad);
		panelEspecialidad.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Cantidad de horas en el computador:");
		lblNewLabel_1.setBounds(66, 187, 222, 14);
		contentPane.add(lblNewLabel_1);
		
		txtHoras = new JTextField();
		txtHoras.setBounds(298, 184, 86, 20);
		contentPane.add(txtHoras);
		txtHoras.setColumns(10);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String sistema=seleccionSistema();
				
			mostrarInformacion(sistema);
			}
		});
		btnNewButton.setBounds(340, 225, 89, 23);
		contentPane.add(btnNewButton);
		
		
		
		
	}
	
	private String seleccionSistema() {

		if (rdbtnWindows.isSelected()) {
		return"Windows";}
		else if (rdbtnMac.isSelected()) {
			return "Mac";
		}
		else if (rdbtnLinux.isSelected()) {
			return "Linux";
		}
		return "Sin selección de sistema";
	}
	
	
	private void mostrarInformacion(String sistema) {
	
		JOptionPane.showMessageDialog(this,sistema+"-","Mensaje", JOptionPane.INFORMATION_MESSAGE);
	}
}

