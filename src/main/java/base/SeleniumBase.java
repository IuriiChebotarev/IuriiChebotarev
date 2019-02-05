package base;

import org.testng.annotations.BeforeSuite;
// TODO missing empty space between imports and code. Please format code for Java Code Convention
public class SeleniumBase {

    @BeforeSuite
    public void beforeSuit() {
        /* TODO
            * I do not recommend use static import for setProperty method--FIXED
            * I am not able see chromedriver.exe in src\main\resources. I do not see src\main\resources folder in you project--FIXED
         */
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }
}
