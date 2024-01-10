package com.joelmaciel.inventory.domain.services.impl;

import com.joelmaciel.inventory.api.dtos.response.CategoryDTO;
import com.joelmaciel.inventory.domain.entities.Category;
import com.joelmaciel.inventory.domain.repository.CategoryRepository;
import com.joelmaciel.inventory.domain.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll(String name) {
        List<Category> listCategories = findListCategories(name);
        return listCategories.stream()
                .map(this::toDTO)
                .toList();
    }

    private List<Category> findListCategories(String name) {
        List<Category> categoryList;
        if (name != null) {
            categoryList = categoryRepository.findByNameContaining(name);
        } else {
            categoryList = categoryRepository.findAll();
        }
        return categoryList;
    }

    private CategoryDTO toDTO(Category category) {
        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .build();
    }
}
