package ui;

// citation for AlarmSystem here **

import model.Bike;
import model.Swim;
import model.TrainingLog;
import model.Workout;
import persistence.JsonReader;
import persistence.JsonWriter;

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
    private static final String JSON_STORE = "./data/trainingLog.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private JLabel titlePanel;
    private TrainingLog trainingLog;
    private ArrayList<Workout> workouts = new ArrayList<>();
    private JInternalFrame displayArea;




    // constructor constructs window for displaying workouts in a training log and
    // button panel for actions that can be performed
    public TrainingLogViewerUI() {

        desktop = new JDesktopPane();
        desktop.addMouseListener(new DesktopFocusAction());
        controlPanel = new JInternalFrame("Training Log Viewer", false, false,
                false,false);
        controlPanel.setLayout(new BorderLayout());
        displayArea = new JInternalFrame("Workouts: ", false, false,
                false,false);

        setContentPane(desktop);
        setSize(WIDTH, HEIGHT);

        addButtons();
        addTitle();

        controlPanel.setTitle("Training Log Controls");

        controlPanel.pack();
        controlPanel.setVisible(true);
        desktop.add(controlPanel);

        displayArea.pack();
        displayArea.setVisible(true);
        desktop.add(displayArea, BorderLayout.NORTH);

        trainingLog = new TrainingLog("My Training Log", workouts);

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

    // MODIFIES: this
    // EFFECTS: represents action to be taken when user wants to add a new swim workout to the
    // current training log
    private class AddNewSwimAction extends AbstractAction {

        AddNewSwimAction() {
            super("Add New Swim");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Swim newSwim;
            String type = "Swim";
            String title;
            String date;
            String swimHR;
            String swimTime;
            String swimPace;
            String swimPerceivedDifficulty;
            String swimDistance;

            // TODO: need to trigger a swim-specific pop-up window for user input and then use code from previous ui
            //  to record all the inputs
            title = JOptionPane.showInputDialog("Please input a title: ");
            date = JOptionPane.showInputDialog("Please input the date: ");
            swimHR = JOptionPane.showInputDialog("Please input your average heart rate: ");
            swimTime = JOptionPane.showInputDialog("Please input total time: ");
            swimPace = JOptionPane.showInputDialog("Please input your pace per 100m in seconds: ");
            swimPerceivedDifficulty =
                    JOptionPane.showInputDialog("Please rate the difficulty of your workout from 1-10:  ");
            swimDistance = JOptionPane.showInputDialog("Please input your distance: ");

            newSwim = new Swim(type, title, date, Integer.parseInt(swimHR), Integer.parseInt(swimTime),
                    Integer.parseInt(swimPace), Integer.parseInt(swimPerceivedDifficulty),
                    Double.parseDouble(swimDistance));

            // TODO: add swim to training log
            trainingLog.addWorkout(newSwim, workouts);

            // TODO: after all inputs entered and swim is created, need to somehow display it in format:
            //  type + ": " + title + " (" + date + ")\n"
            displayWorkout(newSwim);

        }
    }


    // MODIFIES: this
    // EFFECTS: represents action to be taken when user wants to add a new bike workout to the
    // current training log
    private class AddNewBikeAction extends AbstractAction {

        AddNewBikeAction() {
            super("Add New Bike");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Bike newBike;

            // TODO: need to trigger a bike-specific pop-up window for user input and then use code from previous ui
            //  to record all the inputs



            // TODO: add bike to training log

            // TODO: after all inputs entered and bike is created, need to somehow display it in format:
            //  type + ": " + title + " (" + date + ")\n"

        }
    }

    // MODIFIES: this
    // EFFECTS: represents action to be taken when user wants to add a new run workout to the
    // current training log
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

    // EFFECTS: displays the type, title and date of w in the display section of the main window
    private void displayWorkout(Workout w) {

        // TODO: finish this method
        String displayString = w.getType() + ": " + w.getName() + " (" + w.getDate() + ")\n";
        JLabel workout = new JLabel(displayString);
        displayArea.add(workout, BorderLayout.SOUTH);
        displayArea.setVisible(true);
    }


    // EFFECTS: displays only workouts with specified type in display window
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

    // EFFECTS: saves the current state of the application
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


    // MODIFIES: this
    // EFFECTS: loads the previous state of the application
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

    private void addTitle() {
        titlePanel = new JLabel("Training Log Editor");
        controlPanel.add(titlePanel, BorderLayout.NORTH);

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
