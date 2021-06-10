package Principal;


import javax.swing.JFrame;
import javax.swing.UIManager;





public class Start {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//JFrame.setDefaultLookAndFeelDecorated(true);
		//SubstaceLookAndFeel.setSkin("de.javasoft.synthetica.standar");
		//JFrame.setDefaultLookAndFeelDecorated(true);
		//JDialog.setDefaultLookAndFeelDecorated(true);
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 iniciar= new FrameLogin();
		
	}
	private static FrameLogin iniciar;
	public static void LoginCerrar(boolean cierrate) {
		if (cierrate) {
			iniciar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			iniciar.dispose();
		}

	}
}
