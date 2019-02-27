package Homeworks.hw7;


import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import hw7.JDISite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static hw7.entities.Users.PETER;
import static hw7.enums.HeaderItems.METALS_AND_COLORS;

public class JDISiteTest {

    @BeforeSuite
    public void beforeSuite() {
        PageFactory.initElements(JDISite.class);
    }

    @Test
    public void jDISiteTest() {
        JDISite.homePageJDI.open();
        JDISite.homePageJDI.login(PETER);
        JDISite.homePageJDI.clickOnItemInHeader(METALS_AND_COLORS);
    }


    @AfterSuite
    public void afterSuite() {
        WebDriverFactory.close();
    }
}