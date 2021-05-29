package com.nabil.udemy.ecommerce.orderservice.service;

import com.nabil.udemy.ecommerce.orderservice.dto.PurchaseOrderResponseDto;
import com.nabil.udemy.ecommerce.orderservice.repository.PurchaseOrderRepository;
import com.nabil.udemy.ecommerce.orderservice.util.EntityDtoUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * @author Nabil Fawwaz Elqayyim
 */

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderQueryService {

    private final PurchaseOrderRepository orderRepository;

    public Flux<PurchaseOrderResponseDto> getProductsByUserId(int userId) {
        return Flux.fromStream(() -> orderRepository.findByUserId(userId).stream())
                .map(EntityDtoUtil::getPurchaseOrderResponseDto)
                .subscribeOn(Schedulers.boundedElastic());
    }
}
