package hw6.enums;

public enum RadioButtons {

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

    public static RadioButtons getRadiobutton(String radioButtonName) {
        for (RadioButtons radiobutton : RadioButtons.values()) {
            if (radiobutton.label.equals(radioButtonName)) {
                return radiobutton;
            }
        }
        return null;
    }
}
