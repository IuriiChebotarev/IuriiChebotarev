package hw7.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import hw7.data.MetalAndColorsData;
import hw7.forms.MetalAndColorsForm;
import hw7.forms.SummaryForm;
import hw7.sections.ResultSection;

public class MetalsAndColorsPage extends WebPage {

    private MetalAndColorsForm metalAndColorsForm;
    private SummaryForm summaryForm;
    private ResultSection resultSection;

    public void fillForm(MetalAndColorsData data) {
        calculateSummary(data.summary);
        selectElement(data.elements);
        selectColor(data.color);
        selectMetal(data.metals);
        selectVegetable(data.vegetables);
    }

    public void calculateSummary(int[] radiobuttons) {
        summaryForm.setOdds(radiobuttons[0]);
        summaryForm.setEven(radiobuttons[1]);
        summaryForm.calculate.click();
    }

    public void selectElement(String[] elements) {

        metalAndColorsForm.elements.select(elements[0],elements[1]);
    }

    public void selectColor (String color) {
        metalAndColorsForm.colors.select((color));
    }

    public void selectMetal (String metals) {
        metalAndColorsForm.metal.select(metals);
    }

    public void selectVegetable (String[] vegetables){
        metalAndColorsForm.vegetables.select(vegetables[0]);
        metalAndColorsForm.vegetables.select(vegetables[1]);
    }

    public void submit () {
        metalAndColorsForm.submit.click();
    }


}
