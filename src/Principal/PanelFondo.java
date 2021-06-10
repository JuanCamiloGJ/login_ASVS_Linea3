package Principal;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Rectangle;

public class PanelFondo extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private ImageIcon imagenIcon;
	private Icon icono;
	private JLabel lblimagen;
	
	public PanelFondo() {
		setBackground(Color.WHITE);
		setBounds(0, 0, 1350,988);
		
		//pintarimagen(lblNewLabel, );
		
		setLayout(null);
		
		lblimagen = new JLabel("");
		lblimagen.setBackground(new Color(46, 139, 87));
		lblimagen.setBounds(0, 0, 1350, 988);
		
		lblimagen.setIcon(pintarimagen("./Imagenes/fondolog.png"));
		add(lblimagen);
		
		
		
		
	}
	
	private Icon pintarimagen(String ruta) {
		this.imagenIcon= new ImageIcon(ruta);
		this.icono= new ImageIcon(this.imagenIcon.getImage().getScaledInstance(lblimagen.getWidth(), lblimagen.getHeight(), Image.SCALE_AREA_AVERAGING));
		return icono;
	}
}
