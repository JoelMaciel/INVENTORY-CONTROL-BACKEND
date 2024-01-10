package com.joelmaciel.inventory.domain.services;

import com.joelmaciel.inventory.api.dtos.response.CategoryDTO;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> findAll(String name);
}
