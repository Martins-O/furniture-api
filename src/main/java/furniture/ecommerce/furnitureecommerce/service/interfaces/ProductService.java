package furniture.ecommerce.furnitureecommerce.service.interfaces;

import furniture.ecommerce.furnitureecommerce.data.dto.request.ProductRequest;
import furniture.ecommerce.furnitureecommerce.data.dto.response.ApiResponse;

public interface ProductService {
	ApiResponse createProduct(ProductRequest request);
}
