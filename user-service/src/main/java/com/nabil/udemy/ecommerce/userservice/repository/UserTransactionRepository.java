package com.nabil.udemy.ecommerce.userservice.repository;

import com.nabil.udemy.ecommerce.userservice.entity.UserTransactionEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTransactionRepository extends ReactiveCrudRepository<UserTransactionEntity, Integer> {
}
