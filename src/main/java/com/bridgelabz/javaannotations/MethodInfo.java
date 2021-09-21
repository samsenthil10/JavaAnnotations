package com.bridgelabz.javaannotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)

public @interface MethodInfo {

	String author() default "Senthil Kumar S A";
	String date();
	int revision() default 1;
	String comments();
} 