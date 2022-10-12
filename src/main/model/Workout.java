package model;

public interface Workout {

    public int calcTrainingLoadValue(int perceivedDifficulty, int totalTime);
    public void changeHeartRate(int newHeartRate);
    public void changeDate(String newDate);
    public void changeTotalTime(int newTotalTime);
    public void changePerceivedDifficulty(int newPerceivedDifficulty);
    public void changeDistance(int newDistance);

    public int getTrainingLoadValue();
    public int getHeartRate();
    public int getDate();
    public int getTotalTime();
    public int getPerceivedDifficulty();
    public int getDistance();


}

