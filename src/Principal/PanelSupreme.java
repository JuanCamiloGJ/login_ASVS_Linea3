package Principal;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;



import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;

public class PanelSupreme extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	
	private static JButton btnLogout;
	private static int estadopanel=0;
	
		private	static PanelLogin panelcentral;
		private	static PanelLogout panelsecundario;
		private static	PanelLogout2 panelterciario;
		private static PanelMensajeRegistro panelmsjre;
		private static PanelRecuperarCuenta panelrecuperacionCuenta;
		private static PanelValidacionCode panelValidacionCode;
		private static PanelCambiarPassRecu panelCambiarPassRecu;
		private static PanelValidacionCode panelValidacionCode2;
		private JLabel lblescudo;
		private JLabel lbllogo;
	
	
	public PanelSupreme() {
		setBackground(new Color(243,242,242,220));
		setLayout(null);
		setBounds(409, 141, 462, 517);
		
		 panelcentral = new PanelLogin();
		 panelsecundario = new PanelLogout();//esta invisible
		 panelterciario= new PanelLogout2();
		 panelmsjre= new PanelMensajeRegistro();
		 panelrecuperacionCuenta = new PanelRecuperarCuenta();
		 panelValidacionCode = new PanelValidacionCode();
		 panelCambiarPassRecu = new PanelCambiarPassRecu();
		 panelValidacionCode2 = new PanelValidacionCode("");
		  btnLogout = new JButton("Crear nueva cuenta");
		  btnLogout.setForeground(Color.WHITE); btnLogout.setBackground(new
		  Color(37,99,96)); btnLogout.setFont(new Font("SansSerif", Font.PLAIN, 13));
		  btnLogout.addActionListener(new ActionListener() { public void
		  actionPerformed(ActionEvent e) {
			  if (estadopanel==0) {
				  //pone el panel principal invisible
				  panelcentral.setVisible(false);
				  //pone el panel invisible a visible
				  panelsecundario.setVisible(true);
				  panelterciario.setVisible(false);
				  estadopanel=1;
				  btnLogout.setText("Ya Tengo una Cuenta");
				  btnLogout.setBounds(157, 427, 156, 34);
			}else if(estadopanel==1){
				//pone el panel principal visible
				  panelcentral.setVisible(true);
				  //pone el panel secundario invisible 
				  panelsecundario.setVisible(false);
				  panelterciario.setVisible(false);
				  panelmsjre.setVisible(false);
				  panelrecuperacionCuenta.setVisible(false);
				  panelCambiarPassRecu.setVisible(false);
				  panelValidacionCode.setVisible(false);
				  panelCambiarPassRecu.limpiarEspacios();
				  panelValidacionCode.limpiarEspacios();
				  panelrecuperacionCuenta.limpiarEspacios();
				  panelsecundario.limpiarEspacios();
				  panelterciario.limpiarEspacios();
				  estadopanel=0;
				  PanelValidacionCode.intentos=0;
				  btnLogout.setText("Crear nueva cuenta");
				  btnLogout.setBounds(153, 352, 156, 34);
			}else if(estadopanel==3) {
				panelterciario.setVisible(false);
				panelsecundario.setVisible(false);
				panelmsjre.setVisible(false);
				panelcentral.setVisible(true);
				btnLogout.setText("Atrás");
				btnLogout.setBounds(153, 430, 156, 34);
				estadopanel++;
			}
			
		  
		  } }); btnLogout.setBounds(153, 352, 156, 34); 
		  
		  
		  this.add(btnLogout);
		
		
		
		
		
		
		add(panelcentral);
		add(panelsecundario);
		add(panelterciario);
		add(panelmsjre);
		add(panelrecuperacionCuenta);
		add(panelValidacionCode);
		add(panelCambiarPassRecu);
		add(panelValidacionCode2);
		
		lblescudo = new JLabel("");
		lblescudo.setBounds(149, 25, 55, 54);
		
		lblescudo.setIcon(pintarimagen("./Imagenes/escudoicono.png", lblescudo));;
		
		
		add(lblescudo);
		
		lbllogo = new JLabel("");
		lbllogo.setBounds(190, 22, 119, 60);
		lbllogo.setIcon(pintarimagen("./Imagenes/safety.png", lbllogo));
		add(lbllogo);
		repaint();
		 
	}
	
	private Icon pintarimagen(String ruta,JLabel lblimagen) {
		ImageIcon imagenIcon= new ImageIcon(ruta);
		Icon icono= new ImageIcon(imagenIcon.getImage().getScaledInstance(lblimagen.getWidth(), lblimagen.getHeight(), Image.SCALE_AREA_AVERAGING));
		return icono;
	}
	
	public static void mostrarPanelLogout2() {
		System.out.println("entra");
		panelsecundario.setVisible(false);
		panelterciario.setVisible(true);
		btnLogout.setText("Atrás");
		btnLogout.setBounds(153, 430, 156, 34);
		estadopanel=0;
		
	}
	public static void mostrarPanelLogin() {
		panelsecundario.setVisible(false);
		panelterciario.setVisible(false);
		panelcentral.setVisible(true);
		panelCambiarPassRecu.setVisible(false);
		panelValidacionCode.setVisible(false);
		panelCambiarPassRecu.limpiarEspacios();
		btnLogout.setText("Crear nueva cuenta");
		btnLogout.setBounds(153, 352, 156, 34);
		estadopanel=0;
	}
	public static void mostrarPanelMensajeRegistro() {
		panelsecundario.setVisible(false);
		panelterciario.setVisible(false);
		panelcentral.setVisible(false);
		panelmsjre.setVisible(true);
		btnLogout.setText("Aceptar");
		btnLogout.setBounds(153, 352, 156, 34);
		estadopanel=1;
		
	}
	
	public static void mostrarPanelRecuperarCuenta() {
		panelcentral.setVisible(false);
		panelrecuperacionCuenta.setVisible(true);
		btnLogout.setText("Atrás");
		btnLogout.setBounds(153, 430, 156, 34);
		estadopanel=1;
		
	}
	
	public static void mostrarPanelValidacionCode() {
		
		btnLogout.setText("Inicio");
		btnLogout.setBounds(153, 430, 156, 34);
		panelValidacionCode.setVisible(true);
		panelcentral.setVisible(false);
		panelrecuperacionCuenta.setVisible(false);
		panelmsjre.setVisible(false);
		panelsecundario.setVisible(false);
		panelterciario.setVisible(false);
		estadopanel=1;
	}
	
	public static void mostrarPanelCambiarPassRecu() {
		btnLogout.setText("Inicio");
		btnLogout.setBounds(153, 430, 156, 34);
		panelValidacionCode.setVisible(false);
		panelcentral.setVisible(false);
		panelrecuperacionCuenta.setVisible(false);
		panelmsjre.setVisible(false);
		panelsecundario.setVisible(false);
		panelterciario.setVisible(false);
		panelCambiarPassRecu.setVisible(true);
		estadopanel=1;
		
	}
public static void mostrarPanelValidacionCode2() {
		
		btnLogout.setText("Inicio");
		btnLogout.setBounds(153, 430, 156, 34);
		panelValidacionCode.setVisible(false);
		panelcentral.setVisible(false);
		panelrecuperacionCuenta.setVisible(false);
		panelmsjre.setVisible(false);
		panelsecundario.setVisible(false);
		panelterciario.setVisible(false);
		panelValidacionCode2.setVisible(true);
		estadopanel=1;
	}
	public JLabel getLblescudo() {
		return lblescudo;
	}
	public JLabel getLbllogo() {
		return lbllogo;
	}
}
