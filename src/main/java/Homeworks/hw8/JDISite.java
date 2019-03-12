package Homeworks.hw8;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import Homeworks.hw8.pages.HomePageJDI;
import Homeworks.hw8.pages.MetalsAndColorsPage;

@JSite("https://epam.github.io/JDI/")
public class JDISite {

    @Url("index.html")
    public static HomePageJDI homePageJDI;

    @Url("metals-colors.html")
    public static MetalsAndColorsPage metalsAndColorsPage;

}

