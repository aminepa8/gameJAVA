package shapesDesignPatterns;

import java.awt.Color;

import java.awt.image.BufferedImage;

public abstract class Shape {
	   
	   private String id;
	   protected String type;
	   private Color colorShape;
	   public Color getColorShape() {
		return colorShape;
	}
	public void setColorShape(Color colorShape) {
		this.colorShape = colorShape;
	}

	private int width,  height;
	   
	   public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Shape(int width, int height) {
		   this.width = width;
		   this.height = height;
	   }
	 public  abstract   BufferedImage draw();
	   
	   public String getType(){
	      return type;
	   }
	   
	   public String getId() {
	      return id;
	   }
	   
	   public void setId(String id) {
	      this.id = id;
	   }
	   
	   
	}
