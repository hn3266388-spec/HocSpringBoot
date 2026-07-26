package Study.spring.boot.CauTrucChuan.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    //create token
    public String generateToken(UserDetails userDetails){
        Map<String, Object> claims = new HashMap<>();
    // You can add role: claims.put("roles", userDetails.getAuthorities()));
        return createToken(claims,userDetails.getUsername());
    }
    private String createToken(Map<String ,Object> claims,String subject){

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+expiration))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();

    }
    private Key getSignKey(){
        byte[] keyBytes= Base64.getDecoder().decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    //get username to token
    public String extractUsername(String token){
        return extractClaims(token, Claims::getSubject);
    }
    public <T> T extractClaims(String token, Function<Claims,T> claimsResolver){
        final  Claims claims= extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims (String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    //check token expire
    public Boolean validateToken(String token, UserDetails userDetails){
        final  String username= extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpried(token));
    }
    public Boolean isTokenExpried(String token){
        Date expriration = extractClaims(token , Claims::getExpiration);
        return expriration.before((new Date()));
    }
}
