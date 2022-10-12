package model;

public class Run implements Workout {

    private String type;                 // workout type (one of swim, bike, run or lifting)
    private String date;                 // date of workout
    private int avgHeartRate;            // average heart rate
    private int avgRunPaceMins;          // average run pace minutes component
    private int avgRunPaceSecs;          // average run pace seconds component
    private int totalTime;               // time spent exercising in the workout
    private int perceivedDifficulty;     // on a scale of 1-10 where 10 is maximum effort
    private int distance;                // distance covered in kilometers
    private int trainingLoadValue;       // calculated by (totalTime * perceivedDifficulty), these values are
                                         // typically added together for a list of workouts to look at overall load


    public Run(String todaysDate, int runHR, int runPaceMins, int runPaceSecs, int runTime,
               int runPerceivedDifficulty, int runDistance, int runLoadValue) {

        this.date = todaysDate;
        this.avgHeartRate = runHR;
        this.avgRunPaceMins = runPaceMins;
        this.avgRunPaceSecs = runPaceSecs;
        this.totalTime = runTime;
        this.perceivedDifficulty = runPerceivedDifficulty;
        this.distance = runDistance;

    }

    @Override
    public int calcTrainingLoadValue(int perceivedDifficulty, int totalTime) {
        return 0;
    }

    @Override
    public void changeHeartRate(int newHeartRate) {

    }

    @Override
    public void changeDate(String newDate) {

    }

    @Override
    public void changeTotalTime(int newTotalTime) {

    }

    @Override
    public void changePerceivedDifficulty(int newPerceivedDifficulty) {

    }

    @Override
    public void changeDistance(int newDistance) {

    }

    @Override
    public int getTrainingLoadValue() {
        return 0;
    }

    @Override
    public int getHeartRate() {
        return 0;
    }

    @Override
    public int getDate() {
        return 0;
    }

    @Override
    public int getTotalTime() {
        return 0;
    }

    @Override
    public int getPerceivedDifficulty() {
        return 0;
    }

    @Override
    public int getDistance() {
        return 0;
    }
}
