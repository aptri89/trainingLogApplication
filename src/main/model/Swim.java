package model;

public class Swim extends Workout {

    private int avgSwimPace;             // average pace per 100m in seconds (swim only)

    // REQUIRES: swimName is not an empty string, todaysDate is not an empty string, swimHR > 0, swimTime > 0
    //           swimPace > 0, swimPerceivedDifficulty is between 1 and 10, swimDistance > 0
    // EFFECTS: creates new swim object with given parameters
    public Swim(String swimName, String todaysDate, int swimHR, int swimTime,
                int swimPace, int swimPerceivedDifficulty, int swimDistance) {

        super(swimName, todaysDate, swimHR, swimTime, swimPerceivedDifficulty, swimDistance);
        this.avgSwimPace = swimPace;
    }

    // REQUIRES
    public void changeSwimPace(int newSwimPace) {
        this.avgSwimPace = newSwimPace;

    }

    public int getAvgSwimPace() {
        return this.avgSwimPace;
    }




}


