package hw7.sections;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import hw7.data.MetalAndColorsData;
import static org.testng.Assert.assertEquals;

public class ResultSection extends Section {

    @FindBy(className = "results")
    public WebList results;

    public void check(MetalAndColorsData data) {
        for (int i=0;i<data.resultLog().length;i++) {
            assertEquals(results.get(i).getText(),data.resultLog()[i]);
        }
    }
}
