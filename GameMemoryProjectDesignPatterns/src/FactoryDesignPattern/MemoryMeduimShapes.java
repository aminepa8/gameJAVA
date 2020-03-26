package FactoryDesignPattern;
import shapesDesignPatterns.ShapesBoardAdapter;
public class MemoryMeduimShapes extends Memory{
	
	private static  ShapesBoardAdapter gameBoard= new ShapesBoardAdapter();
	
	 public MemoryMeduimShapes(){
		 
		 super("Memory Game Meduim Shapes Level" ,gameBoard);
		 
	    }
	 

	@Override
	public void restartGame(){
      super.restartGame();
        
        
        gameBoard = new ShapesBoardAdapter(this);
        gameBoard.fillBoardView(Memory.getBoardView());
        setVisible(true);
    }

	

    

}
