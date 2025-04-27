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
import javax.swing.JCheckBox;
import java.awt.Font;

public class Ejercicio3 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtHoras;
	private JRadioButton rdbtnWindows;
	private JRadioButton rdbtnMac;
	private JRadioButton rdbtnLinux;
	private JCheckBox chProgramacion;
	private JCheckBox chAdministracion;
	private JCheckBox chDiseñoGrafico;
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		 chProgramacion = new JCheckBox("Programacion");
		chProgramacion.setBounds(234, 7, 121, 23);
		panelEspecialidad.add(chProgramacion);
		
		 chAdministracion = new JCheckBox("Administracion");
		chAdministracion.setBounds(234, 33, 121, 23);
		panelEspecialidad.add(chAdministracion);
		
		 chDiseñoGrafico = new JCheckBox("Diseño Grafico");
		chDiseñoGrafico.setBounds(234, 59, 121, 23);
		panelEspecialidad.add(chDiseñoGrafico);
		

		JLabel lblElijeUnaEspecialidad = new JLabel("Elije una especialidad");
		lblElijeUnaEspecialidad.setBounds(42, 34, 150, 21);
		panelEspecialidad.add(lblElijeUnaEspecialidad);
		
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
				try {
				String sistema=seleccionSistema();
				String especialidad = seleccionEspecialidad();
				String horas = obtenerHoras();
				
				
			mostrarInformacion(sistema,especialidad,horas);
			}
			catch(Exception ex){
	            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
			}
			}
			});
		btnNewButton.setBounds(340, 225, 89, 23);
		contentPane.add(btnNewButton);
		
		
		
		
	}
	
	private String seleccionSistema() throws Exception {

		if (rdbtnWindows.isSelected()) {
		return"Windows";}
		else if (rdbtnMac.isSelected()) {
			return "Mac";
		}
		else if (rdbtnLinux.isSelected()) {
			return "Linux";
		}
		throw new Exception("Debe seleccionar un sistema operativo");
	}
	
	private String seleccionEspecialidad() throws Exception {
	    StringBuilder especialidades = new StringBuilder();

	    if (chProgramacion.isSelected()) {
	        especialidades.append("Programación, ");
	    }
	    if (chAdministracion.isSelected()) {
	        especialidades.append("Administración, ");
	    }
	    if (chDiseñoGrafico.isSelected()) {
	        especialidades.append("Diseño Gráfico, ");
	    }

	    if (especialidades.length() == 0) {
			throw new Exception("Debe seleccionar al menos una especialidad");
	    } else {
	        return especialidades.substring(0, especialidades.length() - 2);
	    }
	}
	
	private String obtenerHoras() throws Exception{
		String horasTxt = txtHoras.getText().trim();
		if (horasTxt.isEmpty()) {
			throw new Exception("No se ingresaron horas");
		}
		try {
			int horas= Integer.parseInt(horasTxt);
			if(horas<=0) {
				throw new Exception("Las horas ingresadas no son validas");
			}else {
				return horas+" Horas";
			}
		}catch(NumberFormatException ex){
			throw new Exception("La hora ingresada debe ser un numero");
		}
	}	
	
	private void mostrarInformacion(String sistema,String especialidad,String horas) {
	
		JOptionPane.showMessageDialog(this,sistema+"-"+ especialidad+"-"+horas,"Mensaje", JOptionPane.INFORMATION_MESSAGE);
	}
}

