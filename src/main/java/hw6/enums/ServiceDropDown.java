package hw6.enums;

import java.util.ArrayList;
import java.util.List;

public enum ServiceDropDown {

    SUPPORT(0, "Support"),
    DATES(1, "Dates"),
    COMPLEX_TABLE(2,"Complex Table"),
    SIMPLE_TABLE(3,"Simple Table"),
    USER_TABLE(4,"User Table"),
    TABLES_WITH_PAGE(5,"Tables With Pages"),
    DIFFERENT_ELEMENTS(6,"Different Elements"),
    PERFORMANCE(7,"Performance");

    public int index;
    public String label;

    ServiceDropDown(int index, String text) {
        this.index = index;
        this.label = text;
    }

    public static List<String> getServiceDropDownHeaders() {
        List<String> listOfServiceDropDownHeaders = new ArrayList<>();

        for (ServiceDropDown serviceDropDown : ServiceDropDown.values()) {
            listOfServiceDropDownHeaders.add(serviceDropDown.label);
        }
        return listOfServiceDropDownHeaders;
    }

    public static ServiceDropDown getServiceDropdownItem(String itemName) {
        for (ServiceDropDown item : ServiceDropDown.values()) {
            if (item.label.equals(itemName)) {
                return item;
            }
        }
        return null;
    }
}
