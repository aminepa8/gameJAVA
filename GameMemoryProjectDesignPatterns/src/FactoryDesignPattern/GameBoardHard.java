package FactoryDesignPattern;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GameBoardHard extends GameBoard{
	private String imgFiles[] = {"1.png", "2.png", "3.png", "4.png",
            "5.png", "6.png", "7.png", "8.png", "9.png", "10.png",
            "11.png", "12.png", "smile.png"};
   
    private ClassLoader loader = getClass().getClassLoader();
    ArrayList<ImageIcon> ImageIconList = super.getImageList(loader, imgFiles);
    
    public GameBoardHard() {
    	GameBoard.setArraySize(ImageIconList.size() ,true);
    }
	 public GameBoardHard(ActionListener event)  {
	        super();
	        
	        super.BoardMaker(event, ImageIconList, true);
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
		return new LevelHard();
	}
	 
	 

}
