package com.joelmaciel.inventory.Utils;

import com.joelmaciel.inventory.domain.entities.Category;

public final class MockCategoryUtil {

    private MockCategoryUtil() {}

    public static Category getMockCategory() {
        return Category.builder()
                .id(1L)
                .name("Category Test One")
                .description("Description Test")
                .build();
    }

    public static Category getMockCategoryTwo() {
        return Category.builder()
                .id(2L)
                .name("Category Test Two")
                .description("Description Test Two")
                .build();
    }
}
