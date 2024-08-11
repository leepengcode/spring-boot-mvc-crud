package com.example.thymeleafdemo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = EmailConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailCustome {

    // define default CourseCode
    public String value()  default "@gmail.com";
    // define default message
    public String message() default "must end with @gmail.com";
    // define default groups
    public Class<?>[] groups() default {};
    // define default payload ( provide custom details about validation failure)
    public Class<? extends Payload>[] payload() default {};

}
