package com.example.challenge_4.utils;

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

}
