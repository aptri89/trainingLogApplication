package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TrainingLogTest {

    private TrainingLog testTrainingLog;
    private ArrayList<Workout> listOfWorkoutsForLog = new ArrayList<Workout>();
    private Swim testSwimWorkout = new Swim("Swim", "TestSwim", "October15,2022", 123,
            51, 120, 4, 2.3);
    private Bike testBikeWorkout = new Bike ("Bike", "TestBike", "October17,2022", 145,
            120, 25, 8, 78);
    private Run testRunWorkout = new Run ("Run", "SpeedWork", "October24,2022", 156, 4,
            34, 46, 9, 10);
    private ArrayList<Workout> listOfWorkoutsForLogContainingTestTitle;

    @BeforeEach
    void runBefore() {
        testTrainingLog = new TrainingLog("October17-23,2022", listOfWorkoutsForLog);
        listOfWorkoutsForLog.add(testSwimWorkout);
        listOfWorkoutsForLog.add(testBikeWorkout);
        listOfWorkoutsForLog.add(testRunWorkout);
        EventLog.getInstance().clear();
    }

    @Test
    public void testTrainingLogConstructor() {
        assertEquals("October17-23,2022", testTrainingLog.getTitle());
        assertEquals(listOfWorkoutsForLog, testTrainingLog.getTrainingLog());

    }

    @Test
    public void testAddWorkout() {
        testTrainingLog.trainingLog.remove(0);
        testTrainingLog.trainingLog.remove(0);
        testTrainingLog.trainingLog.remove(0);
        testTrainingLog.addWorkout(testSwimWorkout, listOfWorkoutsForLog);
        assertEquals(1, listOfWorkoutsForLog.size());
        assertEquals(testSwimWorkout, listOfWorkoutsForLog.get(0));

    }

    @Test
    public void testAddWorkoutMultipleTimes() {
        testTrainingLog.addWorkout(testSwimWorkout, listOfWorkoutsForLog);
        testTrainingLog.addWorkout(testBikeWorkout, listOfWorkoutsForLog);
        testTrainingLog.addWorkout(testRunWorkout, listOfWorkoutsForLog);
        assertEquals(6, listOfWorkoutsForLog.size());
        assertEquals(testSwimWorkout, listOfWorkoutsForLog.get(0));
        assertEquals(testBikeWorkout, listOfWorkoutsForLog.get(1));
        assertEquals(testRunWorkout, listOfWorkoutsForLog.get(2));
    }


    @Test
    public void testGetWorkoutsContainingTitle() {
        String title = "Test";
        assertEquals(2, testTrainingLog.workoutsContainingTitle(title, listOfWorkoutsForLog).size());
        assertEquals(testSwimWorkout, testTrainingLog.workoutsContainingTitle(title, listOfWorkoutsForLog).get(0));
        assertEquals(testBikeWorkout, testTrainingLog.workoutsContainingTitle(title, listOfWorkoutsForLog).get(1));


    }

    @Test
    public void testEventMessageForFilter() {
        testTrainingLog.getWorkoutsWithType("Swim");
        int index = 0;
        for (Event e : EventLog.getInstance()) {
            index += 1;
            if (index == 2) {
                assertEquals("Filtered workouts by: Swim.", e.getDescription());
            }
        }

    }

    @Test
    public void testEventMessageForAddWorkout() {
        testTrainingLog.addWorkout(testSwimWorkout, testTrainingLog.getTrainingLog());
        int index = 0;
        for (Event e : EventLog.getInstance()) {
            index += 1;
            if (index == 2) {
                assertEquals("Swim workout added to training log!", e.getDescription());
            }
        }
    }

    @Test
    public void testEventMessageForSavingLog() {
        testTrainingLog.toJson();
        int index = 0;
        for (Event e : EventLog.getInstance()) {
            index += 1;
            if (index == 2) {
                assertEquals("Saved training log: October17-23,2022 to file.", e.getDescription());
            }
        }
    }

    // TODO: ask about this test (getting the correct title)
    @Test
    public void testEventMessageForLoadingLog() {
        JsonReader reader = new JsonReader("./data/trainingLog.json");
        JsonWriter writer = new JsonWriter("./data/trainingLog.json");
        try {
            writer.open();
            writer.write(testTrainingLog);
            writer.close();
            System.out.println("Saved " + testTrainingLog.getTitle() + " to " + "./data/trainingLog.json");
            reader.read();
            System.out.println("Loaded " + testTrainingLog.getTitle() + " from " + "./data/trainingLog.json");
            int index = 0;
            for (Event e : EventLog.getInstance()) {
                index += 1;
                if (index == 3) {
                    assertEquals("Loaded training log: " + testTrainingLog.getTitle() + " from file.",
                            e.getDescription());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not save to file.");
        } catch (IOException e) {
            System.out.println("Could not read from file.");
        }
    }





}
