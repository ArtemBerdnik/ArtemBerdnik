package api.enums;

public enum TestWordsRus {

    TEST("тест", "тестт"),
    CITY("город", "горот");

    private String corrVer;
    private String wrongVer;

    public String corrVer() {
        return corrVer;
    }

    public String wrongVer() {
        return wrongVer;
    }

    TestWordsRus(String corrVer, String wrongVer) {
        this.corrVer = corrVer;
        this.wrongVer = wrongVer;

    }
}
