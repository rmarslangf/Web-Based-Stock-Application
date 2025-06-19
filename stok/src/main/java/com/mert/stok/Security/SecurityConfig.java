package com.mert.stok.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                    //CSRF etkinleştirme
                .csrf(csrf -> csrf
                    .ignoringRequestMatchers("/home/stock/**")
                )
                //Default login işlemi
                .formLogin(httpForm -> {
                    httpForm
                            .loginPage("/login")
                            .defaultSuccessUrl("/home", true)
                            .permitAll();
                })
                //Ön giriş entitylerine özel izin
                .authorizeHttpRequests(registry -> {
                    registry.requestMatchers(
                            "/login", 
                            "/req/signup", 
                            "/css/**", 
                            "/js/**", 
                            "/images/**", 
                            "/fonts/**",
                            "/home/stock/**"
                    ).permitAll();
                    registry.anyRequest().authenticated();
                })
                .build();
    }
    //BCrypt aktifleştirme
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}