package furniture.ecommerce.furnitureecommerce.data.model;

import furniture.ecommerce.furnitureecommerce.data.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "app_users")
public class AppUser {
	@Id
	@SequenceGenerator(
			name = "id",
			sequenceName = "user_id"
	)
	@GeneratedValue(
			strategy = GenerationType.IDENTITY,
			generator = "user_id"
	)
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String phoneNumber;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Address addressDetails;
	@Enumerated(EnumType.STRING)
	private List<Role> roles;
	private boolean enabled;
}
