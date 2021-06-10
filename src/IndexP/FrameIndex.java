package IndexP;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Principal.PanelFondo;

import java.awt.Toolkit;

public class FrameIndex extends JFrame {

	private JPanel contentPane;

	public FrameIndex() {
		setTitle("Safety - Gestion");
		setIconImage(Toolkit.getDefaultToolkit().getImage("./Imagenes/escudoicono.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 300, 1345, 983);
		setResizable(false);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		PanelIndexSupreme panelIndexSupreme = new PanelIndexSupreme();
		getContentPane().add(panelIndexSupreme);

		PanelFondo fondo = new PanelFondo();

		fondo.setBounds(0, 0, 1345, 983);
		getContentPane().add(fondo);
		setVisible(true);

	}

}
