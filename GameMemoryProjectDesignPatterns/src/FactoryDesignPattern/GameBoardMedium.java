package FactoryDesignPattern;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GameBoardMedium extends GameBoard{
	private String imgFiles[] = {"1.png", "2.png", "3.png", "4.png","5.png", "6.png", "7.png", "8.png"};
   
    private ClassLoader loader = getClass().getClassLoader();
    ArrayList<ImageIcon> ImageIconList =super.getImageList(loader, imgFiles);
    
    public GameBoardMedium() {
    	
    	GameBoard.setArraySize(ImageIconList.size() ,false);
    }
	 public GameBoardMedium(ActionListener event)  {
	        super();
	        
	        super.BoardMaker(event, ImageIconList, false);
	    }
	 
	 public void fillBoardView(JPanel view ){
		 super.fillBoardView(view);
	 }
	 
	 public void resetBoard(){
		 super.resetBoard();
	 }

	@Override
	public Level CreateMemory() {
		// TODO Auto-generated method stub
		return new LevelMeduim();
	}
	 
	
	 

}
