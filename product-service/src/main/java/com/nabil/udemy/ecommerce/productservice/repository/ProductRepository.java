package com.nabil.udemy.ecommerce.productservice.repository;

import com.nabil.udemy.ecommerce.productservice.entity.ProductEntity;
import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<ProductEntity, String> {
    Flux<ProductEntity> findAllByPriceBetween(Range<Integer> range);
}
