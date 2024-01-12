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
    private final ProductRepository productRepository;

    public Product create(ProductDTO productDTO){
        Product product = Product
                .builder()
                .name(productDTO.getName())
                .amount(productDTO.getAmount())
                .build();

        return productRepository.save(product);
    }

    public List<Product> readAll(){
        return productRepository.findAll();
    }

    public Product update(Product product){
        return productRepository.save(product);
    }
    public void deleteById(Long id){
        productRepository.deleteById(id);
    }
}
