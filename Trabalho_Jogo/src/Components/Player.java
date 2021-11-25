package Components;

public class Player {

    String name;
    String[] skills;
    boolean status;
    float health;

    public Player(String name, String[] skills, boolean status, float health) {
        this.name = name;
        this.skills = skills;
        this.status = status;
        this.health = health;
    }
}
