package users_task;

public enum Team {
    FIRST_TEAM("Grifindor"),
    SECOND_TEAN("Slizerin"),
    THIRD_TEAM("Banglhof");

    private String teamName;

    Team(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }
}
