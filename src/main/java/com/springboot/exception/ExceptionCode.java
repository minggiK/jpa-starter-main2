package com.springboot.exception;

import lombok.Getter;

//커스텀 예외코드
public enum ExceptionCode {
    MEMBER_NOT_FOUND(404, "Member not found"),
    MEMBER_EXISTS(409, "Member Exists"),
    COFFEE_NOT_FOUND(404, "Coffee not found"),
    COFFEE_CODE_EXISTS(409, "Coffee Code exists"),
    ORDER_NOT_FOUND(404, "Order not found"),
    CANNOT_ORDER_CHANGE(403, "Order can not change");

    @Getter
    private int codeNumber;

    @Getter
    private String status;

   ExceptionCode(int codeNumber, String status) {
        this.codeNumber = codeNumber;
        this.status = status;
    }

}
