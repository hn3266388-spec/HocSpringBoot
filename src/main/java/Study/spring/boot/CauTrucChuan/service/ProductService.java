package Study.spring.boot.CauTrucChuan.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import Study.spring.boot.CauTrucChuan.dto.record.ProductResponse;

public interface ProductService {

    Page<ProductResponse> getAllProducts(
            String name,
            String category,
            Pageable pageable);
}