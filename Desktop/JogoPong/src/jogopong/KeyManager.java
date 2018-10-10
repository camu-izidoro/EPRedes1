/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopong;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author camil
 */
public class KeyManager implements KeyListener{
    private boolean[] teclas = new boolean[256];
    public static boolean w,s,up,down;
    public void update(){
        w=teclas[KeyEvent.VK_W];
        s=teclas[KeyEvent.VK_S];
        up=teclas[KeyEvent.VK_UP];
        down=teclas[KeyEvent.VK_DOWN];
    }
    @Override
    public void keyTyped(KeyEvent k) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent k) {
        
        if(k.getKeyCode()<0 || k.getKeyCode()> 255)
           return; 
        teclas[k.getKeyCode()] = true;
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent k) {
            if(k.getKeyCode()<0 || k.getKeyCode()> 255)
                return; 
            teclas[k.getKeyCode()] = false;
    }
    
}
