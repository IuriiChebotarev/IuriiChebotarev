package hw7.pages;


import com.epam.jdi.light.elements.composite.WebPage;
import hw7.entities.Users;
import hw7.enums.HeaderItems;
import hw7.forms.HeaderForm;
import hw7.forms.LoginForm;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageJDI extends WebPage {

    LoginForm loginForm;
    HeaderForm headerForm;

    @FindBy(css = "#user-icon")
    private WebElement userIcon;

    public void login(Users users) {
        userIcon.click();
        loginForm.login(users);
    }

    public void clickOnItemInHeader(HeaderItems navigationItems) {
        headerForm.get(navigationItems.index).click();
    }
}
