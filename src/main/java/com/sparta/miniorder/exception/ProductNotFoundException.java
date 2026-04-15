package com.sparta.miniorder.exception;

import lombok.Getter;

@Getter
public class ProductNotFoundException extends RuntimeException {

    private final ErrorCode errorCode;

    public ProductNotFoundException() {
        super(ErrorCode.PRODUCT_NOT_FOUND.getMessage());
        this.errorCode = ErrorCode.PRODUCT_NOT_FOUND;
    }

}
