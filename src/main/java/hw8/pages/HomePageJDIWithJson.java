/*
package hw8.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.ui.html.common.Icon;
import hw7.entities.Users;
import hw7.enums.HeaderItems;
import hw7.forms.LoginForm;
import hw7.sections.HeaderSection;
import org.openqa.selenium.support.FindBy;

import static hw7.JDISite.metalsAndColorsPage;

public class HomePageJDIWithJson extends WebPage {

    LoginForm loginForm;
    public HeaderSection headerSection;

    @FindBy(css = "#user-icon")
    private Icon userIcon;

    public void login(Users users) {
        userIcon.click();
        loginForm.login(users);
    }

    public void openItemInHeaderMenu(HeaderItems navigationItems) {

        headerSection.headerMenu.select(navigationItems.label);
        metalsAndColorsPage.shouldBeOpened();
    }
}
*/
