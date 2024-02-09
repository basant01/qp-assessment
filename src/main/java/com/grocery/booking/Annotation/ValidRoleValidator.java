package com.grocery.booking.Annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidRoleValidator implements ConstraintValidator<ValidRole, String> {

    @Override
    public void initialize(ValidRole constraintAnnotation) {
    }

    @Override
    public boolean isValid(String role, ConstraintValidatorContext context) {
        // Implement your validation logic here
        return "ADMIN".equals(role) || "USER".equals(role); // Example: Only allow "ADMIN" or "USER" roles
    }
}


