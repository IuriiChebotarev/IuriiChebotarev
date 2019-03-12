package Homeworks.hw6.enums;

public enum Checkboxes {

    WATER(0,"Water"),
    EARTH(1,"Earth"),
    WIND(2,"Wind"),
    FIRE(3,"Fire");

    public int indexOfCheckbox;
    public String value;

    Checkboxes(int indexOfCheckbox, String value) {
        this.indexOfCheckbox=indexOfCheckbox;
        this.value = value;
    }

    public static Checkboxes getCheckbox(String checkboxValue) {
        for (Checkboxes checkbox : Checkboxes.values()) {
            if (checkbox.value.equals(checkboxValue)) {
                return checkbox;
            }
        }
        return null;
    }
}
