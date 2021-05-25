package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RollDicePanel extends JPanel {

    //======================================================= instance variables
    private Die _leftDie;     // component for one die
    private Die _rightDie;

    //============================================================== constructor
    /** Create border layout panel with one button and two dice. */
    RollDicePanel() {
        //... Create the dice
        _leftDie  = new Die();
        _rightDie = new Die();

        //...Create the button to roll the dice
        JButton rollButton = new JButton("New Roll");
        rollButton.setFont(new Font("Sansserif", Font.PLAIN, 24));

        //... Add listener.
        rollButton.addActionListener(new RollListener());

        //... Layout components
        this.setLayout(new BorderLayout(5, 5));
        this.add(rollButton, BorderLayout.NORTH);
        this.add(_leftDie , BorderLayout.WEST);
        this.add(_rightDie, BorderLayout.EAST);

        this.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
    }


    ////////////////////////////////////////// inner listener class RollListener
    private class RollListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            _leftDie.roll();
            _rightDie.roll();

        }
    }
}