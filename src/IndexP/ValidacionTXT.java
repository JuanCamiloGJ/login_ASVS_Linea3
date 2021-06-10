package IndexP;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ValidacionTXT {

	
	public ValidacionTXT(JPasswordField jtxt, int limite) {
		// TODO Auto-generated constructor stub
	
		JPasswordField fielpass= jtxt;
		fielpass.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				;
				if (String.valueOf(fielpass.getPassword()).length()>=limite) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	public ValidacionTXT(JTextField jtxt, int limite) {
		// TODO Auto-generated constructor stub
	
		JTextField fielpass= jtxt;
		fielpass.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				;
				if (fielpass.getText().length()>=limite) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
}
