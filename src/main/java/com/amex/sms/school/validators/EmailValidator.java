package com.amex.sms.school.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


/**
 * @author sateesh.gullipalli
 * @project school
 * @created on 30 Oct, 2023
 */
public class EmailValidator implements ConstraintValidator<AmexEmail, String> {
    @Override
    public boolean isValid(final String valueToValidate, final ConstraintValidatorContext context) {
        return valueToValidate != null && valueToValidate.toLowerCase().endsWith("@aexp.com");
    }
}