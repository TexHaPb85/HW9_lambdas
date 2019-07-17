import box.task.ThingsProcessingDemonstrator;

import functionalinterface.example.FunctionalInterfacesDemonstrator;
import movie.task.MovieProcessingDemonstrator;
import users.task.UserProcessingDemonstrator;

public class Main {
    public static void main(String[] args) {
        FunctionalInterfacesDemonstrator.demonstrateFuncInterfacesWork();
        UserProcessingDemonstrator.demonstrateUserProcessing();
        MovieProcessingDemonstrator.demonstrateMovieProcessing();
        ThingsProcessingDemonstrator.demonstrateBoxTask();
    }
}
