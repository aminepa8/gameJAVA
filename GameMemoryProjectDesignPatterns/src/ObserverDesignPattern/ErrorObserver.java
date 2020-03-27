package ObserverDesignPattern;
import FactoryDesignPattern.Level;
import javax.swing.JLabel;

public class ErrorObserver extends Observer{

	JLabel errorLabel = new JLabel("Errors Found : ") ;
	
	

	public JLabel getErrorLabel() {
		return errorLabel;
	}

	Level level;
	
	
	
	@Override
	public void update(int PairsNb) {
		errorLabel.setText("Errors : "+PairsNb);
		level.setErrorLabel(errorLabel);
		// TODO Auto-generated method stub
		
	}
	
	public ErrorObserver() {
		this.errorLabel = level.getErrorLabel();
	}

}
