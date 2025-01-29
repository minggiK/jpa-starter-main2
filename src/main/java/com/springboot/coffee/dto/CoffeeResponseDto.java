package com.springboot.coffee.dto;

import com.springboot.coffee.entity.Coffee;
import lombok.Getter;

@Getter
public class CoffeeResponseDto {

    private long coffeeId;
    private String korName;
    private String engName;
    private int price;
    private Coffee.CoffeeStatus coffeeStatus;

}
