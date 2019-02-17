package hw4.enums;

public enum LogsMessages {

    CHECKBOX_LOG(": condition changed to "),
    RADIOBUTTON_LOG("metal: value changed to "),
    DROPDOWN_LOG("Colors: value changed to ");

    public String text;

    LogsMessages(String text) {
        this.text = text;
    }
}
