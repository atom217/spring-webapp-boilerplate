package org.technomonkeys.util;

/**
 * This class is used to wrap JSON requests given to clients.
 * Is used to associate a message code and a message string to JSON objects.
 */
public class ResponseWrapper {
	
	@SuppressWarnings("unused")
	private String code;
	@SuppressWarnings("unused")
	private String message;
	@SuppressWarnings("unused")
	private Object result;
	
	/**
	 * Constructors
	 */
	public ResponseWrapper(){
	}
	
	public ResponseWrapper(String responseCode, String responseMessage, Object responseObject) {
		super();
		this.code = responseCode;
		this.message = responseMessage;
		this.result = responseObject;
	}
	
	/**
	 * Util methods
	 */
	public void createSuccessResponse(Object responseObject) {
		this.code = "200";
		this.message = "Request managed successfully";
		this.result = responseObject;
	}
	
	public void createSuccessResponse(String responseMessage, Object responseObject) {
		this.code = "200";
		this.message = responseMessage;
		this.result = responseObject;
	}
	
	public void createErrorResponse() {
		this.code = "500";
		this.message = "There was an error managing the request";
		this.result = null;
	}
	
	public void createErrorResponse(String responseMessage) {
		this.code = "500";
		this.message = responseMessage;
		this.result = null;
	}
	
	/**
	 * Getters & Setters
	 */
	public void setResponseCode(String responseCode) {
		this.code = responseCode;
	}
	public void setResponseMessage(String responseMessage) {
		this.message = responseMessage;
	}
	public void setResponseObject(Object responseObject) {
		this.result = responseObject;
	}
}