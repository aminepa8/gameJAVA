package FactoryDesignPattern;


@SuppressWarnings("serial")
public class LevelMeduim extends Level{
	
	private static  GameBoardMedium gameBoard= new GameBoardMedium();
	
	 public LevelMeduim(){
		 
		 super("Memory Game Meduim Level" ,gameBoard);
		 
	    }
	 

	@Override
	public void restartGame(){
      super.restartGame();
        
        
        gameBoard = new GameBoardMedium(this);
        gameBoard.fillBoardView(Level.getBoardView());
        setVisible(true);
    }

	

    

}
