package FactoryDesignPattern;



@SuppressWarnings("serial")
public class LevelHard extends Level{
	
	private static  GameBoardHard gameBoard= new GameBoardHard();
	
    
    
	 public LevelHard(){
		 super("Memory Game Hard Level",gameBoard);
	    }
	 

	@Override
	public void restartGame(){
		 super.restartGame();
       
        gameBoard = new GameBoardHard(this);
        gameBoard.fillBoardView(Level.getBoardView());
        setVisible(true);
    }

	

}
