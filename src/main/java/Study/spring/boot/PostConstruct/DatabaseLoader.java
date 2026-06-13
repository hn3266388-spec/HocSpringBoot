package Study.spring.boot.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class DatabaseLoader {
     @Autowired // đã têm ở đây
     private ConnetionService connect;

		/*
		 * public DatabaseLoader() {
		 * System.out.println("STEP 1: Contrutor runging ...."); try {
		 * connect.connect(); } catch (Exception e) { System.out.println(e); } }
		 */
     @PostConstruct// sau khi tạo bean và tiêm @Autowired thì hàm đc đánh dấu PostConstruct sẽ đc gọi in ra để báo rằng thg đối tượng đã đc tiêm và sẵn sàng sử dụng
     public void init() {
		 System.out.println("STEP 1: Contrutor runging ....");
		 try {
			connect.connect();
		} catch (Exception e) {
			 System.out.println(e);
		}
	 }
}
