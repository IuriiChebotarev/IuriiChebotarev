package hw7.enums;

import java.util.ArrayList;
import java.util.List;

public enum HeaderItems {

    HOME(0, "HOME"),
    CONTACT_FORM(1, "CONTACT FORM"),
    SERVICE(2, "SERVICE"),
    METALS_AND_COLORS(3, "METALS & COLORS");

    public int index;
    public String label;

    HeaderItems(int index, String label) {
        this.index = index;
        this.label = label;
    }
}
