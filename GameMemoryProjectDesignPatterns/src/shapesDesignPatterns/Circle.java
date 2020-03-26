package shapesDesignPatterns;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class Circle extends Shape{

	public Circle(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public BufferedImage draw() {
		// TODO Auto-generated method stub
		 BufferedImage circleImg = new BufferedImage(super.getHeight(), super.getWidth(), BufferedImage.TYPE_INT_ARGB);
	      Graphics2D g2 = circleImg.createGraphics();
	      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	      g2.setColor(super.getColorShape());
	      int width = super.getHeight();
	      int height = super.getWidth();
	      g2.fillOval(0, 0, width, height);
	      g2.dispose();
	      return circleImg;
	}

	
}
