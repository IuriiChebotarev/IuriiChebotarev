package Homeworks.hw3.pageObject.enums;

import java.util.ArrayList;
import java.util.List;

public enum TextsBelowImages {
    FIRST_ICON_TEXT("To include good practices\nand ideas from successful\nEPAM project"),
    SECOND_ICON_TEXT("To be flexible and\ncustomizable"),
    THIRD_ICON_TEXT("To be multiplatform"),
    FOURTH_ICON_TEXT("Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

    // TODO variable naming!!!--FIXED
    public final String imagesText;

    TextsBelowImages(String imagesText) {

        this.imagesText = imagesText;
    }

    public static List<String> getTextsBelowImages() {
        List<String> listOfTextsBelowImages = new ArrayList<>();

        for (TextsBelowImages textsBelowImages : TextsBelowImages.values()) {
            listOfTextsBelowImages.add(textsBelowImages.imagesText);
        }
        return listOfTextsBelowImages;
    }
}


