package Study.spring.boot.CauTrucChuan.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import Study.spring.boot.CauTrucChuan.dto.record.ProductResponse;
import Study.spring.boot.CauTrucChuan.entity.Product;
import Study.spring.boot.CauTrucChuan.mapper.ProductMapper;
import Study.spring.boot.CauTrucChuan.repository.ProductRepository;
import Study.spring.boot.CauTrucChuan.service.ProductService;
import lombok.RequiredArgsConstructor;

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

        Page<Product> products = productRepository.findAll(pageable);

        return products.map(productMapper::toProductResponse);
    }
}