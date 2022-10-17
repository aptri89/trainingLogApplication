package ui;

import model.*;

import java.util.ArrayList;
import java.util.Scanner;

// application for tracking workouts

public class TrainingLogApp {
    private Scanner input;
    private TrainingLog defaultLog;
    private ArrayList<Workout> defaultList = new ArrayList<Workout>();
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
        } else {
            System.out.print("\nSelection not valid ...");
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

    // MODIFIES: this
    // EFFECTS: determines next program step using user input
    private void processCommand2(String command) {
        if (command.equals("y")) {
            int size = defaultList.size();
            Workout currentWorkout = defaultList.get(size - 1);
            System.out.print("\nChoose one of the following options to change: ");
            System.out.print("\nTitle -> t\nDate -> d\nDistance -> k");
            if (input.next().equals("t")) {
                System.out.print("\nEnter new title: ");
                currentWorkout.changeTitle(input.next());
            } else if (input.next().equals("d")) {
                System.out.print("\nEnter new date: ");
                currentWorkout.changeDate(input.next());
            } else if (input.next().equals("k")) {
                System.out.print("\nEnter new distance: ");
                currentWorkout.changeDistance(input.nextInt());
            }
        } else if (command.equals("n")) {
            System.out.print("\nWould you like to view the workouts in your current training log? ");
            System.out.print("\ny -> yes");
            System.out.print("\nn -> no, I would like to return to the home screen");
        } else {
            System.out.print("\nSelection is invalid, returning to home screen...");
        }
    }

    // EFFECTS: displays secondary screen with user options
    private void secondScreen() {
        System.out.print("\nWould you like to edit any data for your workout?");
        System.out.print("\ny -> yes");
        System.out.print("\nn -> no");


    }

    // MODIFIES: this
    // EFFECTS: determines next program step using user input
    private void processCommand3(String command) {
        if (command.equals("y")) {
            for (Workout w: defaultList) {
                System.out.print(w.getDate() + "->" + w.getTitle());
            }
        } else {
            System.out.print("\nReturning to home screen ...");
        }

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
        System.out.print("\nEnter workout data for the following categories: \nTitle for swim workout: ");
        String name = input.next();
        System.out.print("\nDate of swim workout: ");
        String date = input.next();
        System.out.print("\nAverage swim heart rate: ");
        int swimHR = input.nextInt();
        System.out.print("\nTotal time spent swimming: ");
        int swimTime = input.nextInt();
        System.out.print("\nTotal distance swam in kilometers: ");
        double swimDistance = input.nextDouble();
        System.out.print("\nAverage pace per 100m in seconds: ");
        int avgSwimPace = input.nextInt();
        System.out.print("\nOn a scale of 1-10, how difficult was that swim? ");
        int swimPerceivedDifficulty = input.nextInt();

        Swim newSwim = new Swim(name, date, swimHR, swimTime, avgSwimPace, swimPerceivedDifficulty, swimDistance);

        System.out.print("\nWould you like to create a new training log to add this workout to?\ny -> yes\nn -> no");

        if (input.next().equals("y")) {
            createTrainingLog(newSwim);
        } else if (input.next().equals("n")) {
            defaultLog.addWorkout(newSwim, defaultList);
        } else {
            System.out.print("Selection not valid...");
        }
    }


    // MODIFIES: this
    // EFFECTS: creates a Bike object based on user input and adds to selected training log
    private void createBike() {
        System.out.print("Enter workout data for the following categories: \nTitle for bike workout: ");
        String name = input.next();
        System.out.print("\nDate of bike workout: ");
        String date = input.next();
        System.out.print("\nAverage bike heart rate: ");
        int bikeHR = input.nextInt();
        System.out.print("\nTotal time spent biking: ");
        int bikeTime = input.nextInt();
        System.out.print("\nTotal distance biked in kilometers: ");
        double bikeDistance = input.nextDouble();
        System.out.print("\nAverage speed in kilometers an hour: ");
        int avgBikeSpeed = input.nextInt();
        System.out.print("\nOn a scale of 1-10, how difficult was that bike? ");
        int bikePerceivedDifficulty = input.nextInt();

        Bike newBike = new Bike(name, date, bikeHR, bikeTime, avgBikeSpeed,bikePerceivedDifficulty, bikeDistance);

        System.out.println("Would you like to create a new training log to add this workout to?\ny -> yes\nn -> no");

        if (input.next().equals("y")) {
            createTrainingLog(newBike);
        } else if (input.next().equals("n")) {
            defaultLog.addWorkout(newBike, defaultList);
        } else {
            System.out.print("Selection not valid...");
        }
    }


    // MODIFIES: this
    // EFFECTS: creates a Run object based on user input and adds to selected training log
    private void createRun() {
        System.out.print("Enter workout data for the following categories: \nTitle for run workout: ");
        String name = input.next();
        System.out.print("\nDate of run workout: ");
        String date = input.next();
        System.out.print("\nAverage run heart rate: ");
        int runHR = input.nextInt();
        System.out.print("\nTotal time spent running: ");
        int runTime = input.nextInt();
        System.out.print("\nTotal distance ran in kilometers (up to 2 decimal points): ");
        double runDistance = input.nextDouble();
        System.out.print("\nAverage run pace per kilometer (minutes component): ");
        int avgRunPaceMins = input.nextInt();
        System.out.print("\nAverage run pace per kilometer (seconds component): ");
        int avgRunPaceSecs = input.nextInt();
        System.out.print("\nOn a scale of 1-10, how difficult was that run? ");
        int runPD = input.nextInt();

        Run newRun = new Run(name, date, runHR, avgRunPaceMins, avgRunPaceSecs, runTime, runPD, runDistance);

        System.out.print("\nWould you like to create a new training log to add this workout to?\ny -> yes\nn -> no\n");

        if (input.next().equals("y")) {
            createTrainingLog(newRun);
        } else if (input.next().equals("n")) {
            defaultLog.addWorkout(newRun, defaultList);
        }
    }



    // MODIFIES: this
    // EFFECTS: creates a TrainingLog object based on user input
    private void createTrainingLog(Workout w) {
        ArrayList<Workout> listOfWorkoutsForLog = new ArrayList<Workout>();
        listOfWorkoutsForLog.add(w);
        System.out.print("What would you like to name this training log?\n");
        String title = input.next();
        TrainingLog tlObject = new TrainingLog(title, listOfWorkoutsForLog);
        defaultLog = tlObject;
        defaultList = tlObject.getTrainingLog();

    }








}
