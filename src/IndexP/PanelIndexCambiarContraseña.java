package IndexP;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Principal.Encrypt;
import Principal.EnvioCorreos;
import Principal.GestionarDatos;
import Principal.PanelSupreme;
import Principal.RSeguridad_Contraseña;
import Principal.TextPrompt;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



public class PanelIndexCambiarContraseña extends JPanel {
	private JPasswordField txtcontra;
	private JPasswordField textField_1;
	private JPasswordField textField_2;
	private ValidacionTXT  validartxtfiel;
	private TextPrompt holderPrompt;
	public JPasswordField getTxtcontra() {
		return txtcontra;
	}

	public void setTxtcontra(String a) {
		txtcontra.setText(a);
	}

	public JPasswordField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(String a) {
		textField_1.setText(a);
	}

	public JPasswordField getTextField_2() {
		return textField_2;
	}

	public void setTextField_2(String a) {
		textField_2.setText(a);
	}
	
	public void limpiarEspacios() {
		setTxtcontra("");
		setTextField_1("");
		setTextField_2("");
	}
	private JButton btnGuardar ;

	/**
	 * Create the panel.
	 */
	public PanelIndexCambiarContraseña() {
		setBackground(Color.WHITE);
		setLayout(null);
		setBounds(100, 100, 940, 545);
		setVisible(false);
		btnGuardar = new JButton("Guardar Cambios");
		btnGuardar.setBackground(new Color(44, 201, 192));
		btnGuardar.setForeground(new Color(255, 255, 255));
		btnGuardar.setEnabled(false);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean nonull=false;
				
				if(String.valueOf(txtcontra.getPassword()).equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Su contraseña actual NO se a digitado.");
				}else if (String.valueOf(textField_1.getPassword()).equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "No a digitado su NUEVA contraseña, en el PRIMER campo.");
				}else if (String.valueOf(textField_2.getPassword()).equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "No a digitado su NUEVA contraseña, en el SEGUNDO campo.");
				}	else {
					nonull=true;
				}
				
				
				
				if (nonull && GestionarDatos.VerificandoPassIniciado(String.valueOf(txtcontra.getPassword()))) {
					if(String.valueOf(textField_1.getPassword()).equals(String.valueOf(textField_2.getPassword()))) {
						Encrypt encriptar=new Encrypt();
						
						GestionarDatos.CambiandoPassIniciado(encriptar.getAES(String.valueOf(textField_2.getPassword())));
						txtcontra.setText("");
						textField_1.setText("");
						textField_2.setText("");
						EnvioCorreos.enviarInformacionCambiocontra(GestionarDatos.getCorreoIniciado(), "Cambio de contraseña","Acabas de realizar un cambio de contraseña en tu cuenta de Safety");
						
					}else {
						JOptionPane.showMessageDialog(null, "La nueva contraseña no coincide en AMBOS campos. intenta nuevamente");
					
					}	
				}else {
					JOptionPane.showMessageDialog(null, "Al parecer algun campo no cumple algún criterio.");
				}
				
				
			
			
			
			}
		});
		btnGuardar.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnGuardar.setBounds(43, 300, 230, 39);
		add(btnGuardar);
		
		txtcontra = new JPasswordField();
		validartxtfiel= new ValidacionTXT(txtcontra, 20);
		txtcontra.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtcontra.setBounds(43, 119, 230, 24);
		holderPrompt=new TextPrompt("Contraseña actual", txtcontra);
		add(txtcontra);
		txtcontra.setColumns(10);
		
		textField_1 = new JPasswordField();
		validartxtfiel= new ValidacionTXT(textField_1, 20);
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				combrobarPassword();
				
				btnGuardar.setEnabled(cumpleCaracteristicas());
				
			
			}
		});
		textField_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textField_1.setBounds(43, 190, 230, 24);
		holderPrompt=new TextPrompt("Nueva Contraseña", textField_1);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JPasswordField();
		validartxtfiel= new ValidacionTXT(textField_2, 20);
		textField_2.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textField_2.setBounds(43, 251, 230, 24);
		holderPrompt=new TextPrompt("Repetir Contraseña", textField_2);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblCambiarPass = new JLabel("Cambio de Contrase\u00F1a");
		lblCambiarPass.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblCambiarPass.setBounds(71, 24, 175, 21);
		add(lblCambiarPass);
		
		JLabel lblcontra = new JLabel("Ingrese su Contrase\u00F1a Actual");
		lblcontra.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblcontra.setBounds(43, 99, 196, 19);
		add(lblcontra);
		
		JLabel lblNewContra1 = new JLabel("Ingrese se nueva contrase\u00F1a.");
		lblNewContra1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewContra1.setBounds(43, 169, 188, 19);
		add(lblNewContra1);
		
		JLabel lblnewcontra2 = new JLabel("Ingresa nuevamente la constrase\u00F1a.");
		lblnewcontra2.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblnewcontra2.setBounds(43, 230, 230, 19);
		add(lblnewcontra2);

	
		generarOjo( txtcontra, txtcontra.getEchoChar(), 280, 120);
		generarOjo(textField_1, textField_1.getEchoChar(), 280, 191);
		generarOjo(textField_2, textField_2.getEchoChar(), 280, 252);
	
	
		agregarLabels();
		
	
	
	
	
	}
	private JLabel lblMayuscula;
	private JLabel lblCaracteresTam;
	private JLabel lblMinuscula;
	private JLabel lblEspecial;
	private void agregarLabels() {
		
		lblMayuscula = new JLabel("Digite al menos 1 May\u00FAscula            ");
		lblMayuscula.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblMayuscula.setBounds(338, 192, 275, 20);
		add(lblMayuscula);
		System.out.println(lblMayuscula.getText().length());
		lblCaracteresTam = new JLabel("Digite al menos 12 Caracteres         ");
		lblCaracteresTam.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblCaracteresTam.setBounds(338, 217, 275, 20);
		add(lblCaracteresTam);
		System.out.println(lblCaracteresTam.getText().length());
		lblMinuscula = new JLabel("Digite al menos 1 Min\u00FAscula             ");
		lblMinuscula.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblMinuscula.setBounds(338, 242, 275, 20);
		add(lblMinuscula);
		System.out.println(lblMinuscula.getText().length());
		lblEspecial = new JLabel("Digite al menos 1 C\u00E1racter especial ");
		lblEspecial.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblEspecial.setBounds(338, 267, 275, 20);
		add(lblEspecial);
	}
	
	private void combrobarPassword() {
		Color colocariconColor;
		RSeguridad_Contraseña comprobar = new RSeguridad_Contraseña(textField_1.getPassword());
		colocariconColor = comprobar.CalcularTamaño();
		lblCaracteresTam.setForeground(colocariconColor);
		colocarIcono(lblCaracteresTam, colocariconColor);

		colocariconColor = comprobar.CalcularMayuscula();
		lblMayuscula.setForeground(colocariconColor);
		colocarIcono(lblMayuscula, colocariconColor);

		colocariconColor = comprobar.CalcularMinuscula();
		lblMinuscula.setForeground(colocariconColor);
		colocarIcono(lblMinuscula, colocariconColor);

		colocariconColor = comprobar.CalcularEspecial();
		lblEspecial.setForeground(colocariconColor);
		colocarIcono(lblEspecial, colocariconColor);

	}
	private void colocarIcono(JLabel lbl, Color color) {
		lbl.setHorizontalTextPosition(SwingConstants.LEFT);
		if (color == Color.RED) {
			lbl.setIcon(new ImageIcon("./Imagenes/declinecircle/res/drawable-mdpi/declinecircle.png"));
			// lbl.setHorizontalTextPosition(SwingConstants.LEFT);
		} else {
			lbl.setIcon(new ImageIcon("./Imagenes/checkcircle/res/drawable-mdpi/cheackcircle.png"));

		}
	}
	private boolean cumpleCaracteristicas() {

		if (lblCaracteresTam.getForeground().equals(Color.GREEN.darker())
				&& lblEspecial.getForeground().equals(Color.GREEN.darker())
				&& lblMayuscula.getForeground().equals(Color.GREEN.darker())
				&& lblMinuscula.getForeground().equals(Color.GREEN.darker())) {
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	private boolean estadoojo;
	
	public void generarOjo(JPasswordField passwordField,char caracterpass,int x,int y) {
		JButton btnOjo1 = new JButton("");
		btnOjo1.setOpaque(false);
		estadoojo = true;
		// evento del boton ojo

		btnOjo1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (estadoojo) {
					// cambia icono a cerrado
					btnOjo1.setIcon(new ImageIcon(
							"./Imagenes/openeye.png"));
					passwordField.setEchoChar((char) 0);
					estadoojo = false;
				} else {
					// cambia icono
					btnOjo1.setIcon(new ImageIcon(
							"./Imagenes/closeeye.png"));
					passwordField.setEchoChar(caracterpass);
					estadoojo = true;
				}
			}
		});
		btnOjo1.setFont(new Font("Tahoma", Font.PLAIN, 5));
		btnOjo1.setIcon(new ImageIcon(
				"./Imagenes/closeeye.png"));
		btnOjo1.setForeground(Color.WHITE);
		btnOjo1.setBackground(new Color(0, 0, 0, 0));
		btnOjo1.setContentAreaFilled(false);
		btnOjo1.setBorderPainted(false);
		
		//ubicacion x y y
		btnOjo1.setBounds(x, y, 33, 23);

		add(btnOjo1);
	}
}
