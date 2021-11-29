package Components;

public class User {

    String name;
    String nickName;
    String phone;
    String email;

    public String getName(){return name;}
    public String getNickName(){return name;}
    public String getPhone(){return name;}
    public String getEmail(){return name;}

    public User(String name, String nickName, String phone, String email) {
        this.name = name;
        this.nickName = nickName;
        this.phone = phone;
        this.email = email;
    }
}
