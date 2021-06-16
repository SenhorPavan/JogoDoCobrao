package View;

import Model.Fruta;
import Model.Cobrinha;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener{

    public GamePanel() {
        this.cobrinha = new Cobrinha(10*20, 5*20);
        int x = new Random().nextInt(31);
        int y = new Random().nextInt(23);
        this.fruta = new Fruta(x*20,y*20);
        this.FPS = 1000 / 300;
        this.timer = new Timer(this.FPS, this);
        
    }

    private Cobrinha cobrinha;
    private Fruta fruta;
    private int FPS;
    private Timer timer;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.clearRect(1, 1, 640, 480);
        g.setColor(Color.BLACK);
        g.fillRect(1, 1, 640, 480);
        getCobrinha().desenhar(g);
        getFruta().desenhar(g);
        
       
    }

    public void setFruta(Fruta fruta) {
        this.fruta = fruta;
    }

    public Fruta getFruta() {
        return fruta;
    }

    public Cobrinha getCobrinha() {
        return cobrinha;
    }

    public void setCobrinha(Cobrinha cobrinha) {
        this.cobrinha = cobrinha;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
            
    }

}
