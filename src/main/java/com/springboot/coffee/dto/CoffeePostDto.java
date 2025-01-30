package com.springboot.coffee.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
public class CoffeePostDto {
    //유효성검증
    //null, 빈문자열, 공백 X
    @NotBlank
    @Pattern(regexp = "^([ㄱ-ㅎ가-힣])(\\s?[ㄱ-ㅎ가-힣])*$", message = "한글만 입력해주세요.(단어사이에 공백 하나만 가능합니다.)")
    private String korName;

    @NotBlank
    @Pattern(regexp = "^([A-Za-z])(\\s?[A-Za-z])*$", message = "영문만 입력해주세요.(단어사이에 공백 하나만 가능합니다.)")
    private String engName;

    @Range(min = 100, max = 100000)
    private int price;

    @NotBlank
    @Pattern(regexp = "^([a-zA-Z]){3}$")
    private String coffeeCode;
}
