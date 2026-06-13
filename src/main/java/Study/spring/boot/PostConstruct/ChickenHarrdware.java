package Study.spring.boot.PostConstruct;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class ChickenHarrdware {

	public ChickenHarrdware() {  // bắt đầu bean đc tạo
		System.out.println("When Object đc khởi tạo");
	}
	// bean đã đc dùng 
   @PostConstruct// đánh dấu rằng bean đã được tạo và tiêm 
   public void init() {
	   System.out.println("Bean sẵn sàng đc sử dụng");
   }
   //bean bị hủy
   @PreDestroy
   public void cleanup() {
	   System.out.println("Bean đã bị hủy");
   }
}
