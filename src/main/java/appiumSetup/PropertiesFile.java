package appiumSetup;

public enum PropertiesFile {

    /**
     * Enum for building property name with respect to the selected test configuration
     */
    NATIVE("nativeApp"),
    WEB("web");

    private String currentAppType;

    PropertiesFile(String current) {
        this.currentAppType = current;
    }

    public String getFileName() {
        return currentAppType + ".properties";
    }
}
