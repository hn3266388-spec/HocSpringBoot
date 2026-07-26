package Study.spring.boot.CauTrucChuan.service;


import Study.spring.boot.CauTrucChuan.dto.record.CategoryRequest;
import Study.spring.boot.CauTrucChuan.entity.Category;

public interface CategoryService {
    Category createCategory(CategoryRequest rq);
    Category updateCategory(Long cateid,CategoryRequest rq);
}
