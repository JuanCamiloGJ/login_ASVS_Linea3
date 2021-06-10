package Principal;

import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import IndexP.ValidacionTXT;

import java.awt.Font;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JSeparator;

public class PanelLogout extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelLogout() {
		setBackground(Color.WHITE);
		setBounds(81, 100, 300, 376);
		setLayout(null);
		setVisible(false);

		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setEnabled(false);
		encriptar = new Encrypt();
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!cumpleCaracteristicas())
				/*if(txtNombres.getText().equals("")||txtCorreo.getText().equals(""))*/ {
					JOptionPane.showMessageDialog(null, "Para continuar debe registrar todos los campos, correctamente.","Advertencia",JOptionPane.INFORMATION_MESSAGE);
					btnSiguiente.setEnabled(false);
				}else {
					GestionarDatos.ACorreoContraseña(txtNombres.getText(), txtCorreo.getText(),
							encriptar.getAES(String.valueOf(passwordField.getPassword())));
					PanelSupreme.mostrarPanelLogout2();	
				}
				
				
			}
		});
		btnSiguiente.setBackground(new Color(44, 201, 192));
		btnSiguiente.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnSiguiente.setForeground(Color.WHITE);
		btnSiguiente.setBounds(19, 266, 253, 34);
		add(btnSiguiente);

		JLabel lblNewLabel = new JLabel("Registro");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblNewLabel.setBounds(113, 21, 65, 21);
		add(lblNewLabel);
		//// password section//////////
		passwordField = new JPasswordField();
		ValidacionTXT validartxtfiel= new ValidacionTXT(passwordField, 20);
		passwordField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				combrobarPassword();
				if (cumpleCaracteristicas()) {
					btnSiguiente.setEnabled(true);
				}else {
					btnSiguiente.setEnabled(false);
				}
			}
		});
		passwordField.setFont(new Font("SansSerif", Font.PLAIN, 17));
		passwordField.setBounds(19, 155, 253, 34);
		caracterpass = passwordField.getEchoChar();
		holderPrompt = new TextPrompt("Contraseña", passwordField);
		add(passwordField);
		/////////////////////////////////////////////////////
		///////////////////////// ojo pass/////////////////////////
		btnOjo = new JButton("");
		btnOjo.setOpaque(false);
		estadoojo = true;
		// evento del boton ojo

		btnOjo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (estadoojo) {
					// cambia icono a cerrado
					btnOjo.setIcon(new ImageIcon(
							"./Imagenes/openeye.png"));
					passwordField.setEchoChar((char) 0);
					estadoojo = false;
				} else {
					// cambia icono
					btnOjo.setIcon(new ImageIcon(
							"./Imagenes/closeeye.png"));
					passwordField.setEchoChar(caracterpass);
					estadoojo = true;
				}
			}
		});
		btnOjo.setFont(new Font("Tahoma", Font.PLAIN, 5));
		btnOjo.setIcon(new ImageIcon(
				"./Imagenes/closeeye.png"));
		btnOjo.setForeground(Color.WHITE);
		btnOjo.setBackground(new Color(0, 0, 0, 0));
		btnOjo.setContentAreaFilled(false);
		btnOjo.setBorderPainted(false);
		btnOjo.setBounds(274, 162, 20, 20);

		add(btnOjo);
		//////////////////////////////////////////////////////////////////////////////////////
		txtNombres = new JTextField();
		ValidacionTXT validartxtfiel1= new ValidacionTXT(txtNombres, 49);
		txtNombres.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			
				if (cumpleCaracteristicas()) {
					btnSiguiente.setEnabled(true);
				}
			}
		});
		txtNombres.setFont(new Font("SansSerif", Font.PLAIN, 17));
		txtNombres.setBounds(19, 58, 253, 34);
		holderPrompt_1 = new TextPrompt("Nombres y Apellidos", txtNombres);
		holderPrompt_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			
			}
		});
		add(txtNombres);
		txtNombres.setColumns(10);
		txtCorreo = new JTextField();
		validartxtfiel= new ValidacionTXT(txtCorreo, 40);
		txtCorreo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Color auxColor = new Color(0, 0, 0, 0);
				Pattern pat = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
				Matcher mat = pat.matcher(txtCorreo.getText());
				if (mat.find()) {
					auxColor = Color.GREEN.darker();
					msjcorreo.setText("Estas usando un correo valido");
					msjcorreo.setForeground(Color.GREEN.darker());
				} else {
					msjcorreo.setText("Estas usando un correo invalido");
					msjcorreo.setForeground(Color.RED);
					auxColor = Color.RED;
				}
				colocarIcono(msjcorreo, auxColor);

				if (cumpleCaracteristicas()) {
					btnSiguiente.setEnabled(true);
				}

			}
		});
		txtCorreo.setFont(new Font("SansSerif", Font.PLAIN, 17));
		txtCorreo.setBounds(19, 100, 253, 34);
		holderPrompt = new TextPrompt("Correo electrónico", txtCorreo);
		add(txtCorreo);
		txtCorreo.setColumns(10);
////////////////////////////////////////////////////////////////////////////
		lblMayuscula = new JLabel("Digite al menos 1 May\u00FAscula            ");
		lblMayuscula.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblMayuscula.setBounds(19, 205, 275, 20);
		add(lblMayuscula);
		System.out.println(lblMayuscula.getText().length());
		lblCaracteresTam = new JLabel("Digite al menos 12 Caracteres         ");
		lblCaracteresTam.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblCaracteresTam.setBounds(19, 190, 275, 20);
		add(lblCaracteresTam);
		System.out.println(lblCaracteresTam.getText().length());
		lblMinuscula = new JLabel("Digite al menos 1 Min\u00FAscula             ");
		lblMinuscula.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblMinuscula.setBounds(19, 220, 275, 20);
		add(lblMinuscula);
		System.out.println(lblMinuscula.getText().length());
		lblEspecial = new JLabel("Digite al menos 1 C\u00E1racter especial ");
		lblEspecial.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblEspecial.setBounds(19, 235, 275, 20);
		add(lblEspecial);
////////////////////////////////////////////////////////////////////////////////
		msjcorreo = new JLabel("Utiliza un correo valido");
		msjcorreo.setFont(new Font("SansSerif", Font.PLAIN, 11));
		msjcorreo.setBounds(19, 138, 253, 14);
		add(msjcorreo);

		JSeparator separator = new JSeparator();
		separator.setBounds(19, 311, 253, 2);
		add(separator);

		System.out.println(lblEspecial.getText().length());
	}

	private JPasswordField passwordField;
	private JTextField txtNombres;
	private JTextField txtCorreo;
	private boolean estadoojo;
	private char caracterpass;
	private JButton btnOjo;
	private JLabel lblEspecial;
	private JLabel lblMinuscula;
	private JLabel lblCaracteresTam;
	private JLabel lblMayuscula;
	private Encrypt encriptar;
	private JLabel msjcorreo;
	private TextPrompt holderPrompt;
	private TextPrompt holderPrompt_1;

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public void combrobarPassword() {
		Color colocariconColor;
		RSeguridad_Contraseña comprobar = new RSeguridad_Contraseña(passwordField.getPassword());
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

	public void colocarIcono(JLabel lbl, Color color) {
		lbl.setHorizontalTextPosition(SwingConstants.LEFT);
		if (color == Color.RED) {
			lbl.setIcon(new ImageIcon("./Imagenes/declinecircle/res/drawable-mdpi/declinecircle.png"));
			// lbl.setHorizontalTextPosition(SwingConstants.LEFT);
		} else {
			lbl.setIcon(new ImageIcon("./Imagenes/checkcircle/res/drawable-mdpi/cheackcircle.png"));

		}
	}
	
	public void limpiarEspacios() {
		txtNombres.setText("");
		txtCorreo.setText("");
		passwordField.setText("");
		
	}

	public boolean cumpleCaracteristicas() {

		if (msjcorreo.getForeground().equals(Color.GREEN.darker())
				&& lblCaracteresTam.getForeground().equals(Color.GREEN.darker())
				&& lblEspecial.getForeground().equals(Color.GREEN.darker())
				&& lblMayuscula.getForeground().equals(Color.GREEN.darker())
				&& lblMinuscula.getForeground().equals(Color.GREEN.darker())
				&& !(txtNombres.getText().equals(""))) {
			
			return true;
		}
		return false;
	}

	public JLabel getMsjcorreo() {
		return msjcorreo;
	}
}
