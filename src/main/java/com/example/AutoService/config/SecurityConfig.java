package com.example.AutoService.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig{

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((requests)  -> requests
//                        .requestMatchers("/", "/product/**", "/autoservice/**").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .formLogin((form) -> form
//                        .loginPage("/login")
//                        .permitAll()
//                )
//                .logout(LogoutConfigurer::permitAll)
//                .csrf(csrf -> csrf.disable()); // отключение CSRF-защиты
//
//        return http.build();
//    }

    // Bean для настройки SecurityFilterChain
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Отключаем CSRF (Cross-Site Request Forgery) защиту, так как приложение использует JWT
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((requests)  -> requests
                        // Разрешаем доступ без аутентификации для определенных URL-ов
                        .requestMatchers("/", "/autoservice/**").permitAll()
                        // Для всех остальных запросов требуем аутентификацию
                        .anyRequest().authenticated()
                )
                .sessionManagement((session) -> session
                        // Устанавливаем политику управления сессиями в STATELESS, так как мы используем токены
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );
        return http.build();
    }

    // Bean для настройки AuthenticationManager
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    // Bean для настройки PasswordEncoder (в данном случае, BCryptPasswordEncoder)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(8);
    }

}