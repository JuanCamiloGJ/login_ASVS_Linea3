package Principal;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;

import IndexP.ValidacionTXT;

import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.security.PublicKey;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class PanelRecuperarCuenta extends JPanel {
	private JTextField correorecuperar;
	private JTextField captchatxt;
	private JLabel lblcaptcha;
	private String captchatext;
	private static String codigoVerificacionEmail;
	public static String correorecuperartxt;

	/**
	 * Create the panel.
	 */
	public PanelRecuperarCuenta() {
		setBackground(Color.WHITE);
		setBounds(81, 100, 300, 376);
		setLayout(null);
		
		JLabel lblTittle = new JLabel("Recuperar Cuenta");
		lblTittle.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblTittle.setBounds(64, 36, 171, 26);
		add(lblTittle);
		
		JLabel lblNewLabel_1 = new JLabel("<html>Digita el correo electronico<br/> asociado a tu cuenta</html>");
		lblNewLabel_1.setForeground(new Color(102, 102, 102));
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(64, 73, 180, 40);
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		add(lblNewLabel_1);
		
		correorecuperar = new JTextField();
		ValidacionTXT validartxtfiel= new ValidacionTXT(correorecuperar, 40);
		correorecuperar.setFont(new Font("SansSerif", Font.PLAIN, 16));
		correorecuperar.setBounds(35, 130, 236, 34);
		TextPrompt holderPrompt=new TextPrompt("Correo Electrónico", correorecuperar);
		add(correorecuperar);
		correorecuperar.setColumns(10);
		
		JButton btnenviar = new JButton("Enviar");
		btnenviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			boolean estado=false;
			String captchaString;
			if (!correorecuperar.getText().equals("")) {
				if(captchatxt.getText().equals(captchatext)) {
					correorecuperartxt=correorecuperar.getText();
					cargaCaptcha();
					captchatxt.setText("");
					
					if(GestionarDatos.ConsultaCorreoRecuperacion(correorecuperartxt)) {
						codigocorreoCaptcha();
						System.out.println(getCodigoVerificacionEmail());
						estado =EnvioCorreos.enviarCodeRecu(correorecuperartxt, "Safety - Alerta de seguridad para: "+correorecuperartxt+ " ",
							GestionarDatos.getNamerecuperacionString()+" Tu código de recuperación es: "+codigoVerificacionEmail, 
							"Si "+correorecuperartxt+" coincide con la dirección de correo eletrónico\n de tu cuenta, te enviaremos un código de recuperación.");
						PanelSupreme.mostrarPanelValidacionCode();
					
					}else {
						JOptionPane.showMessageDialog(null, "Si "+correorecuperartxt+" coincide con la dirección de correo eletrónico de tu cuenta, te enviaremos un código de recuperación.","Aviso del estado del correo", JOptionPane.INFORMATION_MESSAGE);
						PanelSupreme.mostrarPanelValidacionCode();
					}
					
					
				}else {
					JOptionPane.showMessageDialog(null, "Error, el texto introducido no coincide con la imagen", "Captcha Incorrecto", JOptionPane.ERROR_MESSAGE);
					cargaCaptcha();
					captchatxt.setText("");
					
				}
			}else {
				JOptionPane.showMessageDialog(null, "Error, No ha introducido ningún correo", "Sin Correo", JOptionPane.ERROR_MESSAGE);
			}
			
			
			}
		});
		
		
		btnenviar.setBackground(new Color(44,201,192));
		btnenviar.setForeground(new Color(255, 255, 255));
		btnenviar.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnenviar.setBounds(35, 275, 236, 34);
		add(btnenviar);
		
		captchatxt = new JTextField();
		validartxtfiel= new ValidacionTXT(captchatxt, 15);
		captchatxt.setBounds(35, 248, 134, 20);
		add(captchatxt);
		captchatxt.setColumns(10);
		
		lblcaptcha = new JLabel("");
		lblcaptcha.setBounds(35, 207, 148, 40);
		cargaCaptcha();
		add(lblcaptcha);
		
		JLabel lblNewLabel = new JLabel("<html>Copie en el espacio en blanco <br/> la combinaci\u00F3n de letras y/o n\u00FAmeros. </html>");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblNewLabel.setBounds(35, 167, 255, 45);
		add(lblNewLabel);
		
		JButton btnrecharge = new JButton("");
		btnrecharge.setIcon(new ImageIcon("./Imagenes/refresh_icon/res/drawable-mdpi/refresh_icon.png"));
		btnrecharge.setBorderPainted(false);
		btnrecharge.setOpaque(false);                 
		btnrecharge.setBackground(new Color(0,0,0,0));
		btnrecharge.setContentAreaFilled(false);      
		
		btnrecharge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			cargaCaptcha();
			
			}
		});
		btnrecharge.setBounds(193, 215, 25, 25);
		add(btnrecharge);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(35, 313, 236, 6);
		add(separator);
		setVisible(false);
	}
	public void limpiarEspacios() {
		correorecuperar.setText("");
	}
	
	
	public void cargaCaptcha() {
		try {
			captchatext=TextToGraphics.generateImage();
			Image img= ImageIO.read(new File("./captcha/Text.png"));
			lblcaptcha.setIcon(new ImageIcon(img));
		
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private void codigocorreoCaptcha() {
		try {
			codigoVerificacionEmail=captchaGenerador.createCaptchaValue();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	public static String getCodigoVerificacionEmail() {
		return codigoVerificacionEmail;
	}

	private static void setCodigoVerificacionEmail(String codigoVerificacionEmail1) {
		codigoVerificacionEmail = codigoVerificacionEmail1;
	}
}
