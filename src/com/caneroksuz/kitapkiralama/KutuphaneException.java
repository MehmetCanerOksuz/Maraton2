package com.caneroksuz.kitapkiralama;

public class KutuphaneException extends Exception {

	private String message;

	public KutuphaneException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
