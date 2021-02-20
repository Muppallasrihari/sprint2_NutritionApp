package com.cg.healthify.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CustomerContactException extends RuntimeException{

public CustomerContactException() {
	super();
}
public CustomerContactException(String errMsg) {
	super(errMsg);
}
}
