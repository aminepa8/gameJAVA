
import javax.swing.*;    
import java.awt.event.*;    
public class MainMenu {    
	private  JFrame f;    
	private int LevelNumber ;
	public MainMenu(){    
		f=new JFrame("Main Menu");   
		final JLabel label = new JLabel();          
		label.setHorizontalAlignment(JLabel.CENTER);  
		label.setSize(400,100);  
		JButton b=new JButton("Play");  
		b.setBounds(200,100,75,20);  
		
		String Levels[]={"Easy Level ","Meduim Level","Hard Level"};        
		final JComboBox cb=new JComboBox(Levels);    
		cb.setBounds(50, 100,90,20);    
		f.add(cb); f.add(label); f.add(b);    
		f.setLayout(null);    
		f.setSize(350,350);    
		f.setVisible(true);   
		
		b.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {  
				LevelNumber = cb.getSelectedIndex();
				String data = " Level Number Selected: "   
						+ LevelNumber;  
				
				label.setText(data);  
				
				switch(LevelNumber) {
				
				  case 0:
						GameBoardEasy Board1 = new GameBoardEasy();
						MemoryEasy LVL1 = (MemoryEasy) Board1.CreateMemory();
						HideJframe(f);
				    break;
				  case 1:
					  GameBoardMedium Board2 = new GameBoardMedium();
					  MemoryMeduim LVL2 = (MemoryMeduim) Board2.CreateMemory();
					  HideJframe(f);
				    break;
				  case 2:
					  GameBoardHard Board3 = new GameBoardHard();
					  MemoryHard LVL3 = (MemoryHard) Board3.CreateMemory();
					  HideJframe(f);
					  break;
				  default:
				    System.out.println("LOL");
				}
			}  
			
			
		});           
	}    
	
	
	   public void HideJframe(JFrame f) {
		   f.dispose();
	   }
} 

