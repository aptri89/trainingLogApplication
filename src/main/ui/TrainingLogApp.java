package ui;

import model.TrainingLog;
import model.Workout;

import java.util.ArrayList;
import java.util.Scanner;

// application for tracking workouts

public class TrainingLogApp {
    private Scanner input;
    private TrainingLog defaultLog;
    private ArrayList<Workout> defaultList;



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
            }
        }

        System.out.println("\nHappy training!");
    }


    // MODIFIES: this
    // EFFECTS: determines next program step using user input
    private void processCommand(String command) {


    }

    private void homeScreen() {
        System.out.println("\nWelcome! \nWhat kind of workout would you like to record?");
        System.out.println("\ns -> Swim");
        System.out.println("\nb -> Bike");
        System.out.println("\nr -> Run");
        System.out.println("\nq -> Quit");

    }

    private void initDefault() {
        defaultLog = new TrainingLog("Default Training Log", defaultList);
        input = new Scanner(System.in);
    }

    private void createSwim() {

    }

    private void createBike() {

    }

    private void createRun() {

    }

    private void createTrainingLog() {

    }





}
