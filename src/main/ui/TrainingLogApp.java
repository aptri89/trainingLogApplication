package ui;

import model.*;

import java.util.ArrayList;
import java.util.Scanner;

// application for tracking workouts

public class TrainingLogApp {
    private Scanner input;
    private TrainingLog defaultLog;
    private ArrayList<Workout> defaultList;
    private Workout defaultWorkout = new Workout("null", "null", 0,
            0, 0, 0);



    //EFFECTS: runs the workout tracking application
    public TrainingLogApp() {
        runTrainingLog();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runTrainingLog() {
        boolean keepGoing = true;
        String command = null;

        initDefault();

        while (keepGoing) {
            homeScreen();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;

            } else {
                processCommand(command);
                secondaryScreen();
                processCommand2();
            }
        }

        System.out.println("\nHappy training!");
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
        } else {
            System.out.println("Selection not valid ...");
        }

    }

    // EFFECTS: displays home screen with user options
    private void homeScreen() {
        System.out.println("\nWelcome! \nWhat kind of workout would you like to record?");
        System.out.println("\ns -> Swim");
        System.out.println("\nb -> Bike");
        System.out.println("\nr -> Run");
        System.out.println("\nq -> Quit");

    }

    private void processCommand2() {
    }

    private void secondaryScreen() {
        System.out.println("\nWould you like to edit any data for your workout?");
        System.out.println("\ny -> yes");
        System.out.println("\nn -> no");


    }


    // MODIFIES: this
    // EFFECTS: initializes a default training log that workouts will be added to
    private void initDefault() {
        defaultLog = new TrainingLog("Default Training Log", defaultList);
        input = new Scanner(System.in);
    }

    // MODIFIES: this
    // EFFECTS: creates a swim object based on user input and adds to selected training log
    private void createSwim() {
        System.out.println("Enter workout data for the following categories: \nTitle for swim workout: ");
        String name = input.next();
        System.out.println("\nDate of swim workout: ");
        String date = input.next();
        System.out.println("\nAverage swim heart rate: ");
        int swimHR = input.nextInt();
        System.out.println("\nTotal time spent swimming: ");
        int swimTime = input.nextInt();
        System.out.println("Total distance swam in kilometers: ");
        double swimDistance = input.nextDouble();
        System.out.println("Average pace per 100m in seconds: ");
        int avgSwimPace = input.nextInt();
        System.out.println("\nOn a scale of 1-10, how difficult was that swim? ");
        int swimPerceivedDifficulty = input.nextInt();

        Swim newSwim = new Swim(name, date, swimHR, swimTime, avgSwimPace, swimPerceivedDifficulty, swimDistance);

        System.out.println("Would you like to create a new training log to add this workout to?\ny -> yes\nn -> no");

        if (input.next().equals("y")) {
            createTrainingLog(newSwim);
        } else if (input.next().equals("n")) {
            defaultLog.addWorkout(newSwim, defaultList);
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // MODIFIES: this
    // EFFECTS: creates a bike object based on user input and adds to selected training log
    private void createBike() {
        System.out.println("Enter workout data for the following categories: \nTitle for bike workout: ");
        String name = input.next();
        System.out.println("\nDate of bike workout: ");
        String date = input.next();
        System.out.println("\nAverage bike heart rate: ");
        int bikeHR = input.nextInt();
        System.out.println("\nTotal time spent biking: ");
        int bikeTime = input.nextInt();
        System.out.println("Total distance biked in kilometers: ");
        double bikeDistance = input.nextDouble();
        System.out.println("Average speed in kilometers an hour: ");
        int avgBikeSpeed = input.nextInt();
        System.out.println("\nOn a scale of 1-10, how difficult was that bike? ");
        int bikePerceivedDifficulty = input.nextInt();

        Bike newBike = new Bike(name, date, bikeHR, bikeTime, avgBikeSpeed,bikePerceivedDifficulty, bikeDistance);

        System.out.println("Would you like to create a new training log to add this workout to?\ny -> yes\nn -> no");

        if (input.next().equals("y")) {
            createTrainingLog(newBike);
        } else if (input.next().equals("n")) {
            defaultLog.addWorkout(newBike, defaultList);
        } else {
            System.out.println("Selection not valid...");
        }
    }


    // MODIFIES: this
    // EFFECTS: creates a run object based on user input and adds to selected training log
    private void createRun() {
        System.out.println("Enter workout data for the following categories: \nTitle for run workout: ");
        String name = input.next();
        System.out.println("\nDate of run workout: ");
        String date = input.next();
        System.out.println("\nAverage run heart rate: ");
        int runHR = input.nextInt();
        System.out.println("\nTotal time spent running: ");
        int runTime = input.nextInt();
        System.out.println("Total distance ran in kilometers (up to 2 decimal points): ");
        double runDistance = input.nextDouble();
        System.out.println("Average run pace per kilometer (minutes component): ");
        int avgRunPaceMins = input.nextInt();
        System.out.println("Average run pace per kilometer (seconds component): ");
        int avgRunPaceSecs = input.nextInt();
        System.out.println("\nOn a scale of 1-10, how difficult was that run? ");
        int runPD = input.nextInt();

        Run newRun = new Run(name, date, runHR, avgRunPaceMins, avgRunPaceSecs, runTime, runPD, runDistance);

        System.out.println("Would you like to create a new training log to add this workout to?\ny -> yes\nn -> no");

        if (input.next().equals("y")) {
            createTrainingLog(newRun);
        } else if (input.next().equals("n")) {
            defaultLog.addWorkout(newRun, defaultList);
        }
    }



    private void createTrainingLog(Workout w) {
        ArrayList<Workout> listOfWorkoutsForLog = new ArrayList<Workout>();
        listOfWorkoutsForLog.add(w);
        System.out.println("What would you like to name this training log?");
        String title = input.next();
        TrainingLog tlObject = new TrainingLog(title, listOfWorkoutsForLog);

    }








}
