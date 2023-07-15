package furniture.ecommerce.furnitureecommerce.data.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {
	private String message;
	private boolean success;
	private int statusCode;
}
