package furniture.ecommerce.furnitureecommerce.data.repository;

import furniture.ecommerce.furnitureecommerce.data.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface ProductRepository extends JpaRepository<Products, Long> {
	Products findProductByName(String name);
	
	Products findProductByPrice(BigDecimal price);
}
