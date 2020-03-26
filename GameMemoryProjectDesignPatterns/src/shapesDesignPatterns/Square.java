package shapesDesignPatterns;

import java.awt.Graphics2D;

import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class Square extends Shape{

	public Square(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public BufferedImage draw() {
		  BufferedImage SquareImg = new BufferedImage(super.getHeight(), super.getWidth(), BufferedImage.TYPE_INT_ARGB);
	      Graphics2D g2 = SquareImg.createGraphics();
	      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	      g2.setColor(super.getColorShape());
	      int width = super.getHeight();
	      int height = super.getWidth();
	      g2.fillRect(0, 0, width, height);
	      g2.dispose();
	      return SquareImg;
	}

	

}
