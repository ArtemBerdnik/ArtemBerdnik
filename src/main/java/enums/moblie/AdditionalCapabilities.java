package enums.moblie;

public enum AdditionalCapabilities {
    APPLICATION_PACKAGE("appPackage"),
    APPLICATION_ACTIVITY("appActivity");

    public String capName;

    AdditionalCapabilities(String capability){
        this.capName = capability;
    }
}
