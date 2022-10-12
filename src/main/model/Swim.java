package model;

public class Swim extends Workout {

    private int avgSwimPace;             // average pace per 100m in seconds (swim only)

    public Swim(String swimName, String todaysDate, int swimHR, int swimTime,
                int swimPace, int swimPerceivedDifficulty, int swimDistance) {

        super(swimName, todaysDate, swimHR, swimTime, swimPerceivedDifficulty, swimDistance);
        this.avgSwimPace = swimPace;
    }





}


