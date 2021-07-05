package com.nabil.udemy.ecommerce.orderservice.handler;

import com.nabil.udemy.ecommerce.orderservice.mapper.JacksonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import javax.validation.Validator;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Nabil Fawwaz Elqayyim
 */

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ValidationHandler {

    private final Validator validator;

    public <T> Mono<T> requireValidBody(Mono<T> block) {

        return block.flatMap(body -> {
            if (validator.validate(body).isEmpty()) return Mono.just(body); //If pass bean validation
            else { // if not pass bean validation
                List<Map<String, Object>> message = validator.validate(body).stream().map(tConstraintViolation -> {
                    Map<String, Object> errorMap = new HashMap<>();
                    errorMap.put("field", tConstraintViolation.getPropertyPath().toString());
                    errorMap.put("message", tConstraintViolation.getMessageTemplate());
                    return errorMap;
                }).collect(Collectors.toList());
                final ByteArrayOutputStream out = new ByteArrayOutputStream();
                JacksonMapper.writeValue(out, message);
                return Mono.error(new Resource400BadRequestException(out.toString()));
            }
        });
    }
}
