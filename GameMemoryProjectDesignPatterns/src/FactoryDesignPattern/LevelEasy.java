package FactoryDesignPattern;


@SuppressWarnings("serial")

public class LevelEasy extends Level{
	
	private static  GameBoardEasy gameBoard= new GameBoardEasy();
	
 
    
    
	 public LevelEasy(){
		 super("Memory Game Easy Level",gameBoard);

	    }
	 

	
	public void restartGame(){
       
       super.restartGame(); 
      
       gameBoard = new GameBoardEasy(this);
       gameBoard.fillBoardView(Level.getBoardView());
       setVisible(true);
       
    }



}
