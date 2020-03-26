package shapesDesignPatterns;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class ShapeMaker {
	
	 private Shape circle;
	 private Shape rectangle;
	 private Shape square;
	 private Shape triangle;
	 private Shape roundRectangle;
	 
	 public ShapeMaker() {
		 
	      circle = new Circle(100,100);
	      circle.setColorShape(Color.cyan);
	      rectangle = new Rectangle(100,40);
	      rectangle.setColorShape(Color.GREEN);
	      square = new Square(100,100);
	      square.setColorShape(Color.RED);
	      triangle = new Triangle(100,100);
	      triangle.setColorShape(Color.MAGENTA);
	      
	      roundRectangle  = new RoundRectangle(100,100);
	      roundRectangle.setColorShape(Color.BLUE);
	      
	   }

	   public BufferedImage drawCircle(){
		   return circle.draw();
	   }
	   public BufferedImage drawRectangle(){
	      return rectangle.draw();
	   }
	   public BufferedImage drawSquare(){
		   return square.draw();
	   }
	   
	   public BufferedImage drawTriangle(){
		   return triangle.draw();
		   }
	   public BufferedImage drawRoundRectangle(){
		   return roundRectangle.draw();
		   
	   }
	 }
