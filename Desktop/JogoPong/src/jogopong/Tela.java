/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopong;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

/**
 *
 * @author camil
 */
public class Tela {
    
    private JFrame jframe;
    private Canvas canvas;
    public Tela(String titulo, int larg , int alt){
        
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(larg,alt));
        canvas.setMaximumSize(new Dimension(larg,alt));
        canvas.setMinimumSize(new Dimension(larg,alt));
        
        jframe = new JFrame(titulo);
        canvas.setFocusable(false); // nao roubar a tecla q esta sendo clicada
        jframe.add(canvas);
        jframe.pack();
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setLocationRelativeTo(null);
        jframe.setResizable(false);
        jframe.setVisible(true);
    }
    
    public BufferStrategy getBufferStrategy(){
        return canvas.getBufferStrategy();
    }
    
    public void createBufferStrategy(){
        canvas.createBufferStrategy(3);
    }
    
    //controle de teclado
    
    public void setKeyListener(KeyListener kl){
        jframe.addKeyListener(kl);
    }
}
