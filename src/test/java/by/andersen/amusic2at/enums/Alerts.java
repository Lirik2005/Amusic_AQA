package by.andersen.amusic2at.enums;

public enum Alerts {
    WRONG_LOGIN("Error: This user is not registered yet"),
    WRONG_PASSWORD("Error: Wrong password");

    String error;

    Alerts(String error) {
        this.error = error;
    }

    public String getValue() {
        return error;
    }
}
