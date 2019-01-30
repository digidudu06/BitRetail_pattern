package domain;

import lombok.Data;

public @Data class SuppolierDTO {
	private String supplierId, supplierName, contactName, address, city, postalCode, country, phone;

}
