package model;

public class Bike implements Workout {

    private String date;                 // date of workout
    private int avgHeartRate;            // average heart rate
    private int avgBikeSpeed;            // average speed in kilometers per hour (bike only)
    private int totalTime;               // time spent exercising in the workout
    private int perceivedDifficulty;     // on a scale of 1-10 where 10 is maximum effort
    private int distance;                // distance covered in kilometers
    private int trainingLoadValue;       // calculated by (totalTime * perceivedDifficulty), these values are
                                         // typically added together for a list of workouts to look at overall load

    public Bike(String todaysDate, int bikeHR, int bikeSpeed, int bikeTime,
                int bikePerceivedDifficulty, int bikeDistance) {

        this.date = todaysDate;
        this.avgHeartRate = bikeHR;
        this.avgBikeSpeed = bikeSpeed;
        this.totalTime = bikeTime;
        this.perceivedDifficulty = bikePerceivedDifficulty;
        this.distance = bikeDistance;

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
