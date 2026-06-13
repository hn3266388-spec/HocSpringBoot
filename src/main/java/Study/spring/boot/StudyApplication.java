package Study.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import Study.spring.boot.DI_IOC.Topho;
import Study.spring.boot.PostConstruct.ConnetionService;
import Study.spring.boot.Singleton_Prototype.Chef;
import Study.spring.boot.Singleton_Prototype.Oder;
@SpringBootApplication(scanBasePackages = "Study.spring.boot")
public class StudyApplication implements CommandLineRunner {
    private final Topho topho1 ;
    @Autowired
    private ApplicationContext applicationContext; // Container Spring
    @Autowired
    private ConnetionService hehe;
	public StudyApplication(Topho topho1, Topho topho2) {
		super();
		this.topho1 = topho1;
	}

	public static void main(String[] args) {
		SpringApplication.run(StudyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		 * topho1.phucvu(); System.out.println("\n=== CHECK SINGLETON SCOPE ==="); Chef
		 * chef1 = applicationContext.getBean(Chef.class); Chef chef2 =
		 * applicationContext.getBean(Chef.class);
		 * System.out.println("\nchef1 == chef2 ? " + (chef1 == chef2));
		 * 
		 * System.out.println("\n=== CHECK PROTOTYPE SCOPE ==="); Oder order1 =
		 * applicationContext.getBean(Oder.class); Oder order2 =
		 * applicationContext.getBean(Oder.class);
		 * System.out.println("\nnorder1 == order2 ? " + (order1 == order2));
		 */
        hehe.connect();
        hehe.getStatus();
	}
	
}
