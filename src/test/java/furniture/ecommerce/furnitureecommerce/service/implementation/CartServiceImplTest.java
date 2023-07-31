package furniture.ecommerce.furnitureecommerce.service.implementation;

import furniture.ecommerce.furnitureecommerce.data.dto.request.CartItemsDto;
import furniture.ecommerce.furnitureecommerce.data.model.AppUser;
import furniture.ecommerce.furnitureecommerce.data.model.Product;
import furniture.ecommerce.furnitureecommerce.data.repository.CartItemRepository;
import furniture.ecommerce.furnitureecommerce.data.repository.CartRepository;
import furniture.ecommerce.furnitureecommerce.data.repository.ProductRepository;
import furniture.ecommerce.furnitureecommerce.service.interfaces.AppUserService;
import furniture.ecommerce.furnitureecommerce.service.interfaces.CartService;
import furniture.ecommerce.furnitureecommerce.service.interfaces.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

import static com.fasterxml.jackson.databind.type.LogicalType.Array;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class CartServiceImplTest {
	@Mock
	private CartRepository repository;
	@Mock
	private ProductService service;
	@Mock
	private AppUserService userService;
	@Mock
	private CartItemRepository itemRepository;
	
	@InjectMocks
	private CartService cartService;
	
	public void setUp(){
		MockitoAnnotations.openMocks (this);
	}
	
	@Test
	void createOrder() {
		setUp ();
		Product product = Product.builder()
				.name ("Tables")
				.price (new BigDecimal ("23.0"))
				.quantity (34)
				.build();
		Product secondProduct = Product.builder()
				.name ("Chairs")
				.price (new BigDecimal ("245.0"))
				.quantity (31)
				.build();
		
		AppUser user = new AppUser();
		userService.saveUsers (user);
		AppUser secondUser = new AppUser();
		userService.saveUsers (secondUser);
		
		when(service.getProductByName ("Chairs")).thenReturn (secondProduct);
		when(service.getProductByName ("Tables")).thenReturn (product);
		
		CartItemsDto dto = new CartItemsDto();
		dto.setProducts ((Product) Arrays.asList (secondProduct, product));
		dto.setUserOrder (Arrays.asList (user,secondUser).toString ());
		dto.setPrice ((BigDecimal) Arrays.asList(new BigDecimal("245.0"), new BigDecimal("23.0")));
//		dto.setQuantity (Array.equals (34));
		
	}
	
	@Test
	void deleteCart() {
	}
}