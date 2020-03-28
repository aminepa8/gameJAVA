package FactoryDesignPattern;
import shapesDesignPatterns.ShapesBoardAdapter;
import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
import java.net.URL;    

public class MainMenu {    
	
	private static MainMenu MenuGame =null;
	public ClassLoader loader = getClass().getClassLoader();
	private  JFrame f;    
	private int LevelNumber ;
	AudioClip clip;
	private MainMenu() {
		
		f=new JFrame("Main Menu");   
		
		
		JButton b=new JButton("Play");  
		b.setBounds(200,100,90,20);  
		JButton AboutBtn=new JButton("About");
		AboutBtn.setBounds(200,100,90,20);  
		JButton ExitBtn=new JButton("Exit");
		AboutBtn.setBounds(200,100,90,20);  
		//Image Main MeNU
		ImageIcon image = new ImageIcon(loader.getResource("giphy1.gif"));
		
		JLabel label = new JLabel(image, JLabel.CENTER);
		
		JPanel LogoGIFpanel = new JPanel(new BorderLayout());
		JPanel BtnPanel = new JPanel(new BorderLayout());
		//-----
		String Levels[]={"Easy Level ","Meduim Level","Hard Level","Shapes Level"};        
		final JComboBox cb=new JComboBox(Levels);    
		cb.setBounds(50, 100,90,20);    

		LogoGIFpanel.add(label);
		LogoGIFpanel.setBackground(Color.black);
		BtnPanel.add(cb);
		BtnPanel.add(b);
		BtnPanel.add(AboutBtn);
		BtnPanel.add(ExitBtn);
		BtnPanel.setLayout(new GridLayout(4, 1, 2, 2));//GridLayout(int rows, int columns, int hgap, int vgap):
    
		f.add(LogoGIFpanel,BorderLayout.NORTH); 
		f.add(BtnPanel,BorderLayout.CENTER); 
		   
		f.setSize(300,400);    
		f.setVisible(true);   
		f.setDefaultCloseOperation(3);
		f.setLocationRelativeTo(null); 
		b.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {  
				LevelNumber = cb.getSelectedIndex();
				String data = " Level Number Selected: "  + LevelNumber;  
				
				
				switch(LevelNumber) {
				
				  case 0:
						GameBoardEasy Board1 = new GameBoardEasy();
						LevelEasy LVL1 = (LevelEasy) Board1.CreateMemory();
						HideJframe();
				    break;
				  case 1:
					  GameBoardMedium Board2 = new GameBoardMedium();
					  LevelMeduim LVL2 = (LevelMeduim) Board2.CreateMemory();
					  HideJframe();
				    break;
				  case 2:
					  GameBoardHard Board3 = new GameBoardHard();
					  LevelHard LVL3 = (LevelHard) Board3.CreateMemory();
					  HideJframe();
					  break;
				  case 3:
					  ShapesBoardAdapter Board4 = new ShapesBoardAdapter();
					  LevelEasyShapes LVL4 = (LevelEasyShapes) Board4.CreateMemory();
					  HideJframe();
					  break;
				  default:
				    System.out.println("NOthing ");
				}
			}  
			
			
		});     
		
		
		ExitBtn.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {  
				 System.exit(0);
			}
		});
		
		
		AboutBtn.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {  
				JOptionPane.showMessageDialog(
					    f, 
					    "<html><body><h3>Team :</h3>"
					    + "<p>Moulay Mohammed Amine</p>"
					    + "<p>Ajekal Abdelkarim</p>" 
					    + "<p>Jarid Chaimae</p>"
					    + "<p>Radi Oumaima</p>"
					    + "<h3>Game Description</h3>"
					    + "<p>Title : Memory game"
					    + "<p> Version : 1.0 </p>"
					    + "<p>The player need to find the pairs of each element<p>"
					    +"<p>&copy; 2020</p>"
					    + "</body></html>", 
					    "About", 
					    JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}    
	
	
	   public void HideJframe() {
		  
		   f.setVisible(false);
		   clip.stop();//Stop Music
		  
	   }
	   
	   
	   
	   public  void playSong() {
		   String filename=  "Futureopolis.wav";
	    	URL Song = loader.getResource(filename);
	    	//System.out.println(Song.toString());
	    	clip = Applet.newAudioClip(Song);
	    	clip.loop(); //Play song nonStop
	}
	   
	   public static void ShowJframe() {
		   MenuGame.playSong();
		   MenuGame.f.setVisible(true);
		   
	   }
	   
	   //Singleton DesignPattern
	   public static MainMenu getMainMenu() {
			if(MenuGame==null) {
				MenuGame = new MainMenu();
				
			}
			
			ShowJframe();
			return MenuGame;
		}
} 

