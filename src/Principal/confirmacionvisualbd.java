package Principal;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class confirmacionvisualbd extends JPanel {

	private static JLabel lbltextinformativo;
	public confirmacionvisualbd() {
		setLayout(null);
		
		lbltextinformativo = new JLabel("New label");
		lbltextinformativo.setBounds(10, 0, 332, 23);
		add(lbltextinformativo);
		
	}
	public static JLabel getLbltextinformativo() {
		return lbltextinformativo;
	}
	public static void setLbltextinformativo(String lbltextinformativo) {
		confirmacionvisualbd.lbltextinformativo.setText(lbltextinformativo);
	}

}
