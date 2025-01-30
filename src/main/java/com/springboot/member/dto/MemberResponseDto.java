package com.springboot.member.dto;

import com.springboot.member.entity.Member;
import lombok.Getter;

@Getter
public class MemberResponseDto {
    private long memberId;
    private String email;
    private String name;
    private String phone;
    private Member.MemberStatus memberStatus;
    //member가 갖고있는 stamp
    private int stampCount;


}
