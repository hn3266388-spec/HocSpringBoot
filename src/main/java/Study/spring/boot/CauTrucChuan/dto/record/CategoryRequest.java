package Study.spring.boot.CauTrucChuan.dto.record;

import java.util.List;

public record CategoryRequest(
        Long id,
        String name,
        List<ProductRequest> products
){}