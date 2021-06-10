package Principal;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TextToGraphics {
	public static String generateImage() {
		
		String text= captchaGenerador.createCaptchaValue();
		
		BufferedImage img=new BufferedImage(1,1,BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d =img.createGraphics();
		
		Font font =new Font("Times New Roman", Font.ITALIC|Font.BOLD, 20);
		g2d.setFont(font);
		FontMetrics fMetrics=g2d.getFontMetrics();
		int width =fMetrics.stringWidth(text);
		int height= fMetrics.getHeight();
		g2d.dispose();
		
		img= new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		g2d= img.createGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING,RenderingHints.VALUE_COLOR_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
		g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS,RenderingHints.VALUE_FRACTIONALMETRICS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR );
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL,RenderingHints.VALUE_STROKE_PURE);
		g2d.setFont(font);
		fMetrics=g2d.getFontMetrics();
		g2d.setColor(Color.BLACK);
		g2d.drawString(text, 0, fMetrics.getAscent());
		g2d.dispose();
		
		try {
			ImageIO.write(img, "png", new File("./captcha/Text.png"));
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		return text;
		
	}
}
