package com.example.challenge_5.controller.thymeleaf;

import com.example.challenge_5.model.security.User;
import com.example.challenge_5.repositories.security.UserRepository;
import com.example.challenge_5.utils.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/user-register/web")
public class RegisterConfim {

    @Autowired
    public UserRepository userRepo;

    Config config = new Config();

    @GetMapping("/index/{tokenotp}")
    public String index(Model model, @PathVariable String  tokenotp) {
        User user = userRepo.findOneByOTP(tokenotp);
        if (null == user) {
            System.out.println("user null: tidak ditemukan");
            model.addAttribute("erordesc", "User not found for code "+tokenotp);
            model.addAttribute("title", "");
            return "page";
        }
        String today =  convertDateToString(new Date());

        String dateToken = config.convertDateToString(user.getOtpExpiredDate());
        if(Long.parseLong(today) > Long.parseLong(dateToken)){
            model.addAttribute("erordesc", "Your token is expired. Please Get token again.");
            model.addAttribute("title", "");
            return "page";
        }
        user.setEnabled(true);
        userRepo.save(user);
        model.addAttribute("title", "Congratulations, "+user.getUsername()+", you have successfully registered.");
        model.addAttribute("erordesc", "");
        return "page";
    }

    @GetMapping(value = "/user1")
    public String index() {
        return "user";
    }

    @RequestMapping(value = "/user")
    public Principal user(Principal principal) {

        return  principal;
    }

    public String convertDateToString(Date date) {

        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String strDate = dateFormat.format(date);
//        System.out.println("Date: " + strDate);
        return strDate;
    }
}
