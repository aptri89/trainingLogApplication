package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FilterByTypePopUp extends JPanel {
    JPanel popUp;

    // TODO: how to get this pop up to actually appear when I click the FilterByType button?
    public FilterByTypePopUp() {
        popUp = new JPanel();
        addButtons();

    }

    private void addButtons() {
        popUp.setLayout(new GridLayout(3, 1));
        popUp.add(new JButton(new SwimFilterAction()));
        popUp.add(new JButton(new BikeFilterAction()));
        popUp.add(new JButton(new RunFilterAction()));
        // TODO: button input needs to trigger the display in the main window to only show workouts with the type
        //  pressed by the user

    }

    private class SwimFilterAction extends AbstractAction {

        SwimFilterAction() {
            super("Filter by Type: Swim");
        }

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    private class BikeFilterAction extends AbstractAction {

        BikeFilterAction() {
            super("Filter By Type: Bike");
        }

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    private class RunFilterAction extends AbstractAction {

        RunFilterAction() {
            super("Filter By Type: Run");
        }

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }


}
