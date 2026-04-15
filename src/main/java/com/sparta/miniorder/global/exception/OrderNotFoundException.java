package com.sparta.miniorder.global.exception;

import lombok.Getter;

@Getter
public class OrderNotFoundException extends RuntimeException {

    private final ErrorCode errorCode;

    public OrderNotFoundException() {
        super(ErrorCode.ORDER_NOT_FOUND.getMessage());
        this.errorCode = ErrorCode.ORDER_NOT_FOUND;
    }

}
