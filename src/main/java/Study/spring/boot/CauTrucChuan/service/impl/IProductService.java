package Study.spring.boot.CauTrucChuan.service.impl;

import Study.spring.boot.CauTrucChuan.repository.specification.ProductSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import Study.spring.boot.CauTrucChuan.dto.record.ProductResponse;
import Study.spring.boot.CauTrucChuan.entity.Product;
import Study.spring.boot.CauTrucChuan.mapper.ProductMapper;
import Study.spring.boot.CauTrucChuan.repository.ProductRepository;
import Study.spring.boot.CauTrucChuan.service.ProductService;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class IProductService implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public Page<ProductResponse> getAllProducts(
            String name,
            String category,
            Pageable pageable) {

  //      Page<Product> products = productRepository.findAll(pageable);
       // Page<Product> products = productRepository.findActiveByCategory(category, pageable);
        // Jpa Specification
        Page<Product> products = productRepository.findAll(ProductSpecification.filterProducts(name, BigDecimal.valueOf(10000), category), pageable);
        return products.map(productMapper::toProductResponse);
    }
}