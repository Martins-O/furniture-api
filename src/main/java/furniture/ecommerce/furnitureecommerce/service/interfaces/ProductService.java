package furniture.ecommerce.furnitureecommerce.service.interfaces;

import furniture.ecommerce.furnitureecommerce.data.dto.request.ProductRequest;
import furniture.ecommerce.furnitureecommerce.data.dto.request.UpdateProductRequest;
import furniture.ecommerce.furnitureecommerce.data.dto.response.ApiResponse;
import furniture.ecommerce.furnitureecommerce.data.model.Products;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
	ApiResponse createProduct(ProductRequest request);
	
	void updateProduct(Long productId, UpdateProductRequest request);
	
	List<Products> getAllProducts();
	
	Products getProductByName(String name);
	
	Products getProductByPrice(BigDecimal price);
}
