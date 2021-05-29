package com.nabil.udemy.ecommerce.orderservice.entity;

import com.nabil.udemy.ecommerce.orderservice.dto.OrderStatus;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Nabil Fawwaz Elqayyim
 */

@Data
@Entity
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrder implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    private String productId;
    private Integer userId;
    private Integer amount;
    private OrderStatus status;
}
