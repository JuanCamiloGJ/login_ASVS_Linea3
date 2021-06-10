package IndexP;

import javax.swing.JPanel;

import Principal.GestionarDatos;
import Principal.PanelSupreme;
import Principal.Start;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class PanelIndexSupreme extends JPanel {

	/**
	 * Create the panel.
	 */
	private static PanelIndexTablaGestion panelIndexTablaGestion;
	private static PanelIndexCambiarContraseña panelIndexCambiarContraseña;
	private JButton btncerrarsesion;
	private int estado=1;
	private JLabel lblEscudo, lblLogo;
	public PanelIndexSupreme() {
		
		setBounds(100, 100, 1140,750);
		setBackground(new Color(243,242,242,220));
		setLayout(null);
		
		
		
		panelIndexCambiarContraseña= new PanelIndexCambiarContraseña();
		panelIndexTablaGestion=new PanelIndexTablaGestion(GestionarDatos.getRoliniciado());
		panelIndexTablaGestion.setBounds(100, 100, 940, 545);
		
		JButton btncambiarcontra = new JButton("Cambiar Contrase\u00F1a");
		btncambiarcontra.setBackground(new Color(44, 201, 192));
		btncambiarcontra.setForeground(new Color(255, 255, 255));
		btncambiarcontra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(estado==1) {
			panelIndexCambiarContraseña.setVisible(true);
			panelIndexTablaGestion.setVisible(false);
			panelIndexCambiarContraseña.limpiarEspacios();
			btncambiarcontra.setText("Atrás");
			estado=0;
			}else if (estado==0) {
				panelIndexCambiarContraseña.setVisible(false);
				panelIndexTablaGestion.setVisible(true);
				btncambiarcontra.setText("Cambiar Contraseña");
				estado=1;
			}
		}});
		btncambiarcontra.setFont(new Font("SansSerif", Font.BOLD, 16));
		btncambiarcontra.setBounds(753, 114, 187, 38);
		
		
		btncerrarsesion = new JButton("Cerrar Sesi\u00F3n");
		btncerrarsesion.setBackground(new Color(44, 201, 192));
		btncerrarsesion.setForeground(new Color(255, 255, 255));
		btncerrarsesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea cerrar sesión?")==0) {
					
					try {
						Start.main(null);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					System.exit(0);
				}
			}
		});
		btncerrarsesion.setFont(new Font("SansSerif", Font.BOLD, 16));
		btncerrarsesion.setBounds(753, 176, 187, 38);
		
		add(btncambiarcontra);
		add(btncerrarsesion);
		add(panelIndexCambiarContraseña);
		add(panelIndexTablaGestion);
		
		
		lblEscudo = new JLabel("");
		lblEscudo.setBounds(397, 18, 75, 71);
		lblEscudo.setIcon(pintarimagen("./Imagenes/escudoicono.png", lblEscudo));;
		
		add(lblEscudo);
		
		lblLogo = new JLabel("");
		lblLogo.setBounds(497, 23, 119, 61);
		lblLogo.setIcon(pintarimagen("./Imagenes/safety.png", lblLogo));
		add(lblLogo);
		
		repaint();
	}
	private Icon pintarimagen(String ruta,JLabel lblimagen) {
		ImageIcon imagenIcon= new ImageIcon(ruta);
		Icon icono= new ImageIcon(imagenIcon.getImage().getScaledInstance(lblimagen.getWidth(), lblimagen.getHeight(), Image.SCALE_AREA_AVERAGING));
		return icono;
	}
}

