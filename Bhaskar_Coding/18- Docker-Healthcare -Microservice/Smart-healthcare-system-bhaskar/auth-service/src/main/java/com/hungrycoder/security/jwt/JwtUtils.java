package com.hungrycoder.security.jwt;

import java.security.Key; // Import Key for cryptographic operations
import java.util.Date; // Import Date for handling date and time

import org.slf4j.Logger; // Import Logger for logging errors and information
import org.slf4j.LoggerFactory; // Import LoggerFactory for creating Logger instances
import org.springframework.beans.factory.annotation.Value; // Import Value for dependency injection
import org.springframework.security.core.Authentication; // Import Authentication for handling user authentication
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component; // Import Component for Spring component scanning

import com.hungrycoder.security.services.UserDetailsImpl;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
// Import custom user details implementationimport io.jsonwebtoken.*; // Import the JJWT library classes for handling JWT
import io.jsonwebtoken.io.Decoders; // Import Decoders for decoding JWT secret
import io.jsonwebtoken.security.Keys; // Import Keys for creating keys for JWT signing

@Component
public class JwtUtils {

	public static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

	@Value("${jwt.secret}") // Inject the JWT secret from application properties
	private String jwtSecret;

	@Value("${jwt.expiration}")
	private int jwtExprirationMS;

	public String generateJWTToken(Authentication authentication) {
		UserDetailsImpl userPricipal = (UserDetailsImpl) authentication.getPrincipal();

		String role = userPricipal.getAuthorities().stream().map(GrantedAuthority::getAuthority).findFirst()
				.orElseThrow(() -> new RuntimeException("Roles not found for users"));

		System.out.println("Role of user is --> " + role);

		return Jwts.builder().setSubject(userPricipal.getUsername()).claim("role", role).setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getTime() + jwtExprirationMS))
				.signWith(key(), SignatureAlgorithm.HS256).compact();
	}

	public Key key() {
		return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
	}

	public String generateUserNameFromJwtToken(String token) {
		return Jwts.parserBuilder().setSigningKey(key()).build().parseClaimsJwt(token).getBody().getSubject();
	}

	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parserBuilder().setSigningKey(key()).build().parse(authToken);
			return true;
		} catch (MalformedJwtException e) {
			logger.error("Invalid JWT token: {}", e.getMessage()); // Log invalid token error
		} catch (ExpiredJwtException e) {
			logger.error("JWT token is expired: {}", e.getMessage()); // Log expired token error
		} catch (UnsupportedJwtException e) {
			logger.error("JWT token is unsupported: {}", e.getMessage()); // Log unsupported token error
		} catch (IllegalArgumentException e) {
			logger.error("JWT claims string is empty: {}", e.getMessage()); // Log empty claims error
		}

		return false; // Token is invalid
	}
}
