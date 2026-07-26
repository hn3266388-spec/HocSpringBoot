package Study.spring.boot.CauTrucChuan.service.impl;


import Study.spring.boot.CauTrucChuan.dto.record.CategoryRequest;
import Study.spring.boot.CauTrucChuan.dto.record.ProductRequest;
import Study.spring.boot.CauTrucChuan.entity.Category;
import Study.spring.boot.CauTrucChuan.entity.Product;
import Study.spring.boot.CauTrucChuan.mapper.CategoryMapper;
import Study.spring.boot.CauTrucChuan.repository.Categoryrepository;
import Study.spring.boot.CauTrucChuan.repository.ProductRepository;
import Study.spring.boot.CauTrucChuan.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ICategoryService implements CategoryService {
    private final ProductRepository productrepo;
    private final Categoryrepository categoryrepo;
    private final CategoryMapper categorymapper;

    @Override
    public Category createCategory(CategoryRequest rq) {
        Category category = categorymapper.toEntity(rq);
        //xử lý logic 1 category kèm theo 1 danh sách
        if (Objects.nonNull(rq.products())) {
            for (ProductRequest product : rq.products()) {
                Product pro = categorymapper.toProductEntity(product);
                category.addProduct(pro);
            }
        }
        return categoryrepo.save(category);
    }

    @Override
    public Category updateCategory(Long cateid, CategoryRequest rq) {
        Category category = categoryrepo.findById(cateid).orElseThrow(() -> new RuntimeException("Category not fond!"));
        category.setName(rq.name());
        //xử lý product cũ
        List<Long> newProductids = Objects.nonNull(rq.products()) ? rq.products().stream().map(ProductRequest::id).filter(Objects::nonNull).collect(Collectors.toList())

                : List.of();
        //xóa product ko nằm trong dto reuest mới nữa
        category.getProducts().removeIf(product -> newProductids.contains(product.getId()));
        if (Objects.nonNull(rq.products())) {
            for (ProductRequest prodto : rq.products()) {
                if (prodto.id() == null) {
                    Product newproduct = categorymapper.toProductEntity(prodto);
                    category.addProduct(newproduct);
                } else {
                    Product exsting = category.getProducts().stream().filter(product -> product.getId().equals(prodto.id())).findFirst().orElse(null);
                    if (exsting != null) {
                        exsting.setName(prodto.name());
                        exsting.setPrice(prodto.price());
                    }
                }
            }

        }
        return categoryrepo.save(category);
    }
}