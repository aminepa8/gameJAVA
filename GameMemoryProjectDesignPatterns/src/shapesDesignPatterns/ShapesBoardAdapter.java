package shapesDesignPatterns;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import FactoryDesignPattern.GameBoard;
import FactoryDesignPattern.Memory;

import FactoryDesignPattern.MemoryMeduimShapes;

public class ShapesBoardAdapter extends GameBoard{
	ArrayList<ImageIcon> ShapesList = ShapesAdapterList();
public ShapesBoardAdapter() {
    	
    	GameBoard.setArraySize(ShapesList.size() ,true);
    }
	
	public ShapesBoardAdapter(ActionListener event)  {
	    super();
	    
	   
		super.BoardMaker(event, ShapesList, true);
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
	return new MemoryMeduimShapes();
	}

	
	public  ArrayList<ImageIcon> ShapesAdapterList(){
		ArrayList<ImageIcon> ImageIconList = new ArrayList<ImageIcon>();
		ShapeMaker shapeMaker = new ShapeMaker();
		 
		ImageIconList.add(new ImageIcon(shapeMaker.drawCircle()));
		ImageIconList.add(new ImageIcon(shapeMaker.drawRectangle()));
		ImageIconList.add(new ImageIcon(shapeMaker.drawSquare()));
		ImageIconList.add(new ImageIcon(shapeMaker.drawTriangle()));
		ImageIconList.add(new ImageIcon(shapeMaker.drawRoundRectangle()));
		
		return  ImageIconList ;
	}
	
	
	
	
	
}
