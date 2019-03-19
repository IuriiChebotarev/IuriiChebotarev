package Homeworks.hw7;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import Homeworks.hw7.JDISite;
import Homeworks.hw7.data.MetalAndColorsData;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static Homeworks.hw7.entities.Users.PETER;
import static Homeworks.hw7.enums.HeaderItems.METALS_AND_COLORS;

public class JDISiteTest {

    private MetalAndColorsData data = new MetalAndColorsData();

    @BeforeSuite
    public void beforeSuite() {

        PageFactory.initElements(JDISite.class);
    }

    @Test
    public void jDISiteTest() {
        JDISite.homePageJDI.open();
        JDISite.homePageJDI.login(PETER);
        JDISite.homePageJDI.openItemInHeaderMenu(METALS_AND_COLORS);
        JDISite.metalsAndColorsPage.fillMetalAndColorsForm(data);
        JDISite.metalsAndColorsPage.submitForm();
        JDISite.metalsAndColorsPage.checkResultLog(data);
        // TODO Great, and where is verification step ?
    }

    @AfterSuite
    public void afterSuite() {
        WebDriverFactory.close();
    }
}