package com.easybytes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

//    @Bean
//    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//
//        // below is the custom security config
//
//
//        http.authorizeHttpRequests()
//                .requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards")
//                .authenticated().requestMatchers("/notices", "/contact").permitAll()
//                .and()
//                .formLogin() // Form Login
//                .and()
//                .httpBasic();  // For REST APIs
//        return http.build();
//
//
//        // Deny all the requests gives -> gives login form (Authenticated) but then gives 403 Forbidden (not Authorized)
//
//		/*http.authorizeHttpRequests().anyRequest()
//									.denyAll().and()
//									.formLogin()
//									.and().httpBasic();
//		return http.build();*/
//
//        // Allow all the requests
//
//		/*
//		http.authorizeHttpRequests().anyRequest().permitAll();
//		return http.build();
//
//		*/
//
//
//    }

    //Lambda DSL for the above code
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards").authenticated()
                        .requestMatchers("/notices", "/contact").permitAll()
                )
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

//    @Bean  // In case of maintenance, we can use this code
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(requests -> requests
//                        .anyRequest().denyAll()
//                )
//                .formLogin(Customizer.withDefaults())
//                .httpBasic(Customizer.withDefaults());
//
//        return http.build();
//    }

//    @Bean  // In case of requirement, we can use this code
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(requests -> requests
//                        .anyRequest().permitAll()
//                )
//                .formLogin(Customizer.withDefaults())
//                .httpBasic(Customizer.withDefaults());
//
//        return http.build();
//    }

}
