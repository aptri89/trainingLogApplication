package ui;

// used information from https://www.geeksforgeeks.org/java-swing-popup-and-popupfactory-with-examples/

import model.Workout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FilterByTypePopUp extends JPanel {
    JLabel label;

    // TODO: how to get this pop up to actually appear when I click the FilterByType button?
    public FilterByTypePopUp() {
        label = new JLabel("Choose type to filter by: ");
        this.add(label, BorderLayout.NORTH);
        addButtons();


    }



    private void addButtons() {
        this.setLayout(new GridLayout(3, 1));
        this.add(new JButton(new SwimFilterAction()));
        this.add(new JButton(new BikeFilterAction()));
        this.add(new JButton(new RunFilterAction()));


    }

    private class SwimFilterAction extends AbstractAction {

        SwimFilterAction() {
            super("Filter by Type: Swim");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //TODO: display only swim type workout


        }
    }

    private class BikeFilterAction extends AbstractAction {

        BikeFilterAction() {
            super("Filter By Type: Bike");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO: display only bike type workouts

        }
    }

    private class RunFilterAction extends AbstractAction {

        RunFilterAction() {
            super("Filter By Type: Run");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO: display only run type workouts

        }
    }



}
