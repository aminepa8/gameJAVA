package shapesDesignPatterns;

import java.awt.Graphics2D;

import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class Triangle extends Shape{

	public Triangle(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public BufferedImage draw() {
		  BufferedImage TriangleImg = new BufferedImage(super.getHeight(), super.getWidth(), BufferedImage.TYPE_INT_ARGB);
	      Graphics2D g2 = TriangleImg.createGraphics();
	      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	      g2.setColor(super.getColorShape());
	      int width = super.getHeight();
	      int height = super.getWidth();
	      g2.drawPolygon(new int[] {10, 20, 30}, new int[] {100, 20, 100}, 3); //Change Values Later
	      g2.dispose();
	      return TriangleImg;
	}

	
}
