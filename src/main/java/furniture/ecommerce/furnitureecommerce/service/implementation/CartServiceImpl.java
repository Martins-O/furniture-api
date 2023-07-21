package furniture.ecommerce.furnitureecommerce.service.implementation;

import furniture.ecommerce.furnitureecommerce.data.dto.request.AddToCartRequest;
import furniture.ecommerce.furnitureecommerce.data.dto.response.ApiResponse;
import furniture.ecommerce.furnitureecommerce.data.model.Cart;
import furniture.ecommerce.furnitureecommerce.data.repository.CartRepository;
import furniture.ecommerce.furnitureecommerce.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
	private final CartRepository repository;
	@Override
	public ApiResponse addToCart(AddToCartRequest request) {
		Cart createCart = Cart.builder ()
				.products (request.getProducts ())
				.userOrder (request.getUserOrder ())
				.quantity (request.getQuantity ())
				.build ();
		var saveCart = repository.save(createCart);
		return null;
	}
	
	@Override
	public void deleteCart(Cart cart) {
		repository.delete (cart);
	}
}
