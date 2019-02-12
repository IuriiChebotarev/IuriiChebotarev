package base;

import org.testng.annotations.BeforeSuite;

public class SeleniumBase {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuit() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }
}
