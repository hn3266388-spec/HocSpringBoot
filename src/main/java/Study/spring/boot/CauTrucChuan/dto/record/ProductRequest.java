package Study.spring.boot.CauTrucChuan.dto.record;

import java.math.BigDecimal;

public record ProductRequest(
        Long id,
        String name,
        BigDecimal price
) {
}