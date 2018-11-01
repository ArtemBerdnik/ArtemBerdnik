package enums;

import java.util.ArrayList;
import java.util.List;

public enum SubcategoriesUnderServiceDropdown {
    SUPPORT("Support"),
    DATES("Dates"),
    COMPLEX_TABLE("Complex table"),
    SIMPLE_TABLE("Simple table"),
    USER_TABLE("User table"),
    TABLE_WITH_PAGES("Table with pages"),
    DIFFERENT_ELEMENTS("Different Elements"),
    PERFORMANCE("Performance");

    public String name;

    SubcategoriesUnderServiceDropdown(String name) {
        this.name = name;
    }

    public static List<String> getSubcategoriesNames() {
        List<String> names = new ArrayList<>();
        for (SubcategoriesUnderServiceDropdown category : SubcategoriesUnderServiceDropdown.values()) {
            names.add(category.name);
        }
        return names;
    }
}
