
@SuppressWarnings("serial")
public class MemoryMeduim extends Memory{
	
	private static  GameBoardMedium gameBoard= new GameBoardMedium();
	
	 public MemoryMeduim(){
		 super("Memory Game Meduim Level" ,gameBoard);
		 
	    }
	 

	@Override
	public void restartGame(){
      super.restartGame();
        
        
        gameBoard = new GameBoardMedium(this);
        gameBoard.fillBoardView(Memory.getBoardView());
        setVisible(true);
    }

	

    

}
