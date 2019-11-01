package com.rushit.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {
	@ExceptionHandler(RuntimeException.class)

	public String errorException(Model model, Exception e) {

		System.out.println(model);
		System.out.println();
		System.out.println(e);

		return "error/exception";

	}
}
