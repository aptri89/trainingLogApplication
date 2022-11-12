package ui;

// citation for AlarmSystem here **

import model.Swim;
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

        controlPanel.setTitle("Training Log Controls");

        controlPanel.pack();
        controlPanel.setVisible(true);
        desktop.add(controlPanel);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

    // EFFECTS: helper to add buttons for TrainingLogViewer
    private void addButtons() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2,3));
        buttonPanel.add(new JButton(new AddNewSwimAction()));
        buttonPanel.add(new JButton(new AddNewBikeAction()));
        buttonPanel.add(new JButton(new AddNewRunAction()));
        buttonPanel.add(new JButton(new FilterByTypeAction()));
        buttonPanel.add(new JButton(new SaveCurrentAction()));
        buttonPanel.add(new JButton(new LoadPreviousAction()));


        controlPanel.add(buttonPanel, BorderLayout.SOUTH);


    }

    // MODIFIES: TrainingLog
    // EFFECTS: represents action to be taken when user wants to add a new workout to the
    // current training log
    private class AddNewSwimAction extends AbstractAction {

        AddNewSwimAction() {
            super("Add New Swim");
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            // TODO: need to trigger a swim-specific pop-up window for user input and then use code from previous ui
            //  to record all the inputs

            // TODO: add swim to training log

            // TODO: after all inputs entered and swim is created, need to somehow display it in format:
            //  type + ": " + title + " (" + date + ")\n"

        }
    }

    private class AddNewBikeAction extends AbstractAction {

        AddNewBikeAction() {
            super("Add New Bike");
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            // TODO: need to trigger a bike-specific pop-up window for user input and then use code from previous ui
            //  to record all the inputs

            // TODO: add bike to training log

            // TODO: after all inputs entered and bike is created, need to somehow display it in format:
            //  type + ": " + title + " (" + date + ")\n"

        }
    }

    private class AddNewRunAction extends AbstractAction {

        AddNewRunAction() {
            super("Add New Run");
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            // TODO: need to trigger a run-specific pop-up window for user input and then use code from previous ui
            //  to record all the inputs

            // TODO: add run to training log

            // TODO: after all inputs entered and run is created, need to somehow display it in format:
            //  type + ": " + title + " (" + date + ")\n"

        }
    }

    private class FilterByTypeAction extends AbstractAction {

        FilterByTypeAction() {
            super("Filter Workouts By Type");
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            // TODO: pop-up with the three types (Swim, Bike and Run) as buttons needs to appear

            // TODO: button input needs to trigger the display in the main window to only show workouts with the type
            //  pressed by the user

        }
    }

    private class SaveCurrentAction extends AbstractAction {

        SaveCurrentAction() {
            super("Save Current Training Log");
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            // TODO: use JsonWriter code (in TrainingLog and Workout) to save the current workouts that have
            //  been created


        }
    }

    private class LoadPreviousAction extends AbstractAction {

        LoadPreviousAction() {
            super("Load Previous Training Log");
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            // TODO: use JsonReader code (idk where it is right now but we'll find it) to load the previously saved
            //  workouts

            // TODO: add those loaded workouts to this training log

            // TODO: display the loaded workouts

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
