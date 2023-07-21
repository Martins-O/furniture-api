package furniture.ecommerce.furnitureecommerce.service.implementation;

import furniture.ecommerce.furnitureecommerce.data.dto.request.ProductRequest;
import furniture.ecommerce.furnitureecommerce.data.dto.request.UpdateProductRequest;
import furniture.ecommerce.furnitureecommerce.data.dto.response.ApiResponse;
import furniture.ecommerce.furnitureecommerce.data.model.Products;
import furniture.ecommerce.furnitureecommerce.data.repository.ProductRepository;
import furniture.ecommerce.furnitureecommerce.service.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository repository;
	@Override
	public ApiResponse createProduct(ProductRequest request) {
		Products addProduct = Products
				.builder()
				.price (request.getPrice())
				.description(request.getDescription())
				.colorType (request.getColorType())
				.sizeType (request.getSizeType())
				.name (request.getName())
				.build();
		var saved = repository.save(addProduct);
		return ;
	}
	
	@Override
	public void updateProduct(Long productId, UpdateProductRequest request){
		Optional<Products> checkProduct = repository.findById(productId);
		if (checkProduct.isEmpty ()) {
			throw new IllegalStateException("Product not found");
		}
		Products updateProduct = checkProduct.get();
		updateProduct.setColorType (request.getColorType());
		updateProduct.setName (request.getName());
		updateProduct.setDescription (request.getDescription());
		updateProduct.setPrice (request.getPrice());
		updateProduct.setSizeType (request.getSizeType());
		var savedProduct = repository.save(updateProduct);
	}
	
	@Override
	public List<Products> getAllProducts() {
		return repository.findAll ();
	}
	
	@Override
	public Products getProductByName (String name) {
		return repository.findProductByName(name);
	}
	
	@Override
	public Products getProductByPrice(BigDecimal price) {
		return repository.findProductByPrice(price);
	}
}
