package Principal;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JToolBar;

public class PanelMensajeRegistro extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelMensajeRegistro() {
		setBackground(Color.WHITE);
		setBounds(81, 100, 300, 376);
		setLayout(null);
		setVisible(false);
		JLabel lblImagenRegistro = new JLabel("");
		
		
		lblImagenRegistro.setBounds(114, 29, 80, 80);
		lblImagenRegistro.setIcon(pintarimagen("./Imagenes/checkcircle/res/drawable-xxxhdpi/cheackcircle.png", lblImagenRegistro));
		add(lblImagenRegistro);
		
		JLabel lblMsj1 = new JLabel("\u00A1Registro Exitoso!");
		lblMsj1.setForeground(new Color(51, 51, 51));
		lblMsj1.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblMsj1.setBounds(69, 115, 171, 26);
		add(lblMsj1);
		
		JLabel lblmsj2 = new JLabel("Se ha registrado correctamente, inice sesi\u00F3n.");
		lblmsj2.setForeground(new Color(102, 102, 102));
		lblmsj2.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblmsj2.setBounds(7, 180, 295, 20);
		add(lblmsj2);
		setVisible(false);
	}
	private Icon pintarimagen(String ruta,JLabel lblimagen) {
		ImageIcon imagenIcon= new ImageIcon(ruta);
		Icon icono= new ImageIcon(imagenIcon.getImage().getScaledInstance(lblimagen.getWidth(), lblimagen.getHeight(), Image.SCALE_AREA_AVERAGING));
		return icono;
	}
}
