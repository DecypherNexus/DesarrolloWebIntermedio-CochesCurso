package com.project.coches.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.project.coches.domain.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Clase que Administra la Creación y Validación de JWTs para el "Inicio de Sesión" de Usuarios
 */
@Component
public class JWTAuthenticationProvider {

    /**
     * Llave para Cifrar el JWT
     */
    @Value("${jwt.secret.key}")
    private String secretKey;

    /**
     * Lista Blanca de los JWT Creados
     */
    private HashMap<String, CustomerDTO> listToken = new HashMap<>();

    /**
     * Crea un Nuevo JWT mediante el Cliente recibido como Parámetro y lo Agrega a la Lista Blanca de JWTs
     *
     * @param customerJWT Recibe el Cliente a Utilizar
     * @return Devuelve el JWT Creado
     */
    public String createToken(CustomerDTO customerJWT) {

        Date now = new Date();
        Date validity = new Date(now.getTime() + 3600000); // 1 Hora en Milisegundos
        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        String tokenCreated = JWT.create()
                .withClaim("cardId", customerJWT.getCardId())
                .withClaim("fullname", customerJWT.getFullName())
                .withClaim("numberCellPhone", String.valueOf(customerJWT.getCellphoneNumber()))
                .withClaim("email", customerJWT.getEmail())
                .withIssuedAt(now)
                .withExpiresAt(validity)
                .sign(algorithm);

        listToken.put(tokenCreated, customerJWT);
        return tokenCreated;

    }

    /**
     * Valida si el Token es Correcto y devuelve una Sesión de Usuario
     *
     * @param token Recibe el Token a Validar
     * @return Deuelve la Sesión del Usuario
     * @throws CredentialsExpiredException Si el Token ya expiró
     * @throws BadCredentialsException     Si el Token no existe en la Lista Blanca
     */
    public Authentication validateToken(String token) throws AuthenticationException {

        System.out.println("Entró a la Validación del Token.");
        System.out.println(token);

        // Verifica el Token al igual que su Firma y Expiración; lanza una Excepcion si algo falla
        JWT.require(Algorithm.HMAC256(secretKey)).build().verify(token);


        CustomerDTO customerToken = listToken.get(token);
        if (customerToken == null) {
            throw new BadCredentialsException("Usuario no Registrado.");
        }

        /*

        // Se crea un "UserDetails", sin embargo, cuando se revisan los "roles()", lo que se crea es una nueva Autoridad con Prefijo "ROLES_"
        UserDetails userDetailsTest = User.withUsername(exists.getFullName()).password(exists.getPassword()).roles(exists.getRol()).build();
        userDetailsTest.getAuthorities().forEach(System.out::println);

        System.out.println("Impresión de 'UserDetails'");
        System.out.println(userDetailsTest);

        return new UsernamePasswordAuthenticationToken(userDetailsTest, token, userDetailsTest.getAuthorities());
        return new UsernamePasswordAuthenticationToken(userDetailsTest, token, Collections.singletonList(new SimpleGrantedAuthority("WRITE_PRIVILEGE")));

        */

        HashSet<SimpleGrantedAuthority> rolesAndAuthorities = new HashSet<>();
        rolesAndAuthorities.add(new SimpleGrantedAuthority("ROLE_" + customerToken.getRole())); // Rol
        // rolesAndAuthorities.add(new SimpleGrantedAuthority("ELIMINAR_PRIVILEGE")); // Permisos del Rol

        return new UsernamePasswordAuthenticationToken(customerToken, token, rolesAndAuthorities);

    }

    /**
     * Elimina un Token mediante el JWT recibido como Parámetro y lo Remueve de la Lista Blanca de JWTs
     *
     * @param jwt Recibe el Token a Eliminar
     * @return Devuelve un Mensaje dependiendo del Estatus de la Operación
     */
    public String deleteToken(String jwt) {

        if (!listToken.containsKey(jwt)) {
            return "El Token no Existe,";
        }

        listToken.remove(jwt);
        return "¡Sesión Cerrada Exitosamente!";

    }

}