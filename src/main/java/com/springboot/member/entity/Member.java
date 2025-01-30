package com.springboot.member.entity;

import com.springboot.audit.Auditable;
import com.springboot.order.entity.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class Member extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long memberId;

    @Column(nullable = false, unique = true, updatable = false)
    private String email;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 13)
    private String phone;

    @Enumerated(value = EnumType.STRING)
    private MemberStatus memberStatus = MemberStatus.MEMBER_ACTIVITY;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();

    //stamp, member : 1대1 관계
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stamp_id")
    private Stamp stamp;

    //영속성 전이
    public void setOrders(Order order) {
        //member가 갖고있는 order가 없으면 생성
    if(order.getMember() != this) {
        order.setMember(this);
    }
    this.orders.add(order);



    }

    public enum MemberStatus {
        MEMBER_ACTIVITY("활동중"),
        MEMBER_SLEEP("휴면 상태"),
        MEMBER_QUIT("탈퇴 상태");

        @Getter
        private String status;

        MemberStatus(String status) {
            this.status = status;
        }
    }

}
