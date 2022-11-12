package ui;

// citation for AlarmSystem here **

import model.Workout;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;


// represents application's main window frame
public class TrainingLogViewerUI extends JFrame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;
    private JDesktopPane desktop;
    private JInternalFrame controlPanel;
    private static final String JSON_STORE = "./data/trainingLog.json";
    private Scanner input;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private KeyBoard kb;




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

        AddNewWorkoutAction() {
            super("Add New Workout: ");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Workout newWorkout = createWorkout();

        }
    }

    private Workout createWorkout() {
        Workout w = new Workout("Swim", "Swim", "October",
                0,0,0,0);
        return w; // stub

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
