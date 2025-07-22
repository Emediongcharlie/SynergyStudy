package com.synergystudy.synergystudy.securityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.synergystudy.synergystudy.services.CustomUserDetailsService;

    @Configuration
//@EnableWebSecurity
public class ConfigSecurity {


    @Autowired
    CustomUserDetailsService userDetailsService;

        @Bean
        public BCryptPasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

        @Bean
        public DaoAuthenticationProvider authenticationProvider() {
            DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
            provider.setUserDetailsService(userDetailsService);
            provider.setPasswordEncoder(passwordEncoder());
            return provider;
        }


        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http.authorizeHttpRequests(configurer -> configurer
                    .requestMatchers(HttpMethod.POST, "/api/register/admin/").permitAll()
                    .requestMatchers(HttpMethod.GET, "/api/register/student/").permitAll()
                    .requestMatchers(HttpMethod.POST, "/api/register/instructor/").permitAll()
                    .requestMatchers(HttpMethod.GET, "/api/login/admin/").permitAll()
                    .requestMatchers(HttpMethod.GET, "/api/login/student/").permitAll()
                    .requestMatchers(HttpMethod.GET, "/api/login/instructor/").permitAll()

                    // .requestMatchers(HttpMethod.GET, "/api/get-all-courses").hasAnyRole("STUDENT", "ADMIN")

                    // .requestMatchers(HttpMethod.GET, "/api/remove-instructor").hasRole("ADMIN")

                    .anyRequest().authenticated()
            );

            http.httpBasic(Customizer.withDefaults());
            http.csrf(csrf -> csrf.disable());

            return http.build();
        }

}
