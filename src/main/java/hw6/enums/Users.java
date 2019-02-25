package hw6.enums;

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

    public static Users getLogin(String userLogin) {
        for (Users login : Users.values()) {
            if (login.login.equals(userLogin)) {
                return login;
            }
        }
        return null;
    }

    public static Users getPassword(String userPassword) {
        for (Users password : Users.values()) {
            if (password.password.equals(userPassword)) {
                return password;
            }
        }
        return null;
    }
}
