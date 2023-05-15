package com.project.coches.config;

import com.project.coches.exception.AccessDeniedHandlerException;
import com.project.coches.security.JWTAuthFilter;
import com.project.coches.security.Roles;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * Clase que Administra las Configuraciones de las Peticiones HTTP
 */
@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    /**
     * Clase que Maneja las Excepciones de Denegación de Acceso
     */
    private final AccessDeniedHandlerException accessDeniedHandlerException;

    /**
     * Clase que Filtra los JWTs
     */
    private final JWTAuthFilter jwtAuthFilter;

    /**
     * Configura la Seguridad de las Peticiones HTTP
     *
     * @param httpSecurity Recibe la Peticion a Configurar
     * @return Devuelve la Configuración HTTP
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .cors(withDefaults())
                .exceptionHandling().accessDeniedHandler(accessDeniedHandlerException)
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(requests ->
                        requests.requestMatchers("/auth/**", "/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
                                // .requestMatchers(HttpMethod.GET, "/customers").hasAnyRole(Roles.CUSTOMER, Roles.ADMIN)
                                .requestMatchers(HttpMethod.GET, "/customers/**").hasAnyRole(Roles.CUSTOMER, Roles.ADMIN)
                                .requestMatchers(HttpMethod.DELETE, "/customers/**").hasRole(Roles.ADMIN)
                                // .requestMatchers(HttpMethod.DELETE, "/customers/**").hasAuthority("ELIMINAR_PRIVILEGE")

                                .requestMatchers("/cars").hasRole(Roles.CUSTOMER)
                                // .requestMatchers("/cars").hasAuthority("COMPRAR_PRIVILEGE")
                                // .requestMatchers("/customers").hasRole(Roles.ADMIN)

                                // Solo toma el Primer Filtro, ya no se puede anidar un Rol con una Autoridad
                                // "hasAuthority" o "hasRole" para solo un Rol/Autoridad
                                // "hasAnyAuthority" para varios Roles/Autoridades
                                .anyRequest().authenticated()

                );

        return httpSecurity.build();

    }

    /**
     * Configura el Procesamiento de las Peticiones CORS
     *
     * @return Devuelve la Configuración CORS
     */
    @Bean
    CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(List.of(CorsConfiguration.ALL));
        corsConfiguration.setAllowedMethods(List.of(CorsConfiguration.ALL));
        corsConfiguration.setAllowedHeaders(List.of(CorsConfiguration.ALL));

        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);

        return urlBasedCorsConfigurationSource;

    }

}