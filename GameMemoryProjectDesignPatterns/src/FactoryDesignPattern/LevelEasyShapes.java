package FactoryDesignPattern;
import shapesDesignPatterns.ShapesBoardAdapter;
public class LevelEasyShapes extends Level{
	
	private static  ShapesBoardAdapter gameBoard= new ShapesBoardAdapter();
	
	 public LevelEasyShapes(){
		 
		 super("Memory Game Meduim Shapes Level" ,gameBoard);
		 
	    }
	 

	@Override
	public void restartGame(){
      super.restartGame();
        
        
        gameBoard = new ShapesBoardAdapter(this);
        gameBoard.fillBoardView(Level.getBoardView());
        setVisible(true);
    }

	

    

}
