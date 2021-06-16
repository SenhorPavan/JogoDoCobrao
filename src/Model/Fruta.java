package Model;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Fruta extends Node {

    private ImageIcon fruta;

    public Fruta(int x, int y) {
        super(x, y);
        this.fruta = new ImageIcon("src/Assets/bolinha.png");
    }

    @Override
    public void desenhar(Graphics g) {
        g.drawImage(this.fruta.getImage(), getX(), getY(), Node.TAMANHO, Node.TAMANHO, null);
        g.setColor(Color.BLACK);

    }

}
