package hw4.enums;

public enum  RadioButtons {

    GOLD(0, "Gold"),
    SILVER(1, "Silver"),
    BRONZE(2, "BRONZE"),
    SELEN(3, "Selen");

    public int index;
    public String label;

    RadioButtons(int index, String label) {
        this.index = index;
        this.label = label;
    }
}
