package main;

import java.awt.*;
import java.util.Random;

import static main.SortAlgorithmVisualizer.BAR_WIDTH;
import static main.SortAlgorithmVisualizer.WIN_HEIGHT;

public class ArraySetUp {

    int[] array;
    private Algorithms algorithms;

    public void manager(SortAlgorithmVisualizer simulation, String userChoice) {
        algorithms = new Algorithms();

        switch (userChoice) {
            case "bubble":
            algorithms.bubbleSort(simulation, array);
            case "insert":
            algorithms.insertSort(simulation, array);
            case "merge":
            algorithms.mergeSort(simulation, array, 0, array.length - 1);
            simulation.render();
        }
    }

    public void render(Graphics g) {
        for(int i = 0; i < array.length; i++) {
            g.setColor(Color.BLUE);
            g.fillRect((i*BAR_WIDTH)-BAR_WIDTH, WIN_HEIGHT-(array[i]*2)-100, BAR_WIDTH, array[i]*2);
        }
    }

    public void constructArray(int NUM_BARS) {
        array = new int[NUM_BARS];
        for(int i = 0; i < NUM_BARS; i++) {
            array[i] = i;
        }
    }

    public void shuffleArray(int NUM_BARS) {
        Random rng = new Random();
        for(int i = 0; i < NUM_BARS; i++) {
            int swapWithIndex = rng.nextInt(NUM_BARS - 1);
            int temp = array[i];
            array[i] = array[swapWithIndex];
            array[swapWithIndex] = temp;
        }
    }
}
