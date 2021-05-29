package com.nabil.udemy.ecommerce.productservice.util;

import com.nabil.udemy.ecommerce.productservice.dto.ProductDto;
import com.nabil.udemy.ecommerce.productservice.entity.ProductEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Nabil Fawwaz Elqayyim
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EntityDtoUtil {

    public static ProductDto toDto(ProductEntity productEntity) {
        return ProductDto.builder()
                .id(productEntity.getId())
                .description(productEntity.getDescription())
                .price(productEntity.getPrice())
                .build();
    }

    public static ProductEntity toEntity(ProductDto productDto) {
        return ProductEntity.builder()
                .id(productDto.getId())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .build();
    }
}
