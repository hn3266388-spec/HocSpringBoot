package Study.spring.boot;



import org.springframework.stereotype.Component;

import Study.spring.boot.CauTrucChuan.dto.record.ProductResponse;
import Study.spring.boot.CauTrucChuan.entity.Product;
import Study.spring.boot.CauTrucChuan.mapper.ProductMapper;

@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductResponse toProductResponse(Product product) {
        if (product == null) {
            return null;
        }

        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(), null
        );
    }
}