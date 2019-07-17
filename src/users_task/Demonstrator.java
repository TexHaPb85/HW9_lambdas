package users_task;

import functional_interface_example.Randomable;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Demonstrator {
    public static void main(String[] args) {

        List<User> users = generateUsers();

        Map<Team, List<String>> groupedEmails =users.stream()
                .filter(u->Duration.between(LocalDate.now().atStartOfDay(), u.getLoginDate().atStartOfDay()).toDays()>=-7)
                .peek(System.out::println)
                .collect(Collectors.groupingBy(User::getTeam,
                        Collectors.mapping(User::getEmail,Collectors.toList())));

        System.out.println("Grifindor users:\n"+groupedEmails.get(Team.FIRST_TEAM));
        System.out.println("Slizerin users:\n"+groupedEmails.get(Team.SECOND_TEAN));
        System.out.println("Banglhof users:\n"+groupedEmails.get(Team.THIRD_TEAM));
    }

    private static List<User> generateUsers() {
        Randomable rand = (from, to) -> from + (int) (Math.random() * (to - from));
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 999; i++) {
            String uniqueEmail = "user" + i + "@gmail.com";
            LocalDate date = LocalDate.now().minusDays(rand.getRandomInteger(0, 14));
            Team team = null;
            switch (rand.getRandomInteger(0, 3)) {
                case 0:
                    team = Team.FIRST_TEAM;
                    break;
                case 1:
                    team = Team.SECOND_TEAN;
                    break;
                case 2:
                    team = Team.THIRD_TEAM;
                    break;
            }
            users.add(new User(uniqueEmail, date, team));
        }
        return users;
    }
}
