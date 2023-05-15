package com.project.coches.config;

import com.project.coches.security.JWTAuthFilter;
import com.project.coches.security.JWTAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Clase de Configuración para la Creación de Beans
 */
@RequiredArgsConstructor
@Configuration
public class ApplicationConfig {

    private final JWTAuthenticationProvider jwtAuthenticationProvider;

    /**
     * Bean de Password Encoder para Inyección
     *
     * @return Implementación de BCryptPasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Bean de JWTAuthFilter para Inyección
     *
     * @return Implementación de JWTAuthFilter
     */
    @Bean
    public JWTAuthFilter jwtAuthFilter() {
        return new JWTAuthFilter(jwtAuthenticationProvider);
    }

}