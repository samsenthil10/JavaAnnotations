package com.bridgelabz.javaannotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationExample {

	@Override
	@MethodInfo(author = "Senthil Kumar S A", comments = "Main method", date = "Nov 22 2021", revision = 1)
	public String toString() {
		return "Overridden toString method";
	}

	@Deprecated
	@MethodInfo(comments = "deprecated method", date = "Nov 22 2021")
	public static void oldMethod() {
		System.out.println("old method, don't use it.");
	}

	public static void main(String[] args) {
		try {
			for (Method method : AnnotationExample.class.getMethods()) {
				if (method.isAnnotationPresent(MethodInfo.class)) {
					try {
						for (Annotation annotation : method.getDeclaredAnnotations()) {
							System.out.println("Annotation in Method '" + method + "' : " + annotation);
						}
						MethodInfo methodAnnotation = method.getAnnotation(MethodInfo.class);
						if (methodAnnotation.revision() == 1) {
							System.out.println("Method with revision no 1 = " + method);
						}
					} catch (Throwable ex) {
						ex.printStackTrace();
					}
				}
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
} 