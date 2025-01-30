package com.springboot.member.dto;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
public class MemberPostDto {
    //유효성검사
    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String name;

    @NotBlank
    @Pattern(regexp = "^010-\\d{4}-\\d{4}$")
    private String phone;

}
