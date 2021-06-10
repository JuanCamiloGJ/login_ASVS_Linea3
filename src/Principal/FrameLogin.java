package Principal;



import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class FrameLogin extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FrameLogin() {
		
		
		// TODO Auto-generated constructor stub
		setBounds(800, 300, 1350,988);//buscar un metodo para centrar siempre en la pantalla
		setTitle("Bienvenido a Safety");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("./Imagenes/escudoicono.png"));
		PanelFondo fondo= new PanelFondo();
		PanelSupreme todoslospanel=new PanelSupreme();
		confirmacionvisualbd confirma=new confirmacionvisualbd();
		GestionarDatos gestionarDatos=new GestionarDatos();
		confirma.setBounds(30, 30, 200, 20);
		add(confirma);
		add(todoslospanel);
		add(fondo); 
		
		
		
		
		
		
		repaint();
		
		
		//dejalo al final del constructor
		setVisible(true);
	}
	
	
}
