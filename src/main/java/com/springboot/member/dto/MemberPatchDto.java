package com.springboot.member.dto;

import com.springboot.member.entity.Member;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
public class MemberPatchDto {
    @Setter
    private long memberId;

    @NotBlank
    private String name;

    @Pattern(regexp = "^010-\\d{4}-\\d{4}$")
    private String phone;

    private Member.MemberStatus memberStatus;

}
