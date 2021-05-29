package com.nabil.udemy.ecommerce.userservice.repository;

import com.nabil.udemy.ecommerce.userservice.entity.UserEntity;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * @author Nabil Fawwaz Elqayyim
 */

@Repository
public interface UserRepository extends ReactiveCrudRepository<UserEntity, Integer> {

    @Modifying
    @Query("update users set balance = balance - :amount where id= :id and balance >= :amount")
    Mono<Boolean> updateUserEntityBalance(int id, int amount);
}
