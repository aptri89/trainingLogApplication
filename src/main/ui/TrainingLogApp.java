package ui;

import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// application for tracking workouts
// TODO: additional functionality to change all workout parameters
public class TrainingLogApp {
    private static final String JSON_STORE = "./data/trainingLog.json";
    private Scanner input;
    private TrainingLog defaultLog;
    private ArrayList<Workout> defaultList = new ArrayList<Workout>();
    private Workout defaultWorkout = new Workout("null", "null", "null",
            0, 0, 0, 0);
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;



    //EFFECTS: runs the workout tracking application
    public TrainingLogApp() throws FileNotFoundException {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runTrainingLog();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runTrainingLog() {
        boolean keepGoing = true;
        String command;

        initDefault();

        while (keepGoing) {
            homeScreen();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;

            } else {
                processCommand(command);
                secondScreen();
                command = input.next();
                command = command.toLowerCase();
                processCommand2(command);
                thirdScreen();
                command = input.next();
                command = command.toLowerCase();
                processCommand3(command);
            }
        }
        System.out.print("\nHappy training!");
    }


    // MODIFIES: this
    // EFFECTS: determines next program step using user input
    private void processCommand(String command) {
        if (command.equals("s")) {
            createSwim();
        } else if (command.equals("b")) {
            createBike();
        } else if (command.equals("r")) {
            createRun();
        } else if (command.equals("t")) {
            createTrainingLog(defaultWorkout);
        }

    }

    // EFFECTS: displays home screen with user options
    private void homeScreen() {
        System.out.print("\nWelcome! \nWhat kind of workout would you like to record?");
        System.out.print("\ns -> Swim");
        System.out.print("\nb -> Bike");
        System.out.print("\nr -> Run");
        System.out.print("\nq -> Quit\n");

    }


    private void addWorkoutToATrainingLog(Workout w, String yesOrNo) {
        if (yesOrNo.equals("y")) {
            createTrainingLog(w);
        } else if (yesOrNo.equals("n")) {
            defaultLog.addWorkout(w, defaultList);
        } else {
            System.out.print("Selection not valid...");
        }
    }

    // MODIFIES: this
    // EFFECTS: determines next program step using user input
    private void processCommand2(String command) {
        if (command.equals("y")) {
            int size = defaultList.size();
            Workout currentWorkout = defaultList.get(size - 1);
            System.out.print("\nChoose one of these options to change: \nTitle -> t\nDate -> d\nDistance -> k\n");
            String thisInput = input.next();
            if (thisInput.equals("t")) {
                System.out.print("\nEnter new title: ");
                currentWorkout.changeTitle(input.next());
            } else if (thisInput.equals("d")) {
                System.out.print("\nEnter new date: ");
                currentWorkout.changeDate(input.next());
            } else if (thisInput.equals("k")) {
                System.out.print("\nEnter new distance: ");
                currentWorkout.changeDistance(input.nextDouble());
            }
        } else if (command.equals("n")) {
            System.out.print("No data changed");
        }
    }

    // EFFECTS: displays secondary screen with user options
    private void secondScreen() {
        System.out.print("\nWould you like to edit any data for your workout?");
        System.out.print("\ny -> yes");
        System.out.print("\nn -> no\n");


    }

    // MODIFIES: this
    // EFFECTS: determines next program step using user input
    private void processCommand3(String command) {
        if (command.equals("v")) {
            viewWorkouts();
        } else if (command.equals("s")) {
            searchWorkouts();
        } else if (command.equals("d")) {
            saveTrainingLog();
        } else if (command.equals("l")) {
            loadTrainingLog();
        } else {
            System.out.print("\nReturning to home screen ...");
        }

    }

    private void viewWorkouts() {
        for (Workout w: defaultList) {
            System.out.print("\n" + w.getDate() + "->" + w.getName() + "\n");
        }
        System.out.print("\nPress v to view workouts again, s to search workouts or r for the home screen");
        String thisInput = input.next();
        processCommand3(thisInput);
    }

    private void searchWorkouts() {
        System.out.print("\nEnter search term to search workout titles: \n");
        String title = input.next();
        ArrayList<Workout> tempList = new ArrayList<>();
        tempList = TrainingLog.workoutsContainingTitle(title, defaultList);
        System.out.print("\nAll workouts containing search term shown below: \n");

        for (Workout w: tempList) {
            System.out.print(w.getDate() + "->" + w.getName() + "\n");
        }
        System.out.print("\nPress s to search workouts again, v to view workouts or r for the home screen\n");
        String thisInput = input.next();
        processCommand3(thisInput);
    }

    private void thirdScreen() {
        System.out.print("\nOther options are presented below:");
        System.out.print("\nv -> view my workouts");
        System.out.print("\ns -> search my workouts");
        System.out.print("\nd -> save my training log to file");
        System.out.print("\nl -> load my training log from file");
        System.out.print("\nr -> return to home screen\n");
    }


    // MODIFIES: this
    // EFFECTS: initializes a default training log that workouts will be added to
    private void initDefault() {
        defaultLog = new TrainingLog("Default Training Log", defaultList);
        input = new Scanner(System.in);
    }


    // MODIFIES: this
    // EFFECTS: creates a Swim object based on user input and adds to selected training log
    private void createSwim() {
        System.out.print("\nEnter workout data for the following categories: \nTitle for swim workout (no spaces): ");
        String name = input.next();
        System.out.print("\nDate of swim workout (example of proper format: October22,2022): ");
        String date = input.next();
        System.out.print("\nAverage swim heart rate: ");
        int swimHR = input.nextInt();
        System.out.print("\nTotal time spent swimming (mins): ");
        int swimTime = input.nextInt();
        System.out.print("\nAverage pace per 100m in seconds: ");
        int avgSwimPace = input.nextInt();
        System.out.print("\nOn a scale of 1-10, how difficult was that swim? ");
        int swimPerceivedDifficulty = input.nextInt();
        System.out.print("\nTotal distance swam in kilometers: ");
        double swimDistance = input.nextDouble();

        Swim newSwim =
                new Swim("Swim", name, date, swimHR, swimTime, avgSwimPace, swimPerceivedDifficulty, swimDistance);

        System.out.print("\nWould you like to create a new training log to add this workout to?\ny -> yes\nn -> no");
        String yesOrNo = input.next();

        addWorkoutToATrainingLog(newSwim, yesOrNo);

    }


    // MODIFIES: this
    // EFFECTS: creates a Bike object based on user input and adds to selected training log
    private void createBike() {
        System.out.print("Enter workout data for the following categories: \nTitle for bike workout (no spaces): ");
        String name = input.next();
        System.out.print("\nDate of bike workout (example of proper format: October22,2022): ");
        String date = input.next();
        System.out.print("\nAverage bike heart rate: ");
        int bikeHR = input.nextInt();
        System.out.print("\nTotal time spent biking (mins): ");
        int bikeTime = input.nextInt();
        System.out.print("\nAverage speed in kilometers an hour: ");
        double avgBikeSpeed = input.nextDouble();
        System.out.print("\nOn a scale of 1-10, how difficult was that bike? ");
        int bikePerceivedDifficulty = input.nextInt();
        System.out.print("\nTotal distance biked in kilometers: ");
        double bikeDistance = input.nextDouble();

        Bike newBike =
                new Bike("Bike", name, date, bikeHR, bikeTime, avgBikeSpeed,bikePerceivedDifficulty, bikeDistance);

        System.out.println("Would you like to create a new training log to add this workout to?\ny -> yes\nn -> no");
        String yesOrNo = input.next();

        addWorkoutToATrainingLog(newBike, yesOrNo);
    }


    // MODIFIES: this
    // EFFECTS: creates a Run object based on user input and adds to selected training log
    private void createRun() {
        System.out.print("Enter workout data for the following categories: \nTitle for run workout (no spaces): ");
        String name = input.next();
        System.out.print("\nDate of run workout (example of proper format: October22,2022): ");
        String date = input.next();
        System.out.print("\nAverage run heart rate: ");
        int runHR = input.nextInt();
        System.out.print("\nAverage run pace per kilometer (minutes component): ");
        int avgRunPaceMins = input.nextInt();
        System.out.print("\nAverage run pace per kilometer (seconds component): ");
        int avgRunPaceSecs = input.nextInt();
        System.out.print("\nTotal time spent running (mins): ");
        int runTime = input.nextInt();
        System.out.print("\nOn a scale of 1-10, how difficult was that run? ");
        int runPD = input.nextInt();
        System.out.print("\nTotal distance ran in kilometers (up to 2 decimal points): ");
        double runDistance = input.nextDouble();

        Run newRun = new Run("Run", name, date, runHR, avgRunPaceMins, avgRunPaceSecs, runTime, runPD, runDistance);

        System.out.print("\nWould you like to create a new training log to add this workout to?\ny -> yes\nn -> no\n");
        String yesOrNo = input.next();

        addWorkoutToATrainingLog(newRun, yesOrNo);

    }



    // MODIFIES: this
    // EFFECTS: creates a TrainingLog object based on user input
    private void createTrainingLog(Workout w) {
        ArrayList<Workout> listOfWorkoutsForLog = new ArrayList<Workout>();
        listOfWorkoutsForLog.add(w);
        System.out.print("What would you like to name this training log? (no spaces)\n");
        String title = input.next();
        TrainingLog tlObject = new TrainingLog(title, listOfWorkoutsForLog);
        defaultLog = tlObject;
        defaultList = tlObject.getTrainingLog();

    }

    // EFFECTS: saves the training log to file
    private void saveTrainingLog() {
        try {
            jsonWriter.open();
            jsonWriter.write(defaultLog);
            jsonWriter.close();
            System.out.println("Saved " + defaultLog.getTitle() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }

    }

    // MODIFIES: this
    // EFFECTS: loads training log from file
    private void loadTrainingLog() {
        try {
            defaultLog = jsonReader.read();
            System.out.println("Loaded " + defaultLog.getTitle() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }


}
