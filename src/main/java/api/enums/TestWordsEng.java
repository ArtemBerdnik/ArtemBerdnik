package api.enums;

public enum TestWordsEng {

    MOTHER("mother", "mottherr"),
    BROTHER("brother", "bbrother"),
    LAPTOP("laptop", "laptoo"),
    WORD_WITH_ENDING_DIGITS("bug 1", "a bug1"),
    WORD_WITH_LEADING_DIGITS("1 bug", "a 1bug"),
    WORD_WITH_URL("ABC COM", "please send the mail to abc@test.com"),
    WORD_WITH_CAPITALIZATION("error", "erRor"),
    WORD_WITH_REPEATS("test", "tezt tezt"),
    STRING_WITH_ERRORS("test failed", "tezt \n failet");


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

