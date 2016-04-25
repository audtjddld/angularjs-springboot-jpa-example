package com.anntation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.enums.Actions;

@Retention(RetentionPolicy.RUNTIME)
public @interface ProcessInfo {
	String title() default "미입력";

	Actions actions() default Actions.none;
}
