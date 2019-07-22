import box.task.ThingsProcessingDemonstrator;
import functionalinterface.example.FunctionalInterfacesDemonstrator;
import movie.task.MovieProcessingDemonstrator;
import users.task.UserProcessingDemonstrator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of task:(1-4)");
        switch (sc.nextInt()) {
            case ConstantKeeper.FUNCTIONAL_INTERFACE_TASK:
                FunctionalInterfacesDemonstrator.demonstrateFuncInterfacesWork();
                break;
            case ConstantKeeper.USER_SORTING_BY_TEAM_TASK:
                UserProcessingDemonstrator.demonstrateUserProcessing();
                break;
            case ConstantKeeper.MOVIES_TASK:
                MovieProcessingDemonstrator.demonstrateMovieProcessing();
                break;
            case ConstantKeeper.BOX_TASK:
                ThingsProcessingDemonstrator.demonstrateBoxTask();
                break;
        }
    }
}
