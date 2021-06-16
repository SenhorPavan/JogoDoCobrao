package Model;

import java.awt.Graphics;
import java.util.ArrayList;

public class Cobrinha {

    private ArrayList<Node> cobrinha;

    public Cobrinha(int x, int y) {
        cobrinha = new ArrayList<>();
        CorpoCobrinha cabeca = new CorpoCobrinha(x, y);
        CorpoCobrinha corpo = new CorpoCobrinha(x-20, y);
        CorpoCobrinha rabo = new CorpoCobrinha(x-40, y);
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

    public ArrayList<Node> getCobrinha() {
        return cobrinha;
    }

    public void setCobrinha(ArrayList<Node> cobrinha) {
        this.cobrinha = cobrinha;
    }

}
