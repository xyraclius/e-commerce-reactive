package com.nabil.udemy.ecommerce.productservice.service;

import com.nabil.udemy.ecommerce.productservice.dto.ProductDto;
import com.nabil.udemy.ecommerce.productservice.repository.ProductRepository;
import com.nabil.udemy.ecommerce.productservice.util.EntityDtoUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

/**
 * @author Nabil Fawwaz Elqayyim
 */

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductService {
    private final ProductRepository productRepository;

    private final Sinks.Many<ProductDto> sink;

    public Flux<ProductDto> getAll() {
        return productRepository.findAll().map(EntityDtoUtil::toDto).doOnNext(sink::tryEmitNext);
    }

    public Mono<ProductDto> getProductById(String id) {
        return productRepository.findById(id).map(EntityDtoUtil::toDto);
    }

    public Mono<ProductDto> insertProduct(Mono<ProductDto> productDtoMono) {
        return productDtoMono
                .map(EntityDtoUtil::toEntity)
                .flatMap(productRepository::insert)
                .map(EntityDtoUtil::toDto)
                .doOnNext(sink::tryEmitNext);
    }

    public Mono<ProductDto> updateProduct(String id, Mono<ProductDto> productDtoMono) {
        return productRepository
                .findById(id)
                .flatMap(pe -> productDtoMono.map(EntityDtoUtil::toEntity)
                        .doOnNext(pe2 -> pe2.setId(id)))
                .flatMap(productRepository::save)
                .map(EntityDtoUtil::toDto)
                .doOnNext(sink::tryEmitNext);
    }

    public Mono<Void> deleteProduct(String id) {
        return productRepository.deleteById(id);
    }

    public Flux<ProductDto> getProductByPriceRange(int min, int max) {
        return productRepository.findAllByPriceBetween(Range.closed(min, max)).map(EntityDtoUtil::toDto);
    }
}
