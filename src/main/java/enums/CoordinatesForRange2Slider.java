package enums;

public enum CoordinatesForRange2Slider {

    ZERO(787, 0),
    THIRTY(899, 30),
    SEVENTY(1051, 70),
    HUNDRED(1182, 100);

    public int xAxisCoordinate;
    public int value;

    CoordinatesForRange2Slider(int xAxisCoordinate, int value) {
        this.xAxisCoordinate = xAxisCoordinate;
        this.value = value;
    }
}
