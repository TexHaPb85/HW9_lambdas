package users.task;

import functionalinterface.example.Randomable;

import java.time.LocalDate;

public class User {
    private String email;
    private LocalDate loginDate;
    private Team team;

    public User(String email, LocalDate loginDate, Team team) {
        this.email = email;
        this.loginDate = loginDate;
        this.team = team;
    }

    public User() {
        setRandomValues();
    }

    private void setRandomValues() {
        String emailEnding = "@gmail.com";
        Randomable rand = (from, to) -> (int) (Math.random() * (to - from)) + from;
        String uniqueEmail = "user" + rand.getRandomInteger(1, 150) + emailEnding;
        LocalDate randLastLoginDate = LocalDate.now().minusDays(rand.getRandomInteger(0, 14));
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
        this.email = uniqueEmail;
        this.loginDate = randLastLoginDate;
        this.team = team;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(LocalDate loginDate) {
        this.loginDate = loginDate;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", loginDate=" + loginDate +
                ", team=" + team +
                '}';
    }
}
