package com.sparta.miniorder.global.exception;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "공통 에러 응답")
public record ErrorResponse(
        @Schema(description = "에러 코드", example = "PRODUCT_NOT_FOUND")
        String code,
        @Schema(description = "에러 메시지", example = "상품을 찾을 수 없습니다.")
        String message,
        @Schema(description = "에러 발생 시각", example = "2026-04-15T12:34:56")
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
