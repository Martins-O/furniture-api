package furniture.ecommerce.furnitureecommerce.data.dto.request;

import furniture.ecommerce.furnitureecommerce.data.enums.Color;
import furniture.ecommerce.furnitureecommerce.data.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductRequest {
	private BigDecimal price;
	private String description;
	private String name;
	private Type sizeType;
	private Color colorType;
	private MultipartFile pictures;
}
