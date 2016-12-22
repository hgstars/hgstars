package com.hgstars.examples.bootapi.service.exception;

/**
 * Created by yujindong on 16/12/7.
 */
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 3484757027541306604L;

    public ErrorCode errorCode;

    public ServiceException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
