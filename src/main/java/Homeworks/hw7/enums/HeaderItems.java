package Homeworks.hw7.enums;

public enum HeaderItems {

    HOME(0, "HOME","Home Page"),
    CONTACT_FORM(1, "CONTACT FORM","Contact Form"),
    SERVICE(2, "SERVICE",null),
    METALS_AND_COLORS(3, "METALS & COLORS","Metal and Colors");

    public int index;
    public String label;
    public String pageTitle;


    HeaderItems(int index, String label, String pageTitle) {
        this.index = index;
        this.label = label;
        this.pageTitle = pageTitle;
    }
}
