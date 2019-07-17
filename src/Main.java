import box_task.ThingsProcessingDemonstrator;
import functional_interface_example.FunctionalInterfacesDemonstrator;
import movie_task.MovieProcessingDemonstrator;
import users_task.UserProcessingDemonstrator;

public class Main {
    public static void main(String[] args) {
        FunctionalInterfacesDemonstrator.demonstrateFuncInterfacesWork();
        UserProcessingDemonstrator.demonstrateUserProcessing();
        MovieProcessingDemonstrator.demonstrateMovieProcessing();
        ThingsProcessingDemonstrator.demonstrateBoxTask();
    }
}
