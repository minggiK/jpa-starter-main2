package com.springboot.coffee.dto;

import lombok.Getter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Pattern;
import java.sql.Struct;

@Getter
public class CoffeePatchDto {

    private long coffeeId;

    @Pattern(regexp = "^([ㄱ-ㅎ가-힣])(\\s?[ㄱ-ㅎ가-힣])*$")
    private String korName;

    @Pattern(regexp = "^([a-zA-z])(\\s?[a-zA-Z])*$")
    private String engName;

    @Range(min = 100, max = 100000)
    private int price;


}
