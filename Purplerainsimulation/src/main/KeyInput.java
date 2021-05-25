package main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for(int i = 0; i < handler.object.size(); i++) {
            SimulationObject tempObject = handler.object.get(i);

            if(key == KeyEvent.VK_RIGHT) {
                tempObject.setVelX(5);

            }
            if(key == KeyEvent.VK_LEFT) {
                tempObject.setVelX(-5);
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
    }

}
