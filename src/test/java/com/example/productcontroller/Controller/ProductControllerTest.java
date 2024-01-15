package com.example.productcontroller.Controller;

import com.example.productcontroller.DTO.ProductDTO;
import com.example.productcontroller.Entity.Product;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class ProductControllerTest {
    private static final Long PRODUCT_ID = 3L;
    @Autowired
    private ProductController productController;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void create() {
        ProductDTO productDTO = ProductDTO.builder()
                .categoryId(2L)
                .amount((short) 27)
                .name("Rolton")
                .build();
        ResponseEntity<Product> productResponseEntity = productController.create(productDTO);

        assertEquals(HttpStatus.CREATED, productResponseEntity.getStatusCode());
    }

    @Test
    void readAll() {
        ResponseEntity<List<Product>> listResponseEntity = productController.readAll();
        assertEquals(HttpStatus.OK, listResponseEntity.getStatusCode());

    }
    @Test
    void deleteById() {
        HttpStatus httpStatus = productController.deleteById(PRODUCT_ID);

        assertEquals(HttpStatus.OK, httpStatus);
    }

    @Test
    void findByCategoryId() {
        ResponseEntity<List<Product>> byCategoryId = productController.findByCategoryId(PRODUCT_ID);

        assertEquals(HttpStatus.OK, byCategoryId.getStatusCode());
    }
}