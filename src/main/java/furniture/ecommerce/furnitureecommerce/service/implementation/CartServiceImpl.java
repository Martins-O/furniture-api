package furniture.ecommerce.furnitureecommerce.service.implementation;

import furniture.ecommerce.furnitureecommerce.data.dto.request.AddToCartRequest;
import furniture.ecommerce.furnitureecommerce.data.dto.response.ApiResponse;
import furniture.ecommerce.furnitureecommerce.data.dto.response.PurchaseResponse;
import furniture.ecommerce.furnitureecommerce.data.model.Cart;
import furniture.ecommerce.furnitureecommerce.data.model.Product;
import furniture.ecommerce.furnitureecommerce.data.repository.CartRepository;
import furniture.ecommerce.furnitureecommerce.service.interfaces.CartService;
import furniture.ecommerce.furnitureecommerce.service.interfaces.ProductService;
import furniture.ecommerce.furnitureecommerce.utils.Responses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartServiceImpl implements CartService {
	private final CartRepository repository;
	private final ProductService service;
	@Override
	public ApiResponse addToCart(AddToCartRequest request) {
		Cart createCart = Cart.builder ()
				.products (request.getProducts ())
				.userOrder (request.getUserOrder ())
				.quantity (request.getQuantity ())
				.build ();
		var saveCart = repository.save(createCart);
		return Responses.createdResponse (saveCart);
	}
	
	@Override
	public PurchaseResponse purchase(){
		List<Cart> cartList = repository.findAll ();
		BigDecimal totalPrice = BigDecimal.ZERO;
		for (Cart cart : cartList){
			Product product = (Product) cart.getProducts ();
			BigDecimal itemPrice = product.getPrice ().multiply (BigDecimal.valueOf (cart.getQuantity ()));
			totalPrice = itemPrice.add (itemPrice);
		}
		for (Cart cart : cartList){
			Product product = (Product) cart.getProducts ();
			int purchaseQuantity = cart.getQuantity ();
			int availableQuantity = product.getQuantity ();
			
			if (availableQuantity >= purchaseQuantity){
				product.setQuantity (purchaseQuantity);
				service.saveProduct (product);
				repository.delete (cart);
			}else{
				throw new IllegalStateException("Not enough products available");
			}
		}
		log.info ("Total price: {}", totalPrice);
		return PurchaseResponse.builder ()
				.isSuccessful (true)
				.statusCode (200)
				.message ("Purchase successful!!!")
				.data (totalPrice)
				.build ();
	}
	
	@Override
	public void deleteCart(Cart cart) {
		repository.delete (cart);
	}
}
