package model;

import org.json.JSONObject;
import persistence.Writable;

public class Workout implements Writable {

    private String type;                  // type of workout (Swim, Bike or Run)
    private String name;                 // name of workout with no spaces
    private String date;                 // date of workout with no spaces
    private int avgHeartRate;            // average heart rate
    private int totalTime;               // time spent exercising in the workout (in minutes)
    private int perceivedDifficulty;     // on a scale of 1-10 where 10 is maximum effort
    private double distance;             // distance covered in kilometers
    private int trainingLoadValue;       // calculated by (totalTime * perceivedDifficulty), these values are
                                         // typically added together for a list of workouts to look at overall load

    public Workout(String workoutType, String workoutName, String workoutDate, int workoutAvgHeartRate,
                   int workoutTotalTime, int workoutPerceivedDifficulty, double workoutDistance) {

        this.type = workoutType;
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

    public String getName() {
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

    public String getType() {
        return this.type;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("date", date);
        json.put("avgHeartRate", avgHeartRate);
        json.put("totalTime", totalTime);
        json.put("perceivedDifficulty", perceivedDifficulty);
        json.put("distance", distance);
        json.put("trainingLoadValue", trainingLoadValue);
        if (type == "Swim") {
            json.put("avgSwimPace", Swim.getAvgSwimPace());
        } else if (type == "Bike") {
            json.put("avgBikeSpeed", Bike.getAvgBikeSpeed());
        } else if (type == "Run") {
            json.put("avgRunPaceMins", Run.getAvgRunPaceMins());
            json.put("avgRunPaceSecs", Run.getAvgRunPaceSecs());
        }
        return json;
    }



}

