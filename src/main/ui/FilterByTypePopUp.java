package ui;

// used information from https://www.geeksforgeeks.org/java-swing-popup-and-popupfactory-with-examples/

import model.TrainingLog;
import model.Workout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// creates new JPanel for the filter buttons
public class FilterByTypePopUp extends JPanel {
    JLabel label;

    public FilterByTypePopUp() {
        label = new JLabel("Choose type to filter by: ");
        this.add(label, BorderLayout.NORTH);


    }



}
