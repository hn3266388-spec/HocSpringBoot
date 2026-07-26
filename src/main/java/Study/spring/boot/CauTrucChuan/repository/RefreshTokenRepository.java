package Study.spring.boot.CauTrucChuan.repository;


import Study.spring.boot.CauTrucChuan.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);
    void deleteAllByAccount_Id(String accountId);
}
