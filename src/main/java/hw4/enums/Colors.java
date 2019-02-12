package hw4.enums;

public enum Colors {

    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow");

    public String label;

    Colors(String label) {
        this.label = label;
    }
}