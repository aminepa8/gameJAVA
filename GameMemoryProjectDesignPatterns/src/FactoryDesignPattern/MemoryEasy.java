package FactoryDesignPattern;


@SuppressWarnings("serial")

public class MemoryEasy extends Memory{
	
	private static  GameBoardEasy gameBoard= new GameBoardEasy();
	
 
    
    
	 public MemoryEasy(){
		 super("Memory Game Easy Level",gameBoard);

	    }
	 

	
	public void restartGame(){
       
       super.restartGame(); 
      
       gameBoard = new GameBoardEasy(this);
       gameBoard.fillBoardView(Memory.getBoardView());
       setVisible(true);
       
    }



}
