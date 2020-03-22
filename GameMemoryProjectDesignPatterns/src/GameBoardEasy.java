import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GameBoardEasy extends GameBoard{
	private String imgFiles[] = {"1.png", "2.png", "3.png", "4.png","smile.png"};
    private List<Card> cards = new ArrayList<Card>();
    private ClassLoader loader = getClass().getClassLoader();
    private Card FirstCardOfPair, SecondCardOfPair, WildCard;
    
    public GameBoardEasy() {
    	
    }
	 public GameBoardEasy(ActionListener event)  {
	        super();
	        int cardPair = 1;
	       
	        for(int  i = 0;i < 5;i++){  //i<13
	            if(i == 4){//i==12
	                ImageIcon imgIcon = new ImageIcon(loader.getResource(imgFiles[i]));
	                
	                WildCard = new Card(imgIcon);
	                WildCard.SetID(cardPair);
	                WildCard.addActionListener(event);
	                cards.add(WildCard);
	            }
	            else {
	                ImageIcon imgIcon = new ImageIcon(loader.getResource(imgFiles[i]));
	                FirstCardOfPair = new Card(imgIcon);
	                FirstCardOfPair.SetID(cardPair);
	                FirstCardOfPair.addActionListener(event);
	                FirstCardOfPair.setPreferredSize(new Dimension(20,20));
	                cards.add(FirstCardOfPair);

	                SecondCardOfPair = new Card(imgIcon);
	                SecondCardOfPair.SetID(cardPair);
	                SecondCardOfPair.addActionListener(event);
	                SecondCardOfPair.setPreferredSize(new Dimension(20,20));
	                cards.add(SecondCardOfPair);

	                cardPair++;
	            }
	        }
	        
	        //making sure that  the cards get shuffled well 
	        Collections.shuffle(cards);
	        Collections.shuffle(cards);
	        super.setCards(cards);
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
		return new MemoryEasy();
	}
	 
	 

}
