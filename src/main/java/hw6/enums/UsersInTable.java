package hw6.enums;

import java.util.ArrayList;
import java.util.List;

public enum UsersInTable {

    ROMAN(0, "Roman"),
    SERGEY_IVAN(1, "Sergey Ivan"),
    VLADZIMIR(2,"Vladzimir"),
    HELEN_BENNET(3,"Helen Bennet"),
    YOSHI_TANNAMURI(4,"Yoshi Tannamuri"),
    TGIOVANNI_ROVELLI(5,"Tables With Pages");

    public int index;
    public String label;

    UsersInTable(int index, String label) {
        this.index = index;
        this.label = label;
    }

    public static List<String> getUsersList() {
        List<String> listUsersLabels = new ArrayList<>();

        for (UsersInTable usersInTable : UsersInTable.values()) {
            listUsersLabels.add(usersInTable.label);
        }
        return listUsersLabels;
    }

    public static UsersInTable getUserInTable(String user) {
        for (UsersInTable username : UsersInTable.values()) {
            if (username.label.equals(user)) {
                return username;
            }
        }
        return null;
    }
}

