package model;

public class Bike extends Workout {

    private int avgBikeSpeed;            // average speed in kilometers per hour (bike only)


    public Bike(String bikeName, String todaysDate, int bikeHR, int bikeTime, int bikeSpeed,
                int bikePerceivedDifficulty, int bikeDistance) {

        super(bikeName, todaysDate, bikeHR, bikeTime, bikePerceivedDifficulty, bikeDistance);
        this.avgBikeSpeed = bikeSpeed;

    }






}
