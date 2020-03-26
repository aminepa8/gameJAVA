package FactoryDesignPattern;

import javax.swing.*;

import java.awt.Image;
import java.lang.ClassLoader;

public class Card extends JButton {
    

    private ClassLoader loader = getClass().getClassLoader();
    private Icon FrontIcon;
    private Icon BackIcon = new ImageIcon(loader.getResource("bg2.jpg"));
    private int ID;
 
    
    public Card(){
        super();
    }

    public Card(ImageIcon image){
        super();
        FrontIcon = ImageResizer(image);
        super.setIcon(BackIcon);
    }

    public void displayFrontImage(){
        super.setIcon(FrontIcon);
    }
    public void HideFrontImage(){
        super.setIcon(BackIcon);
    }

    public int ID(){
        return ID;
    }
    public void SetID(int n){
        ID = n;
    }
    
  //Function that resize the images
    public ImageIcon ImageResizer(ImageIcon imgIcon) {
    	Image image = imgIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(90, 90,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imgIcon = new ImageIcon(newimg);  // transform it back
        return imgIcon;
    	
    }
}
