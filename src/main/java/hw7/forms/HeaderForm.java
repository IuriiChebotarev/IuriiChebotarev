package hw7.forms;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.ui.html.complex.Dropdown;
import hw7.entities.Users;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderForm extends Form<Users> {

    @FindBy(css = ".uui-navigation.nav.navbar-nav.m-l8 > li")
    private WebElement headerItems;


}
