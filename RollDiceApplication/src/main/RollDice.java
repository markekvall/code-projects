package main;

import javax.swing.*;

/*-----------------------------------------------------
Created by Mark Ekvall 05-2025 to practice GUIs in java.
Heavily inspired by project created by Fred Swartz - 2006-11-30
 -----------------------------------------------------*/
public class RollDice {

    public RollDice() {
        JFrame window = new JFrame("Roll Dice");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(new RollDicePanel());
        window.pack();
        //System.out.println(window.getContentPane().getSize());
        window.setLocationRelativeTo(null);

        window.setVisible(true);
    }


    public static void main (String[] args) {
        new RollDice();
    }
}
