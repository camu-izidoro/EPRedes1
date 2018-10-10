/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.HashSet;

/**
 *
 * @author camil
 */
public class FPSEstados implements Estados{

    private long now, lastTime = System.nanoTime();
    private double timer =0;
    private int tick=0;
    private int  t;
    @Override
    public void init() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update() {
        now = System.nanoTime();
        timer += now - lastTime;
        lastTime = now;
        tick ++;
        //calcula os nanos segundos
        
     
   
    }

    @Override
    public void render(Graphics g) {

        g.setColor(Color.magenta);
        g.fillRect(0,0,Jogo.WIDTH,Jogo.HEIGHT);
       
        if(timer >= 1000000000){
            t=tick;
            tick=0;
            //quando o timer atingir ele zera
            timer=0;
        }
        
        g.setColor(Color.WHITE);
        Font font = new Font("serif", Font.PLAIN,12);
        g.setFont(font);     
        
        String text = "FPS" +t;
        g.drawString(text, g.getFontMetrics().stringWidth(text), g.getFontMetrics(font).getHeight());
        
    }

    @Override
    public void KeyPress(int cod) {
        System.out.println("press " + cod);
    }

    @Override
    public void KeyReleased(int cod) {
      System.out.println("release " + cod);
    }
    
}
