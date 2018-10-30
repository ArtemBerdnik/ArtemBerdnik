package enums;

public enum Colors {

    RED("Red", 0),
    GREEN("Green", 1),
    BLUE("Blue", 2),
    YELLOW("Yellow", 3);

    public String colorValue;
    public int colorPosition;

    Colors(String colorValue, int colorPosition){
        this.colorValue = colorValue;
        this.colorPosition = colorPosition;
    }


}
