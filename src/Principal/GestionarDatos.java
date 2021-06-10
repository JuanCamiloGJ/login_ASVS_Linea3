package Principal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.print.attribute.standard.Sides;
import javax.swing.JOptionPane;

import IndexP.FrameIndex;
import conector.conexionSQL;
import conector.conexionSQLite;

public class GestionarDatos {


		private static String correoString,contrasenaString,pregunta1String,respuesta1String,pregunta2String,respuesta2String,pregunta3String,respuesta3String;
		private static String nombreString;
		private static conexionSQLite ccConexionSQL= new conexionSQLite();
		private static Connection con= ccConexionSQL.conexion();
		private static String codecpiniciosesion;
		public GestionarDatos() {
			
	
	}
	
	public static void ACorreoContraseña(String nombre,String correo,String Contrasena) {
		nombreString=nombre;
		correoString=correo;
		contrasenaString=Contrasena;
		
	}
	
	public static void APreguntas(String p1,String r1,String p2,String r2,String p3,String r3) {
		
		pregunta1String=p1;
		respuesta1String=r1;
		
		pregunta2String=p2;
		respuesta2String=r2;
		
		pregunta3String=p3;
		respuesta3String=r3;
	}
	
	public static boolean CargarBDCrearUser() {
		
		
		  try { 
		  String  SQL="INSERT INTO usuarios (correo, nombres, rol, password,segundofactor) VALUES(?,?,?,?,?)";
		  PreparedStatement pst= con.prepareStatement(SQL);
		  pst.setString(1,correoString); 
		  pst.setString(2, nombreString); 
		  pst.setString(3, "Normal");
		  pst.setString(4, contrasenaString); 
		  pst.setBoolean(5, false);
		  pst.execute();
		  SQL="INSERT INTO preguntasuser (pregunta1, respuesta1, pregunta2, respuesta2, pregunta3, respuesta3) VALUES(?,?,?,?,?,?)";
		  pst= con.prepareStatement(SQL);
		  pst.setString(1, pregunta1String);
		  pst.setString(2, respuesta1String); 
		  pst.setString(3, pregunta2String);
		  pst.setString(4, respuesta2String);
		  pst.setString(5, pregunta3String);
		  pst.setString(6, respuesta3String); 
		  pst.execute();
		  
		  System.out.println("Se cargaron los datos correctamente!");
		  
		  } catch (Exception e) { // TODO: handle exception
		  System.out.println("No se pudieron cargar los datos :("); }
		 
		
		
		
		return true;
	
	}
	public static boolean ConsultaCorreoRecuperacion(String correoRecuperar) {
		boolean coincidencia=false;
		try {
			PreparedStatement pstm= con.prepareStatement("SELECT ID,correo, nombres FROM usuarios");
			ResultSet respuestaResultSet= pstm.executeQuery();
			while (respuestaResultSet.next()) {
				if(respuestaResultSet.getString("correo").equals(correoRecuperar)) {
					coincidencia=true;
					nombreConsultaCorreoCorreoRecuperacion(respuestaResultSet.getString("nombres"));
					setIdrecuperacion(respuestaResultSet.getString("ID"));
					setCorreoRecuperacion(respuestaResultSet.getString("correo"));
				}
				
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return coincidencia;
		
	}
	
	public static boolean CambiandoPassRecu(String passtochange) {
		String correochange =  PanelRecuperarCuenta.correorecuperartxt;
		
		 try { 
			  String  SQL="UPDATE usuarios SET password=? WHERE ID=?";
			  PreparedStatement pst= con.prepareStatement(SQL); 
			  pst.setString(1, passtochange); 
			  pst.setInt(2, idrecuperacion); 
			  
			  pst.executeUpdate();
			  System.out.println(passtochange + "correo:"+ correochange);
			  JOptionPane.showMessageDialog(null, "La contraseña a cambiado, inicie sesión.","Información",JOptionPane.INFORMATION_MESSAGE);
			  
			  } catch (Exception e) { 
			  System.out.println("No se pudieron cargar los datos :("); }
			 
		
		return false;
	}
	
	
	public static void nombreConsultaCorreoCorreoRecuperacion(String name) {
		namerecuperacionString=name;
		
	}
	private static String namerecuperacionString;
	private static int idrecuperacion;
	private static String correoRecuperacion;
	
	/**
	 * @return the correoRecuperacion
	 */
	public static String getCorreoRecuperacion() {
		return correoRecuperacion;
	}

	/**
	 * @param correoRecuperacion the correoRecuperacion to set
	 */
	public static void setCorreoRecuperacion(String correoRecuperacion) {
		GestionarDatos.correoRecuperacion = correoRecuperacion;
	}
	private static int idiniciado;
	private static String correoIniciado;
	
	/**
	 * @return the correoIniciado
	 */
	public static String getCorreoIniciado() {
		return correoIniciado;
	}

	/**
	 * @param correoIniciado the correoIniciado to set
	 */
	public static void setCorreoIniciado(String correoIniciado) {
		GestionarDatos.correoIniciado = correoIniciado;
	}
	private static String roliniciado;
	public static String getRoliniciado() {
		return roliniciado;
	}

	public static void setRoliniciado(String roliniciado) {
		GestionarDatos.roliniciado = roliniciado;
	}

	public static int getIdiniciado() {
		return idiniciado;
	}

	public static void setIdiniciado(String id) {
		idiniciado= Integer.parseInt(id);
	}

	public static int getIdrecuperacion() {
		return idrecuperacion;
	}

	public static void setIdrecuperacion(String id) {
		idrecuperacion = Integer.parseInt(id);
	}

	public static String getNamerecuperacionString() {
		return namerecuperacionString;
	}
	
	
	public static boolean CambiandoPassIniciado(String passtochange) {
		
		
		 try { 
			  String  SQL="UPDATE usuarios SET password=? WHERE ID=?";
			  PreparedStatement pst= con.prepareStatement(SQL); 
			  pst.setString(1, passtochange); 
			  pst.setInt(2, idiniciado); 
			  
			  pst.executeUpdate();
			  System.out.println();
			  JOptionPane.showMessageDialog(null, "La contraseña a cambiado.","Información",JOptionPane.INFORMATION_MESSAGE);
			  
			  } catch (Exception e) { // TODO: handle exception
			  System.out.println("No se pudieron cargar los datos :("); }
			 
		
		return false;
	}
	//verifica que la consraseña actual sea correcta a la hora de cmabiarla
	public static boolean VerificandoPassIniciado(String passtoverificar) {
		boolean coincidencia=false;
		try {
			PreparedStatement pstm= con.prepareStatement("SELECT ID, password FROM usuarios WHERE ID=?");
			pstm.setInt(1, idiniciado);
			Encrypt desencriptar=new Encrypt();
			ResultSet respuestaResultSet= pstm.executeQuery();
			while (respuestaResultSet.next()) {
				
				if(respuestaResultSet.getInt("ID")==(idiniciado)) {
					String passdecrypt= desencriptar.getAESDecrypt(respuestaResultSet.getString("password"));
					if(passdecrypt.equals(passtoverificar)) {
						coincidencia=true;
					}else {
						JOptionPane.showMessageDialog(null, "Su contraseña actual no coincide.");
						coincidencia=false;
					}
					
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return coincidencia;
		
	}
	
	////////iniciar sesion metodo//////
	
	public static boolean inicarSesion(String correo,String password) {
		
		boolean coincidencia =false;
		
		try {
			
			PreparedStatement psmStatement= con.prepareStatement("SELECT * FROM usuarios WHERE UPPER(correo)=UPPER(?)");
			psmStatement.setString(1, correo);
			ResultSet resultSet= psmStatement.executeQuery();

				Encrypt desencriptar= new Encrypt();
				
			if(!resultSet.isBeforeFirst()) {
				
					JOptionPane.showMessageDialog(null,
							 "¡Ups! algo a ocurrido, al parecer tu correo no esta registrado en el sistema :("
							 , "Información", JOptionPane.INFORMATION_MESSAGE);
				
				
				
				
			}else {
				
					
					while (resultSet.next()) {
						
						if (password.equals(desencriptar.getAESDecrypt(resultSet.getString("password")))) {
							coincidencia=true;
						}else {
							coincidencia=false;
						}
						
					
					if (coincidencia) {
						
						setIdiniciado(resultSet.getString("ID"));
						setRoliniciado(resultSet.getString("rol"));
						setCorreoIniciado(resultSet.getString("correo"));
						if(resultSet.getBoolean("segundofactor")){
							
							//se crea el Panel
							PanelSupreme.mostrarPanelValidacionCode2();
							codecpiniciosesion= captchaGenerador.createCaptchaValue();
							EnvioCorreos.enviarCodeRecu(getCorreoIniciado(), "Codigo de verificación de Inicio de Sesión", "ingresa el siguiente código para iniciar sesión con tu cuenta: "+codecpiniciosesion, "Se a enviado un código de inicio de sesión a su cuenta, revisa tu bandeja de entrada, o en la carpeta de SPAM.");
							
							///
							
						}else {
						@SuppressWarnings("unused")
						FrameIndex index= new FrameIndex();
						Start.LoginCerrar(coincidencia);
						}
					}else {
						JOptionPane.showMessageDialog(null, "¡Ups! algo a ocurrido, al parecer tu correo o contraseña no son validos :(", "Información", JOptionPane.INFORMATION_MESSAGE);
					}
			        }
			}
				
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage()+"es error");
		}
		
		
		
		
		
		
		return coincidencia;
	}


/////////////buscar base datos iniciado////////////
	
	

/**
	 * @return the codecpiniciosesion
	 */
	public static String getCodecpiniciosesion() {
		return codecpiniciosesion;
	}

public static void buscarUsuario(String correo) {
	try {
		PreparedStatement psmStatement= con.prepareStatement("SELECT * FROM usuarios WHERE UPPER(correo)=UPPER(?)");
		psmStatement.setString(1, correo);
		ResultSet resultSet= psmStatement.executeQuery();
		
		if(!resultSet.isBeforeFirst()) {
			JOptionPane.showMessageDialog(null,
					 "¡Ups! algo a ocurrido, al parecer este correo registrado en el sistema :("
					 , "Información", JOptionPane.INFORMATION_MESSAGE);
		}else {
			
			//while (resultSet.next()) {
			System.out.println("nombre:"+ resultSet.getString("nombres"));
			recolectardatosTabla(resultSet);
			
			buscarPreguntasUsuario(getIDTabla());
			
		}
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	
}
///283 posible error
private static String IDTabla, NombreTabla, RolTabla, PasswordTabla;

public static String getIDTabla() {
	return IDTabla;
}

public static String getNombreTabla() {
	return NombreTabla;
}

public static String getRolTabla() {
	return RolTabla;
}

public static String getPasswordTabla() {
	return PasswordTabla;
}

private static void recolectardatosTabla(ResultSet resultSet) {
	try {
		resultSet.isBeforeFirst();
		while (resultSet.next()) {
		IDTabla=resultSet.getString("ID");
		NombreTabla=resultSet.getString("nombres");
		RolTabla=resultSet.getString("rol");
		PasswordTabla=resultSet.getString("password");
		SegundoFTabla=resultSet.getBoolean("segundofactor");	
		}
		System.out.println("ID"+IDTabla);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		JOptionPane.showMessageDialog(null, "OHH ocurrio un error GD-283", "Error", JOptionPane.ERROR_MESSAGE);
		e.printStackTrace();
	}
}
///error 284
private static void  buscarPreguntasUsuario(String ID) {
	try {
		String sql;
		PreparedStatement pstm= con.prepareStatement("SELECT * FROM preguntasuser WHERE ID=?");
		pstm.setString(1, ID);
		ResultSet resultSet= pstm.executeQuery();
		while (resultSet.next()) {
			pregunta1String= resultSet.getString("pregunta1");
			pregunta2String= resultSet.getString("pregunta2");
			pregunta3String= resultSet.getString("pregunta3");
			respuesta1String=resultSet.getString("respuesta1");
			respuesta2String=resultSet.getString("respuesta2");
			respuesta3String=resultSet.getString("respuesta3");
			
		}
	} catch (Exception e) {
		// TODO: handle exception
		JOptionPane.showMessageDialog(null, "OHH ocurrio un error GD-284", "Error", JOptionPane.ERROR_MESSAGE);
	}
	
}

/**
 * @return the pregunta1String
 */
public static String getPregunta1String() {
	return pregunta1String;
}

/**
 * @return the respuesta1String
 */
public static String getRespuesta1String() {
	return respuesta1String;
}

/**
 * @return the pregunta2String
 */
public static String getPregunta2String() {
	return pregunta2String;
}

/**
 * @return the respuesta2String
 */
public static String getRespuesta2String() {
	return respuesta2String;
}

/**
 * @return the pregunta3String
 */
public static String getPregunta3String() {
	return pregunta3String;
}
private static boolean SegundoFTabla;
/**
 * @return the segundoFTabla
 */
public static boolean isSegundoFTabla() {
	return SegundoFTabla;
}

/**
 * @param segundoFTabla the segundoFTabla to set
 */
public static void setSegundoFTabla(boolean segundoFTabla) {
	SegundoFTabla = segundoFTabla;
}

/**
 * @return the respuesta3String
 */
public static String getRespuesta3String() {
	return respuesta3String;
}
public static void actualizardatosTabla(int ID,String nombre,String Rol,String re1,String re2,String re3,boolean sefa) {
	try {
		String  SQL="UPDATE usuarios SET nombres=?, rol=?, segundofactor=? WHERE ID=?";
		verificarCambioSegundoF(ID, sefa);
		  PreparedStatement pst= con.prepareStatement(SQL); 
		  pst.setString(1, nombre); 
		  pst.setString(2, Rol); 
		  pst.setBoolean(3, sefa);
		  pst.setInt(4, ID);
		  
		  pst.executeUpdate();
		  
		  SQL="UPDATE preguntasuser SET respuesta1=?, respuesta2=?, respuesta3=? WHERE ID=?";
		  pst= con.prepareStatement(SQL); 
		  pst.setString(1, re1); 
		  pst.setString(2, re2); 
		  pst.setString(3, re3);
		  pst.setInt(4, ID);
		  pst.executeUpdate();
		  
		  
		 
		  JOptionPane.showMessageDialog(null, "Los Datos han sido modificados con éxito.","Información",JOptionPane.INFORMATION_MESSAGE);
		  
	} catch (Exception e) {
		// TODO: handle exception
		JOptionPane.showMessageDialog(null, "Los Datos NO sido modificados :( ","Información",JOptionPane.INFORMATION_MESSAGE);
	}
	
}
private static boolean verificarCambioSegundoF(int ID,boolean sefa) {
	String correo="";
	Boolean segundoF=false;
	try {
		String sQLString="SELECT segundofactor, correo FROM usuarios WHERE ID=?";
		
		PreparedStatement preparedStatement= con.prepareStatement(sQLString);
		preparedStatement.setInt(1, ID);
		ResultSet resultSet= preparedStatement.executeQuery();
		
		while (resultSet.next()) {
			correo=resultSet.getString("correo");
			segundoF=resultSet.getBoolean("segundofactor");
			
		}
		System.out.println("se tiene un: "+segundoF + "se ha establecido un: "+sefa);
		if (segundoF==sefa) {
			
		}else {
			String estadoString="Activado";
			if (!sefa) {
				estadoString="Desactivado";
			}
			System.out.println("se ha modificado els egundo factor");
		EnvioCorreos.enviarInformacionCambiocontra(correo, "Cambio Segundo Factor", "Atención, "
				+ "al parecer has realizado un cambio en la seguridad de tu cuenta, el estado de tu Segundo Factor ahora es:"+ estadoString );
		}
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e.getMessage());
	}
	
	return false;
}



}
