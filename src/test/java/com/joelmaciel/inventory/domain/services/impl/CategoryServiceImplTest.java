package com.joelmaciel.inventory.domain.services.impl;

import com.joelmaciel.inventory.Utils.MockCategoryUtil;
import com.joelmaciel.inventory.api.dtos.response.CategoryDTO;
import com.joelmaciel.inventory.domain.entities.Category;
import com.joelmaciel.inventory.domain.repository.CategoryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryServiceImplTest {

    @Mock
    CategoryRepository categoryRepository;

    @InjectMocks
    CategoryServiceImpl categoryService;

    @Test
    @DisplayName("Given name is null, When findAll is called, Then return all categories")
    void givenNameIsNull_whenFindAllIsCalled_thenReturnAllCategories() {
        Category mockCategory = MockCategoryUtil.getMockCategory();
        Category mockCategoryTwo = MockCategoryUtil.getMockCategoryTwo();

        List<Category> categoryList = Arrays.asList(mockCategory, mockCategoryTwo);
        when(categoryRepository.findAll()).thenReturn(categoryList);

        List<CategoryDTO> categoryDTOList = categoryService.findAll(null);

        assertNotNull(categoryDTOList);
        assertEquals(2, categoryDTOList.size());
        assertEquals("Category Test One", categoryDTOList.get(0).getName());
        assertEquals("Description Test", categoryDTOList.get(0).getDescription());
        assertEquals("Category Test Two", categoryDTOList.get(1).getName());
        assertEquals("Description Test Two", categoryDTOList.get(1).getDescription());

        verify(categoryRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Given name valid, When findAll is called, Then return all categories")
    void givenNameValid_whenFindAllIsCalled_thenReturnAllCategories() {
        Category mockCategoryTwo = MockCategoryUtil.getMockCategoryTwo();
        String name = "Two";
        List<Category> categoryList = Arrays.asList(mockCategoryTwo);
        when(categoryRepository.findByNameContaining(name)).thenReturn(categoryList);


        List<CategoryDTO> categoryDTOList = categoryService.findAll(name);

        assertNotNull(categoryDTOList);
        assertEquals(1, categoryDTOList.size());
        assertEquals("Category Test Two", categoryDTOList.get(0).getName());
        assertEquals("Description Test Two", categoryDTOList.get(0).getDescription());

        verify(categoryRepository, times(1)).findByNameContaining(name);
    }

}