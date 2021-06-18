package Model;

import java.awt.Graphics;
import java.util.ArrayList;

public class Cobrinha {

    private ArrayList<Node> cobrinha;
    public static final int UP = 1;
    public static final int DOWN = 2;
    public static final int LEFT = 3;
    public static final int RIGHT = 4;

    public Cobrinha(int x, int y) {
        cobrinha = new ArrayList<>();
        CorpoCobrinha cabeca = new CorpoCobrinha(x, y);
        CorpoCobrinha corpo = new CorpoCobrinha(x - 20, y);
        CorpoCobrinha rabo = new CorpoCobrinha(x - 40, y);
        cobrinha.add(cabeca);
        cobrinha.add(corpo);
        cobrinha.add(rabo);

    }

    public void crescerCobrinha() {

        CorpoCobrinha newCorpo = (CorpoCobrinha) this.cobrinha.get(this.cobrinha.size() - 1);
        int x = newCorpo.getX();
        int y = newCorpo.getY();
        this.cobrinha.add(new CorpoCobrinha(x, y));

    }

    public void desenhar(Graphics g) {

        for (int i = 0; i < this.cobrinha.size(); i++) {
            this.cobrinha.get(i).desenhar(g);
        }
    }

    public void atualizar(int direcao) {
        
        for(int i = this.cobrinha.size() - 1; i > 0 ; i--){
            this.cobrinha.get(i).mover(this.cobrinha.get(i - 1).getX(), this.cobrinha.get(i - 1).getY());
        }
        
        switch (direcao) {
            case UP:
                int posicaoAtualY = this.cobrinha.get(0).getY();
                int novaPosicao = posicaoAtualY - Node.TAMANHO;
                this.cobrinha.get(0).setY(novaPosicao);
                break;
            case DOWN:
                this.cobrinha.get(0).setY(this.cobrinha.get(0).getY() + Node.TAMANHO);
                break;
            case LEFT:
                this.cobrinha.get(0).setX(this.cobrinha.get(0).getX() - Node.TAMANHO);
                break;
            case RIGHT:
                this.cobrinha.get(0).setX(this.cobrinha.get(0).getX() + Node.TAMANHO);
                break;

        }
    }

    public ArrayList<Node> getCobrinha() {
        return cobrinha;
    }

    public void setCobrinha(ArrayList<Node> cobrinha) {
        this.cobrinha = cobrinha;
    }

}
