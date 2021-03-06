package com.ayty.fintech.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {
	
	private static final long serialVersionUID = 8506230127194402918L;

	public ResourceNotFoundException(String exception) {
		super(exception);
	}
}
