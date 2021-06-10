package Principal;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javax.swing.JOptionPane;

/*import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;*/



public class EnvioCorreos {

	private static String port="587";
	private static String correoString="Safety.CodeCheck@outlook.com";
	private  static String contraString="BPXkaSKc3MR6sjJ5";
	public EnvioCorreos() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean enviarCodeRecu(String emaildestino, String asuntodestino,String mensajedestino,String mensajeconfirmacion) {
		
		System.out.println("el puerto es:"+ port+ "correo: "+ correoString+ "pass:"+ contraString);
		Properties propiedad= new Properties();
		propiedad.put("mail.smtp.ssl.trust", "smtp-relay.sendinblue.com");
		propiedad.setProperty("mail.smtp.host", "smtp-relay.sendinblue.com");
		propiedad.setProperty("mail.smtp.user", correoString);
		propiedad.setProperty("mail.smtp.clave", contraString);
		propiedad.setProperty("mail.smtp.port", port);//587 o 25 probar si falla no modificar nada más
		propiedad.setProperty("mail.smtp.starttls.enable", "true");
		propiedad.setProperty("mail.smtp.auth", "true");
		
		String correoEnvia= correoString;
		 String contrasena= contraString;
		 String destinatario = emaildestino;
		 String asunto= asuntodestino;
		 String mensaje =mensajedestino;
		
		Session sesion = Session.getDefaultInstance(propiedad, new Authenticator() {
		    @Override
		    protected PasswordAuthentication getPasswordAuthentication() {
		         return new PasswordAuthentication (correoEnvia, contrasena); // Contraseña de la cuenta
		    }
		});
		 
		 try {
			MimeMessage mail=new MimeMessage(sesion);
			mail.setFrom(new InternetAddress(correoEnvia));
			mail.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
			mail.setSubject(asunto);
			mail.setText(mensaje);
			
			Transport transporte= sesion.getTransport("smtp");
			transporte.connect("smtp-relay.sendinblue.com", Integer.parseInt(port) ,correoEnvia,contrasena);
			transporte.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
			transporte.close();
			JOptionPane.showMessageDialog(null, mensajeconfirmacion,"Aviso del estado de la cuenta.", JOptionPane.INFORMATION_MESSAGE);
			return true;
		 } catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//enviarCodeRecu(destinatario, asunto, mensaje, mensajeconfirmacion);
			JOptionPane.showMessageDialog(null,e.getMessage()+ "El correo no se pudo enviar :( intenta nuevamente, si el error persiste contacta con el administrador.","Aviso del estado del correo",JOptionPane.ERROR_MESSAGE);
			return false;
		 }
	}
	
	public static boolean enviarInformacionCambiocontra(String emaildestino, String asuntodestino,String mensajedestino) {
		
		System.out.println("el puerto es:"+ port+ "correo: "+ correoString+ "pass:"+ contraString);
		Properties propiedad= new Properties();
		propiedad.setProperty("mail.smtp.host", "smtp-relay.sendinblue.com");
		propiedad.setProperty("mail.smtp.user", correoString);
		propiedad.setProperty("mail.smtp.clave", contraString);
		propiedad.setProperty("mail.smtp.port", port);//587 o 25 probar si falla no modificar nada más
		propiedad.setProperty("mail.smtp.starttls.enable", "true");
		propiedad.setProperty("mail.smtp.auth", "true");
		propiedad.put("mail.smtp.ssl.trust", "smtp-relay.sendinblue.com");
		String correoEnvia= correoString;
		 String contrasena= contraString;
		 String destinatario = emaildestino;
		 String asunto= asuntodestino;
		 String mensaje =mensajedestino;
		
		Session sesion = Session.getDefaultInstance(propiedad, new Authenticator() {
		    @Override
		    protected PasswordAuthentication getPasswordAuthentication() {
		         return new PasswordAuthentication (correoEnvia, contrasena); // Contraseña de la cuenta
		    }
		});
		 
		 try {
			MimeMessage mail=new MimeMessage(sesion);
			mail.setFrom(new InternetAddress(correoEnvia));
			mail.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
			mail.setSubject(asunto);
			mail.setText(mensaje);
			
			Transport transporte= sesion.getTransport("smtp");
			transporte.connect("smtp-relay.sendinblue.com", Integer.parseInt(port) ,correoEnvia,contrasena);
			transporte.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
			transporte.close();
			//JOptionPane.showMessageDialog(null, mensajeconfirmacion,"Aviso del estado del correo", JOptionPane.INFORMATION_MESSAGE);
			return true;
		 } catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//enviarInformacionCambiocontra(destinatario, asunto, mensaje);
			JOptionPane.showMessageDialog(null, e.getMessage()+ "El correo no se pudo enviar :( intenta nuevamente, si el error persiste contacta con el administrador.","Aviso del estado del correo",JOptionPane.ERROR_MESSAGE);
			return false;
		 }
	}
	
}
