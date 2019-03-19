package Homeworks.hw7.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import Homeworks.hw7.data.MetalAndColorsData;
import Homeworks.hw7.forms.MetalAndColorsForm;
import Homeworks.hw7.sections.ResultSection;
// TODO Code convention !
// TODO All actions with form's elements should be encapsulate in form.
// TODO Same story about the elements, that worm is consist of.
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

