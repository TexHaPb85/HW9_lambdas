import box.task.ThingsProcessingDemonstrator;

import functionalinterface.example.FunctionalInterfacesDemonstrator;
import movie.task.MovieProcessingDemonstrator;
import users.task.UserProcessingDemonstrator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of task:(1-4)");
        switch (sc.nextInt()){
            case ConstantKeeper.firstTaskNumber:
                FunctionalInterfacesDemonstrator.demonstrateFuncInterfacesWork();
                break;
            case ConstantKeeper.secondTaskNumber:
                UserProcessingDemonstrator.demonstrateUserProcessing();
                break;
            case ConstantKeeper.thirdTaskNumber:
                MovieProcessingDemonstrator.demonstrateMovieProcessing();
                break;
            case ConstantKeeper.fourthTaskNumber:
                ThingsProcessingDemonstrator.demonstrateBoxTask();
                break;
        }
    }
}
