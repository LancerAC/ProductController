package com.example.productcontroller.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ProductDTO {
    //DTO (Data Transfer Object) в веб-разработке на Spring Boot представляет собой объект,
    // который используется для передачи данных между слоями приложения или между клиентом и сервером.
    // DTO обычно используется для инкапсуляции данных,
    // которые должны быть переданы между различными частями приложения,
    // чтобы избежать прямого доступа к внутренним объектам или сущностям.
    private String name;
    private Short amount;
    private Long categoryId;
}
