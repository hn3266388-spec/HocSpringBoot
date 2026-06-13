package Study.spring.boot.Singleton_Prototype;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Scope("prototype")
@Component
public class Oder {
	//prototype mỗi lần gọi là tạo 1 bean mới
    public Oder() {
    	System.out.println("new oder");
    }
}
