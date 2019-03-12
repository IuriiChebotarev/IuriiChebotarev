package Homeworks.hw8;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import Homeworks.hw8.data.MetalAndColorsData;
import Homeworks.hw8.data.MetalAndColorsDataWithJson;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static hw7.entities.Users.PETER;
import static hw7.enums.HeaderItems.METALS_AND_COLORS;

public class JDISiteTestWithJson {

    @BeforeSuite ()
    public void beforeSuite() {

        PageFactory.initElements(JDISite.class);
    }

    @Test(dataProvider = "jsonDataProvider",dataProviderClass = MetalAndColorsDataWithJson.class)

    public void jDISiteTest(MetalAndColorsData data) {
        JDISite.homePageJDI.open();
        JDISite.homePageJDI.login(PETER);
        JDISite.homePageJDI.openItemInHeaderMenu(METALS_AND_COLORS);
        JDISite.metalsAndColorsPage.fillMetalAndColorsForm(data);
        JDISite.metalsAndColorsPage.submitForm();
        JDISite.metalsAndColorsPage.checkResultLog(data);
    }

    @AfterMethod()
    public void afterMethod() {

        WebDriverFactory.close();
    }
}