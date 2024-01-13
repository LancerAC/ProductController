package com.example.productcontroller.Service;

import com.example.productcontroller.DTO.ProductDTO;
import com.example.productcontroller.Entity.Product;
import com.example.productcontroller.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    //Service классы:
    //   - Содержат бизнес-логику приложения. Здесь реализуются операции с данными,
    //   проведение бизнес-процессов и другие операции,
    //   не связанные с обработкой HTTP запросов.

    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    public Product create(ProductDTO productDTO){
        Product product = Product
                .builder()
                .name(productDTO.getName())
                .amount(productDTO.getAmount())
                .category(categoryService.findCategoryById(productDTO.getCategoryId()))
                .build();

        return productRepository.save(product);
    }

    public List<Product> readAll(){
        return productRepository.findAll();
    }

    public List<Product> readByCategoryId(Long id){
        return productRepository.findByCategoryId(id);
    }

    public Product update(Product product){
        return productRepository.save(product);
    }
    public void deleteById(Long id){
        productRepository.deleteById(id);
    }




}
