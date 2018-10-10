/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.HashSet;

/**
 *
 * @author camil
 */
public class MenuEstados implements Estados{
    private String[] opcoes = {"START","HELP","EXIT"};
    private Font font1;
    private Font font2;
    private int escolha=0;
    private int  x=0, y=0, movex=1, movey=1;
    @Override
    public void init() {
        font1= new Font("PONG", Font.PLAIN,48);
        font2= new Font("PONG", Font.PLAIN,24);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update() {
        x+= movex;
        y+= movey;
        
        limits();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.MAGENTA);
        g.fillRect(0, 0, Jogo.WIDTH, Jogo.HEIGHT);
        
        g.setColor(Color.WHITE);
        g.setFont(font1);
        g.drawString("PONG", Jogo.WIDTH/2 - g.getFontMetrics().stringWidth("PONG")/2, Jogo.HEIGHT * 1/4);
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        g.setFont(font2);
        
        for(int i =0; i< opcoes.length;i++ ){
            g.setColor(Color.white);
            
            if(i==escolha)
                g.setColor(Color.YELLOW);
            g.drawString(opcoes[i], Jogo.WIDTH/2 - g.getFontMetrics().stringWidth(opcoes[i])/2, Jogo.HEIGHT *3/4 + g.getFontMetrics(font2).getHeight()*i);
    
         
        }
        
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 15, 15);
        
        
            
       
        
    }

    @Override
    public void KeyPress(int cod) {
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void KeyReleased(int cod) {
        //soltar a tecla // metodo capturado e pega o codigo dele
        
        if(cod == KeyEvent.VK_W){
            escolha--;
            if(escolha <0)
                escolha = opcoes.length-1;
            
        }   
          if(cod == KeyEvent.VK_S){
            escolha++;
            if(escolha > opcoes.length-1)
                escolha = 0;
            
        }
          if(cod == KeyEvent.VK_ENTER){
              select();
          }
    }
        
    private void select(){
        switch(escolha){
            case 0:
                GerenciadorEstados.setEstado(GerenciadorEstados.Nivel1);
                break;
            case 1:
                break;
            case 2:
                System.exit(0);
                break;
            default:
                break;  
        }
    }  

    private void limits() {
        if(x+15> Jogo.WIDTH){
            movex =-1;
        }
        
        if(y+15> Jogo.HEIGHT){
            movey =-1;
        }
        
        if(x<0)
            movex=1;
        if(y<0)
            movey=1;
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
}
