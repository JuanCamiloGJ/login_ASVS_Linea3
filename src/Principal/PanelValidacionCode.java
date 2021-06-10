package Principal;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import IndexP.FrameIndex;
import IndexP.ValidacionTXT;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelValidacionCode extends JPanel {
	private JTextField txtcode;
	public static int intentos=0;
	/**
	 * Create the panel.
	 */
	public PanelValidacionCode() {
		setBackground(Color.WHITE);
		setBounds(81, 100, 300, 376);
		setLayout(null);
		setVisible(false);
		JLabel lblTittle = new JLabel("Recuperar Cuenta");
		lblTittle.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblTittle.setBounds(64, 36, 171, 26);
		add(lblTittle);
		JLabel lblNewLabel_1 = new JLabel("<html>Digita el código que hemos enviado<br/> al correo electronico proporcionado.</html>");
		lblNewLabel_1.setForeground(new Color(102, 102, 102));
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(42, 73, 218, 40);
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		add(lblNewLabel_1);
		
		txtcode = new JTextField("");
		ValidacionTXT validartxtfiel= new ValidacionTXT(txtcode, 15);
		txtcode.setFont(new Font("SansSerif", Font.BOLD, 25));
		txtcode.setBounds(42, 169, 218, 51);
		add(txtcode);
		txtcode.setColumns(10);
		
		JButton btnvalidar = new JButton("Confirmar");
		btnvalidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String codeString= PanelRecuperarCuenta.getCodigoVerificacionEmail();
			System.out.println("code:"+ codeString + "intentos:"+ intentos );
			if(intentos<3) {	
			
			if(codeString.equals(txtcode.getText())) {
					
					intentos=0;
					txtcode.setText("");
					PanelSupreme.mostrarPanelCambiarPassRecu();
				}else {
					JOptionPane.showMessageDialog(null, "El código introducido no coincide con el enviado.","¡Alerta!",JOptionPane.ERROR_MESSAGE);
					
					intentos++;
				}
			}else {
				JOptionPane.showMessageDialog(null, "Se han terminado los intentos, prueba nuevamente.","Atención",JOptionPane.WARNING_MESSAGE);
				txtcode.setText("");
				intentos=0;
				PanelSupreme.mostrarPanelLogin();
			}
			}
		});
		btnvalidar.setBackground(new Color(44, 201, 192));
		btnvalidar.setForeground(Color.WHITE);
		btnvalidar.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnvalidar.setBounds(87, 237, 128, 34);
		add(btnvalidar);
	}
	public PanelValidacionCode(String A) {
		setBackground(Color.WHITE);
		setBounds(81, 100, 300, 376);
		setLayout(null);
		setVisible(false);
		JLabel lblTittle = new JLabel("Recuperar Cuenta");
		lblTittle.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblTittle.setBounds(64, 36, 171, 26);
		add(lblTittle);
		JLabel lblNewLabel_1 = new JLabel("<html>Digita el código que hemos enviado<br/> al correo electronico proporcionado.</html>");
		lblNewLabel_1.setForeground(new Color(102, 102, 102));
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(42, 73, 218, 40);
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		add(lblNewLabel_1);
		
		txtcode = new JTextField("");
		txtcode.setFont(new Font("SansSerif", Font.BOLD, 25));
		txtcode.setBounds(42, 169, 218, 51);
		add(txtcode);
		txtcode.setColumns(10);
		
		JButton btnvalidar = new JButton("Confirmar");
		btnvalidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String codeString= GestionarDatos.getCodecpiniciosesion();
			System.out.println("code:"+ codeString + "intentos:"+ intentos );
			if(intentos<3) {	
			
			if(codeString.equals(txtcode.getText())) {
					
					intentos=0;
					txtcode.setText("");
					FrameIndex frameIndex=new FrameIndex();
					Start.LoginCerrar(true);
				}else {
					JOptionPane.showMessageDialog(null, "El código introducido no coincide con el enviado.","¡Alerta!",JOptionPane.ERROR_MESSAGE);
					
					intentos++;
				}
			}else {
				JOptionPane.showMessageDialog(null, "Se han terminado los intentos, prueba nuevamente.","Atención",JOptionPane.WARNING_MESSAGE);
				txtcode.setText("");
				intentos=0;
				PanelSupreme.mostrarPanelLogin();
			}
			}
		});
		btnvalidar.setBackground(new Color(72, 209, 204));
		btnvalidar.setForeground(Color.WHITE);
		btnvalidar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnvalidar.setBounds(87, 237, 128, 34);
		add(btnvalidar);
	}
	public void limpiarEspacios() {
		
		txtcode.setText("");
	}
}
