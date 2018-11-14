package api.enums;

public enum Language {
    RU("ru"),
    UK("uk"),
    EN("en"),
    INSISTING_LANGUAGE("IL");
    private String languageCode;
    public String langCode(){return languageCode;}

    Language(String lang) {
        this.languageCode = lang;
    }
}