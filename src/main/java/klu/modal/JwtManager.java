package klu.modal;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtManager {

	public final String SEC_KEY = "QWERTYUIOPASDFGHJKLZXCVBNM13245678979809asfdfggfgjjyvjhhjhfhgfhbvbhds";
	public final SecretKey KEY = Keys.hmacShaKeyFor(SEC_KEY.getBytes());
	
	//Generate JWT 
	public String generateToken(String emailid)
	{
		Map<String, String> data = new HashMap<String, String>();
		data.put("username", emailid);
		
		return Jwts.builder()
				.setClaims(data)
				.setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getTime() + 84600000))
				.signWith(KEY)
				.compact();
				
	}
}
