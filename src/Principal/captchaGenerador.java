package Principal;

import java.util.Random;

public class captchaGenerador {

	
	public static String createCaptchaValue() {
		Random rand= new Random();
		int length = 7 +(Math.abs(rand.nextInt())%3);
		
		StringBuilder strBuff =new StringBuilder();
		
		for(int i=0; i<length; i++) {
			int baseCharNum = Math.abs(rand.nextInt())%62;
			int charNum=0;
			
			if (baseCharNum<26) {
				charNum=65+baseCharNum;
			}else if(baseCharNum<52) {
				charNum=97+baseCharNum-26;
			}else {
				charNum=48+baseCharNum-52;
			}
			strBuff.append((char)charNum);	
		}
		return strBuff.toString();
	}
}
