package ui;

import javax.swing.*;
import java.awt.*;

// creates new JPanel for the filter buttons
public class FilterByTypePopUp extends JPanel {
    JLabel label;

    public FilterByTypePopUp() {
        label = new JLabel("Choose type to filter by: ");
        this.add(label, BorderLayout.NORTH);


    }



}
