package Principal;



 
import java.util.Properties;
 
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
 
public class MailUtil {
 
	/**
	 * @Title: herramienta de env�o de correo
	  * @Description: se requiere la contrase�a de la cuenta de correo electr�nico de Outlook
	 * @param: to
	 * @return: String
	 * @throws 
	 */
	public static String sendMain(String to) {
		 String from = "Safety.CodeCheck@outlook.com"; // Direcci�n de correo electr�nico del remitente
		 // String to = "�����@qq.com"; // Correo electr�nico del destinatario
		 // Obtiene las propiedades del sistema, que se utilizan principalmente para establecer par�metros relacionados con el correo electr�nico.
		Properties properties = System.getProperties();
		 // Configure el servidor de transferencia de correo. Dado que esta es una operaci�n de env�o de correo, necesitamos configurar el protocolo smtp. De acuerdo con los requisitos del correo de sincronizaci�n oficial de Outlook, configure la direcci�n del protocolo, el n�mero de puerto y el m�todo de cifrado a su vez
		properties.setProperty("mail.smtp.host", "smtp.office365.com");
		properties.setProperty("mail.smtp.port", "587");
		properties.setProperty("mail.smtp.starttls.enable", "true");
		 // Verificaci�n del usuario y volver a la sesi�n, activar la verificaci�n del usuario, configurar la contrase�a de la cuenta para enviar correo electr�nico.
		properties.setProperty("mail.smtp.auth", "true");
		Session session = Session.getDefaultInstance(properties, new Authenticator() {
		    @Override
		    protected PasswordAuthentication getPasswordAuthentication() {
		         return new PasswordAuthentication ("Safety.CodeCheck@outlook.com", "Linea3@password"); // Contrase�a de la cuenta
		    }
		});
		
		 // Cree un objeto de mensaje MimeMessage, el encabezado del mensaje se configura 
		//con la direcci�n del buz�n de env�o y recepci�n, y el cuerpo del mensaje contiene 
		//el t�tulo y el contenido del mensaje. Tipo de destinatario: TO significa env�o directo,
		//CC significa CC y BCC significa CC secreto.
		try {
		    MimeMessage message = new MimeMessage(session);
		    message.addHeader("X-Mailer","Microsoft Outlook Express 6.00.2900.2869");
		    message.setFrom(new InternetAddress(from));
		    message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		     message.setSubject ("Requisitos de admisi�n e informaci�n de la solicitud");
		     message.setText ("�Consulte el archivo adjunto para ver contenido espec�fico!");
//		    Transport.send(message);
 // System.out.println ("�Enviado con �xito!");
		     Transport transporte= session.getTransport("smtp");
				transporte.connect("Safety.CodeCheck@outlook.com","Linea3@password");
				transporte.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
				transporte.close();
				
				/*
				 * // 1. Crea un cuerpo de mensaje compuesto Multipart multipart = new
				 * MimeMultipart(); // 2. Agregar archivo adjunto BodyPart filePart = new
				 * MimeBodyPart(); String filePath = "/data/ISC2019130.xlsx"; DataSource source
				 * = new FileDataSource(filePath); filePart.setDataHandler(new
				 * DataHandler(source)); filePart.setFileName(source.getName());
				 * multipart.addBodyPart(filePart); // 3. Agrega contenido de texto MimeBodyPart
				 * textPart = new MimeBodyPart(); textPart.setText
				 * ("�Correo de prueba que contiene texto y archivos adjuntos!");
				 * multipart.addBodyPart(textPart); // 4. Vincular el objeto de mensaje
				 * message.setContent(multipart); // 5. Enviar correo
				 */			
				//Transport.send(message);
				JOptionPane.showMessageDialog(null, "Correo enviado");
		    return "success";
		} catch (MessagingException e) {
		    e.printStackTrace();
		    return "failed";
		}
		
	}}
 
