package com.example.demo.Config;

import com.example.demo.Security.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtFilter;

    public SecurityConfig(JwtAuthenticationFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable()) // Can be replaced with method reference
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/Register/**", "/Login/**",
////                                "PasswordReSet/{email}/**",
//                                "/checking/**" , "/PasswordReSet2/{email}/**").permitAll()
//                        .anyRequest().authenticated()
//                );
//
//        return http.build();
//    }
//
//@Bean
//public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//    http
//            .csrf(csrf -> csrf.ignoringRequestMatchers("/api/**")) // CSRF enforced except API
//            .authorizeHttpRequests(auth -> auth
//                    .requestMatchers("/Register/**", "/Login/**",
//                            "/PasswordReSet/**", "/PasswordReSet2/**",
//                            "/checking/**", "/api/**").permitAll()
//                    .anyRequest().authenticated()
//            );
//
//    return http.build();
//}

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Best for REST APIs
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/**").permitAll()  // allow all API endpoints
                        .anyRequest().authenticated()            // everything else needs auth
                );

        return http.build();
    }

}
