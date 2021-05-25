package main;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Scanner;

/*--------------------------------------------------
Created by Mark Ekvall
2021-05
 --------------------------------------------------*/

public class SortAlgorithmVisualizer extends Canvas {

    public static final int WIN_WIDTH = 1280, WIN_HEIGHT = 720;
    public static final int BAR_WIDTH = 8;
    public static final int NUM_BARS = WIN_WIDTH / BAR_WIDTH;

    private String userChoice;
    private ArraySetUp arraySetUp;

    public SortAlgorithmVisualizer() {

        arraySetUp = new ArraySetUp();

        arraySetUp.constructArray(NUM_BARS);
        arraySetUp.shuffleArray(NUM_BARS);
        new Window(WIN_WIDTH, WIN_HEIGHT, "Sorting visualizer", this);

    }

    public void manager() {
        userChoice = userInput();
        arraySetUp.manager(this, userChoice);
    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIN_WIDTH, WIN_HEIGHT);

        arraySetUp.render(g);

        g.dispose();
        bs.show();
    }

    public String userInput() {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner from scanner class
        System.out.println("Please choose sorting method: ");
        System.out.println("1. Type 'bubble' for bubble sort");
        System.out.println("2. Type 'insert' for insert sort");
        System.out.println("3. Type 'merge' for merge sort");
        return scanner.nextLine();
    }

    public static void main (String[] args) {
        new SortAlgorithmVisualizer();
    }
}
