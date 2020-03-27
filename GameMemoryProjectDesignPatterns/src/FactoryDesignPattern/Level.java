package FactoryDesignPattern;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.List;

import javax.swing.*;

import ObserverDesignPattern.PairsObserver;
import ObserverDesignPattern.ErrorObserver;
public abstract class Level extends JFrame implements ActionListener{
	
	
	
	// Core game play objects
	private  GameBoard gameBoardL;
    private Card prevCard1 = null, prevCard2 = null;

    // Labels to display game info
    private JLabel  timerLabel;
    //Used bY Observers
	private static JLabel pairsFoundLabel = new JLabel("Pairs Found : 0");
	private static JLabel errorLabel = new JLabel("Errors: 0");

    public static JLabel getErrorLabel() {
		return errorLabel;
	}

	public static void setErrorLabel(JLabel errorLabel) {
		Level.errorLabel = errorLabel;
	}

	public static JLabel getPairsFoundLabel() {
		return pairsFoundLabel;
	}

	public static  void setPairsFoundLabel(JLabel PairsFoundLabel) {
		pairsFoundLabel = PairsFoundLabel;
	}
	
	//Observers
		
		PairsObserver pairsObserver = new PairsObserver();
		ErrorObserver errorObserver = new ErrorObserver();
	// layout objects: Views of the board and the label area
    private static JPanel boardView;
	private JPanel labelView;

    

	public static JPanel getBoardView() {
		return boardView;
	}


	// Record keeping counts and times
	private int clickCount = 0, gameTime = 0, errorCount = 0;
    private int pairsFound = 0, wildCardFound;

    // Game timer: will be configured to trigger an event every second
    private Timer gameTimer;

	private Timer delay;


	public Level(String TitleLevel ,GameBoard gameBoard){
       super(TitleLevel);
       
    
		 
    		 // Allocate the interface elements
    	        JButton restart = new JButton("Restart");
    	        JButton quit = new JButton("Quit");
    	        JButton BackBtn = new JButton("Menu");
    	        
    	        timerLabel = new JLabel("Timer: 0");
    	        errorLabel = errorObserver.getErrorLabel();
    	        pairsFoundLabel = pairsObserver.getPairsFoundLabel();
    	        quit.addActionListener(this);
    	        restart.addActionListener(this);
    	        BackBtn.addActionListener(this);
    	        //declares action listener for the game timer
    	        ActionListener seconds = new ActionListener() {
    	            @Override
    	            public void actionPerformed(ActionEvent e) {
    	                gameTime+=1;
    	                timerLabel.setText("Timer: " + gameTime);
    	            }
    	        };

    	        gameTimer = new Timer(1000,seconds);
    	        int timeDelay = 1000;
    	        //initially hide front images, declares action listener for later
    	        ActionListener hideDelay = new ActionListener() {
    	            @Override
    	            public void actionPerformed(ActionEvent e) {
    	                prevCard1.HideFrontImage();
    	                prevCard2.HideFrontImage();
    	                prevCard1 = null;
    	                prevCard2 = null;
    	            }
    	        };
    	        delay = new Timer(timeDelay, hideDelay);
    	        delay.setRepeats(false);

    	        // Allocate two major panels to hold interface
    	        labelView = new JPanel();  // used to hold labels
    	        boardView = new JPanel();  // used to hold game board cards and stuff ^-^

    	        // get the content pane, onto which everything is eventually added
    	        Container c = getContentPane();

    	        // Setup the game board with cards
    	       // gameBoard = new GameBoard(this);

    	        // Add the game board to the board layout area
    	        System.out.println(" Size :: "+gameBoard.getArraySize());
    	        boardView.setLayout(new GridLayout(gameBoard.getArraySize(), gameBoard.getArraySize(), 10, 10));//GridLayout(int rows, int columns, int hgap, int vgap):
    	        //
    	        gameBoard.fillBoardView(boardView);

    	        // Add required interface elements to the "label" JPanel
    	        labelView.setLayout(new GridLayout(2, 6, 2, 2));
    	        labelView.add(BackBtn);
    	        labelView.add(quit);
    	        labelView.add(restart);
    	        labelView.add(timerLabel);
    	        labelView.add(errorLabel);
    	        labelView.add(pairsFoundLabel);

    	        // Both panels should now be individually layered out
    	        // Add both panels to the container
    	        c.add(labelView, BorderLayout.NORTH);
    	        c.add(boardView, BorderLayout.CENTER);
    	        
    	        setSize(700, 600);
    	        //centers the panel
    	        setLocationRelativeTo(null);
    	        setVisible(true);
    	        this.gameBoardL = gameBoard;
    	        restartGame();// for later use
    }

	//Game Logic
	
	@Override
	public void actionPerformed(ActionEvent e)   {
        //functionality of quit button
        if(e.getActionCommand().equals("Quit")){
            System.exit(0);
        }
        //functionality of restart button
        else if(e.getActionCommand().equals("Restart")){
            restartGame();
        }
        else if(e.getActionCommand().equals("Menu")){
            MainMenu.getMainMenu();
        	this.dispose();
        }
        else if(!delay.isRunning()){
            Card currCard = (Card)e.getSource();
            
            gameTimer.start();
            //when the first card is clicked:
            //     Make sure the card is not the wild card
            //     If it is, then disable its action listener and change the prevCard back to null;
            //
            if(prevCard1 == null && prevCard2 == null){
                prevCard1 = currCard;
                if(prevCard1.ID() == GameBoard.getArrayLength() && GameBoard.isHasWildCard()){ 
                    prevCard1.displayFrontImage();
                    prevCard1.removeActionListener(this);
                    prevCard1 = null;
                    wildCardFound++;
                }
                else {
                    prevCard1.removeActionListener(this);
                    prevCard1.displayFrontImage();
                    clickCount += 1;
                }
            }
            //what to do when first card was clicked and second card has just been clicked
            else if(prevCard1 != null && prevCard2 == null){
                prevCard2 = currCard;
                prevCard2.removeActionListener(this);
                prevCard2.displayFrontImage();
            }
            if(prevCard1 != null && prevCard2 != null){
                //if the ids do not match:
                //  reinstate the listener for both
                //  flip cards back over after timer ends
                if (prevCard1.ID() != prevCard2.ID()){
                    prevCard1.addActionListener(this);
                    prevCard2.addActionListener(this);
                    delay.start();
                    errorCount +=1;
                    
                    errorLabel.setText("Errors: " + errorCount);
                    new Timer(750, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            prevCard1.HideFrontImage();
                            prevCard2.HideFrontImage();
                            prevCard1 = null;
                            prevCard2 = null;
                        }
                    });
                }
                //if cards match:
                //  increment pairsFound by 1
                //  change previous cards back to null
                else if(prevCard1.ID() == prevCard2.ID()){
                    pairsFound +=1;
                    pairsObserver.update(pairsFound);
                    //disabled  the button so it wont be used again(ActionListener already disabled)
                    prevCard1.setEnabled(false);
                    prevCard2.setEnabled(false);
                    prevCard1 = null;
                    prevCard2 = null;
                }
            }
        }
        //Show the numbers of tries and the numbers of pairsFound
        if(!GameBoard.isHasWildCard() && pairsFound == GameBoard.getArrayLength()) {
        	GameEnded();
        }
        if(pairsFound == (GameBoard.getArrayLength() - 1) && GameBoard.isHasWildCard() && wildCardFound == 1){
        	 GameEnded();
        }
        

    }

	public void GameEnded() {
		 gameTimer.stop();
		 String text = "You Win! \n "+pairsFound+" Pairs found with:\n" + errorCount + " errors";
         JOptionPane.showMessageDialog(null, text,"Memory", JOptionPane.INFORMATION_MESSAGE);
	}
    public  void restartGame() {
    	 gameTimer.stop();
         pairsFound = 0;
         gameTime = 0;
         clickCount = 0;
         errorCount = 0;
         timerLabel.setText("Timer: 0");
         errorLabel.setText("Errors: 0");
         pairsFoundLabel.setText("Pairs Found : 0");
      // Clear the boardView and have the gameBoard generate a new layout
         boardView.removeAll();
         gameBoardL.resetBoard();
    }

   



    
}
