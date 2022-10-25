package model;
// citation needed

import org.json.JSONObject;

// represents a swim workout object with data about the workout
public class Swim extends Workout {

    private int avgSwimPace;             // average pace per 100m in seconds (swim only)

    // REQUIRES: swimName is not an empty string, todaysDate is not an empty string, swimHR > 0, swimTime > 0
    //           swimPace > 0, swimPerceivedDifficulty is between 1 and 10, swimDistance > 0
    // EFFECTS: creates new swim object with given parameters
    public Swim(String swimName, String todaysDate, int swimHR, int swimTime,
                int swimPace, int swimPerceivedDifficulty, double swimDistance) {

        super(swimName, todaysDate, swimHR, swimTime, swimPerceivedDifficulty, swimDistance);
        this.avgSwimPace = swimPace;
    }

    public String convertSwimPaceToMinsAndSecs(int avgSwimPace) {
        int swimMins = avgSwimPace / 60;
        int swimSecs = avgSwimPace - (swimMins * 60);

        return (swimMins + ":" + swimSecs);
    }


    public void changeSwimPace(int newSwimPace) {
        this.avgSwimPace = newSwimPace;

    }

    public int getAvgSwimPace() {
        return this.avgSwimPace;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("swimPace", avgSwimPace);
        return json;
    }






}


