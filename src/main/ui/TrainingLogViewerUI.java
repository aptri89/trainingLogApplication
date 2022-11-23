package ui;

// used code from AlarmControllerUI class in https://github.students.cs.ubc.ca/CPSC210/AlarmSystem.git
// used code from https://stackoverflow.com/questions/60516720/java-how-to-print-message-when-a-jframe-is-closed


import model.*;
import model.Event;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


// represents application's main window frame
public class TrainingLogViewerUI extends JFrame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;
    private static int ROWS = 10;
    private JDesktopPane desktop;
    private JInternalFrame controlPanel;
    private static final String JSON_STORE = "./data/trainingLog.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private TrainingLog trainingLog;
    private ArrayList<Workout> workouts = new ArrayList<>();
    private JInternalFrame displayArea;
    private FilterByTypePopUp filter;
    private JInternalFrame filterDisplay;
    private ImageIcon happyTraining;


    // constructor constructs window for displaying workouts in a training log and
    // button panel for actions that can be performed
    public TrainingLogViewerUI() {
        desktop = new JDesktopPane();
        desktop.addMouseListener(new DesktopFocusAction());
        controlPanel = new JInternalFrame("Training Log Viewer", false, false,
                false, false);
        controlPanel.setLayout(new BorderLayout());
        displayArea = new JInternalFrame("Display Area", false, false, false,
                false);
        filterDisplay = new JInternalFrame("Filtered Workouts", false, false, false,
                false);

        happyTraining =
                new ImageIcon(new ImageIcon(getClass().getResource("HappyTraining.jpg")).getImage()
                        .getScaledInstance(110,80,Image.SCALE_DEFAULT));

        setContentPane(desktop);
        setSize(WIDTH, HEIGHT);

        addButtons();

        setUpDisplayArea();

        setUpFilterDisplay();


        setControlPanel();

        trainingLog = new TrainingLog("My Training Log", workouts);

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setVisible(true);
        addTrainingLogWindowListener();


    }

    // MODIFIES: controlPanel
    // EFFECTS: sets the visibility of the controlPanel and adds it to the desktop
    private void setControlPanel() {
        controlPanel.pack();
        controlPanel.setVisible(true);
        desktop.add(controlPanel, BorderLayout.SOUTH);
    }

    // MODIFIES: this
    // EFFECTS: adds a WindowListener that prints events from the EventLog when the user exits the GUI
    private void addTrainingLogWindowListener() {
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                for (Event e : EventLog.getInstance()) {
                    System.out.println(e.getDescription().toString());
                }
                System.exit(0);
            }
        });
    }



    // EFFECTS: helper to add buttons for TrainingLogViewer
    private void addButtons() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 3));
        buttonPanel.add(new JButton(new AddNewSwimAction()));
        buttonPanel.add(new JButton(new AddNewBikeAction()));
        buttonPanel.add(new JButton(new AddNewRunAction()));
        buttonPanel.add(new JButton(new FilterByTypeAction()));
        buttonPanel.add(new JButton(new SaveCurrentAction()));
        buttonPanel.add(new JButton(new LoadPreviousAction()));


        controlPanel.add(buttonPanel, BorderLayout.SOUTH);

    }

    // MODIFIES: displayArea
    // EFFECTS: sets up the display area for workouts added
    private void setUpDisplayArea() {
        displayArea.setLayout(new GridLayout(ROWS, 1)); // TODO: how to set this up with no need for ROWS?
        displayArea.setBounds(0, 200, WIDTH, HEIGHT);
        displayArea.pack();
        displayArea.setVisible(true);
        desktop.add(displayArea, BorderLayout.NORTH);
    }




    // MODIFIES: this
    // EFFECTS: represents action to be taken when user wants to add a new swim workout to the
    // current training log
    private class AddNewSwimAction extends AbstractAction {

        AddNewSwimAction() {
            super("Add New Swim");
        }

        // EFFECTS: achieves effects of the class
        @Override
        public void actionPerformed(ActionEvent e) {
            Swim newSwim;
            String type = "Swim";
            String title = JOptionPane.showInputDialog("Please input a title: ");
            String date = JOptionPane.showInputDialog("Please input the date (ex. October24,2022): ");
            String swimHR = JOptionPane.showInputDialog("Please input your average heart rate: ");
            String swimTime = JOptionPane.showInputDialog("Please input total time: ");
            String swimPace = JOptionPane.showInputDialog("Please input your pace per 100m in seconds: ");
            String swimPerceivedDifficulty =
                    JOptionPane.showInputDialog("Please rate the difficulty of your workout from 1-10:  ");
            String swimDistance = JOptionPane.showInputDialog("Please input your distance: ");


            newSwim = new Swim(type, title, date, Integer.parseInt(swimHR), Integer.parseInt(swimTime),
                    Integer.parseInt(swimPace), Integer.parseInt(swimPerceivedDifficulty),
                    Double.parseDouble(swimDistance));

            trainingLog.addWorkout(newSwim, workouts);

            displayWorkout(newSwim, displayArea);
            displayImage();


        }
    }


    // MODIFIES: this
    // EFFECTS: represents action to be taken when user wants to add a new bike workout to the
    // current training log
    private class AddNewBikeAction extends AbstractAction {

        AddNewBikeAction() {
            super("Add New Bike");
        }

        // EFFECTS: achieves effects of the class
        @Override
        public void actionPerformed(ActionEvent e) {
            Bike newBike;
            String type = "Bike";
            String title = JOptionPane.showInputDialog("Please input a title: ");
            String date = JOptionPane.showInputDialog("Please input the date (ex. October24,2022): ");
            String bikeHR = JOptionPane.showInputDialog("Please input your average heart rate: ");
            String bikeTime = JOptionPane.showInputDialog("Please input total time: ");
            String bikeSpeed = JOptionPane.showInputDialog("Please input your speed in km/hr: ");
            String bikePerceivedDifficulty =
                    JOptionPane.showInputDialog("Please rate the difficulty of your workout from 1-10:  ");
            String bikeDistance = JOptionPane.showInputDialog("Please input your distance: ");

            newBike = new Bike(type, title, date, Integer.parseInt(bikeHR), Integer.parseInt(bikeTime),
                    Double.parseDouble(bikeSpeed), Integer.parseInt(bikePerceivedDifficulty),
                    Double.parseDouble(bikeDistance));

            trainingLog.addWorkout(newBike, workouts);

            displayWorkout(newBike, displayArea);
            displayImage();


        }
    }

    // MODIFIES: this
    // EFFECTS: represents action to be taken when user wants to add a new run workout to the
    // current training log
    private class AddNewRunAction extends AbstractAction {

        AddNewRunAction() {
            super("Add New Run");
        }

        // EFFECTS: achieves effects of the class
        @Override
        public void actionPerformed(ActionEvent e) {
            Run newRun;
            String type = "Run";
            String title = JOptionPane.showInputDialog("Please input a title: ");
            String date = JOptionPane.showInputDialog("Please input the date (ex. October24,2022): ");
            String runHR = JOptionPane.showInputDialog("Please input your average heart rate: ");
            String runTime = JOptionPane.showInputDialog("Please input total time: ");
            String runPaceMins = JOptionPane.showInputDialog("Please input the minutes component of your run speed: ");;
            String runPaceSecs = JOptionPane.showInputDialog("Please input the seconds component of your run speed: ");
            String runPerceivedDifficulty =
                    JOptionPane.showInputDialog("Please rate the difficulty of your workout from 1-10: ");
            String runDistance = JOptionPane.showInputDialog("Please input your distance: ");

            newRun = new Run(type, title, date, Integer.parseInt(runHR), Integer.parseInt(runPaceMins),
                    Integer.parseInt(runPaceSecs), Integer.parseInt(runTime), Integer.parseInt(runPerceivedDifficulty),
                    Double.parseDouble(runDistance));

            trainingLog.addWorkout(newRun, workouts);

            displayWorkout(newRun, displayArea);
            displayImage();

        }
    }


    // EFFECTS: displays the type, title and date of w in the display section of the main window
    private void displayWorkout(Workout w, JInternalFrame frame) {

        String displayString = w.getType() + ": " + w.getName() + " (" + w.getDate() + ")\n";
        JLabel newLabel = new JLabel(displayString);
        frame.add(newLabel);
        frame.pack();
        frame.setVisible(true);


    }

    // EFFECTS: displays image and message after a workout is added
    private void displayImage() {
        JOptionPane.showMessageDialog(desktop, "Thanks for recording a workout!", "Workout Message",
                JOptionPane.INFORMATION_MESSAGE, happyTraining);
    }



    // EFFECTS: displays only workouts with specified type in filterDisplay window
    private class FilterByTypeAction extends AbstractAction {

        FilterByTypeAction() {
            super("Filter Workouts By Type");
        }

        // MODIFIES: filterDisplay
        // EFFECTS: method that achieves the effects of the class
        @Override
        public void actionPerformed(ActionEvent e) {
            filter = new FilterByTypePopUp();
            addFilterButtons();
            controlPanel.add(filter, BorderLayout.EAST);
            controlPanel.pack();
            controlPanel.setVisible(true);
        }
    }

    // EFFECTS: sets up the new frame for filtered workouts
    private void setUpFilterDisplay() {
        desktop.add(filterDisplay);
        filterDisplay.setLayout(new GridLayout(ROWS, 1)); // TODO: how to set this up better?
        filterDisplay.setBounds(200, 200, WIDTH, HEIGHT);
        filterDisplay.setSize(WIDTH, HEIGHT);
        filterDisplay.pack();
        filterDisplay.setVisible(true);

    }

    // MODIFIES: FilterByTypePopUp
    // EFFECTS: adds new buttons with the different filtering options
    private void addFilterButtons() {
        filter.setLayout(new GridLayout(1, 3));
        filter.add(new JButton(new SwimFilterAction()));
        filter.add(new JButton(new BikeFilterAction()));
        filter.add(new JButton(new RunFilterAction()));


    }

    // EFFECTS: creates action that filters workouts in current workouts list by type "Swim"
    private class SwimFilterAction extends AbstractAction {

        SwimFilterAction() {
            super("Filter by Type: Swim");
        }

        // MODIFIES: filterDisplay
        // EFFECTS: filters workouts in current workouts list by type "Swim"
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Workout> swimWorkouts;

            if (trainingLog.getTrainingLog().size() == 0) {
                filterDisplay.add(new JLabel("No workouts added yet."));
                filterDisplay.setVisible(true);
            } else {
                swimWorkouts = trainingLog.getWorkoutsWithType("Swim");
                for (Workout s : swimWorkouts) {
                    displayWorkout(s, filterDisplay);
                    filterDisplay.setVisible(true);
                }
            }
        }
    }


    // EFFECTS: creates action that filters workouts in current workouts list by type "Bike"
    private class BikeFilterAction extends AbstractAction {
        ArrayList<Workout> bikeWorkouts;

        BikeFilterAction() {
            super("Filter By Type: Bike");

        }

        // MODIFIES: filterArea
        // EFFECTS: filters workouts in current workouts list by type "Bike"
        @Override
        public void actionPerformed(ActionEvent e) {
            if (trainingLog.getTrainingLog().size() == 0) {
                filterDisplay.add(new JLabel("No workouts added yet."));
                filterDisplay.setVisible(true);
            } else {
                bikeWorkouts = trainingLog.getWorkoutsWithType("Bike");
                for (Workout b : bikeWorkouts) {
                    displayWorkout(b, filterDisplay);
                    filterDisplay.setVisible(true);
                }
            }
        }
    }



    // EFFECTS: creates action that filters workouts in current workouts list by type "Run"
    private class RunFilterAction extends AbstractAction {
        ArrayList<Workout> runWorkouts;

        RunFilterAction() {
            super("Filter By Type: Run");
        }

        // MODIFIES: filterArea
        // EFFECTS: filters workouts in current workouts list by type "Run"
        @Override
        public void actionPerformed(ActionEvent e) {

            if (trainingLog.getTrainingLog().size() == 0) {
                filterDisplay.add(new JLabel("No workouts added yet."));
                filterDisplay.setVisible(true);
            } else {
                runWorkouts = trainingLog.getWorkoutsWithType("Run");
                for (Workout r : runWorkouts) {
                    displayWorkout(r, filterDisplay);
                    filterDisplay.setVisible(true);
                }
            }
        }
    }


    // EFFECTS: creates action to save the current state of the application
    private class SaveCurrentAction extends AbstractAction {

        SaveCurrentAction() {
            super("Save Current Training Log");
        }

        // EFFECTS: saves the current state of the application (workouts added to the current list of workouts)
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


    // EFFECTS: creates action to load previously saved workouts
    private class LoadPreviousAction extends AbstractAction {
        TrainingLog loadedFromFile;
        ArrayList<Workout> loadedWorkouts;

        LoadPreviousAction() {
            super("Load Previous Training Log");
        }

        // MODIFIES: trainingLog
        // EFFECTS: loads previously saved workouts, adds them to the current list of workouts and displays them
        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                jsonReader = new JsonReader(JSON_STORE);
                loadedFromFile = jsonReader.read();
                System.out.println("Loaded workouts from " + JSON_STORE);
            } catch (IOException exception) {
                System.out.println("Unable to read from file: " + JSON_STORE);
            } finally {
                displayAllLoaded();
            }

        }

        // MODIFIES: displayArea
        // EFFECTS: displays all workouts loaded from file in the displayArea
        private void displayAllLoaded() {
            loadedWorkouts = loadedFromFile.getTrainingLog();
            workouts.addAll(loadedWorkouts);
            for (Workout w : loadedWorkouts) {
                displayWorkout(w, displayArea);


            }
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

