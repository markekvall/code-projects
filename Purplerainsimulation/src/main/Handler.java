package main;

import java.awt.*;
import java.util.LinkedList;

public class Handler {

    LinkedList<SimulationObject> object = new LinkedList<SimulationObject>();

    public void tick() {
        for(int i = 0; i < object.size(); i++) {
            SimulationObject tempObject = object.get(i);
            tempObject.tick(object, i);  //goes into simulation object and changes the object
        }
    }

    public void render(Graphics g) {
        for(int i = 0; i < object.size(); i++) {
            SimulationObject tempObject = object.get(i);
            tempObject.render(g);   //animates the temporary object
        }
    }

    public void addObject(SimulationObject object) {
        this.object.add(object);
    }

}
