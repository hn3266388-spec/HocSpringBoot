package Study.spring.boot.CauTrucChuan.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import Study.spring.boot.CauTrucChuan.common.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ApiResponse<Map<String, String>> handlerValidationException(MethodArgumentNotValidException ex) {

		Map<String, String> errors = new HashMap<>();

		ex.getBindingResult().getFieldErrors().forEach(error -> {
			errors.put(error.getField(), error.getDefaultMessage());
		});

		return ApiResponse.errorListDataMessages(999, "List of error colum", errors);
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ApiResponse<Object>> handlerRuntimeException(RuntimeException ex) {
		ApiResponse<Object> apiResponse = ApiResponse.error(9999, ex.getMessage());
		return ResponseEntity.badRequest().body(apiResponse);
	}
}