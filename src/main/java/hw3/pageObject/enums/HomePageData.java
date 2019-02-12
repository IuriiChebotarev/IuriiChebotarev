package hw3.pageObject.enums;

public enum HomePageData {
    // TODO this is could be combine into one value
    HOME_PAGE_DATA("https://epam.github.io/JDI/","Home Page","https://github.com/epam/JDI");

    public final String url;
    public final String title;
    public final String jdiUrl;

    HomePageData(String url, String title, String jdiUrl){

        this.url = url;
        this.title=title;
        this.jdiUrl=jdiUrl;
    }
}
