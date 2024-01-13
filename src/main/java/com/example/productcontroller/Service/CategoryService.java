package com.example.productcontroller.Service;

import com.example.productcontroller.Entity.Category;
import com.example.productcontroller.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> readAll(){
        return categoryRepository.findAll();
    }
    public Category findCategoryById(Long id){
        return categoryRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Category not exist"));
    }
}
