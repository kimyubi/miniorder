package com.sparta.miniorder.dto.response;

import java.time.LocalDateTime;

import com.sparta.miniorder.exception.ErrorCode;

public record ErrorResponse(
        String code,
        String message,
        LocalDateTime timestamp
) {

    public static ErrorResponse from(ErrorCode errorCode) {
        return new ErrorResponse(
                errorCode.getCode(),
                errorCode.getMessage(),
                LocalDateTime.now()
        );
    }

    public static ErrorResponse of(String code, String message) {
        return new ErrorResponse(code, message, LocalDateTime.now());
    }
}
