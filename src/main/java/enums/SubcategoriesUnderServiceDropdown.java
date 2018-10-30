package enums;

import java.util.ArrayList;
import java.util.List;

public enum SubcategoriesUnderServiceDropdown {
    SUPPORT("SUPPORT"),
    DATES("DATES"),
    COMPLEX_TABLE("COMPLEX TABLE"),
    SIMPLE_TABLE("SIMPLE TABLE"),
    USER_TABLE("USER TABLE"),
    TABLE_WITH_PAGES("TABLE WITH PAGES"),
    DIFFERENT_ELEMENTS("DIFFERENT ELEMENTS"),
    PERFORMANCE("PERFORMANCE");

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
