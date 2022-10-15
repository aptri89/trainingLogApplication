package model;

public class Run extends Workout {

    private int avgRunPaceMins;          // average run pace minutes component
    private int avgRunPaceSecs;          // average run pace seconds component


    // REQUIRES: runName is not an empty string, todaysDate is not an empty string, runHR > 0
    // EFFECTS: creates new run object with given parameters
    public Run(String runName, String todaysDate, int runHR, int runPaceMins, int runPaceSecs, int runTime,
               int runPerceivedDifficulty, int runDistance) {

        super(runName, todaysDate, runHR, runTime, runPerceivedDifficulty, runDistance);
        this.avgRunPaceMins = runPaceMins;
        this.avgRunPaceSecs = runPaceSecs;
    }

    public String getCompleteRunPace(int avgRunPaceMins, int avgRunPaceSecs) {
        return (avgRunPaceMins + ":" + avgRunPaceSecs);

    }


    // MODIFIES: this
    // EFFECTS: changes the minutes component of average run pace
    public void changeRunPaceMins(int newRunPaceMins) {
        this.avgRunPaceMins = newRunPaceMins;
    }

    // MODIFIES: this
    // EFFECTS: changes the seconds component of average run pace
    public void changeRunPaceSecs(int newRunPaceSecs) {
        this.avgRunPaceSecs = newRunPaceSecs;
    }

    // EFFECTS: returns minutes component of average run pace
    public int getAvgRunPaceMins() {
        return this.avgRunPaceMins;
    }

    // EFFECTS: returns seconds component of average run pace
    public int getAvgRunPaceSecs() {
        return this.avgRunPaceSecs;
    }

    // EFFECTS: returns average run pace in a string format
    public String getAvgRunPace() {
        return (getAvgRunPaceMins() + ":" + getAvgRunPaceSecs());
    }

}