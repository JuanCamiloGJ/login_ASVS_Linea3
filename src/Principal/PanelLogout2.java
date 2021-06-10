package Principal;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.border.Border;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.color.ColorSpace;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.LineBorder;

import IndexP.ValidacionTXT;

public class PanelLogout2 extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField repuesta1;
	private JTextField respuesta2;
	private JTextField respuesta3;
	private TextPrompt holderPrompt;
	
	private static boolean vision=false;
	private JButton btnFinalizar = new JButton("Finalizar");
	private JComboBox pregunta3;
	private JComboBox pregunta2;
	private JComboBox pregunta1;

	/**
	 * Create the panel.
	 */
	public PanelLogout2() {
		setBackground(Color.WHITE);
		setBounds(81, 100, 300, 376);
		setLayout(null);
		setVisible(false);
		repuesta1 = new JTextField();
		ValidacionTXT validartxtfiel= new ValidacionTXT(repuesta1, 49);
		repuesta1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				btnFinalizar.setEnabled(cumpleRequisitos());
				colorBordeTextField(repuesta1);
			}
			
		});
		repuesta1.setBounds(10, 128, 280, 25);
		holderPrompt=new TextPrompt("Pregunta 1", repuesta1);
		add(repuesta1);
		repuesta1.setColumns(10);
		
		pregunta1 = new JComboBox(cargapreguntas());
		pregunta1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			btnFinalizar.setEnabled(cumpleRequisitos());
			}
		});
		pregunta1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		pregunta1.setBounds(10, 100, 280, 25);
		add(pregunta1);
		
		pregunta2 = new JComboBox(cargapreguntas());
		pregunta2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				btnFinalizar.setEnabled(cumpleRequisitos());}
		});
		pregunta2.setFont(new Font("SansSerif", Font.PLAIN, 14));
		pregunta2.setBounds(10, 156, 280, 25);
		add(pregunta2);
		
		respuesta2 = new JTextField();
		validartxtfiel= new ValidacionTXT(respuesta2, 49);
		respuesta2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				btnFinalizar.setEnabled(cumpleRequisitos());
				colorBordeTextField(respuesta2);
			}
		});
		respuesta2.setBounds(10, 184, 280, 25);
		holderPrompt=new TextPrompt("Pregunta 2", respuesta2);
		holderPrompt.setSize(274, 25);
		add(respuesta2);
		respuesta2.setColumns(10);
		
		pregunta3 = new JComboBox(cargapreguntas());
		pregunta3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnFinalizar.setEnabled(cumpleRequisitos());
				
			}
		});
		pregunta3.setFont(new Font("SansSerif", Font.PLAIN, 14));
		pregunta3.setBounds(10, 212, 280, 25);
		add(pregunta3);
		
		respuesta3 = new JTextField();
		validartxtfiel= new ValidacionTXT(respuesta3, 49);
		respuesta3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				btnFinalizar.setEnabled(cumpleRequisitos());
				colorBordeTextField(respuesta3);
			}
		});
		respuesta3.setBounds(10, 240, 280, 25);
		holderPrompt=new TextPrompt("Pregunta 3", respuesta3);
		add(respuesta3);
		respuesta3.setColumns(10);
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionarDatos.APreguntas((String)pregunta1.getSelectedItem(), repuesta1.getText(), (String)pregunta2.getSelectedItem(), respuesta2.getText()
						, (String)pregunta3.getSelectedItem(), respuesta3.getText());
				GestionarDatos.CargarBDCrearUser();
				
				PanelSupreme.mostrarPanelMensajeRegistro();
			
			}
		});
		btnFinalizar.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnFinalizar.setForeground(Color.WHITE);
		btnFinalizar.setBackground(new Color(44,201,192));
		btnFinalizar.setBounds(86, 274, 129, 33);
		btnFinalizar.setEnabled(false);
		add(btnFinalizar);
		
		JLabel lblNewLabel = new JLabel("<html>Seleccione diferentes preguntas de seguridad, en<br/> caso que olvides la contrase\u00F1a, se usaran para recuperarla.</html>");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 42, 280, 62);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Registro");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblNewLabel_1.setBounds(118, 11, 65, 21);
		add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 318, 280, 2);
		add(separator);
		setVisible(false);
		
	}
	
	
	public String [] cargapreguntas() {
		String [] preguntaStrings= {"¿Cuál era tu apodo de pequeño/a?",
				"¿En qué ciudad conociste a tu pareja?",
				"¿Cuál era el nombre de tu mejor amigo/a de la infancia?", 
				"¿Cuál era el nombre de tu primera mascota?",
				"¿Quién era el héroe de tu infancia?",
				"¿Dónde fuiste de vacaciones el año pasado?",
				"¿En qué ciudad te gustaría jubilarte?",
				"¿En qué año terminaste secundaria?",
				"¿Cuál era el nombre de tu primer colegio?"};
		
		return preguntaStrings;
	
	}
	
	public boolean cumpleRequisitos() {
		int cont=0;
		if (preguntasRepetidas(pregunta1)||preguntasRepetidas(pregunta2)||preguntasRepetidas(pregunta3)) {
			cont++;
		}
		if(repuesta1.getText().equals("")||respuesta2.getText().equals("")||respuesta3.getText().equals("")) {
			cont++;
		}
		if (cont==0) {
			return true;
		}else {
			return false;	
		}
		
		
	}
	public void limpiarEspacios() {
		repuesta1.setText("");
		respuesta2.setText("");
		respuesta3.setText("");
		pregunta1.setSelectedIndex(1);
		pregunta2.setSelectedIndex(2);
		pregunta3.setSelectedIndex(3);
		
	}
	
	public boolean preguntasRepetidas(JComboBox combo) {
		
		String txtString=(String)combo.getSelectedItem();
		int cont=0;
		if (txtString.equals(pregunta1.getSelectedItem().toString())) {
			cont++;
		}
		if (txtString.equals(pregunta2.getSelectedItem().toString())) {
			cont++;
		}
		if (txtString.equals(pregunta3.getSelectedItem().toString())) {
			cont++;
		}
		
		if (cont<2) {
			return false;
		}else {
			return true;
		}
		
	}
	public void colorBordeTextField(JTextField textField) {
		if(textField.getText().equals("")) {
			
			textField.setBorder(new LineBorder(Color.RED, 2, true));
		}else {
			textField.setBorder(new LineBorder(Color.GREEN.darker(), 2, true));
		}
	}
	
	
	
	}
