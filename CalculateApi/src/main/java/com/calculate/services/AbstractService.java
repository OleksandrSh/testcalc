package com.calculate.services;

import com.google.gson.JsonObject;

public class AbstractService {
	
	public static final String SUCCESS_TRUE = "{\"success\": \"true\"}";
	
	protected String createErrorMessage(String result) {
		JsonObject errorObject = new JsonObject();
		errorObject.addProperty("errorMessage", result);
		return errorObject.toString();
	}
	
	protected String createSuccessMessage(String result) {
		JsonObject errorObject = new JsonObject();
		errorObject.addProperty("success", result);
		return errorObject.toString();
	}	

	protected String createSuccessMessage() {
		return createSuccessMessage(Boolean.TRUE.toString());
	}	
	
}
