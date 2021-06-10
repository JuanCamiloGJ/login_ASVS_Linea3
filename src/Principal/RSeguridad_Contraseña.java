package Principal;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JPasswordField;




public class RSeguridad_Contraseña {

	private char [] password;
	public RSeguridad_Contraseña(char [] contra) {
		// TODO Auto-generated constructor stub
	password=contra;
	}
	public Color CalcularTamaño() {
		 
		
		 if(password.length>=12) {
			return Color.GREEN.darker(); 
		 }
		return Color.RED;
	}
	public Color CalcularMayuscula() {
		boolean tienemay=false;
		for(char e:password) {
			if (Character.isUpperCase(e)) {
				tienemay=true;
			}
		}
		
		if (tienemay) {
			return Color.GREEN.darker();
		}else {
		return Color.RED;
		}
		
	}
	public Color CalcularMinuscula() {
		boolean tienemay=false;
		for(char e:password) {
			if (Character.isLowerCase(e)) {
				tienemay=true;
			}
		}
		
		if (tienemay) {
			return Color.GREEN.darker();
		}else {
		return Color.RED;
		}
		
	}
	//busca si hay un caracter especial en el texto
	public Color CalcularEspecial(){
		
		//estas dos clases sirven para buscar y hacer coincidencias
		Pattern patron =Pattern.compile("[^\\w]");
		Matcher matcher= patron.matcher(String.valueOf(password));
		
		if (matcher.find()) {
			return Color.GREEN.darker();
		}else {
		
		return Color.RED;
		}
	}
}
