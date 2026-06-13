package Study.spring.boot.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class ConnetionService {
     private boolean isReady=false;

	 public ConnetionService() {
		 System.out.println("Wait Connect");
		this.isReady = true;
	 }
     public void connect() {
    	 if(isReady==true) {
    		 System.out.println("Success");
    	 }else {
    		 System.out.println("Fail");
    	 }
     }
     public String getStatus() {
    	 return "Online";
     }
}
