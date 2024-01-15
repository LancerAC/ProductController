package com.example.productcontroller.Service;

import com.example.productcontroller.DTO.ProductDTO;
import com.example.productcontroller.Entity.Category;
import com.example.productcontroller.Entity.Product;
import com.example.productcontroller.Repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
@SpringBootTest
@Transactional
class ProductServiceTest {


    @Autowired
    private ProductService productService;


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
    @Test
    public void testCreateProduct() {
        ProductDTO productDTO = ProductDTO.builder()
                .categoryId(2L)
                .amount((short) 47)
                .name("Cereza")
                .build();

        Product products = productService.create(productDTO);

        assertEquals("Cereza", products.getName());

    }
    @Test
    void readAll() {
        List<Product> products = productService.readAll();
        assertTrue(!products.isEmpty());
    }

    @Test
    void readByCategoryId() {
        List<Product> product = productService.readByCategoryId(2L);
        assertTrue(!product.isEmpty());
    }
}