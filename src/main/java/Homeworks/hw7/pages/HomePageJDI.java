package Homeworks.hw7.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.ui.html.common.Icon;
import Homeworks.hw7.entities.Users;
import Homeworks.hw7.enums.HeaderItems;
import Homeworks.hw7.forms.LoginForm;
import Homeworks.hw7.sections.HeaderSection;
import org.openqa.selenium.support.FindBy;
import static org.testng.Assert.assertEquals;

public class HomePageJDI extends WebPage {

    private LoginForm loginForm;
    private HeaderSection headerSection;

    @FindBy(css = "#user-icon")
    private Icon userIcon;

    public void login(Users users) {
        userIcon.click();
        loginForm.login(users);
    }

    // TODO You have a parameter in this method, so, obviously, it can be use in order to open any kins of page,
    // but what about verification ?
    public void openItemInHeaderMenu(HeaderItems navigationItems) {
        headerSection.headerMenu.select(navigationItems.label);
        assertEquals(getTitle(),navigationItems.pageTitle);
    }

}
