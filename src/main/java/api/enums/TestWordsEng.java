package api.enums;

public enum TestWordsEng {

    MOTHER("mother", "mottherr"),
    BROTHER("brother", "bbrother"),
    LAPTOP("laptop", "laptoo");

    private String corrVer;
    private String wrongVer;

    public String corrVer() {
        return corrVer;
    }

    public String wrongVer() {
        return wrongVer;
    }

    TestWordsEng(String corrVer, String wrongVer) {
        this.corrVer = corrVer;
        this.wrongVer = wrongVer;

    }
}

