package com.jtsarkov.quote.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;

import com.jtsarkov.quote.validation.BidValueValidator;

@Constraint(validatedBy = BidValueValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface BidConstraint {

  String message() default "Bid value must be less then ask value";

  String bidPropertyName() default "bid";

  String askPropertyName() default "ask";
}
