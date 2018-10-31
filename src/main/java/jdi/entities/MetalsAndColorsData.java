package jdi.entities;

import java.util.Arrays;

public class MetalsAndColorsData {

    private int[] summary;
    private String[] elements;
    private String color;
    private String metals;
    private String[] vegetables;

    private MetalsAndColorsData(int[] summary, String[] elements, String color, String metals, String[] vegetables) {
        this.summary = summary;
        this.elements = elements;
        this.color = color;
        this.metals = metals;
        this.vegetables = vegetables;
    }

    public String getOddsRadioButton() {
        return String.valueOf(summary[0]);
    }

    public String getEvenRadioButton() {
        return String.valueOf(summary[1]);
    }

    public int[] getSummary() {
        return summary;
    }

    public void setSummary(int[] summary) {
        this.summary = summary;
    }

    public String[] getElements() {
        return elements;
    }

    public void setElements(String[] elements) {
        this.elements = elements;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMetals() {
        return metals;
    }

    public void setMetals(String metals) {
        this.metals = metals;
    }

    public String[] getVegetables() {
        return vegetables;
    }

    public void setVegetables(String[] vegetables) {
        this.vegetables = vegetables;
    }

    @Override
    public String toString() {
        return "Data{" +
                "summary=" + Arrays.toString(summary) +
                ", elements=" + Arrays.toString(elements) +
                ", color='" + color + '\'' +
                ", metals='" + metals + '\'' +
                ", vegetables=" + Arrays.toString(vegetables) +
                '}';
    }
}