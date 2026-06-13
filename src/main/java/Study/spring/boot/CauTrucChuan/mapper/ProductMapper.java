package Study.spring.boot.CauTrucChuan.mapper;

import org.mapstruct.Mapper;

import Study.spring.boot.CauTrucChuan.dto.record.ProductResponse;
import Study.spring.boot.CauTrucChuan.entity.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductResponse toProductResponse(Product product);
}