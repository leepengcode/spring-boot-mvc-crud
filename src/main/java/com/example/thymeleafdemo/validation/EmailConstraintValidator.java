package com.example.thymeleafdemo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailConstraintValidator implements ConstraintValidator<EmailCustome, String> {

    private String coursePrefix;

    @Override
    public void initialize(EmailCustome theEmail) {
        coursePrefix = theEmail.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
    // boolean result = theCode.startsWith(coursePrefix);
//        if (theCode == null) {
//            return false; // Or true, depending on your requirements
//        }else {
//            return theCode.startsWith(coursePrefix);
//        }

        boolean result;

        if(theCode != null) {
            result = theCode.endsWith(coursePrefix);
        }else {
            result = false;
        }
        return result;
    // theCode the value that user input in html form
    //  theConstraintValidatorContext message (We can replace message here)
    }
}
