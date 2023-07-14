package furniture.ecommerce.furnitureecommerce.data.model;

import furniture.ecommerce.furnitureecommerce.data.enums.Color;
import furniture.ecommerce.furnitureecommerce.data.enums.Type;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "products")
public class Products {
	@Id
	@SequenceGenerator(
			name = "id",
			sequenceName = "product_id"
	)
	@GeneratedValue(
			strategy = GenerationType.IDENTITY,
			generator = "product_id"
	)
	private Long id;
	private BigDecimal price;
	private String description;
	private String name;
	@Enumerated(EnumType.STRING)
	private Type sizeType;
	@Enumerated(EnumType.STRING)
	private Color colorType;
	@Transient
	private MultipartFile pictures;
}
