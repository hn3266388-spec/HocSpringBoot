package Study.spring.boot.CauTrucChuan.dto.record;

import Study.spring.boot.CauTrucChuan.entity.Category;

import java.math.BigDecimal;

public record ProductResponse(
	 Long id,
     String name,
     BigDecimal price,
	 Category category) {
}
