package hw6;

import base.hw6.BasePage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.DataTable;
import hw6.enums.LogsMessages;
import hw6.enums.UsersInTable;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.Map;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.page;

public class UserTablePage extends BasePage {

    @FindBy(css = "select")
    private ElementsCollection dropdown;

    @FindBy(css = "td  a")
    private ElementsCollection usernames;

    @FindBy(css = "td  img")
    private ElementsCollection userImages;

    @FindBy(css = ".user-descr")
    private ElementsCollection userDescriptions;

    @FindBy(css = "td input")
    private ElementsCollection checkboxes;

    @FindBy(css = ".panel-body-list.logs")
    private SelenideElement logsPanel;

    @FindBy(css = "tbody > tr:nth-child(2) option")
    private ElementsCollection itemsInUserRolesDropdown;

    @FindBy(css = "user-table tr")
    private ElementsCollection table;

    public UserTablePage() {
        page(this);
    }

    public void checkAmountOfDropdowns() {
        dropdown.shouldHaveSize(6);
    }

    public void checkAmountOfUsernames() {
        usernames.shouldHaveSize(6);
    }

    public void checkAmountOfUserImages() {
        userImages.shouldHaveSize(6);
    }

    public void checkAmountOfUserDescriptions() {
        userDescriptions.shouldHaveSize(6);
    }

    public void checkAmountOfCheckboxes() {
        checkboxes.shouldHaveSize(6);
    }

    public void checkUsersTable(DataTable userTable) {
        List<Map<String, String>> table = userTable.asMaps(String.class, String.class);

        for (int i = 0; i < table.size(); i++) {
            // TODO Where is checking of the "Number"?
            usernames.get(i).should(text(table.get(i).get("User")));
            userDescriptions.get(i).should(text(table.get(i).get("Description")));
        }
    }

    public void selectCheckbox(UsersInTable usersInTable) {
        checkboxes.get(usersInTable.index).click();
    }

    public void checkLogs(LogsMessages logsMessages, String status) {
        logsPanel.shouldHave(text(logsMessages.text + status));
    }

    public void openDropdownList(UsersInTable usersInTable) {
        dropdown.get(usersInTable.index).click();
    }

    public void checkUserRolesInDropdown(List<String> userRoles) {
        for (int i = 0; i < itemsInUserRolesDropdown.size(); i++) {
            itemsInUserRolesDropdown.get(i).shouldHave(text(userRoles.get(i)));
        }
    }
}

