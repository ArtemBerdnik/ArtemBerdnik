package enums.moblie;

public enum ErrorsTexts {

    ERROR_IN_TYPE_OF_APP("The type of mobile app is unknown"),
    ERROR_IN_MOBILE_PLATFORM("The mobile platform is unknown");

    public String text;

    ErrorsTexts(String text) {
        this.text = text;
    }
}
