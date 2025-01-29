package com.springboot.exception;

import lombok.Getter;

//비즈니스 로직에서 발생하는 예외 처리
 //RuntimeException : 언체크 예외
public class BusinessLogicException extends RuntimeException{

    @Getter
    private ExceptionCode exceptionCode;

    //생성자
    public BusinessLogicException(ExceptionCode exceptionCode) {
        //super() -> 부모 클래스인 RuntimeException의 생성자를 호출하는 코드
            //ExceptionCode의 예외 메세지를 가져옴
        super(exceptionCode.getStatus());
        this.exceptionCode = exceptionCode;
    }

}
