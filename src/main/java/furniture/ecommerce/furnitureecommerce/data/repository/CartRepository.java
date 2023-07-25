package furniture.ecommerce.furnitureecommerce.data.repository;

import furniture.ecommerce.furnitureecommerce.data.model.Cart;
import furniture.ecommerce.furnitureecommerce.data.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
//	List<Cart> findCartByProducts(List<Product> products);
}
