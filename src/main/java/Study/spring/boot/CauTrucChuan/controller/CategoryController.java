package Study.spring.boot.CauTrucChuan.controller;

import Study.spring.boot.CauTrucChuan.common.ApiResponse;
import Study.spring.boot.CauTrucChuan.common.BaseController;
import Study.spring.boot.CauTrucChuan.dto.record.CategoryRequest;
import Study.spring.boot.CauTrucChuan.entity.Category;
import Study.spring.boot.CauTrucChuan.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController extends BaseController {
    private final CategoryService categoryService;

    // 1. Tạo mới category kèm danh sách product
    @PostMapping
    public ResponseEntity<ApiResponse<Category>> createCategory(@RequestBody CategoryRequest rq) {
        Category created = categoryService.createCategory(rq);
        return new ResponseEntity<>(createSuccessResponse(created), HttpStatus.CREATED);
    }

    // 2. Cập nhật category (thêm/sửa/xóa product)
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Category>> updateCategory(@PathVariable Long id, @RequestBody CategoryRequest dto) {
        Category updated = categoryService.updateCategory(id, dto);
        return ResponseEntity.ok(createSuccessResponse(updated));
    }
}