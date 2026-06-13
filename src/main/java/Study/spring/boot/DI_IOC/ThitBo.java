package Study.spring.boot.DI_IOC;

import org.springframework.stereotype.Component;

@Component
public class ThitBo implements CacLoaiThit {
  public String LaythitBo() {
	 return "lấy 100g thịt Bò";
  }

  @Override
  public String LayThit() {
	  return "lấy 100g thịt Bò";
  }
}
