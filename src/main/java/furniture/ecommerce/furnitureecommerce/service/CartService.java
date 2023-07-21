package furniture.ecommerce.furnitureecommerce.service;

import furniture.ecommerce.furnitureecommerce.data.dto.request.AddToCartRequest;
import furniture.ecommerce.furnitureecommerce.data.dto.response.ApiResponse;
import furniture.ecommerce.furnitureecommerce.data.model.Cart;

public interface CartService {
	
	ApiResponse addToCart(AddToCartRequest request);
	
	void deleteCart(Cart cart);
}
