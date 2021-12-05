package Components;

public class User {

    String name;
    String nickName;
    String phone;
    String email;

    public String getName(){return name;}
    public String getNickName(){return nickName;}
    public String getPhone(){return phone;}
    public String getEmail(){return email;}

    public User(String name, String nickName, String phone, String email) {
        this.name = name;
        this.nickName = nickName;
        this.phone = phone;
        this.email = email;
    }
}
