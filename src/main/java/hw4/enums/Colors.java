package hw4.enums;

public enum Colors {

    RED(0,"Red"),
    GREEN(1,"Green"),
    BLUE(2,"Blue"),
    YELLOW(3,"Yellow");

    public int indexOfColor;
    public String label;

    Colors(int indexOfColor,String label) {
        this.indexOfColor = indexOfColor;
        this.label = label;
    }
}