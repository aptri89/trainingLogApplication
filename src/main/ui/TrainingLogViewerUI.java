package ui;

// citation for AlarmSystem here **

import model.TrainingLog;
import model.Workout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


// represents application's main window frame
public class TrainingLogViewerUI extends JFrame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;
    private JDesktopPane desktop;
    private JInternalFrame controlPanel;




    public TrainingLogViewerUI() {

        desktop = new JDesktopPane();
        desktop.addMouseListener(new DesktopFocusAction());
        controlPanel = new JInternalFrame("Default Control", false, false,
                false,false);
        controlPanel.setLayout(new BorderLayout());

        setContentPane(desktop);
        setTitle("TrainingLogViewer");
        setSize(WIDTH, HEIGHT);

    }






    // EFFECTS: represents action to be taken when user clicks desktop to switch focus
    // (needed for key handling)
    private class DesktopFocusAction extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            TrainingLogViewerUI.this.requestFocusInWindow();
        }
    }
}
