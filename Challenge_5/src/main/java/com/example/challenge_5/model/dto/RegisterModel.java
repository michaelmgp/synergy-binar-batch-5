package com.example.challenge_5.model.dto;

import lombok.Data;

@Data
public class RegisterModel {

    public Long id;

    public String email;

    public String username;

    public String password;

    public String fullname;

    public String role;

}
