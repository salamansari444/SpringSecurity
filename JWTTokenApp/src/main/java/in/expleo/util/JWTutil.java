package in.expleo.util;

import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTutil {
	
	public static String generateToken(String id, String subject, String secreteKey) {
		
		return Jwts.builder().setId(id).setSubject(subject)
		.setIssuer("Expleo").setIssuedAt(new Date(System.currentTimeMillis()))
		.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(1)))
		.signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encode(secreteKey.getBytes()))
		.compact();
	}
	public static Claims getClaims(String secreteKey, String token) {
		
		return Jwts.parser().setSigningKey(Base64.getEncoder().encode(secreteKey.getBytes()))
				.parseClaimsJws(token).getBody();
	}
	
	public static boolean isTokenVaid(String secreteKey, String token) {
		Date expiry= getClaims(secreteKey, token).getExpiration();
		Date date = new Date();
		boolean result = date.before(expiry);
		return result;
	}
	
	public static String getSubject(String secreteKey, String token) {
		return getClaims(secreteKey, token).getSubject();
	}
	
	public static Date getExpiry(String secreteKey, String token) {
		return getClaims(secreteKey, token).getExpiration();
	}
}
