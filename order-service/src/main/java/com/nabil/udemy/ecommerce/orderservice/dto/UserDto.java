package com.nabil.udemy.ecommerce.orderservice.dto;

import lombok.*;

import java.io.Serializable;

/**
 * @author Nabil Fawwaz Elqayyim
 */

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {

    private static final long serialVersionUID = -4842517195238210791L;

    private Integer id;

    private String name;

    private Integer balance;
}
