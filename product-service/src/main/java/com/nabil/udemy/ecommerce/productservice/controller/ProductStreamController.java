package com.nabil.udemy.ecommerce.productservice.controller;

import com.nabil.udemy.ecommerce.productservice.dto.ProductDto;
import com.nabil.udemy.ecommerce.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author Nabil Fawwaz Elqayyim
 */

@RestController
@RequestMapping("product")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductStreamController {

    private final Flux<ProductDto> flux;

    @GetMapping(value = "stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ProductDto> getProductUpdates() {
        return flux;
    }

    @GetMapping(value = "stream/all", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ProductDto> all() {
        return flux;
    }
}
