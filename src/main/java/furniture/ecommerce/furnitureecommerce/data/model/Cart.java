package furniture.ecommerce.furnitureecommerce.data.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "carts")
public class Cart {
	@Id
	@SequenceGenerator(
			name = "id",
			sequenceName = "carts_id"
	)
	@GeneratedValue(
			strategy = GenerationType.IDENTITY,
			generator = "carts_id"
	)
	private Long Id;
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.REMOVE, CascadeType.PERSIST})
	@JoinTable(
			name = "orders",
			joinColumns = @JoinColumn(name = "orders_id"),
			inverseJoinColumns = @JoinColumn(name = "orders_id")
	)
	private List<AppUser> userOrder;
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.REMOVE, CascadeType.PERSIST})
	@JoinTable(
			name = "product",
			joinColumns = @JoinColumn(name = "product_id"),
			inverseJoinColumns = @JoinColumn(name = "product_id")
	)
	private List<Products> products;
	private int quantity;

}
