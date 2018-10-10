/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopong;

import java.awt.Graphics;

/**
 *
 * @author camil
 */
public interface Estados {
    void init();
    void update();
    void render(Graphics g);
    void KeyPress(int cod);
    void KeyReleased(int cod); //libera a tecla pressionada
}
