package hw7.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.complex.Menu;

public class HeaderSection extends Section {

    @FindBy(css = ".uui-navigation.nav.navbar-nav.m-l8 > li")
    public Menu headerMenu;


}
