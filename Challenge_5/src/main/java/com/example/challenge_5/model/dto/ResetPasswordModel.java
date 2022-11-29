package com.example.challenge_5.model.dto;

import lombok.Data;

@Data
public class ResetPasswordModel {
    public String email;
    public String otp;
    public String newPassword;
}
