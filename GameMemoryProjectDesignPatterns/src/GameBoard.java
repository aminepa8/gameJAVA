import javax.swing.*;

import java.util.ArrayList;
import java.util.List;




public abstract class GameBoard {
   
	private List<Card> cards = new ArrayList<Card>();
	
    public List<Card> getCards() {
		return cards;
	}
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	public GameBoard()  {
        
    }
    // filling the JPanel with cards
    public void fillBoardView(JPanel view){
        for (Card c : cards){
            view.add(c);
        }
    }
    // deleting the cards from the board
    public void resetBoard(){
        for (int c = 0;c < cards.size();c++){
            cards.remove(c);
        }
    }
    
    public abstract Memory CreateMemory();
    
    
}
