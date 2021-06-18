
package Model;

import java.awt.Color;
import java.awt.Graphics;

public class CorpoCobrinha extends Node {

    public CorpoCobrinha(int x, int y) {
        super(x, y);
    }
   
    @Override
    public void desenhar(Graphics g) {
        
        g.setColor(Color.CYAN);
        g.fillRect(this.getX(), this.getY(), Node.TAMANHO, Node.TAMANHO);
        
    }
    
    
    
    
    
    
    
}
