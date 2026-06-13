package Study.spring.boot.DI_IOC;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ThitGa implements CacLoaiThit{
	public String LaythitGa() {
		 return "lấy 100g thịt Gà";
	  }

	@Override
	public String LayThit() {
		return "lấy 100g thịt Gà";
	}
}
