package shapesDesignPatterns;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class RoundRectangle extends Shape{

	public RoundRectangle(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public BufferedImage draw() {
		BufferedImage RoundRectImg = new BufferedImage(super.getHeight(), super.getWidth(), BufferedImage.TYPE_INT_ARGB);
	      Graphics2D g2 = RoundRectImg.createGraphics();
	      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	      g2.setColor(super.getColorShape());
	      int width = super.getHeight();
	      int height = super.getWidth();
	      g2.fillRoundRect(20,20,height , width, 15, 15);
	      g2.dispose();
	      return RoundRectImg;
	}

}
