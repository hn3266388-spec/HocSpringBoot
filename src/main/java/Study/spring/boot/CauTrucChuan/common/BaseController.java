package Study.spring.boot.CauTrucChuan.common;

public abstract class BaseController {

    protected <T> ApiResponse<T> createSuccessResponse(T data) {
        return ApiResponse.success(data);
    }
}