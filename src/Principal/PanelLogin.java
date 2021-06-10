package Principal;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import IndexP.ValidacionTXT;


public class PanelLogin extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelLogin() {
		setForeground(new Color(0, 0, 0));
		setBackground(Color.WHITE);
		setLayout(null);
		setBounds(81, 100, 300, 376);
		//setVisible(false);
		//////////////////////////////////////////////////////////////////
		btnOjo = new JButton("");
		btnOjo.setOpaque(false);
		estadoojo= true;
		//evento del boton ojo
		
		btnOjo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(estadoojo) {
					//cambia icono a cerrado
				btnOjo.setIcon(new ImageIcon("./Imagenes/openeye.png"));
				passwordFieldContraseña.setEchoChar((char)0);
				estadoojo=false;
				
				}else {
					//cambia icono
				btnOjo.setIcon(new ImageIcon("./Imagenes/closeeye.png"));	
				passwordFieldContraseña.setEchoChar(caracterpass);
				estadoojo=true;
				
				
				}
			}
		});
		
		
		
		btnOjo.setFont(new Font("Tahoma", Font.PLAIN, 5));
		btnOjo.setIcon(new ImageIcon("./Imagenes/closeeye.png"));
		btnOjo.setForeground(Color.WHITE);
		btnOjo.setBackground(new Color(0,0,0,0));
		btnOjo.setContentAreaFilled(false);
		btnOjo.setBorderPainted(false);
		btnOjo.setBounds(274, 106, 20, 20);
		
		add(btnOjo);
		
		textFieldCorreo = new JTextField();
		ValidacionTXT validartxtfiel= new ValidacionTXT(textFieldCorreo, 40);
		textFieldCorreo.setFont(new Font("SansSerif", Font.PLAIN, 17));
		textFieldCorreo.setBounds(15, 58, 255, 34);
		TextPrompt holderPrompt=new TextPrompt("Correo Electrónico", textFieldCorreo);
		add(textFieldCorreo);
		textFieldCorreo.setColumns(10);
		
		passwordFieldContraseña = new JPasswordField();
		validartxtfiel= new ValidacionTXT(passwordFieldContraseña, 20);
		passwordFieldContraseña.setFont(new Font("SansSerif", Font.PLAIN, 17));
		passwordFieldContraseña.setBounds(15, 99, 255, 34);
		holderPrompt =new TextPrompt("Contraseña", passwordFieldContraseña);
		//capturamos el puntico de censura para usarlo en el evento del boton ojo
		caracterpass=passwordFieldContraseña.getEchoChar();
		/////////////////////////////////////////////////////////////////////////
		add(passwordFieldContraseña);
		
		lblcontrase = new JLabel("Inicio de Sesión");
		lblcontrase.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblcontrase.setBounds(82, 23, 121, 21);
		add(lblcontrase);
		
		btnLogin = new JButton("Iniciar Sesión");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			boolean nonull=false, closewindow=false;
				//verificamos que los campos no esten nulos
			if(textFieldCorreo.getText().equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(null, "No a digitado su correo.");
			}else if (String.valueOf(passwordFieldContraseña.getPassword()).equalsIgnoreCase("")){
				JOptionPane.showMessageDialog(null, "No a digitado su contraseña");
			}else {
				nonull=true;
			}
			
			if (nonull) {
				//System.out.println("los campos no son nulos ingres a gestionar datos inicar sesion");
				GestionarDatos.inicarSesion(textFieldCorreo.getText(), String.valueOf(passwordFieldContraseña.getPassword()));
				
			}
				
			
			
			
			}
		});
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(new Color(44, 201, 192));
		btnLogin.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnLogin.setBounds(15, 149, 255, 34);
		
		
		add(btnLogin);
		
		
		/*
		 * btnLogout = new JButton("Crear nueva cuenta");
		 * btnLogout.setForeground(Color.WHITE); btnLogout.setBackground(new
		 * Color(37,99,96)); btnLogout.setFont(new Font("SansSerif", Font.PLAIN, 14));
		 * btnLogout.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { setVisible(false);
		 * 
		 * } }); btnLogout.setBounds(72, 252, 156, 34); add(btnLogout);
		 */
		 
		
		
		
		
		/////////////////////////////////////////boton recuperar cuenta/////////////////////////
		btnRecuperarcuenta = new JButton("¿Olvidaste tu contraseña?");
		btnRecuperarcuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			PanelSupreme.mostrarPanelRecuperarCuenta();
			
			}
		});
		btnRecuperarcuenta.setForeground(new Color(44,201,192));
		btnRecuperarcuenta.setBorderPainted(false);
		btnRecuperarcuenta.setFont(new Font("SansSerif", Font.PLAIN, 12));
		btnRecuperarcuenta.setHorizontalAlignment(SwingConstants.LEFT);
		btnRecuperarcuenta.setOpaque(false);
		btnRecuperarcuenta.setBackground(new Color(0,0,0,0));
		btnRecuperarcuenta.setContentAreaFilled(false);
		btnRecuperarcuenta.setBounds(51, 200, 183, 25);
		add(btnRecuperarcuenta);
		///////////////////////////////////////////////////////////////////////////////////////////
	}
	
	
	public void agregarimagen(){
		
	}
	public JPasswordField getPasswordFieldContraseña() {
		return passwordFieldContraseña;
	}


	public void setPasswordFieldContraseña(JPasswordField passwordFieldContraseña) {
		this.passwordFieldContraseña = passwordFieldContraseña;
	}
	
	
	//componentes
	private JLabel lblcontrase;
	private JButton btnLogin;
	private JButton btnLogout;
	private JTextField textFieldCorreo;
	private JPasswordField passwordFieldContraseña;
	
	private boolean estadoojo;
	
	private JButton btnOjo;
	private char caracterpass;
	private JButton btnRecuperarcuenta;
	
	
	
	
	
}
