
package com.plutext.converter;

import org.apache.http.HttpResponse;


@SuppressWarnings("serial")
public class ConversionException extends Exception {

	private HttpResponse response;
	
	public ConversionException(String msg) {
		super(msg);
	}

	public ConversionException(String msg, Exception e, HttpResponse response) {
		super(msg, e);
		this.response=response;
	}

	public ConversionException(String msg, HttpResponse response) {
		super(msg);
		this.response=response;
	}
	
	public ConversionException(HttpResponse response) {
		super();
		this.response=response;
	}
	
	public ConversionException(String msg, Exception e) {
		super(msg, e);
	}

	public ConversionException(String msg, Throwable t) {
		super(msg, t);
	}

	public HttpResponse getResponse() {
		return response;
	}

	
}