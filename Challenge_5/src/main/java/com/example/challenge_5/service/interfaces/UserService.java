package com.example.challenge_5.service.interfaces;


import com.example.challenge_5.model.dto.LoginModel;
import com.example.challenge_5.model.dto.RegisterModel;

import java.util.Map;

public interface UserService {
    public Map login(LoginModel loginModel);
    Map registerManual(RegisterModel objModel) ;
}
