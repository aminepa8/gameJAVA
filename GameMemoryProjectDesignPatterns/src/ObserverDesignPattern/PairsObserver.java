package ObserverDesignPattern;
import FactoryDesignPattern.Level;
import javax.swing.JLabel;

public class PairsObserver extends Observer{

	 JLabel PairsFoundLabel = new JLabel("Pairs Found : ") ;
	
	public JLabel getPairsFoundLabel() {
		
		return PairsFoundLabel;
	}

	Level level;
	
	
	
	@Override
	public void update(int PairsNb) {
		PairsFoundLabel.setText("Pairs Found : "+PairsNb);
		level.setPairsFoundLabel(PairsFoundLabel);
		// TODO Auto-generated method stub
		
	}
	
	public PairsObserver() {
		this.PairsFoundLabel = level.getPairsFoundLabel();
	}

}
