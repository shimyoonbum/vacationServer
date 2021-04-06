package com.metanet.vacation.exception;

public class BadRequestException extends RuntimeException {
    private String errorCode;

    /**
     * default 400 Error
     */
    public BadRequestException() {
        this.errorCode = "400";
    }

    /**
     * Error Code ÁöÁ¤
     * @param code
     */
    public BadRequestException(String code) {
        this.errorCode = code;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
