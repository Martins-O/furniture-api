package furniture.ecommerce.furnitureecommerce.service.interfaces;

import furniture.ecommerce.furnitureecommerce.data.dto.request.AddToCartRequest;
import furniture.ecommerce.furnitureecommerce.data.dto.response.ApiResponse;
import furniture.ecommerce.furnitureecommerce.data.dto.response.PurchaseResponse;
import furniture.ecommerce.furnitureecommerce.data.model.Cart;

public interface CartService {
	
//	ApiResponse addToCart(AddToCartRequest request);
	
//	PurchaseResponse purchase();
	
	void deleteCart(Cart cart);
}
