package com.example.challenge_4.validation_pass.web;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ApiResponse {

    private Object data;
    private String message;
    private boolean error = true;

    public ApiResponse(Object data, String message){
        this.data = data;
        this.message = message;
    }
}
