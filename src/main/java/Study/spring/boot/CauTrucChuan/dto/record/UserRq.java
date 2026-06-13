package Study.spring.boot.CauTrucChuan.dto.record;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserRq( 
		@NotEmpty(message ="Trường này không được phép trống")   //đối tượng nó quan tâm là khác null độ dài chuỗi phải  >0
		@NotBlank(message = "trường này không được null") // đối tượng nó quan tâm khác null và sau khi bỏ hết dấu cách không được trống
		@NotNull(message = "trường này không được null")  // Nó chỉ quan tâm đến các đối tượng bị null
		String name,
	    String address,
	    @Min(value=0,message = "trường này không được null")
		@Size(min=9,max=11 ,message = "SDT phải phải có 10 kí tự")
	    String phone,
	    @Email
	    @NotBlank
	    String email,
	    String username,
	    String password,
	    @Study.spring.boot.CauTrucChuan.anotation.Cccd
	    String cccd) {
}
