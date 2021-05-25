package main;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Simulation extends Canvas implements Runnable {

    public static final int WIDTH = 1000, HEIGHT = WIDTH / 16 * 9;
    private Thread thread;
    private boolean running = false;

    private Random r;
    private Handler handler;

    public Simulation() {

        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));
        new Window(WIDTH, HEIGHT, "Purple rain simulation", this);
        r = new Random();

        while(running) {              //TODO: implement while running. and maybe do on-off switch
            handler.addObject(new Droplet(r.nextInt(WIDTH*2)-500, -10, ID.Droplet));

            try{
                Thread.sleep(1);
            }catch(Exception e){
                e.printStackTrace();
            }

        }

    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try{
            thread.join();
            running = false;
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1) {
                tick();                 //runs method to i.e change location of object
                delta--;
            }
            if(running){render();}      //renders the objects that have
            frames++;

            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames + " linked list size: "+ handler.object.size());
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
        handler.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);

        g.dispose();
        bs.show();

    }


    public static void main (String[] args) {
        new Simulation();
    }
}
