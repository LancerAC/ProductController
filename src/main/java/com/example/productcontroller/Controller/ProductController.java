package com.example.productcontroller.Controller;

import com.example.productcontroller.DTO.ProductDTO;
import com.example.productcontroller.Entity.Product;
import com.example.productcontroller.Service.ProductService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/products")
@RequiredArgsConstructor
@RestController
public class ProductController {
    //Controller классы:
    //Обрабатывают HTTP запросы и управляют

    private final ProductService productService;
    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductDTO productDTO){
        return new ResponseEntity<>(productService.create(productDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> readAll(){
        return new ResponseEntity<>(productService.readAll(), HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<Product> update(@RequestBody Product product){
        return new ResponseEntity<>(productService.update(product), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public HttpStatus deleteById(@PathVariable Long id){
        productService.deleteById(id);
        return HttpStatus.OK;
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<Product>> findByCategoryId(@PathVariable Long id){
        return new ResponseEntity<>(productService.readByCategoryId(id), HttpStatus.OK);
    }
}
