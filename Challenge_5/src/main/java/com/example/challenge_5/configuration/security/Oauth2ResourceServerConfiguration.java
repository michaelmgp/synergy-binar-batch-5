package com.example.challenge_5.configuration.security;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(securedEnabled = true) //secure definition
public class Oauth2ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    /**
     * Manage resource server.
     */
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        super.configure(resources);
    }
//    private static final String SECURED_PATTERN = "/api/**";
    /**
     * Manage endpoints.
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.cors()
                .and()
                .csrf()
                .disable()
                .antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/","/showFile/**","/v1/showFile/**","/v1/upload", "/user-register/**","/swagger-ui/**","/swagger-ui.html","/v3/api-docs/**","/user-login/**",
                        "/forget-password/**", "/oauth/authorize**", "/login**", "/error**")
                .permitAll()
                .antMatchers("/movie/**").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/seat/**").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/customer/save").hasAnyAuthority("ROLE_USER")
                .antMatchers("/customer/update").hasAnyAuthority("ROLE_USER")
                .antMatchers("/customer/get-all").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/screening/get-all").hasAnyAuthority("ROLE_READ")
                .antMatchers("/screening/save").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/screening/update").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/screening/delete/**").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/reservation/save-reservation").hasAnyAuthority("ROLE_USER")
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .permitAll()
        ;
    }
}
