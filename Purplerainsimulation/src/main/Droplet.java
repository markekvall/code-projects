package main;

import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

import static main.Simulation.WIDTH;
import static main.Simulation.HEIGHT;

public class Droplet extends SimulationObject {

    public double acceleration = 0.05;
    public Random r = new Random();


    public Droplet(int x, int y, ID id) {
        super(x, y, id);
        setVelY(r.nextInt(3)+2);
    }

    public void tick(LinkedList<SimulationObject> object, int index) {
        x += velX;
        y += velY;
        velY += acceleration;



        if(y > HEIGHT) {
            object.remove(index);       //remove object if its out of bounce
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.MAGENTA);
        g.fillRect(x, y, 1, 4);
    }

}
