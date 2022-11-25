package com.example.challenge_4.controller;

import com.example.challenge_4.model.dto.RegisterModel;
import com.example.challenge_4.model.securiy.User;
import com.example.challenge_4.repositories.UserRepository;
import com.example.challenge_4.service.UserService;
import com.example.challenge_4.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user-register/")
public class RegisterController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    public UserService serviceReq;

    @Autowired
    public ResponseGlobal responseGlobal;

    @Autowired
    public EmailTemplate emailTemplate;

    @Autowired
    public EmailSender emailSender;

    @Value("${expired.token.password.minute}")
    private Integer expiredToken;


    @Autowired
    Config config;
    @Value("${BASEURL:}")//FILE_SHOW_RUL
    private String BASEURL;





    @PostMapping("/register")
    public ResponseEntity<Map> saveRegister(@Valid @RequestBody RegisterModel registerModel) throws RuntimeException{
        Map map = new HashMap();

        User user = userRepository.checkExistingEmail(registerModel.getEmail());
        if(user!=null){
            return new ResponseEntity<Map>(responseGlobal.notFound("Username Has been Registered"), HttpStatus.OK);
        }
        map = serviceReq.registerManual(registerModel);
        Map senOtp = sendEmailegister(registerModel);
        return new ResponseEntity<Map>(map, HttpStatus.OK);

    }

    @PostMapping("/send-otp")//send OTP
    public Map sendEmailegister(
            @RequestBody RegisterModel user) {
        String message = "Thanks, please check your email for activation.";

        if (user.getEmail() == null) return responseGlobal.templateEror("No email provided");
        User found = userRepository.findOneByUsername(user.getEmail());
        if (found == null) return responseGlobal.notFound("Email not found"); //throw new BadRequest("Email not found");

        String template = emailTemplate.getRegisterTemplate();
        if (StringUtils.isEmpty(found.getOtp())) {
            User search;
            String otp;
            do {
                otp = SimpleStringUtils.randomString(6, true);
                search = userRepository.findOneByOTP(otp);
            } while (search != null);
            Date dateNow = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateNow);
            calendar.add(Calendar.MINUTE, expiredToken);
            Date expirationDate = calendar.getTime();

            found.setOtp(otp);
            found.setOtpExpiredDate(expirationDate);
            template = template.replaceAll("\\{\\{USERNAME}}", (found.getFullname() == null ? found.getUsername1() : found.getFullname()));
            template = template.replaceAll("\\{\\{VERIFY_TOKEN}}",  otp);
            userRepository.save(found);
        } else {
            template = template.replaceAll("\\{\\{USERNAME}}", (found.getFullname() == null ? found.getUsername1() : found.getFullname()));
            template = template.replaceAll("\\{\\{VERIFY_TOKEN}}",  found.getOtp());
        }
        emailSender.sendAsync(found.getUsername(), "Register", template);
        return responseGlobal.templateSukses(message);
    }

    @GetMapping("/register-confirm-otp/{token}")
    public ResponseEntity<Map> saveRegisterManual(@PathVariable(value = "token") String tokenOtp) throws RuntimeException {


        User user = userRepository.findOneByOTP(tokenOtp);
        if (null == user) {
            return new ResponseEntity<Map>(responseGlobal.templateEror("OTP tidak ditemukan"), HttpStatus.OK);
        }
        String today = config.convertDateToString(new Date());

        String dateToken = config.convertDateToString(user.getOtpExpiredDate());
        if(Long.parseLong(today) > Long.parseLong(dateToken)){
            return new ResponseEntity<Map>(responseGlobal.templateEror("Your token is expired. Please Get token again."), HttpStatus.OK);
        }
        //update user
        user.setEnabled(true);
        userRepository.save(user);

        return new ResponseEntity<Map>(responseGlobal.templateEror("Sukses, Silahkan Melakukan Login"), HttpStatus.OK);
    }

    @PostMapping("/register-tymeleaf")
    public ResponseEntity<Map> saveRegisterManualTymeleaf(@RequestBody RegisterModel objModel) throws RuntimeException {
        Map map = new HashMap();

        User user = userRepository.checkExistingEmail(objModel.getEmail());
        if (null != user) {
            return new ResponseEntity<Map>(responseGlobal.notFound("Username sudah ada"), HttpStatus.OK);

        }
        map = serviceReq.registerManual(objModel);

        Map sendOTP = sendEmailegisterTymeleaf(objModel);

        return new ResponseEntity<Map>(map, HttpStatus.OK);
    }

    @PostMapping("/send-otp-tymeleaf")//send OTP
    public Map sendEmailegisterTymeleaf(@RequestBody RegisterModel user) {
        String message = "Thanks, please check your email for activation.";

        if (user.getEmail() == null) return responseGlobal.templateEror("No email provided");
        User found = userRepository.findOneByUsername(user.getEmail());
        if (found == null) return responseGlobal.notFound("Email not found"); //throw new BadRequest("Email not found");

        String template = emailTemplate.getRegisterTemplate();
        if (StringUtils.isEmpty(found.getOtp())) {
            User search;
            String otp;
            do {
                otp = SimpleStringUtils.randomString(6, true);
                search = userRepository.findOneByOTP(otp);
            } while (search != null);
            Date dateNow = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateNow);
            calendar.add(Calendar.MINUTE, expiredToken);
            Date expirationDate = calendar.getTime();

            found.setOtp(otp);
            found.setOtpExpiredDate(expirationDate);
            template = template.replaceAll("\\{\\{USERNAME}}", (found.getFullname() == null ? found.getUsername1() : found.getFullname()));
            template = template.replaceAll("\\{\\{VERIFY_TOKEN}}", BASEURL + "user-register/web/index/"+ otp);
            userRepository.save(found);
        } else {
            template = template.replaceAll("\\{\\{USERNAME}}", (found.getFullname() == null ? found.getUsername1() : found.getFullname()));
            template = template.replaceAll("\\{\\{VERIFY_TOKEN}}", BASEURL + "user-register/web/index/"+  found.getOtp());
        }
        emailSender.sendAsync(found.getUsername(), "Register", template);
        return responseGlobal.templateSukses(message);
    }


}
