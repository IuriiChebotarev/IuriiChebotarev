package hw3.pageObject.enums;

public enum Items {

    ITEMS("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");

    public String home;
    public String contactForm;
    public String service;
    public String metalsAndColors;

    Items(String home, String contactForm, String service, String metalsAndColors) {
        this.home = home;
        this.contactForm = contactForm;
        this.service = service;
        this.metalsAndColors = metalsAndColors;
    }
}

