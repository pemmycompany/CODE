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

    public String getName(){return name;}
    public String[] getSkills(){return skills;}
    public boolean getStatus(){return status;}
    public float getHealth(){return health;}

    public void setStatus(boolean value){status = value;}
}
