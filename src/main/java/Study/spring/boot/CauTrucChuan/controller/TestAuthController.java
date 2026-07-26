package Study.spring.boot.CauTrucChuan.controller;

import Study.spring.boot.CauTrucChuan.security.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth/test")
public class TestAuthController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping("/token")
    public String getToken() {
        UserDetails user = userDetailsService.loadUserByUsername("admin");
        return jwtService.generateToken(user);
    }
}