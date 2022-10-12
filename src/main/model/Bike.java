package model;

public class Bike extends Workout {

    private int avgBikeSpeed;            // average speed in kilometers per hour (integer values only)


    // REQUIRES: bikeName is not an empty string, todaysDate is not an empty string, bikeHR > 0, bikeTime > 0
    //           bikeSpeed > 0, bikePerceivedDifficulty is between 1 and 10, bikeDistance > 0
    // EFFECTS: creates new bike object with given parameters
    public Bike(String bikeName, String todaysDate, int bikeHR, int bikeTime, int bikeSpeed,
                int bikePerceivedDifficulty, int bikeDistance) {

        super(bikeName, todaysDate, bikeHR, bikeTime, bikePerceivedDifficulty, bikeDistance);
        this.avgBikeSpeed = bikeSpeed;

    }

    // REQUIRES: newBikeSpeed > 0
    // EFFECTS: changes average bike speed to new bike speed
    public void changeBikeSpeed(int newBikeSpeed) {
        this.avgBikeSpeed = newBikeSpeed;
    }

    // EFFECTS: returns average bike speed
    public int getAvgBikeSpeed() {
        return this.avgBikeSpeed;
    }





}
