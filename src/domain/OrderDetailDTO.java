package domain;

import lombok.Data;

public @Data class OrderDetailDTO {
	private int orderDetailId, orderId, productId, quantity;

	
}
