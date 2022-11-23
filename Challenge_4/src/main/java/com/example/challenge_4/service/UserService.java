package com.example.challenge_4.service;


import com.example.challenge_4.model.LoginModel;
import com.example.challenge_4.model.dto.RegisterModel;

import java.util.Map;

public interface UserService {
    public Map login(LoginModel loginModel);
    Map registerManual(RegisterModel objModel) ;
}
