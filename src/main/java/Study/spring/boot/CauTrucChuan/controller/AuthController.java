package Study.spring.boot.CauTrucChuan.controller;

import Study.spring.boot.CauTrucChuan.common.ApiResponse;
import Study.spring.boot.CauTrucChuan.common.BaseController;
import Study.spring.boot.CauTrucChuan.entity.Account;
import Study.spring.boot.CauTrucChuan.entity.RefreshToken;
import Study.spring.boot.CauTrucChuan.repository.AccountRepository;
import Study.spring.boot.CauTrucChuan.security.jwt.JwtService;
import Study.spring.boot.CauTrucChuan.security.service.RefreshTokenService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController extends BaseController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final RefreshTokenService refreshTokenService;
    private final AccountRepository accountRepository;
    @PostMapping("/login")
    public ApiResponse<ResponseEntity<?>> login(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        Account account = (Account) authentication.getPrincipal();
        String accessToken = jwtService.generateToken(account);
        RefreshToken refreshToken = refreshTokenService.createRefreshToken(account.getId());
        return ApiResponse.success(new ResponseEntity<>(Map.of("accessToken", accessToken,
                "refreshToken", refreshToken.getToken()
        ),HttpStatus.OK));
    }
    @PostMapping("/refresh-token")
    public ApiResponse<ResponseEntity<?>> refreshToken(@RequestBody Map<String, String> request) {
        String refreshTokenStr = request.get("refreshToken");
        if (refreshTokenStr == null) {
            throw new RuntimeException("Refresh token not null");
        }

        RefreshToken refreshToken = refreshTokenService.finBytoken(refreshTokenStr)
                .orElseThrow(() -> new RuntimeException("Refresh don't exist"));

        if (refreshToken.isRevoked()) {
            throw new RuntimeException("Refresh token revoked");
        }

        RefreshToken verifiedToken = refreshTokenService.verifyExpiration(refreshToken);
        Account account = verifiedToken.getAccount();
        String newAccessToken = jwtService.generateToken(account);

        return ApiResponse.success(new ResponseEntity<>(Map.of("accessToken", newAccessToken
        ),HttpStatus.OK));
    }


    @PostMapping("/logout")
    public ApiResponse<ResponseEntity<?>> logout(@RequestHeader("Authorization") String authorization) {
        String token = authorization.substring(7);
        String username = jwtService.extractUsername(token);
        Account account = accountRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
        refreshTokenService.revokeAllUserToken(account.getId());
        return ApiResponse.success(new ResponseEntity<>(Map.of("message", "Logout Successfully"
        ),HttpStatus.OK));
    }


    @Data
    static class LoginRequest {
        private String username;
        private String password;
    }
}