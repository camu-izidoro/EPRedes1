/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author camil
 */
public class Nivel1Estados implements Estados{
    private Rectangle bola = new Rectangle(Jogo.WIDTH/2 -5,Jogo.HEIGHT/2 -5,10,10);
    private Rectangle jogador1 = new Rectangle(0,0,10,50);
    private Rectangle jogador2 = new Rectangle(Jogo.WIDTH - 10,0,10,50);
    private int  movex=1, movey=1;
    private int placar1 =0 , placar2=0;
    @Override
    public void init() {
        inicia();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void inicia(){
        bola.x=Jogo.WIDTH/2 - 5;
        bola.y=Jogo.HEIGHT/2 - 5;
        
        Random r = new Random();
        
        movex = (r.nextInt(2) == 0) ? 2 : -2;
        movey = (r.nextInt(2) == 0) ? 2 : -2;
    }

    
    @Override
    public void update() {
        bola.x+= movex;
        bola.y+= movey;
        limits_bola();
         
        if(KeyManager.w){
            jogador1.y -=8;
        }
        if(KeyManager.s){
            jogador1.y +=8;
        }
        if(KeyManager.up){
            jogador2.y -=8;
        }    
        if(KeyManager.down){
            jogador2.y +=8;
        }
      
        limits_jogadores();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Jogo.WIDTH, Jogo.HEIGHT);
        g.setColor(Color.WHITE);
        
        
        Font fonte = new Font("Dialog", Font.BOLD,12);
        g.setFont(fonte);
        g.drawString("Jogador 1 "+ placar1,Jogo.WIDTH * 1/4  - g.getFontMetrics().stringWidth("Jogador 1 "+ placar1)/2, g.getFontMetrics(fonte).getHeight());
        g.drawString("Jogador 2 "+ placar2,Jogo.WIDTH * 3/4  - g.getFontMetrics().stringWidth("Jogador 2 "+ placar2)/2, g.getFontMetrics(fonte).getHeight());
        g.fillRect(Jogo.WIDTH/2 - 3 ,0,6,Jogo.HEIGHT);
        g.fillRect(bola.x, bola.y, bola.width, bola.height);
        g.fillRect(jogador1.x, jogador1.y, jogador1.width, jogador1.height);
        g.fillRect(jogador2.x, jogador2.y, jogador2.width, jogador2.height);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void KeyPress(int cod) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void KeyReleased(int cod) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
        private void limits_bola() {
        if(bola.x+15> Jogo.WIDTH){
            //movex = -1;
            placar1++;
            inicia();
        }
        
        if(bola.y+15> Jogo.HEIGHT){
            movey = -2;
        }
        
        if(bola.x < 0)
            placar2++;
            //movex=1;
             //QUANDO PASSAR DA ESQUERDA DA TELA
            inicia();
           
        if( bola.y< 0)
            movey=2;
        
        // intercept quando o retangulo do jogador encontra a bolinha // importante para os sockets
        
        if(jogador1.intersects(bola) || jogador2.intersects(bola) ){
            movex *=-1; // mantem a velocidade e só muda o sinal
        }
        }

    private void limits_jogadores() {
     if(jogador1.y < 0)
         jogador1.y=0;
     if(jogador1.y > Jogo.HEIGHT - jogador1.height);
         jogador1.y = Jogo.HEIGHT - jogador1.height;
     if(jogador2.y < 0)
         jogador2.y=0;
     if(jogador2.y > Jogo.HEIGHT - jogador2.height);
         jogador2.y = Jogo.HEIGHT - jogador2.height;    
    }
    
}
