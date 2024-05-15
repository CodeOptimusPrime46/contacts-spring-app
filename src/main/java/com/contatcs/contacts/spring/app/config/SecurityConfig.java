package com.contatcs.contacts.spring.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public static SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests((authorizeRequests) -> {
                authorizeRequests
                    .requestMatchers("/").permitAll()
                    .requestMatchers("/contact/read-all").hasAuthority("ROLE_ADMIN")
                    .requestMatchers("/contact").authenticated();
            })
            .httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }

    @Bean
    public static UserDetailsService userDetailsService() {
        UserDetails admin = User.builder()
            .username("admin")
            .password(passwordEncoder().encode("password"))
            .roles("USER")
            .build();

        UserDetails kar = User.builder()
            .username("kar")
            .password(passwordEncoder().encode("kar@123"))
            .roles("ADMIN")
            .build();

        return new InMemoryUserDetailsManager(admin, kar);

    }

}
