package com.joelmaciel.inventory.api.controller;

import com.joelmaciel.inventory.api.dtos.response.CategoryDTO;
import com.joelmaciel.inventory.domain.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryDTO> getALl(@RequestParam(required = false) String name) {
        return categoryService.findAll(name);
    }
}
