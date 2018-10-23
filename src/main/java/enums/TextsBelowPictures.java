package enums;

public enum TextsBelowPictures {

    GOOD_PRACTICES("To include good practices\n" +
            "and ideas from successful\n" +
            "EPAM project"),
    FLEXIBLE("To be flexible and\n" +
            "customizable"),
    MULTIPLATFORM("To be multiplatform"),
    GOOD_BASE("Already have good base\n" +
            "(about 20 internal and\n" +
            "some external projects),\n" +
            "wish to get more…");

    public String text;

    TextsBelowPictures(String text){
        this.text = text;
    }
}
