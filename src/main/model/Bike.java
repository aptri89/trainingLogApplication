package model;

import org.json.JSONObject;

public class Bike extends Workout {

    private double avgBikeSpeed;            // average speed in kilometers per hour (integer values only)


    // REQUIRES: bikeName is not an empty string, todaysDate is not an empty string, bikeHR > 0, bikeTime > 0
    //           bikeSpeed > 0, bikePerceivedDifficulty is between 1 and 10, bikeDistance > 0
    // EFFECTS: creates new bike object with given parameters
    public Bike(String type, String bikeName, String todaysDate, int bikeHR, int bikeTime, double bikeSpeed,
                int bikePerceivedDifficulty, double bikeDistance) {

        super("Bike", bikeName, todaysDate, bikeHR, bikeTime, bikePerceivedDifficulty, bikeDistance);
        this.avgBikeSpeed = bikeSpeed;

    }

    // REQUIRES: newBikeSpeed > 0
    // EFFECTS: changes average bike speed to new bike speed
    public void changeBikeSpeed(int newBikeSpeed) {
        this.avgBikeSpeed = newBikeSpeed;
    }

    // EFFECTS: returns average bike speed
    public double getAvgBikeSpeed() {
        return this.avgBikeSpeed;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        json.put("avgBikeSpeed", avgBikeSpeed);
        json.put("avgSwimPace", 0);
        json.put("avgRunPaceMins", 0);
        json.put("avgRunPaceSecs", 0);
        return json;
    }






}

