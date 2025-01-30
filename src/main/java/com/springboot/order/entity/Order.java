package com.springboot.order.entity;

import com.springboot.audit.Auditable;
import com.springboot.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Order extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus = OrderStatus.ORDER_REQUEST;

    //member, order 1대다 관계
    @ManyToOne
    @JoinColumn(name = "member-id")
    private Member member;


    //member - 영속성 전이
    public void setMember(Member member){
        //기존의 member가 맞으면 생성
        this.member = member;

        //기존의 member가 갖고있는 order의 member가 아니면
        if(!member.getOrders().contains(this)){
            member.setOrders(this);
        }

    }

    public enum OrderStatus{
        ORDER_REQUEST(1, "주문 요청"),
        ORDER_CONFIRM(2, "주문 확정"),
        ORDER_COMPLETE(3, "주문 처리 완료"),
        ORDER_CANCEL(4, "주문 취소");

        @Getter
        private int codeNumber;

        @Getter
        private String status;

        OrderStatus(int codeNumber, String status) {
            this.codeNumber =codeNumber;
            this.status = status;
        }
    }
}
