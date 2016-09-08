package com.weather.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No cities found under your request")
public class PageErrorException extends NullPointerException{
	private static final long serialVersionUID =3935230281455340039L;
}
