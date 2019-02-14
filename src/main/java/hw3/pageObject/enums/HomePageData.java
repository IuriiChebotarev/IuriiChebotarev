package hw3.pageObject.enums;

public enum HomePageData {
    // TODO why https://github.com/epam/JDI as one enum
    HOME_PAGE_DATA("https://epam.github.io/JDI/","Home Page");

    public final String url;
    public final String title;

    HomePageData(String url, String title) {
        this.url = url;
        this.title=title;
    }
}
