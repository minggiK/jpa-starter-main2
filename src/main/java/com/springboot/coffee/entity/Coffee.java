package com.springboot.coffee.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

//entity 설정
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Coffee {
    //기본키
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long coffeeId;

    @Column(nullable = false, length = 100)
    private String korName;

    @Column(nullable = false, length = 100)
    private String engName;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false, unique = true, length = 3)
    private String coffeeCode;

    @Enumerated(value = EnumType.STRING)
    private CoffeeStatus coffeeStatus = CoffeeStatus.COFFEE_FOR_SALE;

    //커피 상태
    public enum CoffeeStatus{
        COFFEE_FOR_SALE("판매중"),
        COFFEE_SOLD_OUT("품절");

        @Getter
        private String status;

        //setter
        CoffeeStatus(String status) {
            this.status = status;
        }

    }
}

