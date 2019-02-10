package hw3.pageObject.enums;

public enum ItemsWithTexts {
    // TODO Why you set into one value?
    HOME ("HOME"),
    CONTACT_FORM ("CONTACT FORM"),
    SERVICE ("SERVICE"),
    METALS_COLORS ("METALS & COLORS");

    public final String ItemText;

    ItemsWithTexts(String ItemText) {

        this.ItemText = ItemText;
    }

    @Override
    public String toString() {

        return ItemText;
    }
}

