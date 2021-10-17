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

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrder implements Serializable {

    private static final long serialVersionUID = -7894099565254677562L;

    @Id
    @GeneratedValue
    private Integer id;

    private String productId;

    private Integer userId;

    private Integer amount;

    private OrderStatus status;
}
