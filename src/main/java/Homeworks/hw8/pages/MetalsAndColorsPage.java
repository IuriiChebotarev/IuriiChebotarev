package Homeworks.hw8.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import Homeworks.hw8.data.MetalAndColorsData;
import Homeworks.hw8.forms.MetalAndColorsForm;
import Homeworks.hw8.sections.ResultSection;

public class MetalsAndColorsPage extends WebPage {

    private MetalAndColorsForm metalAndColorsForm;
    private ResultSection resultSection;

    public void fillMetalAndColorsForm(MetalAndColorsData data) {

        metalAndColorsForm.fillForm(data);
    }

    public void submitForm () {

        metalAndColorsForm.submit();
    }

    public void checkResultLog(MetalAndColorsData data){

        resultSection.check(data);
    }
}

