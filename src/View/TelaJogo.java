package View;

import Controller.TelaJogoController;

public class TelaJogo extends TelaBase{

    public GamePanel gamePanel;    
    private TelaJogoController controle;
    
    public TelaJogo() {
        
        super("Jogo do Cobrão - por Gabriel Pavan");
        this.gamePanel = new GamePanel();
        this.gamePanel.setBounds(0,0,640,480);
        add(this.gamePanel);
        controle = new TelaJogoController(this);
        addKeyListener(controle);
        controle.inicializar();
        
    }
    
}
