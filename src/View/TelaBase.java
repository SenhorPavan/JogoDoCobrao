package View;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public abstract class TelaBase extends JFrame{

    public TelaBase(String title){
        setSize(658, 521);
        setTitle(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon("src/Assets/Icon.png").getImage());
        setVisible(true);
    }
    
}
