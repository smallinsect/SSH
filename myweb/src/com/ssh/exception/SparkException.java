package com.ssh.exception;

public class SparkException extends Exception {
	private static final long serialVersionUID = 1L;

	private String msg;

    public SparkException(String msg) {
        this.msg = msg;
    }

    @Override
    public String getMessage() {
        return msg;
    }
}
