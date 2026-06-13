package Study.spring.boot.Singleton_Prototype;

import org.springframework.stereotype.Component;

@Component // Singleton mặc định
public class Chef {
//Singleton ra 1 lần duy nhất và đc sử dụng lại
    public Chef() {
        System.out.println("Chef is at work");
    }

    public void cook() {
        System.out.println("Chef is cooking...");
    }
}