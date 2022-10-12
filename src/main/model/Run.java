package model;

public class Run extends Workout {

    private int avgRunPaceMins;          // average run pace minutes component
    private int avgRunPaceSecs;          // average run pace seconds component


    public Run(String runName, String todaysDate, int runHR, int runPaceMins, int runPaceSecs, int runTime,
               int runPerceivedDifficulty, int runDistance) {

        super(runName, todaysDate, runHR, runTime, runPerceivedDifficulty, runDistance);
        this.avgRunPaceMins = runPaceMins;
        this.avgRunPaceSecs = runPaceSecs;
    }


}