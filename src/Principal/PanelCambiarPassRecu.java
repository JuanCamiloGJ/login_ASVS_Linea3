package Principal;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;


import IndexP.ValidacionTXT;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PanelCambiarPassRecu extends JPanel {
	private JPasswordField contra1;
	private JPasswordField  contra2;
	private TextPrompt holderPrompt;
	private JButton btnguardar;
	private ValidacionTXT validartxtfielpass;
	/**
	 * Create the panel.
	 */
	public PanelCambiarPassRecu() {
		setBackground(Color.WHITE);
		setBounds(81, 100, 300, 376);
		setLayout(null);
		setVisible(false);
		
		JLabel lblTittle = new JLabel("Recuperar Cuenta");
		lblTittle.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblTittle.setBounds(55, 36, 171, 26);
		add(lblTittle);
		JLabel lblNewLabel_1 = new JLabel("<html>Ingresa tu nueva contraseña.</html>");
		lblNewLabel_1.setForeground(new Color(102, 102, 102));
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(31, 73, 218, 40);
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		add(lblNewLabel_1);
		
		contra1 = new JPasswordField ();
		validartxtfielpass= new ValidacionTXT(contra1, 20);
		contra1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			combrobarPassword();
			btnguardar.setEnabled(cumpleCaracteristicas());
			}
		});
		contra1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		contra1.setBounds(20, 112, 240, 34);
		add(contra1);
		contra1.setColumns(10);
		holderPrompt= new TextPrompt("Contraseña", contra1);
		contra2 = new JPasswordField ();
		validartxtfielpass= new ValidacionTXT(contra2, 20);
		contra2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		contra2.setBounds(20, 213, 240, 34);
		add(contra2);
		contra2.setColumns(10);
		holderPrompt= new TextPrompt("Escribir Contraseña nuevamente", contra2);
		
		btnguardar = new JButton("Guardar Contrase\u00F1a");
		btnguardar.setEnabled(false);
		btnguardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(String.valueOf(contra1.getPassword()).equals(String.valueOf(contra2.getPassword()))) {
					Encrypt encriptador= new Encrypt();
					GestionarDatos.CambiandoPassRecu(encriptador.getAES(String.valueOf(contra2.getPassword())));
					
					PanelSupreme.mostrarPanelLogin();
					EnvioCorreos.enviarInformacionCambiocontra(GestionarDatos.getCorreoRecuperacion(), "Cambio de contraseña","Acabas de realizar un cambio de contraseña en tu cuenta de Safety");
					
				}else {
					JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden. intenta nuevamente");
				
				}
			
			
			}
		});
		btnguardar.setBackground(new Color(44, 201, 192));
		btnguardar.setForeground(Color.WHITE);
		btnguardar.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnguardar.setBounds(40, 258, 200, 40);
		add(btnguardar);
		generarOjo(contra1, contra1.getEchoChar(), 255, 116);
		generarOjo(contra2, contra2.getEchoChar(), 255, 217);
		agregarLabels();
	}
	
	public void limpiarEspacios() {
		contra1.setText("");
		contra2.setText("");
		btnguardar.setEnabled(false);
	}
	private JLabel lblMayuscula;
	private JLabel lblCaracteresTam;
	private JLabel lblMinuscula;
	private JLabel lblEspecial;
		private void agregarLabels() {
		
		lblMayuscula = new JLabel("Digite al menos 1 May\u00FAscula            ");
		lblMayuscula.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblMayuscula.setBounds(20, 145, 275, 20);
		add(lblMayuscula);
		System.out.println(lblMayuscula.getText().length());
		lblCaracteresTam = new JLabel("Digite al menos 12 Caracteres         ");
		lblCaracteresTam.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblCaracteresTam.setBounds(20, 160, 275, 20);
		add(lblCaracteresTam);
		System.out.println(lblCaracteresTam.getText().length());
		lblMinuscula = new JLabel("Digite al menos 1 Min\u00FAscula             ");
		lblMinuscula.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblMinuscula.setBounds(20, 175, 275, 20);
		add(lblMinuscula);
		System.out.println(lblMinuscula.getText().length());
		lblEspecial = new JLabel("Digite al menos 1 C\u00E1racter especial ");
		lblEspecial.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblEspecial.setBounds(20, 190, 275, 20);
		add(lblEspecial);
	}
		private void combrobarPassword() {
			Color colocariconColor;
			RSeguridad_Contraseña comprobar = new RSeguridad_Contraseña(contra1.getPassword());
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
