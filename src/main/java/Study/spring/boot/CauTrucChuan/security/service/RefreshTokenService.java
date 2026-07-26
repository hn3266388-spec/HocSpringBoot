package Study.spring.boot.CauTrucChuan.security.service;

import Study.spring.boot.CauTrucChuan.entity.Account;
import Study.spring.boot.CauTrucChuan.entity.RefreshToken;
import Study.spring.boot.CauTrucChuan.repository.AccountRepository;
import Study.spring.boot.CauTrucChuan.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {
    @Value("${jwt.refresh-expiration}")
    private Long refreshTokenExpirationMs;
    private final RefreshTokenRepository refreshTokenRepository;
    private final AccountRepository accountRepository;
    @Transactional
    public RefreshToken createRefreshToken(String accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new IllegalArgumentException("User not exist!"));
        refreshTokenRepository.deleteAllByAccount_Id(accountId);
        RefreshToken refreshToken = RefreshToken.builder()
                .account(account)
                .token(UUID.randomUUID().toString())
                .expiryDate(Instant.now().plusMillis(refreshTokenExpirationMs))
                .revoked(false)
                .build();
        return refreshTokenRepository.save(refreshToken);
    }

    public Optional<RefreshToken> finBytoken(String token) {
        return refreshTokenRepository.findByToken(token);
    }

    public RefreshToken verifyExpiration(RefreshToken refreshToken) {
        if (refreshToken.getExpiryDate().compareTo(Instant.now()) < 0) {
            refreshToken.setRevoked(true);
            refreshTokenRepository.save(refreshToken);
            throw new RuntimeException("Refresh token expiry!");
        }

        return refreshToken;
    }
    @Transactional
    public void revokeAllUserToken(String accountId) {
        refreshTokenRepository.deleteAllByAccount_Id(accountId);
    }
}
