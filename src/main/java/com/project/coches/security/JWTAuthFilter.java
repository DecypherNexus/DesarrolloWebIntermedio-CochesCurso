package com.project.coches.security;

import com.project.coches.exception.UnauthorizedException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

/**
 * Clase que Filtra si las Peticiones HTTP están Autorizadas (Cabezera de Autorización)
 */
@RequiredArgsConstructor
public class JWTAuthFilter extends OncePerRequestFilter {

    /**
     * Clase que Administra los JWTs
     */
    private final JWTAuthenticationProvider jwtAuthenticationProvider;

    /**
     * Lista Blanca de URIs
     */
    private List<String> urlsToSkip = List.of("/auth", "/swagger-ui.html", "/swagger-ui", "/api-docs");


    /**
     * Verifica si a una URI no se le debe aplicar el Filtro
     *
     * @param request Recibe la Petición a Validar
     * @return Devuelve "True" en el caso de que la URI se encuentre en la Lista Blanca o "False" en el caso contrario
     * @throws ServletException
     */
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        System.out.println("Entró a la Verificación de Aplicación del Filtro de URIs.");
        System.out.println(request.getRequestURI());
        return urlsToSkip.stream().anyMatch(url -> request.getRequestURI().contains(url));
    }

    /**
     * Valida si una Petición contiene la Cabezera de Autorización por medio del "Bearer Token"
     *
     * @param request
     * @param response
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     * @throws UnauthorizedException - Si no contiene la Cabezera "HttpHeaders.AUTHORIZATION"
     *                               - Si posee más de dos elementos en la Cabezera o no tiene "Bearer Token"
     *                               - Si el Token no es válido
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String header = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (header == null) {
            throw new UnauthorizedException();
        }

        /*

        System.out.println("Headers");
        System.out.println(header);
        System.out.println(request);

        Enumeration<String> headerNames = request.getHeaderNames();

        while (headerNames.hasMoreElements()) {

            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);

            System.out.println("Header and Value");
            System.out.println(headerName);
            System.out.println(headerValue);

        }

        */

        String[] authElements = header.split(" ");

        if (authElements.length != 2 || !"Bearer".equals(authElements[0])) {
            throw new UnauthorizedException();
        }

        try {

            Authentication authentication = jwtAuthenticationProvider.validateToken(authElements[1]);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            System.out.println("Impresión del Contexto de 'SecurityContext'");
            System.out.println(SecurityContextHolder.getContext());
            System.out.println("Impresión de la Autenticación de 'SecurityContext'");
            System.out.println(SecurityContextHolder.getContext().getAuthentication());

        } catch (RuntimeException runtimeException) {

            SecurityContextHolder.clearContext();
            System.out.println("Entró a la Excepción de 'SecurityContext'");
            System.out.println(runtimeException);

            throw new RuntimeException(runtimeException);

        }

        System.out.println("Emtró al Filtro de Autorización");
        filterChain.doFilter(request, response);

    }

}