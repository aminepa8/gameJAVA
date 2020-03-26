import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GameBoardEasy extends GameBoard{
	private String imgFiles[] = {"1.png", "2.png", "3.png", "4.png","smile.png"};
    private ClassLoader loader = getClass().getClassLoader();
    
    ArrayList<ImageIcon> ImageIconList = super.getImageList(loader, imgFiles);
    public GameBoardEasy() {
    	GameBoard.setArraySize(ImageIconList.size() ,true);
    }
	 public GameBoardEasy(ActionListener event)  {
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
	public Memory CreateMemory() {
		// TODO Auto-generated method stub
		return new MemoryEasy();
	}
	 
	 

}
