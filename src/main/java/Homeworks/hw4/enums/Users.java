package Homeworks.hw4.enums;

public enum Users {

    PETER("epam", "1234", "PITER CHAILOVSKII");

    public String login;
    public String password;
    public String username;

    Users(String login, String password, String username) {
        this.login = login;
        this.password = password;
        this.username = username;
    }
}
