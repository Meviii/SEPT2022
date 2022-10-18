package com.mdonline.LoginService.Security.Jwt;

import com.mdonline.LoginService.Model.User;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

/**
 * This utility class is designed to hold utility functions for JWT
 */
@Component
public class JwtTokenUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenUtil.class);

    // Expire duration for a token
    private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000; // 24hrs

    // secret key for JWT token
    @Value("${app.jwt.secret}")
    private String secretKey;

    /**
     * This function returns a newly generated JWT token for the passed user.
     *
     * @param user - User payload
     * @Return - This function returns a JWT token in String format
     */
    public String generateAccessToken(User user){
        LOGGER.trace("Generating access token.");
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS512;
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secretKey);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        return Jwts.builder()
                .setSubject(user.getId() + "," + user.getEmail())
                .setIssuer("JWTUTIL")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
                .signWith(signingKey)
                .compact();
    }

    /**
     * This function validates a JWT token.
     *
     * @param token - JWT token in string format
     * @Return - Boolean. True if validated, false otherwise
     */
    public boolean validateAccessToken(String token) {
        try {
            LOGGER.trace("Validating access token.");
            SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS512;
            byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secretKey);
            Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

            Jwts.parserBuilder()
                    .setSigningKey(signingKey)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException ex) {
            LOGGER.error("JWT expired", ex.getMessage());
        } catch (IllegalArgumentException ex) {
            LOGGER.error("Token is null, empty or only whitespace", ex.getMessage());
        } catch (MalformedJwtException ex) {
            LOGGER.error("JWT is invalid", ex);
        } catch (UnsupportedJwtException ex) {
            LOGGER.error("JWT is not supported", ex);
        }
        LOGGER.warn("Failed to validate access token.");
        return false;
    }

    /**
     * This function returns the subject of a passed JWT token
     *
     * @param token - JWT token in string format
     * @Return - subject of token
     */
    public String getSubject(String token) {
        LOGGER.trace("Getting subject of token.");
        return parseClaims(token).getSubject();
    }

    /**
     * This function returns the claims of a passed JWT token
     *
     * @param token - JWT token in string format
     * @Return - Claims of token
     */
    private Claims parseClaims(String token) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS512;
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secretKey);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        LOGGER.trace("Parsing claims.");
        return Jwts.parserBuilder()
                .setSigningKey(signingKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
