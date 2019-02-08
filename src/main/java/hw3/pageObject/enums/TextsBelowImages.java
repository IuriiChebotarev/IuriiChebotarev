package hw3.pageObject.enums;

public enum TextsBelowImages {
    // TODO Why you set into one value?
    TEXTS("To include good practices\nand ideas from successful\nEPAM project","To be flexible and\ncustomizable", "To be multiplatform", "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

    public String firstText;
    public String secondText;
    public String thirdText;
    public String fourthText;

    TextsBelowImages(String firstText, String secondText, String thirdText, String fourthText) {
        this.firstText = firstText;
        this.secondText = secondText;
        this.thirdText = thirdText;
        this.fourthText = fourthText;
    }
}

