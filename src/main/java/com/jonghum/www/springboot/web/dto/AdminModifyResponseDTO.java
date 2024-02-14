package com.jonghum.www.springboot.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminModifyResponseDTO {
    private String id;
    private String password;
    private String phoneNumber;
    private String postcode;
    private String roadAddress;
    private String jibunAddress;
    private String detailAddress;
    private String extraAddress;
}
