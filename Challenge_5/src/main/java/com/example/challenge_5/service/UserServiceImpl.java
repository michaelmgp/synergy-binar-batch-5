package com.example.challenge_5.service;
import com.example.challenge_5.model.dto.LoginModel;
import com.example.challenge_5.model.dto.RegisterModel;
import com.example.challenge_5.model.security.Role;
import com.example.challenge_5.model.security.User;
import com.example.challenge_5.repositories.security.RoleRepository;
import com.example.challenge_5.repositories.security.UserRepository;
import com.example.challenge_5.service.interfaces.UserService;
import com.example.challenge_5.utils.Config;
import com.example.challenge_5.utils.ResponseGlobal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    @Value("${BASEURL}")
    private String baseUrl;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    public ResponseGlobal templateResponse;





    Config config = new Config();
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public Map login(LoginModel loginModel) {
        /**
         * bussines logic for login here
         * **/
        try {
            Map<String, Object> map = new HashMap<>();

            User checkUser = userRepository.findOneByUsername(loginModel.getUsername());

            if ((checkUser != null) && (encoder.matches(loginModel.getPassword(), checkUser.getPassword()))) {
                if (!checkUser.isEnabled()) {
                    map.put("is_enabled", checkUser.isEnabled());
                    return templateResponse.templateEror(map);
                }
            }
            if (checkUser == null) {
                return templateResponse.notFound("user not found");
            }
            if (!(encoder.matches(loginModel.getPassword(), checkUser.getPassword()))) {
                return templateResponse.templateEror("wrong password");
            }
            String url = baseUrl + "/oauth/token?username=" + loginModel.getUsername() +
                    "&password=" + loginModel.getPassword() +
                    "&grant_type=password" +
                    "&client_id=my-client-web" +
                    "&client_secret=password";
            ResponseEntity<Map> response = restTemplateBuilder.build().exchange(url, HttpMethod.POST, null, new
                    ParameterizedTypeReference<Map>() {
                    });

            if (response.getStatusCode() == HttpStatus.OK) {
                User user = userRepository.findOneByUsername(loginModel.getUsername());
                List<String> roles = new ArrayList<>();

                for (Role role : user.getRoles()) {
                    roles.add(role.getName());
                }
                //save token
//                checkUser.setAccessToken(response.getBody().get("access_token").toString());
//                checkUser.setRefreshToken(response.getBody().get("refresh_token").toString());
//                userRepository.save(checkUser);

                map.put("access_token", response.getBody().get("access_token"));
                map.put("token_type", response.getBody().get("token_type"));
                map.put("refresh_token", response.getBody().get("refresh_token"));
                map.put("expires_in", response.getBody().get("expires_in"));
                map.put("scope", response.getBody().get("scope"));
                map.put("jti", response.getBody().get("jti"));

                return map;
            } else {
                return templateResponse.notFound("user not found");
            }
        } catch (HttpStatusCodeException e) {
            e.printStackTrace();
            if (e.getStatusCode() == HttpStatus.BAD_REQUEST) {
                return templateResponse.templateEror("invalid login");
            }
            return templateResponse.templateEror(e);
        } catch (Exception e) {
            e.printStackTrace();

            return templateResponse.templateEror(e);
        }
    }

    @Override
    public Map registerManual(RegisterModel objModel) {
        Map map = new HashMap();
        try{
            String [] roleNames = {"ROLE_USER", "ROLE_READ", "ROLE_WRITE"};
            User user = new User();
            user.setUsername(objModel.getEmail().toLowerCase());
            user.setFullname(objModel.getFullname());
            String password= encoder.encode(objModel.getPassword().replaceAll("\\s+", ""));
            List<Role> roleList = roleRepository.findByNameIn(roleNames);
            user.setRoles(roleList);
            user.setPassword(password);
            User userSave = userRepository.save(user);
            return templateResponse.templateSukses(userSave);
        }catch (Exception e){
            logger.error("Error register= "+ e);
            return templateResponse.templateEror(e.getMessage());
        }
    }

}




