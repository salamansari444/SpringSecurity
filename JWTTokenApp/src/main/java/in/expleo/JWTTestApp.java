package in.expleo;

import java.io.IOException;

import in.expleo.util.JWTutil;
import io.jsonwebtoken.Claims;

public class JWTTestApp {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String token = JWTutil.generateToken("Al-PHA", "Google-PAy", "7865");
		System.out.println(token);
		
		Claims claims = JWTutil.getClaims("7865", token);
		System.out.println("client id : "+claims.getId());
		System.out.println("subject : "+claims.getSubject());
		System.out.println("issued at : "+claims.getIssuedAt());
		System.out.println("Expiration Date : "+claims.getExpiration());
		System.in.read();
		System.out.println("is token Valid : "+JWTutil.isTokenVaid("7865", token));
		JWTutil.getSubject("7865", token);
		System.out.println("ExpiryDate and Time :: " +JWTutil.getExpiry("7865", token));
		
	}

}
