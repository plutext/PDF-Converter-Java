package com.plutext.converter;

import org.apache.http.HttpResponse;

public class ConversionRateLimitException extends ConversionException {

	public ConversionRateLimitException(String msg) {
		super(msg);
	}

	public ConversionRateLimitException(String msg, Exception e, HttpResponse response) {
		super(msg, e, response);
	}

	public ConversionRateLimitException(String msg, HttpResponse response) {
		super(msg, response);
	}
	
	public ConversionRateLimitException(HttpResponse response) {
		super(response);
	}
	
	public ConversionRateLimitException(String msg, Exception e) {
		super(msg, e);
	}

	public ConversionRateLimitException(String msg, Throwable t) {
		super(msg, t);
	}


	
}