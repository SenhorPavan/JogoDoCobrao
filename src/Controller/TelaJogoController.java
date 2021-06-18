package Controller;

import Model.Cobrinha;
import Model.Node;
import View.TelaJogo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelaJogoController implements KeyListener, Runnable {

    private TelaJogo tela;
    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;
    private boolean pau;
    private Thread loop;
    private int velocidade;

    public TelaJogoController(TelaJogo tela) {
        this.tela = tela;
        up = false;
        down = false;
        left = false;
        right = true;
        pau = true;
        loop = new Thread(this);
        this.velocidade = 250;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP && !this.down) {
            this.up = true;
            this.left = false;
            this.right = false;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN && !this.up) {
            this.down = true;
            this.left = false;
            this.right = false;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT && !this.right) {
            this.left = true;
            this.down = false;
            this.up = false;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && !this.left) {
            this.right = true;
            this.up = false;
            this.down = false;
        } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }else if((e.getKeyCode() == KeyEvent.VK_R && !this.pau)){
            this.reiniciar();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void inicializar() {
        this.tela.gamePanel.getCobrinha().getCobrinha().get(0).mover(10 * 20, 5 * 20);
        pau = false;
        this.tela.gamePanel.getTimer().start();
        loop.start();
    }

    public void VerificarColizao(Node a) {
        if (a.getX() == 0 || a.getX() == (20 * 31) || a.getY() == 0 || a.getY() == (20 * 23)) {
            pau = true;
            loop.interrupt();
        }
    }

    public void VerificarComida(Node a, Node b) {
        if (a.getX() == b.getX() && a.getY() == b.getY()) {
            this.tela.gamePanel.getCobrinha().crescerCobrinha();
            int x = (new Random().nextInt(30)+1);
            int y = (new Random().nextInt(22)+1);
            this.tela.gamePanel.getFruta().mover(x*20, y*20);
            this.velocidade -= 20; 
            

        }
    }

    public void ColissaoCobrinha(Cobrinha a){
        
        ArrayList<Node> b = a.getCobrinha();
        for(int i = 1 ; i > a.getCobrinha().size();i++){
            if(b.get(0).getX() == b.get(i).getX() && b.get(0).getY() == b.get(i).getY()){
                pau = true;
                loop.interrupt();
            }            
        }
    }
    
    public void reiniciar(){
        this.tela.gamePanel.getCobrinha().getCobrinha().get(0).mover(10 * 20, 5 * 20);
        pau = false;
        this.tela.gamePanel.getTimer().start();
        up = false;
        down = false;
        left = false;
        right = true;
        loop = new Thread(this);
        loop.start();
    }
    
    
    private void atualizar() {
        if (up) {
            this.tela.gamePanel.getCobrinha().atualizar(Cobrinha.UP);
        } else if (down) {
            this.tela.gamePanel.getCobrinha().atualizar(Cobrinha.DOWN);
        } else if (left) {
            this.tela.gamePanel.getCobrinha().atualizar(Cobrinha.LEFT);
        } else if (right) {
            this.tela.gamePanel.getCobrinha().atualizar(Cobrinha.RIGHT);
        }
    }

    @Override
    public void run() {
        while (pau == false) {
            try {
                Thread.sleep(velocidade);
            } catch (InterruptedException ex) {
                Logger.getLogger(TelaJogoController.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.atualizar();
            this.VerificarColizao(this.tela.gamePanel.getCobrinha().getCobrinha().get(0));
            this.VerificarComida(this.tela.gamePanel.getCobrinha().getCobrinha().get(0), this.tela.gamePanel.getFruta());
            this.ColissaoCobrinha(this.tela.gamePanel.getCobrinha());
        }
    }

}
