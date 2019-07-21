package users.task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class UserProcessingDemonstrator {

    public static void demonstrateUserProcessing() {
        int durationOfWeek = 7;
        List<User> users = generateUsers(99);

        Map<Team, List<String>> groupedEmails = users.stream()
                .filter(u -> u.getLoginDate().isAfter(LocalDate.now().minusDays(durationOfWeek)))
                .collect(Collectors.groupingBy(User::getTeam,
                        Collectors.mapping(User::getEmail, Collectors.toList())));

        System.out.println("Grifindor users:\n" + groupedEmails.get(Team.FIRST_TEAM));
        System.out.println("Slizerin users:\n" + groupedEmails.get(Team.SECOND_TEAN));
        System.out.println("Banglhof users:\n" + groupedEmails.get(Team.THIRD_TEAM));
    }

    private static List<User> generateUsers(int amount) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            users.add(new User());
        }

        return users;
    }
}
