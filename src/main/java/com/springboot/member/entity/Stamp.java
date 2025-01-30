package com.springboot.member.entity;

import com.springboot.audit.Auditable;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Stamp extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long stampId;

    @Column(nullable = false)
    private int stampCount;

    //커피 주문될때, 주문 수량 만큼 stampCount 변경
    public void setStampCount(int quantity) {
        this.stampCount += quantity;
    }
}
