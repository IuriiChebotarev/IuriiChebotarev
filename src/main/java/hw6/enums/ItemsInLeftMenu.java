package hw6.enums;

import java.util.ArrayList;
import java.util.List;

public enum ItemsInLeftMenu {

    HOME(0, "Home"),
    CONTACT_FORM(1, "Contact form"),
    SERVICE(2, "Service"),
    METALS_AND_COLORS(3, "Metals & Colors"),
    ELEMENTS_PACKS(4, "Elements packs");

    public int index;
    public String label;

    ItemsInLeftMenu(int index, String label) {
        this.index = index;
        this.label = label;
    }

    public static ItemsInLeftMenu getItemInLeftMenu(String itemName) {
        for (ItemsInLeftMenu itemsInLeftMenu : ItemsInLeftMenu.values()) {
            if (itemsInLeftMenu.label.equals(itemName)) {
                return itemsInLeftMenu;
            }
        }
        return null;
    }
}
