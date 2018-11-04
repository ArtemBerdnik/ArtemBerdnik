package jdi.entities;

public class User {

    private String login;
    private String password;

    private User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public static User PITER_CHAILOVSKI = new User("epam", "1234");

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

}
