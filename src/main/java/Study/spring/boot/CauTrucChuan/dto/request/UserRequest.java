package Study.spring.boot.CauTrucChuan.dto.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UserRequest {
	private String name;
	private String address;
	private String phone;
	private String email;
	private String username;
	private String password;
}
