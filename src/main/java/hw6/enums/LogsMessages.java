package hw6.enums;

public enum LogsMessages {

    CHECKBOX_LOG(": condition changed to "),
    RADIOBUTTON_LOG("metal: value changed to "),
    DROPDOWN_LOG("Colors: value changed to "),
    VIP_CHECKBOX_LOG("Vip: condition changed to ");

    public String text;

    LogsMessages(String text) {

        this.text = text;
    }

    public static LogsMessages getLogMessage(String log) {
        for (LogsMessages logMessage : LogsMessages.values()) {
            if (logMessage.text.equals(log)) {
                return logMessage;
            }
        }
        return null;
    }
}
