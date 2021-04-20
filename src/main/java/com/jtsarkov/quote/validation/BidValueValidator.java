package com.jtsarkov.quote.validation;

import java.util.Objects;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;

import com.jtsarkov.quote.annotation.BidConstraint;

public class BidValueValidator implements ConstraintValidator<BidConstraint, Double> {

  private String bidPropertyName;
  private String askPropertyName;

  @Override
  public void initialize(BidConstraint constraintAnnotation) {
    bidPropertyName = constraintAnnotation.bidPropertyName();
    askPropertyName = constraintAnnotation.askPropertyName();
  }

  @Override
  public boolean isValid(Double value, ConstraintValidatorContext context) {
    Double askValue = (Double) new BeanWrapperImpl(value).getPropertyValue(askPropertyName);
    Double bidValue = (Double) new BeanWrapperImpl(value).getPropertyValue(bidPropertyName);
    // в предположении, что askValue != null (см. QuoteInputModel)
    return Objects.isNull(bidValue) || askValue > bidValue;
  }
}
