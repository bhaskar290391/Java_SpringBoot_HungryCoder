package com.hungrycoders.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ ElementType.FIELD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EnumValidator.class)  // Specify the validator class
public @interface ValidEnum {

	String message() default "Invalue value of enum";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
	
	Class<? extends Enum<?>> enumClass() ;
}
