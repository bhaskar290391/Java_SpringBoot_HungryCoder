package com.hungrycoders.payload.response;

public class GenericResponse<T> {

	private String message;

	private T data;

	public GenericResponse(String message, T data) {
		super();
		this.message = message;
		this.data = data;
	}

	public GenericResponse(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "GenericResponse [message=" + message + ", data=" + data + "]";
	}

}
