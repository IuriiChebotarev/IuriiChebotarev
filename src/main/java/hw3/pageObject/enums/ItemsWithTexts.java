package hw3.pageObject.enums;

public enum ItemsWithTexts {
    HOME ("HOME"),
    CONTACT_FORM ("CONTACT FORM"),
    SERVICE ("SERVICE"),
    METALS_COLORS ("METALS & COLORS");

    // TODO variable naming!!!
    public final String ItemText;

    ItemsWithTexts(String ItemText) {
        // TODO extra empty line
        this.ItemText = ItemText;
    }

    @Override
    public String toString() {
        // TODO extra empty line
        return ItemText;
    }
}

