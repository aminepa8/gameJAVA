package FactoryDesignPattern;



@SuppressWarnings("serial")
public class MemoryHard extends Memory{
	
	private static  GameBoardHard gameBoard= new GameBoardHard();
	
    
    
	 public MemoryHard(){
		 super("Memory Game Hard Level",gameBoard);
	    }
	 

	@Override
	public void restartGame(){
		 super.restartGame();
       
        gameBoard = new GameBoardHard(this);
        gameBoard.fillBoardView(Memory.getBoardView());
        setVisible(true);
    }

	

}
