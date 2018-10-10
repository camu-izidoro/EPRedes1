/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopong;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author camil
 */
public class GerenciadorEstados implements KeyListener{
    
    public static final int numeroEstados =3;
    public static Estados[] estados = new Estados[numeroEstados];
    public static int estadoAtual=0;
    public static final int FPS = 0;
    public static final int MENU = 1;
    public static final int Nivel1 = 2;
    
    public static void setEstado (int status){
        estadoAtual=status;
        estados[estadoAtual].init();
    }
    
    public GerenciadorEstados(){
        //colocar os estados garregar imagens e configuração de teclados
        estados[0]= new FPSEstados();
        estados[1]= new MenuEstados();
        estados[2]= new Nivel1Estados();
    }
    
    public void update(){
        
     estados[estadoAtual].update();
    }
    
    public void render(Graphics g){
        estados[estadoAtual].render(g);
    }
    
    public static Estados getEstado(){
        return estados[estadoAtual];
    }
//recebe os avisos de eventos
    @Override
    public void keyTyped(KeyEvent e) {
  
    }

    @Override
    public void keyPressed(KeyEvent e) {
       estados[estadoAtual].KeyPress(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        estados[estadoAtual].KeyReleased(e.getKeyCode());
    }
}
