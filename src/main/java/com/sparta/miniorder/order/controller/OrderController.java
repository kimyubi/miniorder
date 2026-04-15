package com.sparta.miniorder.order.controller;

import com.sparta.miniorder.global.exception.ErrorResponse;
import com.sparta.miniorder.order.dto.request.RequestOrder;
import com.sparta.miniorder.order.dto.response.ResponseOrder;
import com.sparta.miniorder.order.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
@Tag(name = "Orders", description = "주문 관리 API")
public class OrderController {

    private final OrderService orderService;

    @Operation(summary = "주문 생성", description = "상품 ID와 수량으로 주문을 생성합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "주문 생성 성공"),
            @ApiResponse(
                    responseCode = "400",
                    description = "잘못된 요청 값",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "상품을 찾을 수 없음",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            )
    })
    @PostMapping
    public ResponseEntity<ResponseOrder> createOrder(@Valid @RequestBody RequestOrder requestOrder) {
        ResponseOrder responseOrder = orderService.createOrder(requestOrder);
        return ResponseEntity.created(URI.create("/api/orders/" + responseOrder.orderId())).body(responseOrder);
    }

    @Operation(summary = "주문 조회", description = "주문 ID로 주문을 조회합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "주문 조회 성공"),
            @ApiResponse(
                    responseCode = "404",
                    description = "주문을 찾을 수 없음",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            )
    })
    @GetMapping("/{id}")
    public ResponseEntity<ResponseOrder> getOrder(@PathVariable Long id) {
        ResponseOrder responseOrder = orderService.getOrder(id);
        return ResponseEntity.ok(responseOrder);
    }
}
