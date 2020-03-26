package FactoryDesignPattern;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;




public abstract class GameBoard {
   
	private List<Card> cards = new ArrayList<Card>();
	private Card FirstCardOfPair, SecondCardOfPair, WildCard;
	private static boolean HasWildCard;
	private static int ArraySize = 0;
	
    public static int getArraySize() {
		return ArraySize;
	}
	public static void setArraySize(int arraySize ,boolean CheckWildCard) {
		System.out.println( "GameBoard setArraySize :"+arraySize);
		if(CheckWildCard) {
			int size = (arraySize - 1);
		      size = (size * 2 ) +1;
		      size = (int) Math.sqrt(size);
			ArraySize = size;
		}else {
			ArraySize = arraySize /2;
		}
		
	}
	public void setHasWildCard(boolean hasWildCard) {
		HasWildCard = hasWildCard;
	}
	public static boolean isHasWildCard() {
		return HasWildCard;
	}
	
	//--
	public static int getArrayLength() {
		return ArraySize;
		
	}
	
	//--
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
    	cards.clear();
    }
    //Good Method Haha Avoid Repetiton or WhatEver LOL.....
    public void BoardMaker(ActionListener event,ArrayList<ImageIcon> ImageList,boolean HasWilCard) {
        int cardPair = 1;
        setHasWildCard(HasWilCard);
        ArraySize = ImageList.size();
        System.out.println("ArraySize from BorderMaker Method : "+ArraySize);
        for(int  i = 0;i < ImageList.size();i++){  
            if(i == ImageList.size() -1 && HasWilCard ){
                ImageIcon imgIcon = ImageList.get(i);
                
                WildCard = new Card(imgIcon);
                WildCard.SetID(cardPair);
                WildCard.addActionListener(event);
                cards.add(WildCard);
            }
            else {
            	ImageIcon imgIcon =  ImageList.get(i);
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
          //making sure that  the cards get shuffled well 
            Collections.shuffle(cards);
    	   
        }
    }
    public abstract Memory CreateMemory();
    
    
    public ArrayList<ImageIcon> getImageList(ClassLoader loader,String[] imgFiles) {
    	loader = getClass().getClassLoader();
    	ArrayList<ImageIcon> ImageIconList = new ArrayList<ImageIcon>();
    	
    	for(int i = 0 ; i < imgFiles.length; i++) {
    		
    		ImageIcon imgIcon = new ImageIcon(loader.getResource(imgFiles[i]));
    		System.out.println(imgFiles[i]);
    		ImageIconList.add(imgIcon);
    	}
    	
    	return ImageIconList ;
    }
    
}
