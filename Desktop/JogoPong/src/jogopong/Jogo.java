/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author camil
 */
public class Jogo implements Runnable {
    
    private Tela tela;
    private Thread thread;
    private boolean running = false;
    
    public static final int WIDTH =400, HEIGHT=300;
  
    private GerenciadorEstados gm;
    
    private KeyManager km;
    
    public Jogo(){
        
        tela= new Tela("Pong",WIDTH,HEIGHT);
        gm=new GerenciadorEstados(); 
        km=new KeyManager(); 
        tela.setKeyListener(gm);
        tela.setKeyListener(km);
        GerenciadorEstados.setEstado(GerenciadorEstados.MENU);
       
    }

    @Override
    public void run() {
        init();
        int FPS = 60;
        double timePerTick = 1000000000/FPS;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
       while(running){
           now = System.nanoTime();
           delta  += (now - lastTime)/timePerTick;
           lastTime = now;
           // para o proximo calculo do frame, quando for ideal, ele escreve na tela
           // não atualiza antes do 1 
           // garante que faça 60x por segundo
           if (delta >= 1 ){
               update();
               render();
                  //System.out.println(delta);
                  delta --;
           }
        
       }
       para();
    }
    
    public synchronized void inicia(){
        // se um metodo estiver sendo executado, outro nao pode ser
        
        if(thread != null){
            return;
        }else{
            thread = new Thread(this);
            thread.start();
            running = true;
        }
        
    }
    
    public synchronized void para(){
        if(thread == null){
            return;
        }else{
        
            try {
                thread.join();
            } catch (InterruptedException ex) {
               ex.printStackTrace();
            }
  
     
        }
    }

    private void update() {
        
      if  (GerenciadorEstados.getEstado()== null)  return;
      gm.update();
      km.update();
        //cada interação do usuário , dados que compoe o momento do jogo
    }

    private void render() { // render desenha 60x por segundo, guarda imagens previas de renderização
        BufferStrategy bs = tela.getBufferStrategy();
        if (bs==null){
            tela.createBufferStrategy() ;
            bs = tela.getBufferStrategy();
        }
        //trabalha na tela
        // nao segue plano cartesiano
        // 0.0 está no canto superior esquerdo
        // desenha 60x por segundo
        Graphics g = bs.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);
            
        if  (GerenciadorEstados.getEstado() != null) {
          gm.render(g);
         
        }
      
    
        //retirado pois agora passará por um metodo a renderização
        //g.setColor(Color.PINK);
        //g.fillRect(10, 10, 50, 50);
        g.dispose(); // pode ser usado no buffer
        bs.show();
    }

    private void init() {

    }
}
