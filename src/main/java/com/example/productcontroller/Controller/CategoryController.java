package com.example.productcontroller.Controller;

import com.example.productcontroller.Entity.Category;
import com.example.productcontroller.Service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        return new ResponseEntity<>(categoryService.readAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Category> findCategoryById(@PathVariable Long id){
        return new ResponseEntity<>(categoryService.findCategoryById(id), HttpStatus.OK);
    }

}
