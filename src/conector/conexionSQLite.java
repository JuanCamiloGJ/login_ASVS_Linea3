package conector;

import java.sql.Connection;
import java.sql.DriverManager;

import Principal.confirmacionvisualbd;

public class conexionSQLite {

	String strConexionDBString="jdbc:sqlite:./bdsqlite/logindata.s3db";
	Connection conn=null;
	public conexionSQLite() {
		// TODO Auto-generated constructor stub
		
	
	}
	public Connection conexion() {
		try {
			Class.forName("org.sqlite.JDBC");
			conn=DriverManager.getConnection(strConexionDBString);
			System.out.println("Conexion establecida a SQLite");
			confirmacionvisualbd.setLbltextinformativo("Conexion establecida a SQLite");
		} catch (Exception e) {
			// TODO: handle exception
			confirmacionvisualbd.setLbltextinformativo("Error en conexion a SQLite");
			System.out.println("Error de conexion"+e);
		}
		return conn;
	}
	
	
}
