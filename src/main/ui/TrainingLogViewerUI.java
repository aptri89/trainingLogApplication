package ui;

// citation for AlarmSystem here **

import model.TrainingLog;
import model.Workout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


// represents application's main window frame
public class TrainingLogViewerUI extends JFrame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;
    private JDesktopPane desktop;
    private JInternalFrame controlPanel;




    // constructor constructs window for displaying workouts in a training log and
    // button panel for actions that can be performed
    public TrainingLogViewerUI() {

        desktop = new JDesktopPane();
        desktop.addMouseListener(new DesktopFocusAction());
        controlPanel = new JInternalFrame("Default Control", false, false,
                false,false);
        controlPanel.setLayout(new BorderLayout());

        setContentPane(desktop);
        setTitle("TrainingLogViewer");
        setSize(WIDTH, HEIGHT);

        addButtons();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

    // EFFECTS: helper to add buttons for TrainingLogViewer
    private void addButtons() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2,2));
        buttonPanel.add(new JButton(new AddNewWorkoutAction()));
        buttonPanel.add(new JButton(new FilterByTypeAction()));
        buttonPanel.add(new JButton(new SaveCurrentAction()));
        buttonPanel.add(new JButton(new LoadPreviousAction()));

        controlPanel.add(buttonPanel, BorderLayout.SOUTH);


    }

    // MODIFIES: TrainingLog
    // EFFECTS: represents action to be taken when user wants to add a new workout to the
    // current training log
    private class AddNewWorkoutAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    private class FilterByTypeAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    private class SaveCurrentAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    private class LoadPreviousAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
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
