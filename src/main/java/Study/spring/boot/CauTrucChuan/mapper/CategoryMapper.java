package Study.spring.boot.CauTrucChuan.mapper;

import Study.spring.boot.CauTrucChuan.dto.record.CategoryRequest;
import Study.spring.boot.CauTrucChuan.dto.record.ProductRequest;
import Study.spring.boot.CauTrucChuan.entity.Category;
import Study.spring.boot.CauTrucChuan.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mapping(target = "products",ignore = true)
    Category toEntity(CategoryRequest categoryrequest);

    ProductRequest toProductDto(Product prodcuts);
    Product toProductEntity(ProductRequest productrequest);
}
