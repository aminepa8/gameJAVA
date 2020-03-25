import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GameBoardEasy extends GameBoard{
	private String imgFiles[] = {"1.png", "2.png", "3.png", "4.png","smile.png"};
  //  private List<Card> cards = new ArrayList<Card>();
    private ClassLoader loader = getClass().getClassLoader();
    
    
    public GameBoardEasy() {
    	
    }
	 public GameBoardEasy(ActionListener event)  {
	        super();
	        ArrayList<ImageIcon> ImageIconList = super.getImageList(loader, imgFiles);
	        super.BoardMaker(event, ImageIconList, true);
	    }
	 
	
	 public void fillBoardView(JPanel view ){
		 super.fillBoardView(view);
	 }
	 
	 public void resetBoard(){
		 super.resetBoard();
	 }

	@Override
	public Memory CreateMemory() {
		// TODO Auto-generated method stub
		return new MemoryEasy();
	}
	 
	 

}
