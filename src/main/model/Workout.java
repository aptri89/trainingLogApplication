package model;

public class Workout {

    private String name;                 // name of workout with no spaces
    private String date;                 // date of workout with no spaces
    private int avgHeartRate;            // average heart rate
    private int totalTime;               // time spent exercising in the workout (in minutes)
    private int perceivedDifficulty;     // on a scale of 1-10 where 10 is maximum effort
    private double distance;             // distance covered in kilometers
    private int trainingLoadValue;       // calculated by (totalTime * perceivedDifficulty), these values are
                                         // typically added together for a list of workouts to look at overall load

    public Workout(String workoutName, String workoutDate, int workoutAvgHeartRate,
                   int workoutTotalTime, int workoutPerceivedDifficulty, double workoutDistance) {

        this.name = workoutName;
        this.date = workoutDate;
        this.avgHeartRate = workoutAvgHeartRate;
        this.totalTime = workoutTotalTime;
        this.perceivedDifficulty = workoutPerceivedDifficulty;
        this.distance = workoutDistance;
        this.trainingLoadValue = calcTrainingLoadValue(this.perceivedDifficulty, this.totalTime);

    }


    public int calcTrainingLoadValue(int perceivedDifficulty, int totalTime) {
        return (perceivedDifficulty * totalTime);

    }

    public void changeTitle(String newTitle) {
        this.name = newTitle;
    }


    public void changeDate(String newDate) {
        this.date = newDate;

    }


    public void changeDistance(double newDistance) {
        this.distance = newDistance;

    }

    public String getTitle() {
        return this.name;
    }


    public int getTrainingLoadValue() {
        return this.trainingLoadValue;

    }

    public int getHeartRate() {
        return this.avgHeartRate;

    }

    public String getDate() {
        return this.date;

    }

    public int getTotalTime() {
        return this.totalTime;

    }

    public int getPerceivedDifficulty() {
        return this.perceivedDifficulty;

    }

    public double getDistance() {
        return this.distance;

    }


}

