package Study.spring.boot.CauTrucChuan.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;
import Study.spring.boot.CauTrucChuan.common.ApiResponse;
import Study.spring.boot.CauTrucChuan.common.BaseController;
import Study.spring.boot.CauTrucChuan.dto.record.ProductResponse;
import Study.spring.boot.CauTrucChuan.service.ProductService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController extends BaseController {

    private final ProductService productService;

    @GetMapping
    public ApiResponse<Page<ProductResponse>> index(
            @RequestParam(value = "page_no", defaultValue = "0" ) int page,
            @RequestParam(value = "page_size", defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "category", required = false) String category
    ){
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page == 0 ? page : page - 1 , size, sort);

        return ApiResponse.success(productService.getAllProducts(name, category, pageable));
    }
}
