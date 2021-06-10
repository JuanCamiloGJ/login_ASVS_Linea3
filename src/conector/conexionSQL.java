package conector;

import java.sql.Connection;
import java.sql.DriverManager;



public class conexionSQL {
	
	private String nombreBD= "lineaproyectofinal";
	private String usuario="root";
	private String password="";
	private String url="jdbc:mysql://localhost:3306/"+nombreBD+"?useUnicode=true&use"
			+"JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=dfalse&"
			+"serverTimezone=UTC";
	Connection conectar=null;
	public Connection conexion() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conectar=(Connection) DriverManager.getConnection(url,usuario,password);
			System.out.println("Conexión exitosa");
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("NO se pudo conectar a la base de datos :("+ e.getMessage());
		}
		
		return conectar;
	}
}
