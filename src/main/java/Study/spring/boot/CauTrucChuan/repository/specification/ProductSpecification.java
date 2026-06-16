package Study.spring.boot.CauTrucChuan.repository.specification;

import Study.spring.boot.CauTrucChuan.entity.Product;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import jakarta.persistence.criteria.Predicate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductSpecification {

    public static Specification<Product> filterProducts(
            String name,
            BigDecimal price,
            String category
    ) {
        return (root, query, cb) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.hasText(name)) {
                predicates.add(
                        cb.like(
                                cb.lower(root.get("name")),
                                "%" + name.toLowerCase() + "%"
                        )
                );
            }

            if (StringUtils.hasText(category)) {
                predicates.add(
                        cb.like(
                                cb.lower(root.get("category")),
                                "%" + category.toLowerCase() + "%"
                        )
                );
            }

            if (price != null) {
                predicates.add(
                        cb.lessThanOrEqualTo(root.get("price"), price)
                );
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}