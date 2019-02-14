package hw3.pageObject.enums;

import java.util.ArrayList;
import java.util.List;

public enum ItemsWithTexts {
    HOME("HOME"),
    CONTACT_FORM("CONTACT FORM"),
    SERVICE("SERVICE"),
    METALS_COLORS("METALS & COLORS");

    // TODO variable naming!!!--FIXED
    public final String itemText;

    ItemsWithTexts(String itemText) {
        this.itemText = itemText;
    }

    public static List<String> getHeaderItemsList() {
        List<String> listOfHeaderItems = new ArrayList<>();

        for (ItemsWithTexts itemsWithTexts : ItemsWithTexts.values()) {
            listOfHeaderItems.add(itemsWithTexts.itemText);
        }
        return listOfHeaderItems;
    }
}

