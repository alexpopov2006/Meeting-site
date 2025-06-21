package com.meetingsite.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable() // Отключаем CSRF для простоты (для RESTful API)
                .authorizeHttpRequests()
                .requestMatchers("/api/auth/**", "/swagger-ui/**", "/v3/api-docs/**").permitAll() // Разрешаем доступ к auth и Swagger
                .anyRequest().authenticated() // Все остальные требуют аутентификации
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS); // Отключаем сессии

        // Если вы используете Basic Authentication с пользователями из application.yml,
        // Spring Boot автоматически настроит UserDetailsService на основе этих свойств.
        // Если вы будете использовать свою реализацию UserDetailsService для базы данных,
        // вам нужно будет добавить ее сюда или настроить AuthenticationProvider.

        return http.build();
    }

    // Этот бин UserDetailsService нужен, если вы не используете свою
    // реализацию UserDetailsService и хотите определить пользователей
    // программно. Если у вас есть пользователи в application.yml,
    // Spring Boot автоконфигурирует UserDetailsService.
    // Если вы будете использовать JWT с UserDetailsService на основе базы данных,
    // этот бин вам не понадобится, и его нужно будет удалить.
    // @Bean
    // public UserDetailsService userDetailsService() {
    //     UserDetails user = User.withDefaultPasswordEncoder() // В продакшене используйте PasswordEncoder
    //             .username("admin")
    //             .password("admin")
    //             .roles("ADMIN") // Добавляем роль ADMIN
    //             .build();
    //     return new InMemoryUserDetailsManager(user);
    // }
}
