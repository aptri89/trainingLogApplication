package ui;

// citation for AlarmSystem here **

import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;

// Project Requirements:
// TODO: display all X's added to Y
// TODO: be able to add X to Y
// TODO: be able to save current X's to file
// TODO: be able to load previous X's from file
// TODO: add a splash screen or an image that appears after

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
        displayArea = new JInternalFrame("Display Area", false, false, false,
                false);


        setContentPane(desktop);
        setSize(WIDTH, HEIGHT);

        addButtons();

        displayArea.setLayout(new GridLayout());
        displayArea.setBounds(0, 200, WIDTH, HEIGHT);
        displayArea.pack();
        displayArea.setVisible(true);
        desktop.add(displayArea, BorderLayout.NORTH);

        controlPanel.pack();
        controlPanel.setVisible(true);
        desktop.add(controlPanel, BorderLayout.SOUTH);


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

            title = JOptionPane.showInputDialog("Please input a title: ");
            date = JOptionPane.showInputDialog("Please input the date (ex. October24,2022): ");
            swimHR = JOptionPane.showInputDialog("Please input your average heart rate: ");
            swimTime = JOptionPane.showInputDialog("Please input total time: ");
            swimPace = JOptionPane.showInputDialog("Please input your pace per 100m in seconds: ");
            swimPerceivedDifficulty =
                    JOptionPane.showInputDialog("Please rate the difficulty of your workout from 1-10:  ");
            swimDistance = JOptionPane.showInputDialog("Please input your distance: ");

            newSwim = new Swim(type, title, date, Integer.parseInt(swimHR), Integer.parseInt(swimTime),
                    Integer.parseInt(swimPace), Integer.parseInt(swimPerceivedDifficulty),
                    Double.parseDouble(swimDistance));

            trainingLog.addWorkout(newSwim, workouts);

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
            String type = "Bike";
            String title;
            String date;
            String bikeHR;
            String bikeTime;
            String bikeSpeed;
            String bikePerceivedDifficulty;
            String bikeDistance;

            title = JOptionPane.showInputDialog("Please input a title: ");
            date = JOptionPane.showInputDialog("Please input the date: ");
            bikeHR = JOptionPane.showInputDialog("Please input your average heart rate: ");
            bikeTime = JOptionPane.showInputDialog("Please input total time: ");
            bikeSpeed = JOptionPane.showInputDialog("Please input your speed in km/hr: ");
            bikePerceivedDifficulty =
                    JOptionPane.showInputDialog("Please rate the difficulty of your workout from 1-10:  ");
            bikeDistance = JOptionPane.showInputDialog("Please input your distance: ");

            newBike = new Bike(type, title, date, Integer.parseInt(bikeHR), Integer.parseInt(bikeTime),
                    Integer.parseInt(bikeSpeed), Integer.parseInt(bikePerceivedDifficulty),
                    Double.parseDouble(bikeDistance));

            trainingLog.addWorkout(newBike, workouts);

            displayWorkout(newBike);

        }
    }

    // MODIFIES: this
    // EFFECTS: represents action to be taken when user wants to add a new run workout to the
    // current training log
    private class AddNewRunAction extends AbstractAction {

        AddNewRunAction() {
            super("Add New Run");
        }

        // TODO: ask if I can suppress checkstyle here
        @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
        @Override
        public void actionPerformed(ActionEvent e) {
            Run newRun;
            String type = "Run";
            String title;
            String date;
            String runHR;
            String runTime;
            String runPaceMins;
            String runPaceSecs;
            String runPerceivedDifficulty;
            String runDistance;

            title = JOptionPane.showInputDialog("Please input a title: ");
            date = JOptionPane.showInputDialog("Please input the date: ");
            runHR = JOptionPane.showInputDialog("Please input your average heart rate: ");
            runTime = JOptionPane.showInputDialog("Please input total time: ");
            runPaceMins = JOptionPane.showInputDialog("Please input the minutes component of your run speed: ");
            runPaceSecs = JOptionPane.showInputDialog("Please input the seconds component of your run speed: ");
            runPerceivedDifficulty =
                    JOptionPane.showInputDialog("Please rate the difficulty of your workout from 1-10: ");
            runDistance = JOptionPane.showInputDialog("Please input your distance: ");

            newRun = new Run(type,title,date,Integer.parseInt(runHR), Integer.parseInt(runPaceMins),
                    Integer.parseInt(runPaceSecs), Integer.parseInt(runTime), Integer.parseInt(runPerceivedDifficulty),
                    Double.parseDouble(runDistance));

            trainingLog.addWorkout(newRun, workouts);

            displayWorkout(newRun);

        }
    }

    // EFFECTS: displays the type, title and date of w in the display section of the main window
    private void displayWorkout(Workout w) {

        // TODO: figure out how to make this part appear
        String displayString = w.getType() + ": " + w.getName() + " (" + w.getDate() + ")\n";
        JLabel newLabel = new JLabel(displayString);
        displayArea.add(newLabel);
        displayArea.pack();

    }



    // EFFECTS: displays only workouts with specified type in display window
    private class FilterByTypeAction extends AbstractAction {

        FilterByTypeAction() {
            super("Filter Workouts By Type");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            FilterByTypePopUp filterByTypePopUp = new FilterByTypePopUp();
            controlPanel.add(filterByTypePopUp, BorderLayout.EAST); // TODO: make this look nicer
            controlPanel.pack();
            controlPanel.setVisible(true);

        }
    }

    // EFFECTS: saves the current state of the application
    private class SaveCurrentAction extends AbstractAction {

        SaveCurrentAction() {
            super("Save Current Training Log");
        }

        // TODO: is it correct to just copy over the JSON code?
        @Override
        public void actionPerformed(ActionEvent e) {
            jsonWriter = new JsonWriter(JSON_STORE);
            try {
                jsonWriter.open();
                jsonWriter.write(trainingLog);
                jsonWriter.close();
                System.out.println("Saved " + trainingLog.getTitle() + " to " + JSON_STORE);
            } catch (FileNotFoundException ex) {
                System.out.println("Unable to write to file: " + JSON_STORE);
            }

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
            jsonReader = new JsonReader(JSON_STORE);

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

    public ArrayList<Workout> getWorkouts() {
        return workouts;
    }
}
