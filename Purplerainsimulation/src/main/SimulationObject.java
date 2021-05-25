package main;

import java.awt.*;
import java.util.LinkedList;

public abstract class SimulationObject {

    protected int x, y;
    protected ID id;

    protected double velX, velY, wind;

    public SimulationObject(int x, int y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick(LinkedList<SimulationObject> object, int index);
    public abstract void render(Graphics g);

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setVelX(double velX) {
        this.velX = velX;
    }

    public void setVelY(double velY) {
        this.velY = velY;
    }

    public void setWind(double wind) { this.wind = wind; }

    public double getWind() {
        return wind;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public int getX(int x) {
        return x;
    }

    public int getY(int y) {
        return y;
    }

    public ID getId(ID id) {
        return id;
    }

    public int getVelX(int velX) {
        return velX;
    }

    public int getVelY(int velY) {
        return velY;
    }

}
