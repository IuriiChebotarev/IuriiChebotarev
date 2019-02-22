package hw6.enums;

public enum Colors {

    RED(0,"Red"),
    GREEN(1,"Green"),
    BLUE(2,"Blue"),
    YELLOW(3,"Yellow");

    public int indexOfColor;
    public String label;

    Colors(int indexOfColor, String label) {
        this.indexOfColor = indexOfColor;
        this.label = label;
    }

    public static Colors getColor(String colorLabel) {
        for (Colors color : Colors.values()) {
            if (color.label.equals(colorLabel)) {
                return color;
            }
        }
        return null;
    }
}