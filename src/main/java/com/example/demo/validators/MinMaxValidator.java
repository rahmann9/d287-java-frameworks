package com.example.demo.validators;

import com.example.demo.domain.Part;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MinMaxValidator implements ConstraintValidator<ValidMinMax, Part> {

    @Override
    public void initialize(ValidMinMax constraintAnnotation) {}

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();

        boolean valid = true;

        if (part.getInv() < part.getMinInv()) {
            context.buildConstraintViolationWithTemplate("Inventory must be greater than min.").addConstraintViolation();
            valid = false;
        }
        if (part.getInv() > part.getMaxInv()) {
            context.buildConstraintViolationWithTemplate("Inventory must be less than max.").addConstraintViolation();
            valid = false;
        }

        return valid;
    }
}