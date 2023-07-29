package furniture.ecommerce.furnitureecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class FurnitureEcommerceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run (FurnitureEcommerceApplication.class, args);
	}
	
}
