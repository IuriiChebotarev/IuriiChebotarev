package hw3.pageObject.enums;

public enum TextsBelowImages {
    // TODO Why you set into one value?
    FIRST_ICON_TEXT("To include good practices\nand ideas from successful\nEPAM project"),
    SECOND_ICON_TEXT("To be flexible and\ncustomizable"),
    THIRD_ICON_TEXT("To be multiplatform"),
    FOURTH_ICON_TEXT("Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

    public final String ImagesText;

    TextsBelowImages(String ImagesText) {

        this.ImagesText = ImagesText;
    }

    @Override
    public String toString() {
        return ImagesText;
    }
}

