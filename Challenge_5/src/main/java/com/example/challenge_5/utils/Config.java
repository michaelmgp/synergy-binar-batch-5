package com.example.challenge_5.utils;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Config {
    public static  String ERROR_401 = "401";
    public static  String ERROR_500 = "500";
    public static  String ERROR_404 = "404";
    public static  String SUCCESS_200 = "200";

    public static String ERROR_400 = "400";

    public String convertDateToString(Date date) {

        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String strDate = dateFormat.format(date);
        return strDate;
    }

    String code = "status", message = "message";
    public String code_notFound ="404";

    public String codeRequired ="403";
    public String isRequired =" is Required";

    public String code_sukses = "200";
    public String code_server = "500";
    public String code_null = "1";
    public String message_sukses = "sukses";





}
