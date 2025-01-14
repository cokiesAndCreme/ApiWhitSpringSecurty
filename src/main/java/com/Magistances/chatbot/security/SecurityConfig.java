package com.Magistances.chatbot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        return httpSecurity
//                .csrf(config -> config.disable())
//                .authorizeHttpRequests(aut -> {
//                    aut.requestMatchers("dates/getdates").permitAll();
//                    aut.anyRequest().authenticated();
//                        }
//                )
//                .sessionManagement(session ->{
//                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//                })
    //   }
}
