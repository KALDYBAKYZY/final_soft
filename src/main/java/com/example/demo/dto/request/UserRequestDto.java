package com.example.demo.dto.request;

import lombok.Data;

@Data
public class UserRequestDto {
    private String fullName;
    private String email;
    private String password;
    private String role;
}
