package com.fiap.techChallenge.config;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Path;
import jakarta.validation.Validator;

@Configuration
public class ValidateForm {
    
    @Autowired
    private Validator validator;
   
    public <T>Map<Path, String> validateForm(T form) {
        Set<ConstraintViolation<T>> violations = validator.validate(form);
        Map<Path, String> violationsToMap = violations.stream()
                                        .collect(Collectors.toMap(
                                            violation -> violation.getPropertyPath(), violation -> violation.getMessage()));
        return violationsToMap;
    }
}
