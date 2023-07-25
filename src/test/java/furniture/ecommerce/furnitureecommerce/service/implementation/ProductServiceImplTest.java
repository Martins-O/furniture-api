package furniture.ecommerce.furnitureecommerce.service.implementation;

import furniture.ecommerce.furnitureecommerce.data.dto.request.ProductRequest;
import furniture.ecommerce.furnitureecommerce.data.dto.request.UpdateProductRequest;
import furniture.ecommerce.furnitureecommerce.data.enums.Color;
import furniture.ecommerce.furnitureecommerce.data.enums.Type;
import furniture.ecommerce.furnitureecommerce.data.repository.ProductRepository;
import furniture.ecommerce.furnitureecommerce.service.interfaces.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProductServiceImplTest {
	
	@Autowired
	private ProductService service;
	private ProductRequest request;
	private UpdateProductRequest updateRequest;
	@Autowired
	private ProductRepository repository;
	
	@BeforeEach
	void setUp() {
		request = new ProductRequest();
		request.setQuantity (23);
		request.setName ("Cushion");
		request.setDescription ("Soft and effective and reliable");
		request.setSizeType (Type.SHORT);
		request.setColorType (List.of (Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW));
		request.setPrice (BigDecimal.valueOf (35000));
	}
	
	@Test
	void createProduct() {
		var response = service.createProduct (request);
		assertThat(response.isSuccessful ()).isTrue ();
		assertThat (response).isNotNull ();
	}
	
	@BeforeEach
	void setUpForUpdate() {
		updateRequest = new UpdateProductRequest();
		updateRequest.setQuantity (20);
		updateRequest.setName ("Cushions");
		updateRequest.setDescription ("Soft and effective and reliable");
		updateRequest.setSizeType (Type.LONG);
//		updateRequest.setColorType (Color.BLUE);
		updateRequest.setPrice (BigDecimal.valueOf (354000));
	}
	
	@Test
	void updateProduct() {
		Long id = 1L;
		System.out.println (updateRequest.getPrice ());
		System.out.println (updateRequest.getName ());
		var response = service.updateProduct (id, updateRequest);
		assertThat (response.isSuccessful ()).isTrue ();
	}
	
	@Test
	void getAllProducts() {
		var response = repository.count ();
		assertEquals(2L, response);
	}
	
	@Test
	void getProductByName() {
		String name = "Cushions";
		var response = service.getProductByName (name);
		assertThat(response.getName ()).isEqualTo(name);
		assertThat (response).isNotNull ();
	}
	
	@Test
	void getProductByPrice() {
		BigDecimal price = BigDecimal.valueOf (35000);
		var response = service.getProductByPrice (price);
		assertThat (response.getPrice ()).isEqualTo(price);
	}
}