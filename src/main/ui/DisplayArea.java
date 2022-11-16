package ui;

import javax.swing.*;
import java.awt.*;

public class DisplayArea extends JPanel {

    public DisplayArea() {

    }

    public void addToDisplayArea(String newWorkout) {
        JLabel newLabel = new JLabel(newWorkout);
        setLayout(new FlowLayout());
        add(newLabel);
    }

}
