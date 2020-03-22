import java.awt.event.*;
import javax.swing.*;

public abstract class Memory extends JFrame implements ActionListener{
   

    public Memory(String TitleLevel){
       super(TitleLevel);
    }



    public abstract void restartGame();

    
}
