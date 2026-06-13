package Study.spring.boot.CauTrucChuan.entity;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder // giúp cho các bạn có thể insert vào user 1 cách dễ dàng hơn thay vì sử dụng contructer
@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	private String name;
	private String address;
	@Column(name ="phone" ,length = 10)
	private String phone;
	private String email;
	private String username;
	private String password;
}
